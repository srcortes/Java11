package PROJECTOEULER;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Fechas {

  public static int yearsAtPresentDate(LocalDate dateOfBirth, LocalDate presentDate) {
    return (int) ChronoUnit.YEARS.between(dateOfBirth, presentDate);
  }

  public static LocalDate birthdayPassengerOnDepartureYear(LocalDate dateOfBirth, LocalDate departure) {
    final int yearLastDeparture = departure.get(ChronoField.YEAR);
    return LocalDate.of(
        yearLastDeparture,
        dateOfBirth.get(ChronoField.MONTH_OF_YEAR),
        dateOfBirth.get(ChronoField.DAY_OF_MONTH));
  }

  public static void main(String[] args) {
    Fechas.birthdayPassengerOnDepartureYear(LocalDate.parse("2014-06-14"), LocalDate.parse("2024-06-14"));
    int a = Fechas.yearsAtPresentDate(LocalDate.parse("2012-06-14"), LocalDate.parse("2024-06-14"));
    System.out.println(a);
  }

}
