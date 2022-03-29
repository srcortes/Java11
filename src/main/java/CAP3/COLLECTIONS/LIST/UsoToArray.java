package CAP3.COLLECTIONS.LIST;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class UsoToArray {
    private int arregloInt[] = {1,2,3,4,5,6};
    private double arregloDouble[] = {8.4, 9.3, 0.2, 7.9, 3.4};
    private int arregloIntLleno [], copiaArregloInt[];

    public UsoToArray() {
        arregloIntLleno = new int[10];
        copiaArregloInt = new int[arregloInt.length];

        /*HERE FILL IN THE ARRAY WITH 7*/
        Arrays.fill(arregloIntLleno, 7);
        Arrays.sort(arregloDouble);

        System.arraycopy(arregloInt, 0, copiaArregloInt, 0, arregloInt.length);
    }

    public void imprimirArreglos() {
        System.out.println("Arreglo double");
        for ( double valorDouble : arregloDouble )
            System.out.printf("%.1f", valorDouble);

        System.out.println("\narregloInt");
        for ( int valorInt : arregloInt )
            System.out.printf("%d", valorInt);

        System.out.println("\narregloInt");
        for ( int valorInt : arregloIntLleno )
            System.out.printf("%d", valorInt);

        System.out.println("\ncopiaArregloInt");
        for ( int valorInt : copiaArregloInt )
            System.out.printf("%d", valorInt);
    }

    public int buscarUnInt( int valor ) {
        return Arrays.binarySearch(arregloInt, valor);
    }

    public void imprimirIgualdad() {
        boolean b = Arrays.equals(arregloInt, copiaArregloInt);
        System.out.println(b);

        b = Arrays.equals(arregloInt, arregloIntLleno);
        System.out.println(b);
    }

    public static void main(String[] args) {
        Supplier<UsoToArray> supplier = UsoToArray::new;

        supplier.get().imprimirArreglos();
        supplier.get().imprimirIgualdad();

        int ubicacion = supplier.get().buscarUnInt(5);
        if(ubicacion >= 0 )
            System.out.println("HERE: " + ubicacion);
        else
            System.out.println("No encontrado");




    }

}
