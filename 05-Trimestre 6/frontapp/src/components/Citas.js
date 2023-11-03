import React, {useEffect, useState} from "react";
import axios from "axios";
import Swal from "sweetalert2";
import withReactContent from "sweetalert2-react-content";
import {mostrar_alerta} from "../funciones/citas_funciones";

const MostrarCitas = () =>{
    const url = "http://localhost:8080/api.jjSystem/citas"
    const [citas, setCitas]= useState([]);
    const [idCita, setIdCita] = useState('');
    const [fechaCita, setFechaCita] = useState('');
    const [direccionCita, setDireccionCita] = useState('');
    const [contactoCliente, setContactoCliente] = useState('');
    const [descripcionCita, setDescripcionCita] = useState('');
    const [idTecnico, setIdTecnico] = useState('');
    const [idAdministrador, setIdAdministrador] = useState('');
    const [idCotizacion, setIdCotizacion] = useState('');
    const [idEstadoCita, setIdEstadoCita] = useState('1');

    useEffect(()=>
        {
            getCitas();
        },[]
    );

    const getCitas = async()=>
    {
        const respuesta = await axios.get(url);
        setCitas(respuesta.data);
    }
    return(//El codigo de estilos
        <section className="App">
            <div className="container-fluid">
                <div className="row mt-3">
                    <div className="col-12 col-lg-8 offset-0 offser-lg-2">
                        <div className="table-responsive">
                            <table className=" table table-bordered">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Fecha</th>
                                        <th>Direccion</th>
                                        <th>Contacto cliente</th>
                                        <th>Descripcion cita</th>
                                        <th>Tecnico</th>
                                        <th>Administrador</th>
                                        <th>Numero de Cotizacion</th>
                                        <th>Estado</th>
                                    </tr>
                                </thead>
                                <tbody className="table-group-divider">
                                    {citas.map((cita,idCita)=>(
                                        <tr key={cita.idCita}>
                                            <td>{cita.idCita}</td>
                                            <td>{cita.fechaCita}</td>
                                            <td>{cita.direccionCita}</td>
                                            <td>{cita.contactoCliente}</td>
                                            <td>{cita.descripcionCita}</td>
                                            <td>{cita.idTecnico}</td>
                                            <td>{cita.idAdministrador}</td>
                                            <td>{cita.idCotizacion}</td>
                                            <td>{cita.idEstadoCita}</td>
                                            <td>
                                                <button className="btn btn-warning">
                                                    <i className="fa-solid fa-edit"></i>
                                                </button>
                                                &nbsp;
                                                <button className="btn btn-danger">
                                                    <i className="fa-solid fa-trash"></i>
                                                </button>
                                            </td>
                                        </tr>
                                    ))
                                    }
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    )
}
export default MostrarCitas