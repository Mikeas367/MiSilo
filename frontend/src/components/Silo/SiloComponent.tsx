import { useEffect, useState } from "react"
import type { Silo } from "../../models"
import { obtenerSilo } from "../../api/services"
import { Link } from 'react-router-dom';
import "./SiloComponent.css"

export const SiloComponent = () => {
    const [silo, setSilo] = useState<Silo>()

    const fetchSilo = async () => {
        try {
            const response = await obtenerSilo()
            setSilo(response.data)
        } catch (error) {
            console.log(error);
        }
    }
    const formatFecha = (fecha: Date | string | undefined | null): string => {
        if (!fecha) return 'Sin registro';
        const d = new Date(fecha);
        if (isNaN(d.getTime())) return 'Fecha inválida';

        return d.toLocaleDateString('es-ES', {
            day: '2-digit',
            month: '2-digit',
            year: 'numeric'
        });
    };

    useEffect(() => {
        fetchSilo();
    }, [])

    return (
        <>
            <div className="container mt-4">
                <div className="border rounded bg-white shadow-sm overflow-hidden" style={{ borderColor: '#367c2b' }}>
                    {/* Cabecera con Verde John Deere */}
                    <div className="p-3 d-flex align-items-center" style={{ backgroundColor: '#367c2b', color: '#ffde00' }}>
                        <h5 className="mb-0 fw-bold">
                            <i className="bi bi-info-circle-fill me-2"></i>
                            Detalles del Contenido del Silo
                        </h5>
                    </div>

                    {/* Cuerpo con los datos */}
                    <div className="p-4">
                        <div className="row g-4">
                            {/* Columna de Kilos */}
                            <div className="col-md-4">
                                <label className="text-muted small fw-bold d-block mb-1" style={{ letterSpacing: '1px' }}>CANTIDAD ACTUAL</label>
                                <div className="d-flex align-items-baseline">
                                    <span className="h2 mb-0 me-2 fw-bold" style={{ color: '#367c2b' }}>
                                        {silo?.contenidoEnSilo?.toLocaleString() ?? '0'}
                                    </span>
                                    <span className="text-muted fw-bold">Kg</span>
                                </div>
                            </div>

                            {/* Columna de Fecha */}
                            <div className="col-md-4">
                                <label className="text-muted small fw-bold d-block mb-1" style={{ letterSpacing: '1px' }}>ÚLTIMO LLENADO</label>
                                <div className="h5 mb-0 text-dark pt-1">
                                    <i className="bi bi-calendar-check me-2" style={{ color: '#367c2b' }}></i>
                                    {formatFecha(silo?.fechaUltimoLLenado) ?? 'Sin registro'}
                                </div>
                            </div>

                            {/* Columna de Capacidad */}
                            <div className="col-md-4 text-md-end">
                                <label className="text-muted small fw-bold d-block mb-1" style={{ letterSpacing: '1px' }}>CAPACIDAD LÍMITE</label>
                                <div className="h5 mb-0 text-dark pt-1">
                                    <strong style={{ color: '#27251f' }}>{silo?.kilosMax?.toLocaleString() ?? '0'}</strong> Kg
                                </div>
                            </div>
                        </div>

                        {/* Sección de Progreso Visual */}
                        <div className="mt-4 pt-3 border-top">
                            <div className="d-flex justify-content-between mb-2">
                                <span className="small fw-bold text-secondary">Nivel de ocupación</span>
                                <span className="small fw-bold" style={{ color: '#367c2b' }}>
                                    {silo?.kilosMax ? ((silo.contenidoEnSilo / silo.kilosMax) * 100).toFixed(0) : 0}%
                                </span>
                            </div>
                            <div className="progress" style={{ height: '24px', borderRadius: '12px', backgroundColor: '#e9ecef', border: '1px solid #dee2e6' }}>
                                <div
                                    className="progress-bar progress-bar-striped progress-bar-animated custom-jd-progress"
                                    role="progressbar"
                                    style={{
                                        width: `${(silo?.contenidoEnSilo && silo?.kilosMax) ? (silo.contenidoEnSilo / silo.kilosMax) * 100 : 0}%`,
                                        backgroundColor: '#367c2b'
                                    }}
                                ></div>
                            </div>
                        </div>

                        {/* Acciones - Botón Amarillo con texto oscuro */}
                        <div className="mt-4 d-flex justify-content-end">
                            <Link
                                to="/llenar-silo"
                                className="btn btn-jd-yellow px-4 py-2 fw-bold shadow-sm border-0"
                            >
                                <i className="bi bi-database-add me-2"></i>
                                Añadir maíz
                            </Link>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}