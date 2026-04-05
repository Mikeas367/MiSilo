import { useState, type FormEvent } from "react"
import type { DetallePedido } from "../../models";
import { nuevoPedido } from "../../api/services";
import { Link } from 'react-router-dom';
import "./PedidoForm.css"

export const PedidoForm = () => {
    const [cantidadSeleccionada, setCantidadSeleccionada] = useState<number>(0)
    const [tipoBolsaSeleccionada, setTipoBolsaSeleccionada] = useState<string>()
    const [carrito, setCarrito] = useState<DetallePedido[]>([]);

    const agregarAlCarrito = () => {
        console.log(cantidadSeleccionada)
        console.log(tipoBolsaSeleccionada)

        const nuevoDetalle: DetallePedido = {
            tipoDeBolsa: tipoBolsaSeleccionada,
            cantidad: cantidadSeleccionada
        };

        setCarrito([...carrito, nuevoDetalle]);
    }

    const envioDeFormulario = async (e: FormEvent) => {
        e.preventDefault();
        try {
            await nuevoPedido(carrito)
            window.alert("pedido registrado")
        } catch (error) {
            console.log(error)
        }
    }

    const eliminarDelCarrito = (indiceAEliminar: number) => {
        const nuevoCarrito = carrito.filter((_, index) => index !== indiceAEliminar);
        setCarrito(nuevoCarrito);
    }
    return (
        <>
            <div className="container mt-5" style={{ maxWidth: '700px' }}>
                {/* Encabezado Simple */}
                <div className="mb-4">
                    <h2 className="fw-bold text-dark d-flex align-items-center">
                        <span className="jd-accent-bar me-3"></span>
                        Nuevo Pedido
                    </h2>
                    <p className="text-muted ms-4">Seleccione las bolsas y confirme la carga.</p>
                </div>

                <div className="card border-0 shadow-sm rounded-4 overflow-hidden">
                    {/* Cuerpo del Formulario */}
                    <div className="card-body p-4 p-md-5">
                        <div className="row g-3">
                            <div className="col-md-8">
                                <label className="form-label jd-label">TIPO DE BOLSA</label>
                                <select
                                    className="form-select jd-input"
                                    onChange={(e) => setTipoBolsaSeleccionada(e.target.value)}
                                    defaultValue=""
                                >
                                    <option value="" disabled>Seleccionar tipo de maíz...</option>
                                    <option value="ENTERO">Maíz Entero</option>
                                    <option value="PARTIDO">Maíz Partido</option>
                                    <option value="MOLIDO">Maíz Molido</option>
                                </select>
                            </div>
                            <div className="col-md-4">
                                <label className="form-label jd-label">CANTIDAD</label>
                                <input
                                    type="number"
                                    className="form-control jd-input"
                                    placeholder="0"
                                    onChange={(e) => setCantidadSeleccionada(Number(e.target.value))}
                                />
                            </div>

                            {/* Botón Añadir - Amarillo JD */}
                            <div className="col-12 mt-3">
                                <button
                                    type="button"
                                    className="btn btn-jd-yellow w-100 py-2 fw-bold"
                                    onClick={agregarAlCarrito}
                                >
                                    <i className="bi bi-cart-plus me-2"></i>
                                    AÑADIR AL CARRITO
                                </button>
                            </div>
                        </div>

                        {/* Lista de productos (Carrito) */}
                        {carrito.length > 0 && (
                            <div className="mt-4 pt-4 border-top">
                                <h6 className="jd-label mb-3">PRODUCTOS EN EL PEDIDO</h6>
                                <div className="list-group list-group-flush">
                                    {carrito.map((item, index) => (
                                        <div className="list-group-item px-0 d-flex justify-content-between align-items-center border-bottom-dashed" key={index}>
                                            <div>
                                                <span className="fw-bold text-dark">
                                                    <i className="bi bi-box-seam text-success me-2"></i>
                                                    {item.tipoDeBolsa}
                                                </span>
                                                <span className="badge bg-jd-green text-white ms-2 px-2 py-1 shadow-sm">
                                                    {item.cantidad}
                                                </span>
                                            </div>

                                            {/* Botón de eliminar */}
                                            <button
                                                className="btn btn-outline-danger btn-sm border-0"
                                                onClick={() => eliminarDelCarrito(index)}
                                                title="Eliminar producto"
                                            >
                                                <i className="bi bi-trash3"></i>
                                            </button>
                                        </div>
                                    ))}
                                </div>
                            </div>
                        )}
                    </div>

                    {/* Acción Final: Confirmación - También Amarillo JD */}
                    <div className="card-footer bg-light p-4 border-0">
                        <form onSubmit={envioDeFormulario}>
                            <button
                                type="submit"
                                className="btn btn-jd-yellow w-100 py-3 fw-bold fs-5 shadow-sm"
                                disabled={carrito.length === 0}
                            >
                                CONFIRMAR PEDIDO <i className="bi bi-check-all ms-2"></i>
                            </button>
                        </form>
                        <div className="text-center mt-3">
                            <Link to="/" className="text-decoration-none text-muted small jd-link">
                                <i className="bi bi-x-circle me-1"></i> Cancelar y volver
                            </Link>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}