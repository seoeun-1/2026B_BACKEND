package day10;

public class Exam1 {
    public static void main(String[] args) {
        //1. 동물 객체 생성
        동물 animal1 = new 동물();
        animal1.name = "강아지";
        animal1.show();
        //2.조류객체 생성
        조류 bird1 = new 조류();
        bird1.name = "비둘기";
        bird1.show();
        // 즉] 하위/자식 클래스의 객체는 상위/부모 크래스의 멤버(변수/메소드) 사용
        //3. 참새객체 생성
        참새 sparrow1 = new 참새();
        sparrow1.name = "참새";
        sparrow1.show();
        //4. 닭 객체 생성
        닭 chicken1 = new 닭();
        chicken1.name = "닭";
        chicken1.show();
        // 즉] 사위 클래스의 객체가 먼저 생성되고 하위 클래스 객체가 생성된다.

        // 다양성
        // *하나의 자료*가 다양한 형(형식/모양/형태/구분) 성질
        // 1. 참새 타입에서 조류 타입으로 될까?
         
    }
}

class 동물 { //부모 클래스
    String name; // 1.멤버변수
    동물(){ //2.생성자
        System.out.println("동물 탄생");
    }
    void show(){ //3.메소드
        System.out.println("동물 입니다.");
    }
}
class 조류 extends 동물 { }//하위 클래스 extends 상위 클래스명{ }
class 참새 extends 조류 { }
class 닭 extends 조류 { }
