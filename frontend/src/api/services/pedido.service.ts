
import { api, apiRoutes } from "../api"
import type { DetallePedido } from "../../models"

export const nuevoPedido = async(detallesPedido: DetallePedido[]) => {
    const response = await api.post(apiRoutes.PEDIDO.NUEVO_PEDIDO, detallesPedido)
    return response
}

export const obtenerTodosPedidos = async()=>{
    const response = await api.get(apiRoutes.PEDIDO.OBTENER_TODOS_PEDIDOS)
    return response
}

