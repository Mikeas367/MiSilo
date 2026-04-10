import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { LoginComponent, PedidoForm, PedidoList, SideBar, SiloComponent, SiloForm } from './components'

import "bootstrap/dist/css/bootstrap.min.css";
import 'bootstrap/dist/js/bootstrap.bundle.min';
import "bootstrap-icons/font/bootstrap-icons.css";
import { ProtectedRoute } from "./components/ProtectedRoute";

function App() {
  
  return (
     <Router>
      <SideBar/>
      <div className="content" style={{ marginLeft: "260px", padding: "20px" }}>
        <Routes>
          {/* Rutas Publicas */}
          <Route path="/login" element={<LoginComponent />} />
          {/* Rutas Privadas */}
          <Route element={<ProtectedRoute/>}>
            <Route path="/"element={<h1>Bienvenido</h1>}></Route>
            <Route path="/silo" element={<SiloComponent/>}></Route>
            <Route path="/pedidos" element={<PedidoList/>}></Route>
            <Route path="/llenar-silo" element={<SiloForm/>}></Route>
            <Route path="/nuevo-pedido" element={<PedidoForm/>}></Route>
          </Route>
        </Routes>
      </div>
    </Router>
  )
}

export default App