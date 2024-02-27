import { Link } from "react-router-dom";
import './Register.css';
import { useState } from "react";
import apiService from "../../services/index.js";
import { showAlert } from "../../Utilities/index.js";

const Registro = () => {
    const [email, setEmail] = useState("");
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    // Función validar datos antes de enviar
    const validar = () => {
        if (email.trim() === "") {
            showAlert("warning", "Falta completar los datos", "Debe llenar el correo");
        } else if (username.trim() === "") {
            showAlert("warning", "Falta completar los datos", "Debe llenar el username");
        } else if (password.trim() === "") {
            showAlert("warning", "Falta completar los datos", "Debe llenar la contraseña");
        } else {
            const usuario = {
                email: email,
                username: username,
                password: password,
            }
            registrarUsuario(usuario);
            setEmail("");
            setUsername("");
            setPassword("");
        }
    };

    // Función para registrar nuevo usuario
    const registrarUsuario = (_usuario) => {
        try {
            apiService.registrarUSuarios(_usuario)
                .then(() => {
                    showAlert("success", "Usuario creado correctamente");
                })
                .catch((error) => {
                    showAlert("error", "No se pudo crear el usuario");
                    console.error(error);
                });
        } catch (error) {
            console.error("No se pudo crear Usuario " + error)
        }
    }

    // Componente HTML
    return (
        <div className="Register">
            <div className="overlay"></div>
            <div className="card border_moradoOscuro w-75">
                <div className="card-header p-2 bg_moradoOscuro color_blanco">
                    <h3 className="text-center mt-2">Registrarse</h3>
                </div>
                <div className="card-body">
                    <div className="text-center">
                        <div className="d-flex gap-2 inputsContainer">
                            <div className="input-group mb-3">
                                <span className="input-group-text">
                                    <i className="fa-solid fa-envelope pe-2"></i>
                                    Correo:
                                </span>
                                <input type="email" className="form-control" placeholder="micorreo@correo.com" value={email} onChange={(error) => setEmail(error.target.value)} required />
                            </div>
                        </div>
                        <div className="d-flex gap-2 inputsContainer">
                            <div className="input-group mb-3">
                                <span className="input-group-text">
                                    <i className="fa-solid fa-compass pe-2"></i>
                                    Password:
                                </span>
                                <input type="password" className="form-control" placeholder="Password" value={password} onChange={(error) => setPassword(error.target.value)} required />
                            </div>
                            <div className="input-group mb-3">
                                <span className="input-group-text">
                                    <i className="fa-solid fa-location-crosshairs pe-2"></i>
                                    Username:
                                </span>
                                <input type="text" className="form-control" placeholder="Username" value={username} onChange={(error) => setUsername(error.target.value)} required />
                            </div>
                        </div>
                        <div className="d-grid">
                            <button type="submit" className="btn btn_outline_moradoOscuro" onClick={() => validar()}>Registrarse <i className="fas fa-sign-in-alt"></i></button>
                        </div>
                    </div>
                </div>
                <div className="card-footer text-center">
                    ¿Ya tienes cuenta?, <Link to="/Login">Inicia Sesión</Link>
                </div>
            </div>
        </div>
    );
}

export default Registro;
