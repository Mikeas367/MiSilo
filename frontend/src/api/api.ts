import axios from "axios"

const apiBaseUrl = 'http://localhost:8080/api'

// voy a crear una istancia "Personalizada" de axios en la cual voy a poder usar el envio de tokens automaticos

export const api = axios.create({
    baseURL: apiBaseUrl
})

api.interceptors.request.use((config)=>{
    const token = localStorage.getItem('token')
    if(token){
        config.headers.Authorization = `Bearer ${token}`
    }
    return config
}, (error)=>{
    return Promise.reject(error)
})



export const apiRoutes = {
    SILO:{
        OBTENER_SILO: `/silo`,
        LLENAR_SILO: (cantidadAAñadir: number) => `/silo/llenar-silo/${cantidadAAñadir}`, 
    },
    PEDIDO:{
        NUEVO_PEDIDO: `/pedidos/nuevo-pedido`,
        OBTENER_TODOS_PEDIDOS: `/pedidos`
    }
    
}