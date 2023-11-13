import React, { useEffect, useState } from "react";

const Envios = () => {
  const [envios, setEnvios] = useState([]);

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
    </tr>
  ));

  return (
    <table className="table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Direccion</th>
          <th>Tecnico</th>
          <th>Estado</th>
        </tr>
      </thead>
      <tbody>
        {listaEnvios}
      </tbody>
    </table>
  );
};

export default Envios;
