import java.util.Optional;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

class PassengerDTO{
  private TaxDocumentDTO taxDocument;

  public TaxDocumentDTO getTaxDocument() {
    return taxDocument;
  }

  public void setTaxDocument(TaxDocumentDTO taxDocument) {
    this.taxDocument = taxDocument;
  }
}

class TaxDocumentDTO {
  private String documentNumber;

  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }
}

public class ExamplePattern {

  public static final String ALPHANUMERIC_FORMAT_PATTERN = "^[0-9a-zA-Z]+$";

  public static void validateTaxDocument(PassengerDTO passengerDto) {
    String taxDocument =
        Optional.ofNullable(passengerDto.getTaxDocument())
            .flatMap(passenger -> Optional.ofNullable(passenger.getDocumentNumber()))
            .orElse(StringUtils.EMPTY);

    if (!taxDocument.isEmpty()
        && !Pattern.compile(ALPHANUMERIC_FORMAT_PATTERN).matcher(taxDocument).matches()) {
      throw new RuntimeException("error");
    }
  }

  public static void validateTaxDocument2(PassengerDTO passengerDto) {
    Optional.ofNullable(passengerDto.getTaxDocument())
        .flatMap(passenger -> Optional.ofNullable(passenger.getDocumentNumber()))
        .filter(
            taxdocument ->
                !taxdocument.isEmpty()
                    && !Pattern.compile(ALPHANUMERIC_FORMAT_PATTERN)
                    .matcher(taxdocument)
                    .matches())
        .ifPresent(
            validateTaxDocument -> {
              throw new RuntimeException("error");
            });
  }

  public static void main(String[] args) {

    PassengerDTO passengerDTO = new PassengerDTO();
    TaxDocumentDTO taxDocumentDTO = new TaxDocumentDTO();
    taxDocumentDTO.setDocumentNumber(" ");
    passengerDTO.setTaxDocument(taxDocumentDTO);

    //ExamplePattern.validateTaxDocument(passengerDTO);
    ExamplePattern.validateTaxDocument2(passengerDTO);
  }

}
