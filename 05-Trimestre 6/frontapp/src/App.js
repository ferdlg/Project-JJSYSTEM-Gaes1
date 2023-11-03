import React from "react";
import Login from "./components/Login";
import { Routes, Route, BrowserRouter } from "react-router-dom";

function App(){
  return(
    <BrowserRouter>
      <Routes>
        <Route path="/" element={Login}></Route>
      </Routes>
    </BrowserRouter>
  )
}