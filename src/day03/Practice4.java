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
    




/*[문제 10] Scanner를 이용해 총 구매 금액을 입력받습니다. 구매 금액에 따라 할인율을 적용하여 최종 결제 금액을 출력하는 프로그램을 작성하시오.
50,000원 이상: 10% 할인
30,000원 이상 50,000원 미만: 5% 할인
10,000원 이상 30,000원 미만: 1% 할인
10,000원 미만: 할인 없음
입력 예시: 총 구매 금액: 60000
출력 예시: 최종 결제 금액: 54000원 */

/*[문제 11] 1부터 12 사이의 월(Month)을 숫자로 입력받아, 해당하는 계절을 출력하는 프로그램을 작성하시오. 만약 1~12 이외의 숫자를 입력하면 '잘못된 월입니다.'를 출력하세요.
봄: 3, 4, 5월
여름: 6, 7, 8월
가을: 9, 10, 11월
겨울: 12, 1, 2월
입력 예시:
월(1~12)을 입력하세요: 9
출력 예시: 가을 */

/*[문제 12] Scanner를 이용해 서로 다른 세 개의 정수를 입력받아, 가장 큰 수를 출력하는 프로그램을 작성하시오.
입력 예시:
첫 번째 정수: 45
두 번째 정수: 12
세 번째 정수: 78
출력 예시: 가장 큰 수: 78 */

