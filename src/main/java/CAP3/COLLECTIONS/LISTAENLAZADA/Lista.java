package CAP3.COLLECTIONS.LISTAENLAZADA;

import java.util.LinkedList;
import java.util.function.Supplier;


class NodoLista {
    Object datos;
    NodoLista siguienteNodo;

    NodoLista(Object objeto){
        this(objeto, null);
    }

    NodoLista(Object objeto, NodoLista nodo) {
        datos = objeto;
        siguienteNodo = nodo;
    }

    Object obtenerObject() {
        return datos;
    }

    NodoLista obtenerSiguiente() {
        return siguienteNodo;
    }
}

public class Lista{
    private NodoLista primerNodo;
    private NodoLista ultimoNodo;
    private String nombre;

    public Lista() {
        this("Lista");
    }

    public Lista(String nombreLista){
        nombre = nombreLista;
        primerNodo = ultimoNodo = null;
    }

    public void insertarAlfrente(Object elementoInsertar){
        if(estaVacia())
            primerNodo = ultimoNodo = new NodoLista(elementoInsertar);
        else
            primerNodo = new NodoLista( elementoInsertar, primerNodo);

    }

    public void insertarAlFinal(Object elementoInsertar){
        if(estaVacia())
           primerNodo = ultimoNodo = new NodoLista(elementoInsertar);
        else
            ultimoNodo = ultimoNodo.siguienteNodo = new NodoLista(elementoInsertar);

    }

    public Object eliminarDelFrente() throws ExceptionListaVacia {
        if(estaVacia())
            throw new ExceptionListaVacia(nombre);

        Object elementoEliminado = primerNodo.datos;

        if(primerNodo == ultimoNodo)
            primerNodo = ultimoNodo = null;
        else
            primerNodo = primerNodo.siguienteNodo;

        return elementoEliminado;
    }

    public Object eliminarDelFinal() throws ExceptionListaVacia{
        if(estaVacia())
            throw new ExceptionListaVacia(nombre);

        Object elementoEliminado = ultimoNodo.datos;

        if(primerNodo == ultimoNodo)
            primerNodo = ultimoNodo = null;
        else {
            NodoLista actual = primerNodo;

            while(actual.siguienteNodo != ultimoNodo)
                actual = actual.siguienteNodo;

            ultimoNodo = actual;
            actual.siguienteNodo = null;
        }
       return elementoEliminado;
    }

    public boolean estaVacia(){
        return primerNodo == null;
    }

    public void imprimir() {
        if(estaVacia()){
            System.out.printf("%s vacia\n", nombre);
            return;
        }

        System.out.printf("La %s es: ", nombre);
        NodoLista actual = primerNodo;

        while(actual != null){
            System.out.printf("%s ", actual.datos);
            actual = actual.siguienteNodo;
        }

        System.out.println("\n");
    }

    public static void main(String[] args) {
        Supplier<Lista> listaSupplier = Lista::new;
        Lista lista = listaSupplier.get();
        lista.insertarAlfrente("A");
        lista.imprimir();
        lista.insertarAlfrente("B");
        lista.imprimir();
        lista.insertarAlfrente("C");
        lista.imprimir();
        lista.insertarAlFinal("AA");
        lista.imprimir();
    }
}
