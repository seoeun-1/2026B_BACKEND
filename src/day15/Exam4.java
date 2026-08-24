package day15;

import java.time.LocalTime;
import java.util.Scanner;

public class Exam4 {
    public static void main(String[] args) {
        // [1] 시계
        시계스레드 runnable1 = new runnable1();
        // [3] 타이머 구현
        타이머스레드 thread2 = null;

        // [2] 입력 구현
        while (true) {
            System.out.println("1.on , 2.off");
            Scanner scan = new Scanner(System.in);
            int ch = scan.nextInt();
            if( ch == 1 ){
                thread2 = new 타이머스레드();
                thread2.start();
            }
            if( ch == 2 ){
                if( thread2 != null ) thread2.state = false;
            }
        }
    }
}
class 타이머스레드 extends Thread{
    public boolean state = true;
    @Override public void run() {
        int time = 0;
        while (state) {
            time++;
            System.out.println(">>타이머: "+ time + "초");
            try{Thread.sleep(1000); }
            catch(Exception e){}
        }
    }
}
class 시계스레드 implements Readable{
    @Override public void run(){
        while(true){
            System.out.println(LocalTime.now());
            try{Thread.sleep}
        }
    }
}