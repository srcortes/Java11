package ACCOUNTMAP;

public class Account implements AcountState{

    private final String idAccount;
    private final String name;

    private Account(String idAccount, String name) {
        this.idAccount = idAccount;
        this.name = name;
    }

    public void validateAccount(String id) {
        if(id.length() < 16 )
            System.out.println("Account is valid");
    }

    @Override
    public Account createAccount(String id, String name) {
        return new Account(id, name);
    }
}
