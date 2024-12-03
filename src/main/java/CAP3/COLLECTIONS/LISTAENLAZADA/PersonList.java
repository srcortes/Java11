package CAP3.COLLECTIONS.LISTAENLAZADA;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

class Persona {
    String numberIdentification;
    Integer age;
    Integer turno;

    public String getNumberIdentification() {
        return numberIdentification;
    }

    public void setNumberIdentification(String numberIdentification) {
        this.numberIdentification = numberIdentification;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return turno + "-" + numberIdentification + " / " + age;
    }

}

class Nodo {
    Persona datos;
    Nodo anteriorNodo;
    Nodo siguienteNodo;

    Nodo(Persona objeto) {
        this(objeto, null, null);
    }

    Nodo(Persona objeto, Nodo nodo, Nodo nodoAnt) {
        datos = objeto;
        siguienteNodo = nodo;
        anteriorNodo = nodoAnt;
    }


    Object obtenerObject() {
        return datos;
    }

    Nodo obtenerSiguiente() {
        return siguienteNodo;
    }
}

public class PersonList {
    Nodo firstNode;
    Nodo lastNode;
    static int turn = 0;

    public void evaluateList(List<Persona> list) {
        list.forEach(i -> {

            if (i.age >= 60) {
                Persona old1 = new Persona();
                old1.setNumberIdentification(i.numberIdentification);
                old1.setAge(i.getAge());
                insertFront(old1);
            } else {
                Persona young = new Persona();
                young.setNumberIdentification(i.getNumberIdentification());
                young.setAge(i.getAge());
                insertEnd(young);
            }
        });

        print();

    }

    public void insertEnd(Persona persona) {
        if (listEmpty())
            firstNode = lastNode = new Nodo(persona);
        else
            lastNode = lastNode.siguienteNodo = new Nodo(persona);



    }


    /**
     * @param identificationNumber
     */
    public void insertFront(Persona persona) {
        if (listEmpty()) {
            firstNode = lastNode = new Nodo(persona);
        } else {




        }

    }

    public void ordenar() {
        Persona current = firstNode.datos;


        while (current != null) {

            if (current.getAge() >= 80) {
                firstNode.datos = current;

            }

        }
    }

    /**
     *
     */
    public void print() {

        Nodo previous = firstNode;
        Nodo next = firstNode;


        while (next.siguienteNodo != null) {

            if (previous.anteriorNodo != null) {
                System.out.print(previous.anteriorNodo.datos + ".. ");
                previous = previous.anteriorNodo;
            } else if (next.siguienteNodo != null) {
                System.out.print(next.siguienteNodo.datos + " ");
                next = next.siguienteNodo;
            }

            System.out.println("....");

        }
    }

    public boolean listEmpty() {
        return firstNode == null;
    }

    public static void main(String[] args) {
        Supplier<Persona> personaSupplier = Persona::new;
        Supplier<List<Persona>> listSupplier = ArrayList::new;


        Persona p1 = personaSupplier.get();
        p1.setNumberIdentification("41777657");
        p1.setAge(60);

        Persona p2 = personaSupplier.get();
        p2.setNumberIdentification("80217780");
        p2.setAge(41);

        Persona p3 = personaSupplier.get();
        p3.setNumberIdentification("63545795");
        p3.setAge(38);

        Persona p5 = personaSupplier.get();
        p5.setNumberIdentification("jr20179");
        p5.setAge(100);

        Persona p4 = personaSupplier.get();
        p4.setNumberIdentification("6270561");
        p4.setAge(75);

        Persona p = personaSupplier.get();
        p.setNumberIdentification("3218259650");
        p.setAge(90);


        List<Persona> list = listSupplier.get();
        list.add(p4);
        list.add(p2);
        list.add(p3);
        list.add(p5);
        list.add(p);
        list.add(p1);


        new PersonList().evaluateList(list);

    }
}
