# Mi Silo 🌽

"Mi silo" es una App web que ayuda a la gestion de la produccion de bolsas de maíz. 

## Descripción y Evolucion📝🚀
La idea de este sistema es poder tener una trazabilidad de las bolsas de maiz que se van creando asi como tambien del silo, ya que anteriormente solo se escribian en una pizarra. Ademas se buscaria en el futuro implementar un modulo de gestion de clientes que nos permita saber cuanto maiz consume cada uno y saber de antemano cuanto maiz va a necesitar para asi poder mejorar la confiabilidad con nuestros clientes.

Ademas se buscaria poder generar distintas estadisticas o graficos para saber que cantidad de maiz se consume en un mes por ejemplo, como tambien saber que tipos de bolsas se venden más.



# Estructura 🏗️
La aplicacion se divide en 2 partes:

`/Backend`: backend desarrollado con Java y Spring-Boot, utilizando DDD (Domain Driven Development) y base de datos MySql

`/Frontend`: Interfaz de usuario desarrollado con javaScript y React con TypeScript, tambien se utilizo bootstrap para los estilos de los componentes.


## ScreenShoots 📷✨
Login del sistema, solo se hace con un usuario y contraseña.

![Login de Mi Silo.](./docs/assets/LoginMiSiloCaptura.png")

Informacion del silo, en esta pantalla se nos muestra informacion relacionada al silo como cantidad actual de maiz con una y el ultimo llenado del silo. Ademas nos permite añadir más contenido al silo.

![Info del silo.](./docs/assets/SiloInfoCaptura.png")


Aqui el sistema nos permite indicar la cantidad de maiz a añadir al silo.

![Agregar maiz al silo.](./docs/assets/AgregarContenidoSoloCaptura.png")


Se selecciona el tipo de bolsa de maiz a crear y se indica la cantidad de bolsas de ese tipo, luego se agrega a un "carrito" perimitiendo generar más de un tipo de bolsa.

![Nuevo Pedido.](/docs/assets/NuevoPedidoCaptura.png")


El sistema nos permite visualizar los pedidos que se fueron realizando, y nos indica la cantidad total de kilos que se quitaron del silo, asi como tambien los tipos y cantidades de bolsa que se hicieron.

![Listado de pedidos.](/docs/assets/ListadoPedidosCaptura.png")
