package com.MiSilo.MiSilo.casosDeUso.PecioPizarra;

import com.MiSilo.MiSilo.infraestructura.DTO.CerealBCR;
import com.MiSilo.MiSilo.infraestructura.DTO.PrecioPizarra;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class PrecioPizarraInteractor implements IPrecioPizarraInteractor {

    private String url = "https://www.cac.bcr.com.ar/es/precios-de-pizarra";
    private PrecioPizarra precioPizarraEnChache;


    public PrecioPizarra obtenerPreciosPizarra() {
        return precioPizarraEnChache; // devuelvo lo que tengo en chache
    }

    @Scheduled(fixedRate = 86400000) // cada 24hs
    public void actualizarPreciosPizarra() {
        try{
            System.out.println("Actualizando precios de pizarra...");
            Document doc = Jsoup.connect(url).get();

            String fechaPizarra = doc.select("h3").first().text();

            Elements container = doc.select(".boards-container .board");
            List<CerealBCR> nuevaLista = obtenerCerealesDeContainer(container);

            PrecioPizarra nuevaPizarra = new PrecioPizarra(fechaPizarra, nuevaLista);

            this.precioPizarraEnChache = nuevaPizarra;
            System.out.println("Se actualizaron los datos exitosamente :)");

        } catch (Exception e) {
            System.err.println("Error actualizando precios: " + e.getMessage());
        }
    }

    private List<CerealBCR> obtenerCerealesDeContainer(Elements container) {
        List<CerealBCR> nuevaLista = new ArrayList<>();
        for (Element card : container) {
            CerealBCR nuevoCereal = mapearCardACerealCBR(card);
            nuevaLista.add(nuevoCereal);
        }
        return nuevaLista;
    }

    private CerealBCR mapearCardACerealCBR(Element card){
        String nombreCereal = card.select("h3").text();
        String precioEnPesos = card.select(".price").text();
        String precioEnDolar = card.select(".cell").text();

        Element flecha = card.select(".direction").first();
        boolean suba = flecha.hasClass("fa-arrow-up");

        //System.out.println("----> Cereal: " + card.select("h3").text());
        //System.out.println("Pecio en Pesos: " + card.select(".price").text());
        //System.out.println("Pecio en Dolar: " + card.select(".cell").text());

        return new CerealBCR(nombreCereal, precioEnPesos, precioEnDolar, suba);
    }

    public PrecioPizarraInteractor() {
    }
}
