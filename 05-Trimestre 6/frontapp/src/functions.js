//funciones de la app

import Swal from "sweetalert2";
import withReactContent from "sweetalert2-react-content";

//funcion exportable para mostrar todas las citas 
export function mostrar_alerta(mensaje, icono, foco)
{
    const MySwal = withReactContent(Swal);
    MySwal.fire(
        {
            title: mensaje,
            icon: icono,
        }
    );
}

function onfocus(foco)
{
    if (foco !=='')
    {
        document.getElementById(foco).focus();
    }
}