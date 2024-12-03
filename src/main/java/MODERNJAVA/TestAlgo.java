package MODERNJAVA;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Reservation {
    private long code;

    private boolean isAvailableForLendBook;
    private PNRInformationDTO pnr;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public PNRInformationDTO getPnr() {
        return pnr;
    }

    public void setPnr(PNRInformationDTO pnr) {
        this.pnr = pnr;
    }

    public boolean getIsAvailableForLendBook() {
        return isAvailableForLendBook;
    }

    public void setIsAvailableForLendBook(boolean isAvailableForLendBook) {
        this.isAvailableForLendBook = isAvailableForLendBook;
    }
}

class PNRInformationDTO {
    List<DocumentDetailDTO> documents;

    public List<DocumentDetailDTO> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentDetailDTO> documents) {
        this.documents = documents;
    }
}

class DocumentDetailDTO {
    List<CouponDTO> coupons;

    public List<CouponDTO> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<CouponDTO> coupons) {
        this.coupons = coupons;
    }
}

class CouponDTO {
    private String name;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


public class TestAlgo {

    public static List<CouponDTO> prueba1(Reservation reservation, boolean flag){

        if(flag){
            return reservation.getPnr().getDocuments().stream()
                    .map(DocumentDetailDTO::getCoupons).flatMap(Collection::stream).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }



    }

    public static void prueba2(boolean algo){
       if(algo){
           System.out.println("Si tiene");
       }else {
           System.out.println("No tiene");
       }
    }



    public static void main(String[] args) {

        System.out.println("hello");


         CouponDTO bookOne = new CouponDTO();
        bookOne.setName("Harry Potter and the philosopher's stone");
        bookOne.setStatus("VOID");

        CouponDTO bookTwo = new CouponDTO();
        bookTwo.setName("Harry Potter and Chamber of secrets");
        bookTwo.setStatus("VOIDeee");

        CouponDTO bookThree = new CouponDTO();
        bookThree.setName("Harry Potter and Chamber of secrets");
        bookThree.setStatus("VOID");

        List<CouponDTO> couponDTO = new ArrayList<>();
        couponDTO.add(bookOne);
        couponDTO.add(bookTwo);
        couponDTO.add(bookThree);

        DocumentDetailDTO subjects = new DocumentDetailDTO();
        subjects.setCoupons(couponDTO);

        List<DocumentDetailDTO> documentDetailDTO = new ArrayList<>();
        documentDetailDTO.add(subjects);


        PNRInformationDTO pnr =  new PNRInformationDTO();
        pnr.setDocuments(documentDetailDTO);

        Reservation reservationDTO = new Reservation();
        reservationDTO.setCode(80217780);
        reservationDTO.setPnr(pnr);
        List<CouponDTO> list = TestAlgo.prueba1(reservationDTO, true);

        if(!list.isEmpty()) {
            boolean allCouponsContainsVoidStatus = list.stream().map(CouponDTO::getStatus).allMatch("VOID"::equals);
            TestAlgo.prueba2(allCouponsContainsVoidStatus);
        }






        /*String documents = "nnn";
        Predicate<String> evaluate = Objects::nonNull;
        BooleanSupplier evaluateConditions = () -> a && evaluate.test(documents);

        BiPredicate<String, Boolean> biPredicate =  (a1,  a2) -> Objects.nonNull(a1) && a2;

        if(biPredicate.test(documents, a)) {
            System.out.println(a);
        } else {
            System.out.println("no");
        }*/





    }


}
