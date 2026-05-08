import { Link } from "react-router-dom";
import "./NavBar.css"

export const NavBar = () => {
  return (
    <>
      <nav  className="navbar navbar-expand-lg bg-body-tertiary" >
      <div className="container-fluid">
        <Link className="navbar-brand" id="logo-v" to="/">
          Mi Silo
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          {/* Eliminamos 'me-auto' para evitar comportamientos horizontales */}
          <ul className="navbar-nav mb-2 mb-lg-0">
            <li className="nav-item">
    <Link to="/" className="nav-link">
      <i className="bi bi-house-door-fill me-2"></i> Inicio
    </Link>
  </li>
  <li className="nav-item">
    <Link to="/silo" className="nav-link">
      <i className="bi bi-database-fill me-2"></i> Silo
    </Link>
  </li>
  <li className="nav-item">
    <Link to="/nuevo-pedido" className="nav-link">
      <i className="bi bi-plus-circle-fill me-2"></i> Nuevo Pedido
    </Link>
  </li>
  <li className="nav-item">
    <Link to="/pedidos" className="nav-link">
      <i className="bi bi-truck"></i> Pedidos
    </Link>
  </li>
          </ul>
        </div>
      </div>
    </nav>
    </>
  );
};
