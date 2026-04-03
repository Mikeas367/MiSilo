import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { SideBar, SiloComponent, SiloForm } from './components'

import "bootstrap/dist/css/bootstrap.min.css";
import 'bootstrap/dist/js/bootstrap.bundle.min';
import "bootstrap-icons/font/bootstrap-icons.css";

function App() {
  
  return (
     <Router>
      <SideBar/>
      <div className="content" style={{ marginLeft: "260px", padding: "20px" }}>
        <Routes>
          <Route path="/"element={<h1>Bienvenido</h1>}></Route>
          <Route path="/silo" element={<SiloComponent/>}></Route>
          <Route path="/llenar-silo" element={<SiloForm/>}></Route>
        </Routes>
      </div>
    </Router>
  )
}

export default App