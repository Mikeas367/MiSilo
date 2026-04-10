import { useState } from 'react';
import { Link } from 'react-router-dom';
import './SideBar.css';

export const SideBar = () => {
    const [isOpen, setIsOpen] = useState(true);

    const toggleSidebar = () => setIsOpen(!isOpen);

    return (
        <>
            {/* Botón de hamburguesa (siempre visible o según necesites) */}
            <button className="btn-toggle" onClick={toggleSidebar}>
                <i className={`bi ${isOpen ? 'bi-x-lg' : 'bi-list'}`}></i>
            </button>

            <div className={`sidebar ${isOpen ? 'open' : 'closed'}`}>
                <h1 className="sidebar-title">a</h1>
                <h1 className="sidebar-title">Menu</h1>
                <ul className="nav flex-column">
                    <li className='nav-item'>
                        <Link to="/" className='nav-link'>Inicio</Link>
                    </li>
                    <li className='nav-item'>
                        <Link to="/silo" className='nav-link'>
                            Silo <i className="bi bi-database-fill"></i> 
                        </Link>
                    </li>
                    <li className='nav-item'>
                        <Link to="/nuevo-pedido" className='nav-link'>Nuevo Pedido</Link>
                    </li>
                    <li className='nav-item'>
                        <Link to="/pedidos" className='nav-link'>Pedidos</Link>
                    </li>
                </ul>
            </div>
        </>
    );
};