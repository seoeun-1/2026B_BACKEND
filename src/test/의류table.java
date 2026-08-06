package test;

import java.util.Scanner;

public class 의류table {
    public static void main(String[] args) {
        OverallRepository2 repository = new OverallRepository2();
        Scanner scan = new Scanner(System.in);
        for (;;) {
            System.out.println("====================세탁도우미=====================");
            System.out.println("1.의류 추가 2. 세탁법추가 3. 의류 출력 4. 세탁법 출력");
            System.out.println("===================================================");
            System.out.println("선택>");
            int ch = scan.nextInt();

            if (ch == 1) {
                scan.nextLine();
                System.out.print("의류ID : ");  int 의류ID = scan.nextInt(); scan.nextLine();
                System.out.print("의류명 : ");  String 의류명 = scan.nextLine(); 
                System.out.print("카테고리ID : ");  int 카테고리ID = scan.nextInt(); scan.nextLine();
                System.out.print("소재ID : ");  int 소재ID = scan.nextInt(); scan.nextLine();
                System.out.print("이미지경로 : ");  String 이미지경로 = scan.nextLine();

                의류 새의류 = new 의류(의류ID, 의류명, 카테고리ID, 소재ID, 이미지경로);
                boolean result = repository.의류저장함수(새의류);

                if (result) { System.out.println("[안내] 성공");} 
                else { System.out.println("[안내] 실패"); }  

            } else if (ch == 2) {
                의류[] 의류배열 = repository.findAll();
                for (의류 새의류 : 의류배열) {
                    if (새의류 != null) {
                        System.out.printf("의류ID : %s , 의류명 : %s , 카테고리ID : %s , 소재ID : %s , 이미지경로 : %s \n", 새의류.의류ID, 새의류.의류명, 새의류.카테고리ID, 새의류.소재ID, 새의류.이미지경로);
                    }
                }
            }

        }
    }
}
// 의류 데이터 저장 및 반환(조회) 비즈니스 로직 전담 클래스
class OverallRepository2 {
    의류[] 의류배열 = new 의류[100];

    boolean 의류저장함수(의류 새의류) {
        for(int i = 0; i < 의류배열.length; i++) {
            if(의류배열[i] == null) {
               의류배열[i] = 새의류;
               return true;
            }
        }
        return false;
    }

    
    의류[] findAll() {
        return 의류배열;
    }
}

// 의류
class 의류{
    int 의류ID;
    String 의류명;
    int 카테고리ID;
    int 소재ID;
    String 이미지경로;
    의류() {}
    의류(int 의류ID, String 의류명, int 카테고리ID, int 소재ID, String 이미지경로) {
        this.의류ID = 의류ID;
        this.의류명 = 의류명;
        this.카테고리ID = 카테고리ID;
        this.소재ID = 소재ID;
        this.이미지경로 = 이미지경로;
    }
}

/* 
class 의류별세탁법 {
    int 의류ID;
    String 물온도;
    String 세탁방법;
    String 권장세제;
    String 주의사항;
}

class 의류{
    int 의류ID;
    String 의류명;
    int 카테고리ID;
    int 소재ID;
    String 이미지경로;
}
*/