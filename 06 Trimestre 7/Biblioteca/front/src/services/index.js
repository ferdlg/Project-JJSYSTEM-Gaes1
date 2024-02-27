import axios from "axios";
const url = 'http://127.0.0.1:8000/api/';

const apiService = {
    getLibro : async() => {
        try{
            const url_libro = url + "libros/";
            const response = await axios.get(url_libro);
            const data = response.data;
            return data;
        } catch (error){
            console.error("API ERROR: LIBROS: "+error);
            throw error;
        }
    },
    registrarLibro : async(libro) => {
        try{
            libro.estado = 0;
            const url_libro = url + "libros/";
            const response = await axios.get(url_libro);
            const data = response.data;
            return data;
        }catch (error){
            console.error("API ERROR: REGISTRAR LIBROS: "+error);
            throw error;
        }
    },
    editarLibro : async(libro) => {
        try{
            const id = libro.id_libro;
            const url_libro = url + "libros/"+id+"/";
            const response = await axios.get(url_libro, libro);
            const data = response.data;
            return data;
        }catch (error){
            console.error("API ERROR: ACTUALIZAR LIBROS: "+error);
            throw error;
        }
    },
    getCategorias : async() => {
        try{
            const url_categorias = url + "categorias/";
            const response = await axios.get(url_categorias);
            const data = response.data;
            return data;
        } catch(error){
            console.error("API ERROR: CATEGORIAS: "+error);
            throw error;
        }
    },
    getEstados : async() => {
        try{
            const url_estados = url + "estados/";
            const response = await axios.get(url_estados);
            const data = response.data;
            return data;
        } catch(error){
            console.error("API ERROR: ESTADOS: "+error);
            throw error;
        }
    },
    getLibroUsuario : async() => {
        try{
            const url_libro_usuario = url + "libro_usuario/";
            const response = await axios.get(url_libro_usuario);
            const data = response.data;
            return data;
        } catch(error){
            console.error("API ERROR: LIBRO USUARIO: "+error);
            throw error;
        }
    },
    registrarUSuarios : async(usuario) => {
        try{
            usuario.estado = 0
            const url_registrarusuario = url + "usuarios/";
            const response = await axios.get(url_registrarusuario, usuario);
            const data = response.data;
            return data;
        } catch(error){
            console.error("API ERROR: REGISTRAR USUARIOS: "+error);
            throw error;
        }
    },

    editarUsuario : async (usuario) => {
        try{
            const id = usuario.id_usuario;
            const url_registrarusuario = url + "usuarios/"+id+"/";
            const response = await axios.put(url_registrarusuario, usuario);
            const data = response.data;
            return data;
        } catch (error){
            console.error("API ERROR: ACTUALIZAR USUARIO: "+ error);
            throw error;
        }
    }
}

export default apiService;
