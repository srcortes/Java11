package CAP3.COLLECTIONS.LIST;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PruebaCollection
{
    private static final String[] colores = {"MAGENTA","ROJO","AZUL","CYAN"};
    private static final String[] eliminarColores = {"ROJO","BLANCO","AZUL"};
    Consumer<String> print = System.out::print;

    public PruebaCollection()
    {



        var lista = new ArrayList<String>();
        var eliminarLista = new ArrayList<String>();

        for(String color : colores)
            lista.add(color);

        for(int cuenta = 0; cuenta < lista.size(); cuenta++)
            print.accept(" " + lista.get(cuenta));

        this.eliminarColores(lista, eliminarLista);

        for(String color : lista )
            print.accept(color);


    }

    private void eliminarColores(Collection<String> collection1, Collection<String> collection2)
    {
        Iterator<String> iterador = collection1.iterator();
        while(iterador.hasNext()){

            if(collection2.contains(iterador.next()))
                iterador.remove();



        }


        ListIterator<String> iterador2 = List.of(collection1.toString()).listIterator();
        while(iterador2.hasNext()){
            if(collection2.contains(iterador2.next()))
                iterador2.remove();

        }


    }

    public static void main(String[] args)
    {
        new PruebaCollection();
    }
}
