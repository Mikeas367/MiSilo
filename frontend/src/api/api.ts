const apiBaseUrl = import.meta.env.VITE_API_URL

export const apiRoutes = {
    SILO:{
        OBTENER_SILO: `${apiBaseUrl}/silo`,
        LLENAR_SILO: (cantidadAAñadir: number) => `${apiBaseUrl}/silo/llenar-silo/${cantidadAAñadir}`, 
    },
    PEDIDO:{
        NUEVO_PEDIDO: `${apiBaseUrl}/pedidos/nuevo-pedido`,
        OBTENER_TODOS_PEDIDOS: `${apiBaseUrl}/pedidos`
    }
    
}