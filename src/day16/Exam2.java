package day16;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Exam2 {
    public static void main(String[] args) {
        /*
            스레드 풀: 매ㅐ번 새로운 스레드 생성하지 않고 미리 일정한 스레드를 풀(pool)에 생성
            목적: 과부하 방지
            구조: 선입선출(queue)방식으로 먼저 요청이 들어온 순서대로 *대기중인* 스레드가  처린한다.
                *)만일 대기중인 스레드가 없으면 wait(대기) 상태이며 스레드가 작업이 끝나고 대기중인 요청 처리
            활용처: 웹서버(톰캣), JDBC, 안전한 서버(돈) 구축 등등

            * 강호동이 신도엽과 유재석이 존재하는 방에 '안녕' 보낸다.
            강호동 ---안녕--->
                <---안녕---

            신동엽 <---안녕--- 카카오톡(서버) : 강호동에게 '안녕' 받아서 강호동/신동엽/유재석(방)에게 보낸다

            유재석 <---안녕---

            *               
                            -스레드풀-
        */
        // [1] 스레드풀 구축(미리 스레드 수 생성),
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(3);
        // [2] 임의의 요청 스레드 생성(구현체), 인터페이스명 변수명 = new 인터페이스명(){};
        Runnable runnable = new Runnable() { 
            @Override public void run(){
                for(int i = 1 ; i <= 20; i++){
                    try{Thread.sleep(3000);}catch(Exception e){}
                    //[3] 스레드풀에 해당 구현체 배정
                    CallTask task = new CallTask(i);
                    poolExecutor.submit(task);

                    // [6] 현재 스레드 상태
                    int 작업중인스레드수 = poolExecutor.getActiveCount();
                    int 대기중인스레드수 = poolExecutor.getCorePoolSize() - 작업중인스레드수;
                    int 대기중인요청수 = poolExecutor.getQueue().size();
                    System.out.println("작업중인 스레드수" + 작업중인스레드수);
                    System.out.println("대기중인 스레드수" + 대기중인스레드수);
                    System.out.println("대기중인 요청수" + 대기중인요청수);
                }
                //[4] 20개 배정후 스레드풀 종료 에약(모든 작업이 끝나면)
                poolExecutor.shutdown();
            }
        };
        // [5] 구현체 start
        Thread thread = new Thread(runnable);
        thread.start();
    }
}

class CallTask implements Runnable{
    private Random random = new Random();
    private int id;
    public CallTask( int id ){ this.id = id; }
    @Override public void run(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+"상담원 고객통화 시작됨 고색id:"+id);
        try{Thread.sleep(6000+ random.nextInt(6000));}catch(Exception e){}
        System.out.println(threadName+"상담원이 고색통화 종료됨");
    }
}
