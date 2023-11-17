import React, { useEffect, useState } from "react";

const Envios = () => {
  const [envios, setEnvios] = useState([]);

  const handleDelete = idEnvio => {
    const requestInit = {
      method: "DELETE"
    }
    fetch ('http://localhost:8080/api.jjSystem/envios/' + idEnvio, requestInit)
  }


  useEffect(() => {
    const getEnvios = async () => {
      const respuesta = await fetch('http://localhost:8080/api.jjSystem/envios');
      const datos = await respuesta.json();
      console.log(datos);
      setEnvios(datos);
    };

    getEnvios();
  }, []);

  const listaEnvios = envios.map((envio) => (
    <tr key={envio.idEnvio}>
      <td>{envio.idEnvio}</td>
      <td>{envio.direccionEnvio}</td>
      <td>{envio.tecnicos.id}</td>
      <td>{envio.estadosEnvios.nombreEstadoEnvio}</td>
      <td>
        <div className="mb-3">
          <button onClick={() => handleDelete(envio.idEnvio)}className="btn btn-danger"> Delete </button>
        </div>
      </td>
    </tr>
  ));

  return (
    <div id="content" style={{marginTop: '30px'}}>
          <div class="container" style={{marginLeft: '30px'}}>
              <div class="row">
                  <div class="col-lg-9 allowed_prod">
                      <h2 class="font-weight-bold">ENVIOS: </h2>
                  </div>
              </div>
          </div>

    <section style={{padding: '30px'}}>
        <form class="form-inline position-relative my-2 d-inline-block">
            <input class="form-control mr-sm-2" type="search" placeholder="Buscar" aria-label="Search"></input>
        </form>
    </section>

    <section class="s-data-table">
      <table className="table">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Dirección</th>
              <th scope="col">ID Tecnico</th>
              <th scope="col">Estado</th>
              <th></th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {listaEnvios}
          </tbody>
      </table>
        <a href="" class="btn btn-primary btn-sm">Añadir Envio</a>
        <a href="" class="btn btn-success btn-sm">Exportar</a>
    </section>
    </div>

  );
};

export default Envios;
