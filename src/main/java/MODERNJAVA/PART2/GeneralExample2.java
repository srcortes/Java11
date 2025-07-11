package MODERNJAVA.PART2;



import MODERNJAVA.PART2.PARALELLSTREAM.ParallelStreamBenchmark;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

class CouponDTO {
    private Integer couponNumber;
    private String couponStatus;
    private TravelInformationDTO travelPart;

    public Integer getCouponNumber() {
        return couponNumber;
    }

    public void setCouponNumber(Integer couponNumber) {
        this.couponNumber = couponNumber;
    }

    public String getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(String couponStatus) {
        this.couponStatus = couponStatus;
    }

    public TravelInformationDTO getTravelPart() {
        return travelPart;
    }

    public void setTravelPart(TravelInformationDTO travelPart) {
        this.travelPart = travelPart;
    }
}

class TravelInformationDTO {
    private String origin;
    private String destination;
    private Date departure;
    private Date arrival;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }
}


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"})
@State(Scope.Benchmark)
public class GeneralExample2 {

    public static String algoOne(){
     return "true";
    }

    public static String algoTwo(){
        return "false";
    }

    @Benchmark
    public void firtsVersion(){
        CouponDTO couponDTO1 = new CouponDTO();
        couponDTO1.setCouponNumber(1);
        couponDTO1.setCouponStatus("OK");

        TravelInformationDTO travelInformationDTO1 = new TravelInformationDTO();
        travelInformationDTO1.setOrigin("ANF");
        travelInformationDTO1.setDestination("SCL");
        couponDTO1.setTravelPart(travelInformationDTO1);

        CouponDTO couponDTO2 = new CouponDTO();
        couponDTO2.setCouponNumber(2);
        couponDTO2.setCouponStatus("VOIDSS");
        couponDTO2.setTravelPart(travelInformationDTO1);

        CouponDTO couponDTO3 = new CouponDTO();
        couponDTO3.setCouponNumber(3);
        TravelInformationDTO travelInformationDTO2 = new TravelInformationDTO();
        travelInformationDTO2.setOrigin("LIM");
        travelInformationDTO2.setDestination("GYE");
        couponDTO1.setTravelPart(travelInformationDTO2);
        couponDTO3.setTravelPart(travelInformationDTO2);

        couponDTO3.setCouponStatus("OK");



        List<CouponDTO> coupons = new ArrayList<>();
        coupons.add(couponDTO1);
        coupons.add(couponDTO2);
        coupons.add(couponDTO3);



        for(CouponDTO coupon : coupons) {

            boolean b = Optional.ofNullable(coupon)
                    .map(CouponDTO::getCouponStatus)
                    .filter("VOID"::equalsIgnoreCase).isPresent() && Objects.isNull(coupon.getTravelPart());

            if( b )
                continue;

            if (coupon.getTravelPart() != null) {
                System.out.println( "Coupon Number: " + coupon.getCouponNumber());
            } else {
                System.out.println("No travel part information available.");
            }
        }

    }


    public static void main(String[] args) throws RunnerException {

        String value = "john jairo rodriguez cortes";
        String firstHalf = value.substring(0, value.length() / 2);
        String secondHalf = value.substring(value.length() / 2);

        System.out.println(value.length() / 2);


    }













}
