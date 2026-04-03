const apiBaseUrl = 'http://localhost:8080/api/silo'

export const apiRoutes = {
    SILO:{
        OBTENER_SILO: `${apiBaseUrl}`,
        LLENAR_SILO: (cantidadAAñadir: number) => `${apiBaseUrl}/llenar-silo/${cantidadAAñadir}`, 
    },
    
}