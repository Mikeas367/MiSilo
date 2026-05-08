import axios from "axios"
import type { Usuario } from "../../models"
import { apiRoutes } from "../api"

export const iniciarSesion = async(usuario: Usuario) => {
    const response = await axios.post(apiRoutes.LOGIN.INICIAR_SESION, usuario)
    return response
}