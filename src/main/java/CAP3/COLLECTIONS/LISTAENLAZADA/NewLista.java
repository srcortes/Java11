package CAP3.COLLECTIONS.LISTAENLAZADA;

import java.util.Arrays;

class Persona{
    String nombre;
    String  identificacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}

class Nodo{
    Persona datos;
    Nodo siguienteNodo;

    Nodo(Persona objeto){
        this(objeto, null);
    }

    Nodo(Persona objeto, Nodo nodo) {
        datos = objeto;
        siguienteNodo = nodo;
    }

    Object obtenerObject() {
        return datos;
    }

    Nodo obtenerSiguiente() {
        return siguienteNodo;
    }
}

public class NewLista {
    Nodo primerNodo;
    Nodo ultimoNodo;

    public void insertarFrente(){
        if(listaVacia()){
            primerNodo = ultimoNodo = null;
        } else{
            primerNodo =
        }

    }

    Persona construirPersona(String... datos){
        Persona persona = null;
       for(int j=0; j < datos.length; j++){
           persona = new Persona();

       }
    }

    public boolean listaVacia(){
        return primerNodo == null;
    }
}
