
import { api, apiRoutes } from "../api"

export const obtenerPrecioPizarra = async() => {
    const response = await api.get(apiRoutes.PRECIO_PIZARRA.OBTENER_PRECIO_PIZARRA)
    return response
}