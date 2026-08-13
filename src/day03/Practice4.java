package day03;

import java.util.Scanner;

public class Practice4 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        // 1.
        System.out.println("문제1] 정수1"); int 정수1 = scan.nextInt();
        System.out.println("문제1] 정수1"); int 정수2 = scan.nextInt();
        int 총점 = 정수1 + 정수2;
        if (총점 >= 90){System.out.println("성공");}
        else{System.out.println("실패");}

        // 2.
        System.out.println("첫 번째 정수: "); int num11 = scan.nextInt();
        System.out.println("두 번째 정수: "); int num22 = scan.nextInt();

        if (num11 > num22) {System.out.println("더 큰 수: " + num11);}
        else {System.out.println("더 큰 수: " + num22);}

        // 3.
        System.out.print("아이디: "); String id = scan.nextLine();
        System.out.print("비밀번호: "); String password = scan.nextLine();

        if (id == "admin" && password == "1234") {System.out.println("로그인 성공");} 
        else {System.out.println("로그인 실패");}

        // 4.
        System.out.print("비밀번호를 입력하세요: "); String password1 = scan.nextLine();
        int length = password.length();

        if (length < 8) {
            System.out.println("보안 등급: 약함 (8자 이상으로 설정해주세요.)");
        } else if (length < 12) {
            System.out.println("보안 등급: 보통");
        } else {
            System.out.println("보안 등급: 강함");
        }

        // 5.
        System.out.print("주민등록번호(-포함) 13자리를 입력하세요: ");
        String number = scan.nextLine();
        char gender = number.charAt(7);

        if (gender == '1' || gender == '3') {
            System.out.println("남자");
        } else if (gender == '2' || gender == '4') {
            System.out.println("여자");
        }

        // 6.
        System.out.print("점수를 입력하세요: "); int score = scan.nextInt();

        if (score >= 900) {
            System.out.println("A급 경품");
        } else if (score >= 700) {
            System.out.println("B급 경품");
        } else if (score >= 500) {
            System.out.println("C급 경품");
        } else {
            System.out.println("참가상");
        }

        // 7. 
        System.out.print("역할을 입력하세요: "); String role = scan.nextLine();

        if (role == "admin") {
            System.out.println("모든 기능에 접근할 수 있습니다.");
        } else if (role == "editor") {
            System.out.println("콘텐츠 수정 및 생성 기능에 접근할 수 있습니다.");
        } else if (role == "viewer") {
            System.out.println("콘텐츠 조회만 가능합니다.");
        } else {
            System.out.println("정의되지 않은 역할입니다.");
        }

        // 8.
        System.out.print("나이를 입력하세요: "); int age = scan.nextInt();

        if (age < 8) {
            System.out.println("무료");
        } else if (age <= 19) {
            System.out.println("5,000원");
        } else if (age < 65) {
            System.out.println("10,000원");
        } else {
            System.out.println("3,000원");
        }

        // 9.
        System.out.print("점수를 입력하세요: "); int score1 = scan.nextInt();

        if (score1 >= 90) {
            System.out.println("A등급");
        } else if (score1 >= 80) {
            System.out.println("B등급");
        } else if (score1 >= 70) {
            System.out.println("C등급");
        } else {
            System.out.println("재시험");
        }
/* 
        // 10.
        System.out.println("총 구매 금액: "); int money = scan.nextInt();

        if (money >= 50000) {System.out.println (money * 0.9);} 
        else if (money >= 30000) {System.out.println (money * 0.95);} 
        else if (money >= 10000) {System.out.println (money * 0.99);}
        else {System.out.println("최종 결제 금액: " + money + "원");}

        // 11.
        System.out.println("월(1~12)을 입력하세요"); int month = scan.nextInt();

        if(month >= 3 && month <= 5){System.out.println("봄");}
        else if(month >= 6 && month <= 8){System.out.println("여름");}
        else if(month >= 9 && month <= 11){System.out.println("가을");}
        else if(month == 12 || month == 1 || month ==2){System.out.println("겨울");}
        else{System.out.println("잘못 된 월입니다");}

        // 12.
        System.out.println("첫 번째 정수"); int num1 = scan.nextInt();
        System.out.println("두 번째 정수"); int num2 = scan.nextInt();
        System.out.println("세 번째 정수"); int num3 = scan.nextInt();

        if(num1 > num2 && num1 > num3){System.out.println("가장 큰 수"+ num1);}
        else if(num2 > num1 && num2 > num3){System.out.println("가장 큰 수"+ num2);}
        else {System.out.println("가장 큰 수"+ num3);}
*/
        // 13. 
        System.out.print("연도를 입력하세요: "); int year = scan.nextInt();

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {System.out.println(year + "년은 윤년입니다.");} 
        else {System.out.println(year + "년은 평년입니다.");}

        // 14.
                System.out.print("첫 번째 정수: ");
        int num1 = scan.nextInt();

        System.out.print("두 번째 정수: ");
        int num2 = scan.nextInt();

        System.out.print("세 번째 정수: ");
        int num3 = scan.nextInt();

        int temp;

        if (num1 > num2) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }

        if (num2 > num3) {
            temp = num2;
            num2 = num3;
            num3 = temp;
        }

        if (num1 > num2) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }

        System.out.println(num1 + ", " + num2 + ", " + num3);

        // 15.
        System.out.print("플레이어1 (0:가위, 1:바위, 2:보): "); int player1 = scan.nextInt();
        System.out.print("플레이어2 (0:가위, 1:바위, 2:보): ");int player2 = scan.nextInt();

        if (player1 == player2) {
            System.out.println("무승부");
        } else if (
            (player1 == 0 && player2 == 2) || (player1 == 1 && player2 == 0) || (player1 == 2 && player2 == 1)) 
        { System.out.println("플레이어1 승리");}
        else {
            System.out.println("플레이어2 승리");
        }
    }
}
    





