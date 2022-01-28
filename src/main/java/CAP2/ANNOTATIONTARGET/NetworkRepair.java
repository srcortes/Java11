package CAP2.ANNOTATIONTARGET;

@Technical(value = "testinmg", author = "john.rodriguez")
public class NetworkRepair {

    class OutSrc extends @Technical NetworkRepair{

        @Technical(value="method that execute something")
        public void repair(){
            var repairSubclass = new @Technical NetworkRepair();
            var o = new @Technical NetworkRepair().new @Technical OutSrc();

            int remaining = (@Technical int)10.0;
        }
    }
}
