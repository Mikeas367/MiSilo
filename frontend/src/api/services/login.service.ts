import axios from "axios"
import type { Usuario } from "../../models"

const url = 'http://localhost:8080/api/auth/login'

export const iniciarSesion = async(usuario: Usuario) => {
    const response = await axios.post(url,usuario)
    return response
}