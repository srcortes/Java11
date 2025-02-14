package MODERNJAVA.PART2.PARALELLSTREAM;



public class ParallelStreamBenchmark {

  public static void main(String[] args) {

  }

  public static void InitialVersionSum(){
    System.out.println(start());

  }
  private static final long N = 10_000_000L;

  private static long start(){
    long tiempoEnMilisegundos = System.currentTimeMillis();
    return tiempoEnMilisegundos / 1000;
  }

  private long end(){
    long tiempoEnMilisegundos = System.currentTimeMillis();
    return tiempoEnMilisegundos / 1000;
  }




}
