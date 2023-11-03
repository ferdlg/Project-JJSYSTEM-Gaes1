//funciones de la app
import Swal from "sweetalert2";
import withReactContent from "sweetalert2-react-content";

//funcion exportable para mostrar todas las citas 
export function mostrar_alerta(mensaje, icono, foco)
{
    onfocus(foco);
    const MySwal = withReactContent(Swal);
    MySwal.fire(
        {
            title: mensaje,
            icon: icono,
        }
    );
}
//Funcion interna, para activar foco
function onfocus(foco)
{
    if (foco !=='')
    {
        document.getElementById(foco).focus();
    }
}
