import {useEffect, useState} from 'react';
import { showAlert} from '../../Utilities';
import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content';
import apiService from '../../services/index.js';

const Libros = () => {
    const [libros, setlibros] = useState([]);
    const [categorias, setCategorias] = useState([]);
    const [estados, setEstados] = useState([]);

    //formularios
    const [modalTitle, setModalTitle] = useState('');
    const [modalOption, setModalOption] = useState('');

    const [id_libro, setId_libro] = useState('');
    const [nombre, setNombre] = useState('');
    const [autor, setAutor] = useState('');
    const [descripcion, setDescripcion] = useState('');
    const [id_categoria_fk, setId_categoria_fk] = useState('');
    const [id_estado_fk, setId_estado_fk] = useState('');

    useEffect(() => {
        listarLibros();
        apiService.getCategorias()
        .then((response) =>{
            setCategorias(response);
        })
        .catch((error) => {
            console.error('Error al cargar las categorias:', error);
        });
        apiService.getEstados()
        .then((response) => {
            setEstados(response);
        }).catch((error) => {
            console.error('Error al cargar los estados:', error);
        });

    }, []);

    const listarLibros = () => {
        apiService.getLibro()
          .then((response) => {
            setlibros(response);
          })
          .catch((error) => {
            console.error('Error al cargar los libros:', error);
          });
      };
    


      const limpiarCampos = () => {
        setNombre("");
        setAutor("");
        setDescripcion("");
        setId_categoria_fk("");
        setId_estado_fk("");
      }
    const openModal = (opcion, _id_libro, _nombre, _autor, _descripcion, _id_categoria_fk, _id_estado_fk)=>{
        limpiarCampos()
        if (opcion === 1){
            setModalTitle('Nuevo Libro');
            setModalOption(1);
        } else if (opcion === 2){
            setModalTitle('Actualizar Libro ID: ${_id_libro}');
            setModalOption(2);
            setId_libro(_id_libro);
            setNombre(_nombre);
            setAutor(_autor);
            setDescripcion(_descripcion);
            setId_categoria_fk(_id_categoria_fk);
            setId_estado_fk(_id_estado_fk);
        }
    };

    const validar = (op) => {
        if (nombre.toString().trim()===""){
            showAlert("warning", "Falta completar los datos", "Ingrese el nombre");
        } else
        if (autor.toString().trim()===""){
            showAlert("warning", "Falta completar los datos", "Ingrese el autor");
        }else
        if (descripcion.toString().trim()===""){
            showAlert("warning", "Falta completar los datos", "Ingrese la descripcion");
        }else
        if (id_categoria_fk.toString().trim()===""){
            showAlert("warning", "Falta completar los datos", "Ingrese la categoria");
        }else
        if (id_estado_fk.toString().trim()===""){
            showAlert("warning", "Falta completar los datos", "Ingrese el estado");
        } 
    };

    const registrarLibro = (_libro)=>{
        try{
            apiService.registrarLibro(_libro)
                .then(() => {
                    showAlert('success','Libro registrado correctamente');
                    listarLibros();
                    document.getElementById('btn_cerrar').click();
                })
                .catch((error)=>{
                    showAlert('error', 'No se pudo registrar el libro');
                    console.error(error);
                });
        } catch(error){
            console.error('No se pudo registrar el libro' + error);
        }
        const modificarLibro = (_libro) => {
            try {
                apiService.editarLibro(_libro)
                    .then(() => {
                        showAlert('success', 'Libro actualizada correctamente');
                        listarLibros();
                        document.getElementById('btn_cerrar').click();
                    })
                    .catch((error) => {
                        showAlert('error', 'No se pudo actualizar el libro');
                        console.error(error);
                    });
            } catch (error) {
                console.error('No se pudo actualizar el libro' + error);
            }
        }
        const eliminarLibro = (_id_libro) => {
            const libro = { id_cita: _id_libro, estado: 1 };
            const MySwal = withReactContent(Swal);
            MySwal.fire({
                title: '¿Estás seguro?',
                text: 'Esta acción eliminará el libro. ¿Quieres continuar?',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Sí, eliminar',
                cancelButtonText: 'Cancelar',
            }).then((result) => {
                if (result.isConfirmed) {
                    try {
                        apiService.editarLibro(libro)
                            .then(() => {
                                showAlert('success', 'Libro eliminado correctamente');
                                listarLibros();
                                document.getElementById('btn_cerrar').click();
                            })
                            .catch((error) => {
                                showAlert('error', 'No se pudo eliminar el libro');
                                console.error(error);
                            });
                    } catch (error) {
                        console.error('No se pudo eliminar el libro ' + error);
                    }
                }
            });
          }
          return (
            <>
              <div className="container">
                <div className="d-flex justify-content-between py-3">
                  <h1>Libros</h1>
                  <div className="d-flex gap-3">
                    <button
                      className="btn_outline_moradoOscuro p-1"
                      data-bs-toggle="modal"
                      data-bs-target="#nuevoEditarCita"
                      onClick={() => openModal(1)}
                    >
                      + Nuevo Libro
                    </button>
                  </div>
                </div>
                <div className="table-responsive border_verde rounded bg_gris">
                <table className="table table-hover">
                            <thead>
                                <tr className='border_moradoOscuro'>
                                    <th className="text-center" scope="col">Titulo</th>
                                    <th className="text-center" scope="col">Autor</th>
                                    <th className="text-center" scope="col">Descripcion</th>
                                    <th className="text-center" scope="col">Categoria</th>
                                    <th className="text-center" scope="col">Estado</th>
                                </tr>
                            </thead>
                            <tbody>
                            {libros.map((i) => {
                                if (i.estado === 0) {
                                    return (
                                        <tr key={i.nombre}>
                                            <td>{i.autor}</td>
                                            <td>{i.descripcion}</td>
                                            <td>{i.id_categoria_fk}</td>
                                            <td>{i.id_estado_fk}</td>
                                            <td className='d-flex gap-2 justify-content-center'>
                                                <button
                                                    className='btn btn-warning'
                                                    onClick={() => openModal(
                                                        2,
                                                        i.id_libro,
                                                        i.nombre,
                                                        i.autor,
                                                        i.descripcion,
                                                        i.id_categoria_fk,
                                                        i.id_estado_fk,
                                                    )}
                                                    data-bs-toggle="modal"
                                                    data-bs-target="#nuevoEditarCita"
                                                >
                                                    <i className='fa-solid fa-edit btnEditar color_blanco'></i>
                                                </button>
                                                <button className='btn btn-danger' onClick={() => eliminarLibro(i.id_libro)}>
                                                    <i className='fa-solid fa-trash color_blanco'></i>
                                                </button>
                                            </td>
                                        </tr>
                                    );
                                } else {
                                    return null;
                                }
                            })}
        
        
        
                            </tbody>
                        </table>
                </div>
                 {/* Modal Nuevo y Editar */}
            <div className="modal fade" id="nuevoEditarCita" tabIndex="-1" data-bs-backdrop="static" data-bs-keyboard="false" aria-hidden="true">
            <div className="modal-dialog modal-dialog-scrollable modal-dialog-centered modal-lg" role="document">
                <div className="modal-content">
                <div className="modal-header bg_moradoOscuro color_blanco">
                    <h5 className="modal-title" id="modalTitleId">{modalTitle}</h5>
                    <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close" onClick={limpiarCampos}></button>
                </div>
                <div className="modal-body">
                        <div className="text-center">
                            <div className="d-flex gap-2 inputsContainer">
                            <div className="input-group mb-3">
                                <span className="input-group-text">
                                Categoria:
                                </span>
                                <select
                                className="form-select"
                                value={id_categoria_fk}
                                onChange={(error) => setId_categoria_fk(error.target.value)}
                                >
                                <option value="" disabled>
                                    Seleccione una categoria
                                </option>
                                {categorias.map((categoria) => (
                                    <option key={categoria.id_categoria} value={categoria.id_categoria_fk}>
                                    {categoria.categoria}
                                    </option>
                                ))}
                                </select>
                            </div>
                            </div>
                            <div className="d-flex gap-2 inputsContainer">
                            <div className="input-group mb-3">
                                <span className="input-group-text">
                                Estado:
                                </span>
                                <select
                                className="form-select"
                                value={id_estado_fk}
                                onChange={(error) => setId_estado_fk(error.target.value)}
                                >
                                <option value="" disabled>
                                    Seleccione un estado
                                </option>
                                {estados.map((estado) => (
                                    <option key={estado.id_estado} value={estado.id_servicio}>
                                    {estado.estado}
                                    </option>
                                ))}
                                </select>
                            </div>
                            </div>
                            <div className="d-flex gap-2 inputsContainer">
                            <div className="input-group mb-3">
                                <span className="input-group-text">
                                Titulo del libro:
                                </span>
                                <input
                                type="text"
                                className="form-control"
                                placeholder='Titulo'
                                value={nombre}
                                onChange={(error) => setNombre(error.target.value)}
                                required
                                />
                            </div>
                            <div className="input-group mb-3">
                                <span className="input-group-text">
                                Autor del libro:
                                </span>
                                <input
                                type="text"
                                className="form-control"
                                placeholder='Autor'
                                value={autor}
                                onChange={(error) => setAutor(error.target.value)}
                                required
                                />
                            </div>
                            </div>
                            <div className="d-flex gap-2 inputsContainer">
                            <div className="input-group mb-3">
                                <span className="input-group-text">
                                Descripcion del libro:
                                </span>
                                <input
                                type="text"
                                className="form-control"
                                placeholder="Descripcion"
                                value={descripcion}
                                onChange={(error) => setDescripcion(error.target.value)}
                                required
                                />
                            </div>
                            </div>
                        </div>
                        </div>

                        <div className="modal-footer">
                            <button type="button" className="btn btn_naranja" data-bs-dismiss="modal" id='btn_cerrar'>Cancelar</button>
                            <button type="button" className="btn btn_verde" onClick={() => validar(modalOption)}>Guardar</button></div>
                        </div>
            </div>
            </div>
        </div>
        </>
            )
    };
}
export default Libros;