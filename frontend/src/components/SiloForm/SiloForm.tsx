import { useState, type FormEvent } from "react"
import { llenarSilo } from "../../api/services";
import { Link } from 'react-router-dom';


export const SiloForm = () => {
    const [catidadAAñadir, setCatidadAAñadir] = useState<number>(0);
    
    const envioDeFormulario = async (e: FormEvent) => {
        e.preventDefault();
        if(catidadAAñadir <= 0){
            window.alert("La cantidad ingresada debe de ser mayor a 0")
        }
        try {

            await llenarSilo(catidadAAñadir)
            window.alert(`Se agregaron correctamente los ${catidadAAñadir} Kg al silo`)
        } catch (error) {
            console.log(error)
        }
    }

    return (
        <>
<div className="container mt-5">
    {/* Cabecera integrada: quitamos el fondo gris y el borde redondeado */}
    <div className="border-bottom pb-3 mb-4">
        <h2 className="text-dark fw-bold mb-1">
            <i className="bi bi-plus-circle-fill me-2 text-primary"></i>
            Actualizar Contenido de Silo
        </h2>
        <p className="text-muted mb-0">
            Ingrese la cantidad exacta de maíz que desea ingresar al sistema. 
            El inventario se actualizará automáticamente.
        </p>
    </div>

    <div className="py-2" style={{ maxWidth: '800px' }}>
        <form onSubmit={envioDeFormulario}>
            <div className="mb-4">
                <label htmlFor="catidadAAñadir" className="form-label fw-bold text-secondary small uppercase">
                    CANTIDAD A AÑADIR (KG)
                </label>
                
                {/* Mantenemos el input group que te gustó, pero más limpio */}
                <div className="input-group input-group-lg shadow-none">
                    <span className="input-group-text bg-transparent border-top-0 border-start-0 border-end-0 border-bottom rounded-0 px-0">
                        <i className="bi bi-box-seam text-primary fs-4 me-3"></i>
                    </span>
                    <input 
                        className="form-control bg-transparent border-top-0 border-start-0 border-end-0 border-bottom rounded-0 ps-0 shadow-none" 
                        type="number" 
                        id="catidadAAñadir" 
                        name="catidadAAñadir" 
                        placeholder="Ej: 500"
                        style={{ fontSize: '1.8rem', fontWeight: '500' }}
                        onChange={(e) => setCatidadAAñadir(Number(e.target.value))}
                        required
                    />
                </div>
                
                <div className="form-text mt-3 text-muted">
                    <i className="bi bi-info-circle me-1"></i>
                    Asegúrese de que el silo tenga capacidad suficiente antes de confirmar.
                </div>
            </div>

            {/* Pie de formulario con línea simple */}
            <div className="d-flex justify-content-between align-items-center mt-5 pt-4">
                <Link to="/silo" className="btn btn-link text-decoration-none text-muted p-0">
                    <i className="bi bi-arrow-left me-1"></i> Cancelar y volver
                </Link>
                
                <button type="submit" className="btn btn-primary btn-lg px-5 shadow-sm">
                    Confirmar Carga <i className="bi bi-floppy ms-2"></i> 
                </button>
            </div>
        </form>
    </div>
</div>
        </>
    )
}