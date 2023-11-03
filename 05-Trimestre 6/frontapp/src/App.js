import React from "react";
import { Routes, Route, BrowserRouter } from "react-router-dom";
import Citas from "./components/Citas";

function App(){
  return(
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Citas></Citas>}></Route>
      </Routes>
    </BrowserRouter>
  )
}
export default App