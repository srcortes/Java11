package CAP2.ANNOTATIONDEPRECATED;

import java.util.ArrayList;
import java.util.List;

public class SongBird {

    @Deprecated(since = "1.8", forRemoval = true)
    static void sing(int volume){

    }

    static Object chirp(List<String> data){
        return data.size();
    }

}

class Nigthingale{

    @SuppressWarnings("deprecation")
    public void wakeUp(){
        SongBird.sing(10);
    }

    public void goToBed(){
        SongBird.chirp(new ArrayList<>());
    }

    public static void main(String[] args) {
        var birdy = new Nigthingale();
        birdy.wakeUp();
        birdy.goToBed();
    }
}
