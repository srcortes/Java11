package MODERNJAVA.PART2;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;


class BaggageDTO {

    private SegmentDetailsDTO segment;
    private List<PassengerDetailsDTO> passengers;

    public SegmentDetailsDTO getSegment() {
        return segment;
    }

    public void setSegment(SegmentDetailsDTO segment) {
        this.segment = segment;
    }

    public List<PassengerDetailsDTO> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerDetailsDTO> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "BaggageDTO{" + "segment=" + segment + ", passengers=" + passengers + '}';
    }
}

class SegmentDetailsDTO {

    private String departureTime;

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "SegmentDetailsDTO{" + "departureTime='" + departureTime + '\'' + '}';
    }
}

class PassengerDetailsDTO {
    private String passengerId;
    private List<PassengerBaggageDTO> bags;

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public List<PassengerBaggageDTO> getBags() {
        return bags;
    }

    public void setBags(List<PassengerBaggageDTO> bags) {
        this.bags = bags;
    }

    @Override
    public String toString() {
        return "PassengerDetailsDTO{" + "passengerId='" + passengerId + '\'' + ", bags=" + bags + '}';
    }
}

class PassengerBaggageDTO {
    private BagCharacteristicsDTO bagCharacteristics;
    private AssociatedDocumentDTO document;
    private boolean includedInClass;

    public BagCharacteristicsDTO getBagCharacteristics() {
        return bagCharacteristics;
    }

    public void setBagCharacteristics(BagCharacteristicsDTO bagCharacteristics) {
        this.bagCharacteristics = bagCharacteristics;
    }

    public AssociatedDocumentDTO getDocument() {
        return document;
    }

    public void setDocument(AssociatedDocumentDTO document) {
        this.document = document;
    }

    public boolean isIncludedInClass() {
        return includedInClass;
    }

    public void setIncludedInClass(boolean includedInClass) {
        this.includedInClass = includedInClass;
    }

    @Override
    public String toString() {
        return "PassengerBaggageDTO{" + "bagCharacteristics=" + bagCharacteristics + ", document=" + document + ", includedInClass=" + includedInClass + '}';
    }
}

class AssociatedDocumentDTO {
    private String documentNumber;
    private String couponNumber;
    private String couponStatus;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getCouponNumber() {
        return couponNumber;
    }

    public void setCouponNumber(String couponNumber) {
        this.couponNumber = couponNumber;
    }

    public String getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(String couponStatus) {
        this.couponStatus = couponStatus;
    }

    @Override
    public String toString() {
        return "AssociatedDocumentDTO{" + "documentNumber='" + documentNumber + '\'' + ", couponNumber='" + couponNumber + '\'' + ", couponStatus='" + couponStatus + '\'' + '}';
    }
}


class BagCharacteristicsDTO {

    private String ancillaryCode;
    private Double kilograms;
    private Double pounds;
    private String bagCharacteristicsType;

    public String getAncillaryCode() {
        return ancillaryCode;
    }

    public void setAncillaryCode(String ancillaryCode) {
        this.ancillaryCode = ancillaryCode;
    }

    public Double getKilograms() {
        return kilograms;
    }

    public void setKilograms(Double kilograms) {
        this.kilograms = kilograms;
    }

    public Double getPounds() {
        return pounds;
    }

    public void setPounds(Double pounds) {
        this.pounds = pounds;
    }

    public String getBagCharacteristicsType() {
        return bagCharacteristicsType;
    }

    public void setBagCharacteristicsType(String bagCharacteristicsType) {
        this.bagCharacteristicsType = bagCharacteristicsType;
    }

    @Override
    public String toString() {
        return "BagCharacteristicsDTO{" + "ancillaryCode='" + ancillaryCode + '\'' + ", kilograms=" + kilograms + ", pounds=" + pounds + ", bagCharacteristicsType='" + bagCharacteristicsType + '\'' + '}';
    }
}

public class GeneralExampleCoupon {
    static List<String> allows = Arrays.asList("OK", "CTRL", "CKIN", "LFTD", "USED");

    public void cleanInvalidBaggageCoupons(List<BaggageDTO> baggageList) {

        baggageList.stream()
                .flatMap(baggage -> baggage.getPassengers().stream())
                .forEach(passengerDetails -> passengerDetails.setBags(filterAllowedCoupons(passengerDetails.getBags())));
    }

    private List<PassengerBaggageDTO> filterAllowedCoupons(List<PassengerBaggageDTO> baggages) {


        List<PassengerBaggageDTO> recoveryAgainAncilliary = baggages.stream().filter(anci -> !anci.getBagCharacteristics().getAncillaryCode().equals("")).collect(toList());
        String algos = this.algo(baggages);
        List<PassengerBaggageDTO> b =
                baggages.stream().filter(j -> j.getDocument().getDocumentNumber().equals(algos)).collect(toList());
        b.addAll(recoveryAgainAncilliary);

        return b;
    }

    private String algo(List<PassengerBaggageDTO> baggages) {

        return baggages.parallelStream().filter(anci -> anci.getBagCharacteristics().getAncillaryCode().equals("")).reduce((aa, bb) -> bb).filter(this::isAllowedCouponBag).map(PassengerBaggageDTO::getDocument).map(AssociatedDocumentDTO::getDocumentNumber).orElseGet(() -> "");

    }


    private boolean isAllowedCouponBag(PassengerBaggageDTO bag) {
        return Objects.nonNull(bag.getDocument()) && allows.contains(bag.getDocument().getCouponStatus());
    }

    public static void main(String[] args) {
        PassengerDetailsDTO p1 = new PassengerDetailsDTO();
        p1.setPassengerId("ADT_1");

        BagCharacteristicsDTO b1 = new BagCharacteristicsDTO();
        b1.setKilograms(10.0);
        b1.setPounds(22.0);
        b1.setBagCharacteristicsType("CARRY_ON");
        b1.setAncillaryCode("");

        BagCharacteristicsDTO b2 = new BagCharacteristicsDTO();
        b2.setKilograms(23.0);
        b2.setPounds(50.0);
        b2.setBagCharacteristicsType("CHECKED_IN");
        b2.setAncillaryCode("");

        BagCharacteristicsDTO b3 = new BagCharacteristicsDTO();
        b3.setKilograms(10.0);
        b3.setPounds(22.0);
        b3.setBagCharacteristicsType("CHECKED_IN");
        b3.setAncillaryCode("");

        BagCharacteristicsDTO b4 = new BagCharacteristicsDTO();
        b4.setKilograms(23.0);
        b4.setPounds(50.0);
        b4.setBagCharacteristicsType("CARRY_ON");
        b4.setAncillaryCode("");

        BagCharacteristicsDTO b5 = new BagCharacteristicsDTO();
        b5.setKilograms(23.0);
        b5.setPounds(50.0);
        b5.setBagCharacteristicsType("CHECKED_IN");
        b5.setAncillaryCode("");


        BagCharacteristicsDTO b6 = new BagCharacteristicsDTO();
        b6.setKilograms(23.0);
        b6.setPounds(50.0);
        b6.setBagCharacteristicsType("CHECKED_IN");
        b6.setAncillaryCode("");

        BagCharacteristicsDTO b7 = new BagCharacteristicsDTO();
        b7.setKilograms(10.0);
        b7.setPounds(22.0);
        b7.setBagCharacteristicsType("CARRY_ON");
        b7.setAncillaryCode("");

        AssociatedDocumentDTO d1 = new AssociatedDocumentDTO();
        d1.setDocumentNumber("0452101586469");
        d1.setCouponNumber("1");
        d1.setCouponStatus("CTRL");

        AssociatedDocumentDTO d2 = new AssociatedDocumentDTO();
        d2.setDocumentNumber("0452101587654");
        d2.setCouponNumber("1");
        d2.setCouponStatus("EXCH");

        AssociatedDocumentDTO d3 = new AssociatedDocumentDTO();
        d3.setDocumentNumber("0452101587654");
        d3.setCouponNumber("1");
        d3.setCouponStatus("EXCH");

        AssociatedDocumentDTO d4 = new AssociatedDocumentDTO();
        d4.setDocumentNumber("0452101587654");
        d4.setCouponNumber("1");
        d4.setCouponStatus("EXCH");

        AssociatedDocumentDTO d5 = new AssociatedDocumentDTO();
        d5.setDocumentNumber("0452101587656");
        d5.setCouponNumber("1");
        d5.setCouponStatus("OK");

        AssociatedDocumentDTO d6 = new AssociatedDocumentDTO();
        d6.setDocumentNumber("0452101587656");
        d6.setCouponNumber("1");
        d6.setCouponStatus("OK");

        AssociatedDocumentDTO d7 = new AssociatedDocumentDTO();
        d7.setDocumentNumber("0452101587656");
        d7.setCouponNumber("1");
        d7.setCouponStatus("OK");

        PassengerBaggageDTO pb1 = new PassengerBaggageDTO();
        pb1.setBagCharacteristics(b1);
        pb1.setDocument(d1);
        pb1.setIncludedInClass(true);

        PassengerBaggageDTO pb2 = new PassengerBaggageDTO();
        pb2.setBagCharacteristics(b2);
        pb2.setDocument(d2);
        pb2.setIncludedInClass(true);

        PassengerBaggageDTO pb3 = new PassengerBaggageDTO();
        pb3.setBagCharacteristics(b3);
        pb3.setDocument(d3);
        pb3.setIncludedInClass(true);

        PassengerBaggageDTO pb4 = new PassengerBaggageDTO();
        pb4.setBagCharacteristics(b4);
        pb4.setDocument(d4);
        pb4.setIncludedInClass(true);

        PassengerBaggageDTO pb5 = new PassengerBaggageDTO();
        pb5.setBagCharacteristics(b5);
        pb5.setDocument(d5);
        pb5.setIncludedInClass(true);

        PassengerBaggageDTO pb6 = new PassengerBaggageDTO();
        pb6.setBagCharacteristics(b6);
        pb6.setDocument(d6);
        pb6.setIncludedInClass(true);

        PassengerBaggageDTO pb7 = new PassengerBaggageDTO();
        pb7.setBagCharacteristics(b7);
        pb7.setDocument(d7);
        pb7.setIncludedInClass(true);


        List<PassengerBaggageDTO> bags = new ArrayList<>();
        bags.add(pb1);
        bags.add(pb2);
        bags.add(pb3);
        bags.add(pb4);
        bags.add(pb5);
        bags.add(pb6);
        bags.add(pb7);


        System.out.println(bags);


    }


}
