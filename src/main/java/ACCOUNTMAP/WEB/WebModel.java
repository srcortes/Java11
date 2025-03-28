package ACCOUNTMAP.WEB;

import ACCOUNTMAP.Account;
import ACCOUNTMAP.AcountState;

public class WebModel implements AcountState {

    private String id;
    private String name;
    private Account account;


    @Override
    public Account createAccount(String id, String name) {
        return null;
    }
}
