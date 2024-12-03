package FIT;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@FunctionalInterface
interface CreateObject<Name, Id, Members> {
    Members apply(Name name, Id id);
}

class Members {
    private String name;
    private Integer Id;

    public Members(String name, Integer id) {
        this.name = name;
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}

class NodeTest {
    Members datos;
    Members anteriorNodo;
    NodeTest siguienteNodo;

    NodeTest(Members objeto) {
        this(objeto, null, null);
    }

    NodeTest(Members objeto, NodeTest nodo, NodeTest nodoAnt) {
        datos = objeto;
        siguienteNodo = nodo;

    }

    Object obtenerObject() {
        return datos;
    }

    NodeTest obtenerSiguiente() {
        return siguienteNodo;
    }
}



public class FitGlobant {
    static NodeTest firstNode;

    static NodeTest lastNode;

    static List<Members>  list;

    public static void evaluateList(List<Members> list) {
        list.forEach(value ->{
            insertFront(value);
        });

        print();

    }

    public static List<Members> CreateList(Supplier<List<Members>> listSupplier) {
        return listSupplier.get();
    }

    public static void insertFront(Members members) {
        if (listEmpty())
            firstNode = lastNode = new NodeTest(members);
        else
            firstNode = firstNode.siguienteNodo = new NodeTest(members);
    }

    public static Members CreateObjectFamily(String name,Integer id,
                                            CreateObject<String, Integer, Members> createFamily){
        return createFamily.apply(name, id);

    }

    public static void PrintInfo(String value, Consumer<String> consumer){
        consumer.accept(value);
    }

    public static boolean listEmpty() {
        return firstNode == null;
    }

    public static void print() {

        NodeTest previous = firstNode;
        NodeTest next = firstNode;


        while (next.siguienteNodo != null) {

            if (previous.anteriorNodo != null) {

            } else if (next.siguienteNodo != null) {
                System.out.print(next.siguienteNodo.datos + " ");
                next = next.siguienteNodo;
            }

            System.out.println("....");

        }
    }



    public static void main(String[] args) {
        Members membersOne = FitGlobant.CreateObjectFamily("John Rodriguez", 40, Members::new);
        Members membersTwo = FitGlobant.CreateObjectFamily("July Mora", 40, Members::new);

        list = FitGlobant.CreateList(ArrayList::new);
        list.add(membersOne);
        list.add(membersTwo);
        list.sort(Comparator.comparing(Members::getName));


        FitGlobant.evaluateList(list);


    }

    }


