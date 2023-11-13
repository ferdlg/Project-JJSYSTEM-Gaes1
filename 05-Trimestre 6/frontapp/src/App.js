import React from "react";
import { Routes, Route, BrowserRouter } from "react-router-dom";
import Citas from "./components/Citas";
import Envios from "./components/Envios";

function App(){
  return(
    <BrowserRouter>
      <Routes>
        <Route path="/Citas" element={<Citas></Citas>}></Route>
        <Route path="/Envios" element={<Envios></Envios>}></Route>
      </Routes>
    </BrowserRouter>
  )
}
export default App