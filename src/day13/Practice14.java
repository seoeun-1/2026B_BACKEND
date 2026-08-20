package day13;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Practice14 {
    public static void main(String[] args) {

        String carParkingList = "3,211가6231,202608190930\n8,452하1234,202608171227";
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("1.위치찾기 2.입차 3.출차 선택:");
            int ch = scan.nextInt();

            if( ch == 1 ){ 
                boolean have = false;
                System.out.print("찾을 차량의 번호를 입력하십시오 : "); 
                String carNumber = scan.next();
                String results[] = carParkingList.split("\\n");
                for(String a : results){
                    if(a.contains(carNumber)){
                        String carinfo[] = a.split(",");
                        System.out.println("현재 주차되어있는 차량 위치 번호 : " + carinfo[0]);
                        have = true;
                    }
                } // 차번호를 찾기 위한 반복문 종료 
                if(have == false){
                    System.out.println("미등록된 차량입니다. ");
                } 


            } // 위치찾기 구현 


            if( ch == 2 ){
                System.out.print("주차하고자 하는 주차 번호를 입력해주세요 : ");
                String location = scan.next();
                boolean result = true;
                String results[] = carParkingList.split("\\n");
                for(String a : results){
                    String b[] = a.split(",");
                    if(b[0].equals(location)){
                        result = false;
                    }
                }
                if(result){
                    System.out.println("입력하신 주차 번호에 주차가 가능합니다.");
                    System.out.print("차량번호를 입력하세요 : ");
                    String carNumber = scan.next();
                    LocalDateTime localDateTime1 = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
                    String time = localDateTime1.format(formatter);
                    carParkingList += ("\n" + location + "," + carNumber + "," + time);
                    System.out.println(location+"번 위치 주차 완료");
                }else{
                    System.out.println("입력하신 번호에는 중복 주차할 수 없습니다. ");
                }
                
                
            } // 입차 구현 




            if( ch == 3 ){ 
                StringBuilder builder = new StringBuilder();  // 수정할 차정보들을 담을 빌더
                String fee = ""; // 요금을 계산할 변수 
                
                System.out.print("출차하고자 하는 차량번호를 입력해주세요 : ");
                String carNumber = scan.next();
                String results[] = carParkingList.split("\n"); // 목록에서 차량으로 쪼갬 배열이름 result
                for(String a : results){
                    boolean result = true;  //  빌더에 담을 여부를 알려주는 변수 + 다음 조각담으면 초기화
                    String b[] = a.split(",");    // 차량에서 세부항목으로 쪼갬 배열이름 b
  
                    if(b[1].equals(carNumber)){   fee = b[2];       result = false;  }
                    else {result = true;} 
                    if(result){
                        builder.append(a).append("\n");
                    }
                    // for(String c : b){
                    //     if(c.equals(carNumber)){   fee = b[2];       result = false;  }
                    //     else {result = true;} 
                    // }
                    // if(result){
                    //     builder.append(a).append("\n");
                        
                    // }
                } //  반복문 종료

                carParkingList = builder.toString();  // 차량번호 삭제 완료
                System.out.println(carParkingList);  // 갱신된 목록 출력

                // 주차 요금 정산 
                // 현재 저장되어있는 요금계산은 배열 a[2]에 있으므로 
                System.out.println("+++++++++++++==");
                System.out.println(fee); // 입차시간

                int yearfee = Integer.parseInt( fee.substring( 0 , 4 ) );      
                int monthfee = Integer.parseInt( fee.substring( 4 , 6 ));     
                int dayfee = Integer.parseInt( fee.substring( 6 , 8 ));       
                int hurfee = Integer.parseInt( fee.substring( 8 , 10 ));      
                int minfee= Integer.parseInt( fee.substring( 10 , 12 ));

            

                LocalDateTime inTime = LocalDateTime.of(yearfee, monthfee, dayfee, hurfee, minfee );

                // 현재 날짜 시간 
                
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
                now.format(formatter);

                int year = Integer.parseInt( now.format(formatter).substring( 0 , 4 ) );
                int month = Integer.parseInt( now.format(formatter).substring( 4 , 6 ) ); 
                int day = Integer.parseInt( now.format(formatter).substring( 6 , 8 ) );  
                int hur = Integer.parseInt( now.format(formatter).substring( 8 , 10 ) ); 
                int min = Integer.parseInt( now.format(formatter).substring( 10 , 12 ) ); 
                

                // 연/월이 같은 단순 일자 차이 기준
                        // [LocalDateTime.getYear()] 연도(int) 반환
                        // [LocalDateTime.getDayOfYear()] 해당 연도의 몇 번째 날인지(1~366, int) 반환
                        int inTotalDays = (inTime.getYear() * 365) + inTime.getDayOfYear();
                        int nowTotalDays = (now.getYear() * 365) + now.getDayOfYear();
                        int diffDays = nowTotalDays - inTotalDays;
                        
                        // 분 차이 기준
                        // [LocalDateTime.getHour()] 시간(0~23, int) 반환
                        // [LocalDateTime.getMinute()] 분(0~59, int) 반환
                        int inMinutesOfDay = (inTime.getHour() * 60) + inTime.getMinute();
                        int nowMinutesOfDay = (now.getHour() * 60) + now.getMinute();
                        
                        // 차이난 일수의 분과 분 차이 합계
                        int totalMinutes = (diffDays * 24 * 60) + (nowMinutesOfDay - inMinutesOfDay);
                        if( totalMinutes < 0 ) totalMinutes = 0;
                        
                        // 3. 요금 계산 (일자 단위 + 잔여 분)
                        int days = totalMinutes / (24 * 60);          // 일수
                        int remainMinutes = totalMinutes % (24 * 60); // 일수 제외한 분(나머지)
                        int remainFee = 0;
                        if (remainMinutes > 30) {
                            int billableMinutes = remainMinutes - 30;
                            remainFee = ((billableMinutes + 9) / 10) * 1000; // 10분 단위 올림
                        }
                        if (remainFee > 20000) {
                            remainFee = 20000; // 일 최대 20,000원 캡
                        }
                        int totalFee = (days * 20000) + remainFee; // 일별 추가 요금.
                        
                        System.out.println( "총 내야하는 요금은 " + totalFee + "원입니다.");

                
                

                


            } // 출차 구현

            if(ch == 4){
                System.out.println(carParkingList);
            }


        }

    }    
}

/*
[ 문자열 실습 ] 타워 주차 관리 시스템 데이터 처리
1. 문제 개요
주차장 관제 시스템에서 관리 중인 차량 데이터(carParkingList)는 단일 String으로 관리되고 있습니다. 
이 데이터를 기반으로 입차, 출차, 내 차량 위치 찾기 기능을 구현하세요.
단) 새로운 클래스 만들지 않습니다.

2. 데이터 규격
데이터 구분자:
행(객체/차량) 구분: 줄바꿈 문자 (\n)
열(속성) 구분: 쉼표 (,)
컬럼 순서: 위치번호,차량번호,날짜시간(YYYYMMDDhhmm)

초기 데이터 예시:
String carParkingList = "3,211가6231,202608190930\n8,452하1234,202608171227";

3. 구현 요구사항
다음 세 기능 구현하세요. 
① 차량 위치 찾기 (findCarLocation)
기능: 차량 번호를 입력받아 현재 주차된 위치 번호를 반환합니다.
입력: carNumber (찾을 차량번호)
출력/반환:
차량이 존재할 경우: 주차 위치 번호 (예: "3")
차량이 없을 경우: "미등록 차량" 또는 -1 반환

② 입차 처리
기능: 새로운 차량의 주차 정보를 기존 데이터에 추가합니다.
조건:
이미 주차되어 있는 위치 번호에는 중복 주차할 수 없습니다
입력: location (위치번호), carNumber (차량번호), dateTime (입차일시)
출력/반환:
차량이 입차한 경우 : 주차 위치 번호 (예: "3")
차량이 입차가 없을 경우: 위치 번호에는 중복 주차할 수 없습니다. (위치 중복 시 입차 불가 메시지 출력)

③ 출차 처리
기능: 출차할 차량 번호를 입력받아 해당 차량의 행을 carParkingList에서 삭제합니다.
입력: carNumber (출차할 차량번호)
반환: 해당 차량이 제거되고 줄바꿈이 올바르게 정리된 갱신된 carParkingList 문자열
기본 정책: 최초 30분 무료추가 요금: 30분 초과 시, 10분당 1,000원 (10분 단위 절상/올림 계산)
예: 31분 ~ 40분 주차 -> 1,000원   
예: 41분 ~ 50분 주차 -> 2,000원
일일 최대 요금: 24시간(1일)당 최대 20,000원여러 날에 걸쳐 주차한 경우, 
각 일자 단위로 계산 후 합산하거나 총 일수×20,000원 + 잔여시간 요금(최대 20,000원)을 적용합니다.

*/