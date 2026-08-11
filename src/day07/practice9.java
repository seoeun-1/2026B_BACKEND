package day07;

public class Practice9 {
    public static void main(String[] args) {
       // [1]
        Printer printer = new Printer(); 
        printer.printMessage();
       // [2] 
        Greeter greeter = new Greeter();
        greeter.greet("유재석");
       // [3] 
        SimpleCalculator s1 = new SimpleCalculator();
        int result = s1.add( 10, 5);
        System.out.println( result );
       // [4] 
       Checker c1 = new Checker();
       boolean result2 = c1.isEven( 10 );
       if( result2 ){  System.out.println("짝수");  }
       else{ System.out.println("홀수"); }
       // [5] 
       Lamp l1 = new Lamp();
       l1.turnOn(); System.out.println( l1.isOn );
       l1.turnOff(); System.out.println( l1.isOn );
       // [6] 
        Product product = new Product("노트북", 10);
        System.out.println("초기 재고: " + product.stock);
        boolean result1 = product.sell(3);
        System.out.println("구매 결과: " + result1);
        System.out.println("남은 재고: " + product.stock);
       // [7] 
        Visualizer visualizer = new Visualizer();
        String result11 = visualizer.getStars(5);
        System.out.println(result11);
       // [8] 
        ParkingLot parkingLot = new ParkingLot();
        int fee1 = parkingLot.calculateFee(65);
        int fee2 = parkingLot.calculateFee(140);
        System.out.println("65분 주차 요금: " + fee1 + "원");
        System.out.println("140분 주차 요금: " + fee2 + "원");
    }
} // class end 
class ParkingLot { //[8]

    int calculateFee(int minutes) {

        int fee = 1000;

        if (minutes > 30) {
            int extraMinutes = minutes - 30;
            int extraCount = (int) Math.ceil(extraMinutes / 10.0);
            fee = fee + (extraCount * 500);
        }
        if (fee > 20000) {
            fee = 20000;
        }
        return fee;
    }
}

class Visualizer{ //[7]

    String getStars(int number) {
        String stars = "";
        for (int i = 0; i < number; i++) {
            stars += "★";
        }
        return stars;
    }
}
class Product{ //[6]
    String name;
    int stock;

    Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    boolean sell(int count) {
        if (stock >= count) {
            stock = stock - count;
            return true;
        } else {
            System.out.println("재고 부족");
            return false;
        }
    }
}
class Lamp{ // [5]
    boolean isOn;
    void turnOn(){ isOn = true; }
    void turnOff(){ isOn = false; }
}
class Checker{ // [4]
    boolean isEven( int num ){
        if( num % 2 == 0 )return true;
        return false;
    }
}
class SimpleCalculator{ // [3]
    int add( int x , int y ){
        return x + y;
    }
}
class Greeter{  // [2]
    void greet( String name ){
        System.out.printf("안녕하세요 %s \n" ,name);
    }
}
class Printer{  // [1]
    void printMessage(){ 
        System.out.println("안녕하세요, 메소드입니다.");
    } 
}



    /*[문제 8] ParkingLot 클래스를 만드세요.
    1. 주차 시간(분)을 매개변수로 받아, 요금 규정에 따라 계산된 최종 주차 요금을 반환하는 calculateFee 메소드를 정의하세요.
    2. 요금 규정:
    기본 요금: 최초 30분까지 1,000원
    추가 요금: 30분 초과 시, 매 10분마다 500원씩 추가
    일일 최대 요금: 20,000원
    3. main 함수에서 calculateFee 메소드에 65, 140을 각각 인자로 전달하여 반환된 요금을 출력하세요.*/