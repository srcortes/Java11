import java.nio.file.OpenOption;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExampleObject {

  private static final String TTL_REMARK_REGEX =
      "PLS CHECK CPN STATUS BEFORE (\\d{2}\\d{2}\\d{4} \\d{2}\\d{2}) OR AUTO CNL";

  private static void getTtlRemarks(String remarks) {
    Pattern pattern = Pattern.compile(TTL_REMARK_REGEX);
    Matcher matcher = pattern.matcher(remarks);
    while (matcher.find()) {
      System.out.println("Found: " + matcher.group());
    }

  }

  public static LocalDate birthdayPassengerOnDepartureYear(LocalDate dateOfBirth, LocalDate departure) {
    final int yearLastDeparture = departure.get(ChronoField.YEAR);
    return LocalDate.of(
        yearLastDeparture,
        dateOfBirth.get(ChronoField.MONTH_OF_YEAR),
        dateOfBirth.get(ChronoField.DAY_OF_MONTH));
  }

  public static void main(String[] args) {
    //boolean alguito = ExampleObject.algo("789");
    //System.out.println(alguito);

    /*int outcome = ExampleObject.yearsAtPresentDate(LocalDate.of(2012,07,02)
        , LocalDate.of(2024, 07, 07));
    System.out.println(outcome);

    System.out.println(ExampleObject
        .birthdayPassengerOnDepartureYear(LocalDate.of(2022,07,06),
            LocalDate.of(2024,07,07)));*/

    //Optional<String> op = "";
    //System.out.println(!op.isEmpty());

    ExampleObject.getTtlRemarks("PLS CHECK CPN STATUS BEFORE 28042024 0800 OR AUTO CNL");

  }

}
