package day08;

public class Practice10 {
    public static void main(String[] args){
        //[1]
        Member member = new Member();

        member.setId("admin");
        System.out.println(member.getId());
        //[2]
        Score score = new Score();

        score.setScore(85);
        score.setScore(100);
        //[3]
        BankAccount account = new BankAccount("123-456");

        System.out.println(account.getAccountNumber());
        //[4]
        CircleCalculator calculator = new CircleCalculator();

        calculator.printCircleArea(5);
        //[5]
        TicketMachine machine1 = new TicketMachine();
        TicketMachine machine2 = new TicketMachine();

        machine1.issueTicket();
        machine1.issueTicket();
        machine2.issueTicket();

        TicketMachine.printTotalTickets();
        //[6]
        System.out.println("게임 이름 : " + GameConfig.GAME_TITLE);
        System.out.println("최대 레벨 : " + GameConfig.MAX_LEVEL);
        System.out.println("최대 HP : " + GameConfig.MAX_HP);
    }
}

//[1]
class Member{
    private String id;
    public void setId(String id){
    this.id = id; 
    }

    public String getId(  ){
        return id;
    }

}
//[2]
class Score{
    private int score;
    public void setScore(int score){
        if(score >= 0 && score <= 100){
             this.score = score;
        }
        else {
            System.out.println("유효하지 않은 점수입니다.");
        }
    }
}
//[3]
class BankAccount{
    private String accountNumber;
    public BankAccount(String accountNumber) {
    this.accountNumber = accountNumber;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
}
//[4]
class CircleCalculator{
     final double PI = 3.14159;

    public void printCircleArea(int radius) {
        double area = radius * radius * PI;

        System.out.println(area);
    }
}
//[5]
class TicketMachine {
    static int totalTickets = 0;

    public void issueTicket() {
        totalTickets++;
        System.out.println("티켓 1장을 발권했습니다.");
    }

    public static void printTotalTickets() {
        System.out.println("총 티켓 수: " + totalTickets);
    }
}
//[6]
class GameConfig {
    public static final int MAX_LEVEL = 99;

    public static final int MAX_HP = 10000;

    public static final String GAME_TITLE = "My RPG";
}


