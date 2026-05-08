import { useEffect, useState } from "react"
import type { PrecioPizarra } from "../../models"
import { obtenerPrecioPizarra } from "../../api/services"

export const Menu = () => {
    const [pizarra, setPizarra] = useState<PrecioPizarra>()

    const fetchPizarra = async() => {
        try {
            const response = await obtenerPrecioPizarra()
            setPizarra(response.data)
        } catch (error) {
            console.log(error)
        }
    }

    useEffect(()=>{
        fetchPizarra()
    },[])
    return (
        <>
            <div className="container mt-5">
            {/* Encabezado con el divisor amarillo */}
            <div className="d-flex align-items-center mb-4">
                <div className="jd-divider-vertical me-3"></div>
                <h1 className="h2 fw-bold mb-0 text-dark">
                    {pizarra?.fechaPizarra || "Precios Pizarra BCR"}
                </h1>
            </div>

            {/* Tabla Estilo MiSilo */}
            <div className="table-responsive shadow-sm rounded border overflow-hidden bg-white">
                <table className="table table-hover mb-0">
                    <thead className="jd-table-header">
                        <tr>
                            <th className="ps-4">CEREAL</th>
                            <th>PRECIO ARS</th>
                            <th>PRECIO USD</th>
                            <th className="pe-4 text-center">TENDENCIA</th>
                        </tr>
                    </thead>
                    <tbody>
                        {pizarra?.listaCereal.map((c, index) => (
                            <tr key={index} className="align-middle border-bottom-light">
                                <td className="ps-4 fw-bold text-dark text-uppercase">
                                    {c.nombreCereal}
                                </td>
                                <td>
                                    <span className="badge bg-jd-green text-white fw-bold px-3 py-2 fs-6">
                                        {c.precioEnPesos}
                                    </span>
                                </td>
                                <td>
                                    <div className="d-flex align-items-center text-muted fw-semibold">
                                        <i className="bi bi-currency-dollar me-1 text-success"></i>
                                        {c.precioEnDolar}
                                    </div>
                                </td>
                                <td className="pe-4 text-center">
                                    <div className={`jd-detail-pill ${c.suba ? 'border-success' : 'border-danger'}`} 
                                         style={{ borderLeftColor: c.suba ? '#198754' : '#dc3545' }}>
                                        {c.suba ? (
                                            <>
                                                <i className="bi bi-caret-up-fill text-success me-1"></i>
                                                <span className="text-success fw-bold">SUBA</span>
                                            </>
                                        ) : (
                                            <>
                                                <i className="bi bi-caret-down-fill text-danger me-1"></i>
                                                <span className="text-danger fw-bold">BAJA</span>
                                            </>
                                        )}
                                    </div>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            <p>Precios corrientes expresados en $/Tn</p>
        </div>
        </>
    )
}