package PROJECTOEULER;


public class Multiple3or5NewVersion {
    static int[] values = {3};
    static int outCome3, outCome5, outCome15 = 0;
    public static int VALUE_OVERALL = 20;


    public static void calculate() {
        for(int j = 0; j < values.length; j++) {
             sumDivisibleBy(values[j]);
        }
    }

    public static void sumDivisibleBy(int number){
        int p = VALUE_OVERALL / number;
        switch(number){
            case 3 : outCome3 = number * (p*(p + 1)) / 2;
            break;
            case 5 : outCome5 = number * (p*(p + 1)) / 2;
            break;
            case 15 : outCome15 = number * (p*(p + 1)) / 2;
        }

    }

    public static void main(String[] args) {
        Multiple3or5NewVersion.calculate();
        System.out.println(outCome3 + outCome5 - outCome15);
    }
}
