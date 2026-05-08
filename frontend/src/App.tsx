import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
} from "react-router-dom";
import {
  LoginComponent,
  PedidoForm,
  PedidoList,
  SideBar,
  SiloComponent,
  SiloForm,
} from "./components";

import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min";
import "bootstrap-icons/font/bootstrap-icons.css";
import { useEffect, useState } from "react";
import { NavBar } from "./components/NavBar/NavBar";
import { Menu } from "./components/Menu/Menu";

function App() {
  const [token, setToken] = useState<string | null>(
    localStorage.getItem("token"),
  );

  useEffect(() => {
    // Esta función revisa el token y actualiza el estado de React
    const checkToken = () => {
      const currentToken = localStorage.getItem("token");
      if (currentToken !== token) {
        setToken(currentToken);
      }
    };

    // 2. Escuchamos cambios en el storage (útil si abres otra pestaña)
    window.addEventListener("storage", checkToken);

    // 3. Creamos un intervalo pequeño para chequear cambios locales
    // (Esto soluciona el problema de "tengo que recargar")
    const interval = setInterval(checkToken, 500);

    return () => {
      window.removeEventListener("storage", checkToken);
      clearInterval(interval);
    };
  }, [token]);

  return (
      <Router>
    {/* El container-fluid ocupa todo el ancho sin márgenes laterales */}
    <div className="container-fluid p-0"> 
      <div className="row g-0"> {/* g-0 elimina el espacio entre columnas si quieres que la barra esté pegada */}
        
        {/* Columna de la Navbar: 2 de 12 en escritorio (lg), 12 de 12 en mobile */}
        {token && (
          <div className="col-12 col-lg-2">
            <NavBar />
          </div>
        )}

        {/* Columna del Contenido: 10 de 12 en escritorio, 12 de 12 en mobile */}
        <main className={token ? "col-12 col-lg-10" : "col-12"}>
          <div className="p-4"> {/* Padding interno para que el texto no pegue al borde */}
            <Routes>
            <Route
              path="/login"
              element={token ? <Navigate to="/" replace /> : <LoginComponent />}
            />

            {/* Rutas protegidas por lógica de estado */}
            <Route path="/" element={token ? (
                  <Menu/>
                ) : (
                  <Navigate to="/login" replace />
                )
              }
            />
            <Route
              path="/silo"
              element={
                token ? <SiloComponent /> : <Navigate to="/login" replace />
              }
            />
            <Route
              path="/pedidos"
              element={token ? <PedidoList /> : <Navigate to="/login" replace />}
            />
            <Route
              path="/llenar-silo"
              element={token ? <SiloForm /> : <Navigate to="/login" replace />}
            />
            <Route
              path="/nuevo-pedido"
              element={token ? <PedidoForm /> : <Navigate to="/login" replace />}
            />

            {/* Redirección por defecto */}
            <Route
              path="*"
              element={<Navigate to={token ? "/" : "/login"} replace />}
            />
          </Routes>
          </div>
        </main>

      </div>
    </div>
  </Router>
    
  );
}

export default App;


