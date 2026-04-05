import axios from "axios"
import { apiRoutes } from "../api"
import type { DetallePedido } from "../../models"

export const nuevoPedido = async(detallesPedido: DetallePedido[]) => {
    const response = await axios.post(apiRoutes.PEDIDO.NUEVO_PEDIDO, detallesPedido)
    return response
}

export const obtenerTodosPedidos = async()=>{
    const response = await axios.get(apiRoutes.PEDIDO.OBTENER_TODOS_PEDIDOS)
    return response
}

