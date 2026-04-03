import { Link } from 'react-router-dom';
import './SideBar.css'

export const SideBar = () =>  {
    return(
    <>
    <div className="sidebar">
        <h1 className="sidebar-title">Menú</h1>
        <ul className="nav flex-colum">
            {/* Inicio */}
            <li className='nav-item'>
                <Link to="/" className='nav-link'>
                    Inicio
                </Link>
            </li>

            {/* Silo */}
            <li className='nav-item'>
                <Link to="/silo" className='nav-link'>
                    Silo  <i className="bi bi-database-fill"></i> 
                </Link>
            </li>
        </ul>
        
    </div>  

    </>
)
}

export default SideBar;