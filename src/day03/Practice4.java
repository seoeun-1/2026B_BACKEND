package day03;

import java.util.Scanner;

public class Practice4 {
    public static void main(String[] args) {
        /*Scanner scan = new Scanner("문제1] 정수1"); int 정수1 = scan.nextInt();
        Scanner scan = new Scanner("문제1] 정수1"); int 정수2 = scan.nextInt();
        int 총점 = 점수1 + 점수2;
        if (총점 >= 90){System.out.println("성공");}
        else{System.out.println("실패");}*/
        Scanner scan = new Scanner(System.in);

        //10.
       System.out.println("총 구매 금액: "); int money = scan.nextInt();

        if (money >= 50000) {System.out.println (money * 0.9);} 
        else if (money >= 30000) {System.out.println (money * 0.95);} 
        else if (money >= 10000) {System.out.println (money * 0.99);}
        else {System.out.println("최종 결제 금액: " + money + "원");}

        //11.
        System.out.println("월(1~12)을 입력하세요"); int month = scan.nextInt();

        if(month >= 3 && month <= 5){System.out.println("봄");}
        else if(month >= 6 && month <= 8){System.out.println("여름");}
        else if(month >= 9 && month <= 11){System.out.println("가을");}
        else if(month == 12 || month == 1 || month ==2){System.out.println("겨울");}
        else{System.out.println("잘못 된 월입니다");}

        //12.
        System.out.println("첫 번째 정수"); int num1 = scan.nextInt();
        System.out.println("두 번째 정수"); int num2 = scan.nextInt();
        System.out.println("세 번째 정수"); int num3 = scan.nextInt();

        if(num1 > num2 && num1 > num3){System.out.println("가장 큰 수"+ num1);}
        else if(num2 > num1 && num2 > num3){System.out.println("가장 큰 수"+ num2);}
        else {System.out.println("가장 큰 수"+ num3);}


    }
}
    





