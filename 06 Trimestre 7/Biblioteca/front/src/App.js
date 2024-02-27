import {BrowserRouter, Routes, Route, useLocation } from 'react-router-dom';
import Login from './pages/Login/index.js';
import Registro from './pages/Registro/index.js';
import Libros from './pages/Libros/index.js';
import NavSuperior from './components/NavSuperior/index.js';
import Footer from './components/Footer/index.js';

function App(){
  return(
  <BrowserRouter>
    {
      window.location.pathname !== "/Login"
      && window.location.pathname !== "/Registrarse" ? <NavSuperior/> : null
    }
    <Routes>
      <Route path = '/Login' element = {<Login/>}/>
      <Route path = '/Registrarse' element = {<Registro/>}/>

      <Route path= '/Libros' element = {<Libros/>}/>
    </Routes>
    <Footer/>
  </BrowserRouter>
  );
}

export default App;