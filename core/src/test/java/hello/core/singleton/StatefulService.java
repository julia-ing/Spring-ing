package hello.core.singleton;

public class StatefulService {

//    private int price; //싱태를 유지하는 필드 10000 -> 20000
//
//    public void order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price;  //여기가 문제
//    }

    public int order(String name, int price) {  // 공유 필드 제거 -> stateless 하게 변경
        System.out.println("name = " + name + " price = " + price);
        return  price;
    }

//    public int getPrice() {
//        return price;
//    }
}
