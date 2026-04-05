import { useEffect, useState } from "react"
import { obtenerTodosPedidos } from "../../api/services"
import type { Pedido } from "../../models"
import "./PedidoList.css"

export const PedidoList = () => {
    const [pedidos, setPedidos] = useState<Pedido[]>()

    const fetchPedidos = async () => {
        try {
            const response = await obtenerTodosPedidos();
            setPedidos(response.data)
        } catch (error) {
            console.log(error)
        }
    }

    useEffect(() => {
        fetchPedidos()
    }, [])

    return (
        <>
            <div className="container mt-5">
    <div className="d-flex align-items-center mb-4">
        <div className="jd-divider-vertical me-3"></div>
        <h1 className="h2 fw-bold mb-0 text-dark">Listado de Pedidos</h1>
    </div>

    <div className="table-responsive shadow-sm rounded border overflow-hidden bg-white">
        <table className="table table-hover mb-0">
            <thead className="jd-table-header">
                <tr>
                    <th className="ps-4">N° PEDIDO</th>
                    <th>FECHA</th>
                    <th>TOTAL KILOS</th>
                    <th className="pe-4">DETALLE DEL CONTENIDO</th>
                </tr>
            </thead>
            <tbody>
                {pedidos?.map((p) => (
                    <tr key={p.id} className="align-middle border-bottom-light">
                        <td className="ps-4 fw-bold text-muted">#{p.id}</td>
                        <td>
                            <div className="d-flex align-items-center">
                                <i className="bi bi-calendar3 me-2 text-success"></i>
                                {new Date(p.fechaPedido).toLocaleDateString()}
                            </div>
                        </td>
                        <td>
                            {/* MEJORA DE CONTRASTE: Usamos bg-jd-green y text-white */}
                            <span className="badge bg-jd-green text-white fw-bold px-3 py-2 fs-6">
                                {p.totalKilos.toLocaleString()} Kg
                            </span>
                        </td>
                        <td className="pe-4">
                            <div className="d-flex flex-wrap gap-2">
                                {p.detallePedidos.map((dp, index) => (
                                    <span key={index} className="jd-detail-pill">
                                        <span className="fw-bold text-uppercase">{dp.tipoDeBolsa}:</span> {dp.cantidad}
                                    </span>
                                ))}
                            </div>
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
    </div>
</div>
        </>
    )
}