import React, { useEffect, useState } from 'react';
import { showAlert } from '../../Utilities';
import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content';
import apiService from '../../services/index.js';

const Libros = () => {
    const [libros, setLibros] = useState([]);
    const [categorias, setCategorias] = useState([]);
    const [estados, setEstados] = useState([]);

    // Formularios
    const [modalTitle, setModalTitle] = useState('');
    const [modalOption, setModalOption] = useState('');

    const [id_libro, setId_libro] = useState('');
    const [nombre, setNombre] = useState('');
    const [autor, setAutor] = useState('');
    const [descripcion, setDescripcion] = useState('');
    const [id_categoria_fk, setId_categoria_fk] = useState('');
    const [id_estado_fk, setId_estado_fk] = useState('');

    useEffect(() => {
        cargarDatos();
    }, []);

    const cargarDatos = () => {
        apiService.getLibro()
            .then((response) => {
                setLibros(response);
                console.log(libros);
            })
            .catch((error) => {
                console.error('Error al cargar los libros:', error);
            });

        apiService.getCategorias()
            .then((response) => {
                setCategorias(response);
            })
            .catch((error) => {
                console.error('Error al cargar las categorias:', error);
            });

        apiService.getEstados()
            .then((response) => {
                setEstados(response);
            })
            .catch((error) => {
                console.error('Error al cargar los estados:', error);
            });
    };

    const limpiarCampos = () => {
        setNombre('');
        setAutor('');
        setDescripcion('');
        setId_categoria_fk('');
        setId_estado_fk('');
    };

    const openModal = (opcion, _id_libro, _nombre, _autor, _descripcion, _id_categoria_fk, _id_estado_fk) => {
        limpiarCampos();
        if (opcion === 1) {
            setModalTitle('Nuevo Libro');
            setModalOption(1);
        } else if (opcion === 2) {
            setModalTitle(`Actualizar Libro ID: ${_id_libro}`);
            setModalOption(2);
            setId_libro(_id_libro);
            setNombre(_nombre);
            setAutor(_autor);
            setDescripcion(_descripcion);
            setId_categoria_fk(_id_categoria_fk);
            setId_estado_fk(_id_estado_fk);
        }
    };

    const validar = () => {
        if (!nombre.trim() || !autor.trim() || !descripcion.trim() || !id_categoria_fk.trim() || !id_estado_fk.trim()) {
            showAlert('warning', 'Falta completar los datos', 'Por favor, complete todos los campos');
            return false;
        }
        return true;
    };

    const registrarLibro = (_libro) => {
        try {
            apiService.registrarLibro(_libro)
                .then(() => {
                    showAlert('success', 'Libro registrado correctamente');
                    cargarDatos();
                    document.getElementById('btn_cerrar').click();
                })
                .catch((error) => {
                    showAlert('error', 'No se pudo registrar el libro');
                    console.error(error);
                });
        } catch (error) {
            console.error('No se pudo registrar el libro' + error);
        }
    };

    const modificarLibro = (_libro) => {
        try {
            apiService.editarLibro(_libro)
                .then(() => {
                    showAlert('success', 'Libro actualizado correctamente');
                    cargarDatos();
                    document.getElementById('btn_cerrar').click();
                })
                .catch((error) => {
                    showAlert('error', 'No se pudo actualizar el libro');
                    console.error(error);
                });
        } catch (error) {
            console.error('No se pudo actualizar el libro' + error);
        }
    };

    const eliminarLibro = (_id_libro) => {
        const libro = { id_libro: _id_libro};
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
                            cargarDatos();
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
    };

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
                            <tr className="border_moradoOscuro">
                                <th className="text-center" scope="col">
                                    Titulo
                                </th>
                                <th className="text-center" scope="col">
                                    Autor
                                </th>
                                <th className="text-center" scope="col">
                                    Descripcion
                                </th>
                                <th className="text-center" scope="col">
                                    Categoria
                                </th>
                                <th className="text-center" scope="col">
                                    Estado
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            {libros && libros.map((libro) => {
                                if (libro) {
                                    return (
                                        <tr key={libro.id_libro}>
                                            <td>{libro.nombre}</td>
                                            <td>{libro.autor}</td>
                                            <td>{libro.descripcion}</td>
                                            <td>{libro.id_categoria_fk}</td>
                                            <td>{libro.id_estado_fk}</td>
                                            <td className="d-flex gap-2 justify-content-center">
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
                <div
                    className="modal fade"
                    id="nuevoEditarCita"
                    tabIndex="-1"
                    data-bs-backdrop="static"
                    data-bs-keyboard="false"
                    aria-hidden="true"
                >
                    <div className="modal-dialog modal-dialog-scrollable modal-dialog-centered modal-lg" role="document">
                        <div className="modal-content">
                            <div className="modal-header bg_moradoOscuro color_blanco">
                                <h5 className="modal-title" id="modalTitleId">
                                    {modalTitle}
                                </h5>
                                <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close" onClick={limpiarCampos}></button>
                            </div>
                            <div className="modal-body">
                                <div className="text-center">
                                    <div className="d-flex gap-2 inputsContainer">
                                        <div className="input-group mb-3">
                                            <span className="input-group-text">Categoria:</span>
                                            <select
                                                className="form-select"
                                                value={id_categoria_fk}
                                                onChange={(e) => setId_categoria_fk(e.target.value)}
                                            >
                                                <option value="" disabled>
                                                    Seleccione una categoria
                                                </option>
                                                {categorias.map((categoria) => (
                                                    <option key={categoria.id_categoria} value={categoria.id_categoria}>
                                                        {categoria.categoria}
                                                    </option>
                                                ))}
                                            </select>
                                        </div>
                                    </div>
                                    <div className="d-flex gap-2 inputsContainer">
                                        <div className="input-group mb-3">
                                            <span className="input-group-text">Estado:</span>
                                            <select
                                                className="form-select"
                                                value={id_estado_fk}
                                                onChange={(e) => setId_estado_fk(e.target.value)}
                                            >
                                                <option value="" disabled>
                                                    Seleccione un estado
                                                </option>
                                                {estados.map((estado) => (
                                                    <option key={estado.id_estado} value={estado.id_estado}>
                                                        {estado.estado}
                                                    </option>
                                                ))}
                                            </select>
                                        </div>
                                    </div>
                                    <div className="d-flex gap-2 inputsContainer">
                                        <div className="input-group mb-3">
                                            <span className="input-group-text">Titulo del libro:</span>
                                            <input
                                                type="text"
                                                className="form-control"
                                                placeholder="Titulo"
                                                value={nombre}
                                                onChange={(e) => setNombre(e.target.value)}
                                                required
                                            />
                                        </div>
                                        <div className="input-group mb-3">
                                            <span className="input-group-text">Autor del libro:</span>
                                            <input
                                                type="text"
                                                className="form-control"
                                                placeholder="Autor"
                                                value={autor}
                                                onChange={(e) => setAutor(e.target.value)}
                                                required
                                            />
                                        </div>
                                    </div>
                                    <div className="d-flex gap-2 inputsContainer">
                                        <div className="input-group mb-3">
                                            <span className="input-group-text">Descripcion del libro:</span>
                                            <input
                                                type="text"
                                                className="form-control"
                                                placeholder="Descripcion"
                                                value={descripcion}
                                                onChange={(e) => setDescripcion(e.target.value)}
                                                required
                                            />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn_naranja" data-bs-dismiss="modal" id="btn_cerrar">
                                    Cancelar
                                </button>
                                <button type="button" className="btn btn_verde" onClick={() => validar() && modalOption === 1 ? registrarLibro({'nombre':nombre, 'autor':autor, 'descripcion':descripcion, 'categoria':id_categoria_fk, 'estado':id_estado_fk}) : modificarLibro()}>
                                    Guardar
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
};

export default Libros;
