package CAP1.NESTED_CLASSES.ANONYMUSCLASSES;

import java.util.Locale;
import java.util.function.Supplier;

public class ZooGiftShop {
    abstract class SalesTodayOnly{
        abstract int dollarsOff();
    }

    @FunctionalInterface
    interface SpaceString{
        String withOutSpace(String value);
    }

    public int admission(int basePrice){
        SalesTodayOnly s = new SalesTodayOnly(){
            @Override
            int dollarsOff() {
                return 3;
            }
        };

        return basePrice - s.dollarsOff();
    }

    public String removedSpaceBlank(String value){
        SpaceString s = new SpaceString(){
            @Override
            public String withOutSpace(String value) {
                return value.trim().toLowerCase() ;
            }
        };

        return s.withOutSpace(value);
    }

    public static void main(String[] args) {
        Supplier<ZooGiftShop> zooGiftShopSupplier = ZooGiftShop::new;
        int h = zooGiftShopSupplier.get().admission(2);
        System.out.println(h);

        String name = "JOHN JAIRO      ";
        String newName = zooGiftShopSupplier.get().removedSpaceBlank(name);
        System.out.println(newName);
    }
}
