package CAP1.INTERFACE;

interface TestTwoIn{

    int j = 5;

    static String getValueName(){
        return "John Jairo"+ getLastName() + String.valueOf(j);
    }

    private static String getLastName(){
        return "Rodriguez Cortes";
    }

    private String value(){
        return "Rodriguez";
    }
}

interface TestTwoInt{
    static String getValueName(){
        return "John Jairo2";
    }
}

public class TestTwoInterface {

    public static void main(String[] args) {
        String name = TestTwoInt.getValueName();
        System.out.println(name + " - "+ TestTwoIn.j);
    }
}
