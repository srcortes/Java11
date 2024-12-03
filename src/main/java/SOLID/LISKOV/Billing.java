package SOLID.LISKOV;

interface License{
  void calFee();
}

class PersonalLicense implements License {
  @Override
  public void calFee() {
    System.out.println("Personal");
  }
}

class BusinessLicence implements License {
  @Override
  public void calFee() {
    System.out.println("Bussiness");
  }
}
public class Billing {

  public void algo(License license){
     license.calFee();
  }

  public static void main(String[] args) {
    Billing billing = new Billing();
    License license = new BusinessLicence();
    License license1 = new PersonalLicense();

    billing.algo(license1);

  }

}
