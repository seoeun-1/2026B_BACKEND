package day05;

import java.util.Scanner;

public class Practice7 {
    public static void main(String[] args) {
        // [1] 1.객체 생성, new 생성자명();  또는  타입 변수명 = new 생성자명();
        Book b1 = new Book();   
        // 2.객체 멤버변수 수정
        b1.title="이것이 자바다";   b1.author="신용권"; b1.price=30000;
        Book b2 = new Book();
        b2.title="자바의 정석";     b2.author="남궁성"; b2.price=28000;
        // 3.객체 멤버변수 출력
        System.out.printf( "%s, %s, %d \n", b1.title, b1.author, b1.price );
        System.out.printf( "%s, %s, %d \n", b2.title, b2.author, b2.price );

        // [2] 
        Pet p1 = new Pet(); p1.name="초코"; p1.species="푸들"; p1.age=3;
        Pet p2 = new Pet(); p2.name="나비"; p2.species="코리안숏헤어"; p2.age=5;
        System.out.printf( "%s, %s, %d \n", p1.name, p1.species, p1.age );
        System.out.printf( "%s, %s, %d \n", p2.name, p2.species, p2.age );

        // [3] 객체는 초기값이 없으면 기본값 자동할당
        // * 정수:0 , 실수:0.0 , 논리:false , 객체:null
        Rectangle r1 = new Rectangle();
        System.out.println( r1.width ); // 0 들어있는 이유는 기본값 할당
        r1.width = 10; r1.height = 5;
        System.out.println( r1.width * r1.height );

        // [4] 
        BankAccount bank1 = new BankAccount();
        bank1.accountNumber = "111-222-3333";
        bank1.ownerName = "유재석";
        bank1.balance = 10000;
        bank1.balance += 5000; System.out.println( bank1.balance );  // 입금 후 출력 
        bank1.balance -= 3000; System.out.println( bank1.balance );  // 출금 후 출력 

        // [5]
        Product prod1 = new Product();  prod1.name="새우깡";    prod1.price=1500;
        Product prod2 = new Product();  prod2.name="콜라";      prod2.price=2000;
        if( prod1.price > prod2.price ){ System.out.println( prod1.name );}
        else{ System.out.println( prod2.name); }
        
        // [6]
        Member member = new Member();

        member.id = "admin";
        member.isLogin = false;

        System.out.println("로그인 전 상태: " + member.isLogin);
        member.isLogin = true;

        System.out.println("로그인 후 상태: " + member.isLogin);

        // [7]
        Television television = new Television();

        television.channel = 7;
        television.volume = 20;
        television.channel = 11;
        television.volume = television.volume - 2;

        System.out.println("채널: " + television.channel);
        System.out.println("볼륨: " + television.volume);

        // [8]
        Player player1 = new Player();
        Player player2 = new Player();

        player1.name = "손흥민";
        player1.power = 90;
        player1.speed = 95;

        player2.name = "이강인";
        player2.power = 85;
        player2.speed = 92;

        int total1 = player1.power + player1.speed;
        int total2 = player2.power + player2.speed;

        System.out.println(player1.name + " 총점: " + total1);
        System.out.println(player2.name + " 총점: " + total2);

        if (total1 > total2) {
            System.out.println("더 높은 선수: " + player1.name);
        } else if (total2 > total1) {
            System.out.println("더 높은 선수: " + player2.name);
        } else {
            System.out.println("두 선수의 점수가 같습니다.");
        }

        // [9]
        MenuItem menu1 = new MenuItem();
        MenuItem menu2 = new MenuItem();
        MenuItem menu3 = new MenuItem();

        menu1.name = "김치찌개";
        menu1.price = 8000;
        menu1.isSignature = true;

        menu2.name = "된장찌개";
        menu2.price = 8000;
        menu2.isSignature = false;

        menu3.name = "계란찜";
        menu3.price = 3000;
        menu3.isSignature = false;

        if (menu1.isSignature == true) {
            System.out.println("[대표메뉴] " + menu1.name + " : " + menu1.price + "원");
        }
        if (menu2.isSignature == true) {
            System.out.println("[대표메뉴] " + menu2.name + " : " + menu2.price + "원");
        }
        if (menu3.isSignature == true) {
            System.out.println("[대표메뉴] " + menu3.name + " : " + menu3.price + "원");
        }

        // [10]
        Scanner scan = new Scanner(System.in);
        UserProfile user = new UserProfile();

        System.out.print("이름을 입력하세요: ");
        user.name = scan.nextLine();
        System.out.print("나이를 입력하세요: ");
        user.age = scan.nextInt();
        scan.nextLine();
        System.out.print("MBTI를 입력하세요: ");
        user.mbti = scan.nextLine();

        System.out.println("--- 프로필 ---");
        System.out.println("이름: " + user.name);
        System.out.println("나이: " + user.age);
        System.out.println("MBTI: " + user.mbti);

        scan.close();
    }
}


// [1] 객체 정의 
// 1. 클래스선언 : 기존 class{ } 밖에 새로운 클래스선언{ }
// 2. 멤버변수선언: { } 안에 멤버변수 선언
class Book{ 
    String title;
    String author;
    int price;
}

// [2]
class Pet{
    String name;
    String species;
    int age;
}
// [3]
class Rectangle{
    int width;
    int height;
}
// [4]
class BankAccount{
    String accountNumber;
    String ownerName;
    int balance;
}
// [5]
class Product{
    String name;
    int price;
}
// [6]
class Member {
    String id;
    boolean isLogin;
}
// [7]
class Television {
    int channel;
    int volume;
}
// [8]
class Player {
    String name;
    int power;
    int speed;
}
// [9]
class MenuItem {
    String name;
    int price;
    boolean isSignature;
}
// [10]
class UserProfile {
    String name;
    int age;
    String mbti;
}