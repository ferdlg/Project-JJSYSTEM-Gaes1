import { Link } from 'react-router-dom'
import './NavBar.css'

const NavSuperior = () => {
  return (
  <nav className="navbar navbar-expand-lg bg-body-tertiary NavSuperior text-light">
    <div className="container-fluid bg_moradoOscuro">
      <a href='/Manzanas'>
        <img src='img/logoCompleto.svg' className='logo navbar-brand'/>
      </a>
      <button className="navbar-toggler btn_blanco" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span className="navbar-toggler-icon"></span>
      </button>
      <div className="collapse navbar-collapse opciones" id="navbarSupportedContent">
        <Link to="/" className='btn_outline_blanco p-2'>Manzanas</Link>
        <Link to="/Usuarios" className='btn_outline_blanco p-2'>Usuarios</Link>
        <Link to="/Municipios" className='btn_outline_blanco p-2'>Municipios</Link>
        <Link to="/Servicios" className='btn_outline_blanco p-2'>Servicios</Link>
        <Link to="/Citas" className='btn_outline_blanco p-2'>Citas</Link>
        <Link to="/#" className='btn_outline_blanco p-2'>Agenda</Link>
        <Link to="/Mapa" className='btn_outline_blanco p-2'>Mapa</Link>
        <Link to="/Landing" className='btn_outline_verde p-2'>Salir</Link>
      </div>
    </div>
  </nav>
  )
}

export default NavSuperior;