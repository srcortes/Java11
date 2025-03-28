package ACCOUNTMAP.WEB.IN;

import ACCOUNTMAP.SendMoneyServiceUseCase;
import ACCOUNTMAP.WEB.WebModel;

public class AccountController {

    private static WebModel webModel = new WebModel();
    private static SendMoneyServiceUseCase sendMoneyServiceUseCase;

    public static void main(String[] args) {
        String id = "123";
        //sendMoneyServiceUseCase.createAccount( webModel.createAccount(id) );


    }
}
