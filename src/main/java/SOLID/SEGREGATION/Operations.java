package SOLID.SEGREGATION;

public class Operations implements Suma, Resta{


  @Override
  public int doResta(int... number) {
    return 0;
  }

  @Override
  public int doSuma(int... number) {
    return number[0] + number[1];
  }
}
