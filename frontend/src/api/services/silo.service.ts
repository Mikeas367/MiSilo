
import { api, apiRoutes } from "../api"
import type { Silo } from "../../models"

export const obtenerSilo = async() => {
    const response = await api.get<Silo>(apiRoutes.SILO.OBTENER_SILO)
    return response
}

export const llenarSilo = async(cantidadAAñadir: number) => {
    console.log("entro al servicio con la cantidad a añadir: " + cantidadAAñadir)
    const response = await api.put(apiRoutes.SILO.LLENAR_SILO(cantidadAAñadir))
    return response
}
    