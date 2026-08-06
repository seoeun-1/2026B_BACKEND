package test;

import java.util.Scanner;

public class Overallcontroller {
    public static void main(String[] args) {
        OverallRepository repository = new OverallRepository();
        Scanner scan = new Scanner(System.in);
        for (;;) {
            System.out.println("============ My Community ============ ");
            System.out.println("1.게시물쓰기 2.게시물출력");
            System.out.println("====================================== ");
            System.out.print("선택>");
            int ch = scan.nextInt();

            if (ch == 1) {
                scan.nextLine();
                System.out.print("내용 : ");     String content = scan.nextLine();
                System.out.print("작성자 : ");   String writer = scan.nextLine();

                Post post = new Post(content, writer);
                boolean result = repository.save(post);

                if (result) { System.out.println("[안내] 글쓰기 성공");} 
                else { System.out.println("[안내] 글쓰기 실패"); }

            } else if (ch == 2) {
                Post[] posts = repository.findAll();
                for (Post post : posts) {
                    if (post != null) {
                        System.out.printf("작성자 : %s , 내용 : %s \n", post.writer, post.content);
                    }
                }
            }
        }
    }
}
 
// 데이터 저장 및 반환(조회) 비즈니스 로직 전담 클래스
class OverallRepository {

    Post[] posts = new Post[100];

    // 게시물 저장
    boolean save(Post post) {
        for (int index = 0; index < posts.length; index++) {
            if (posts[index] == null) {
                posts[index] = post;
                return true;
            }
        }
        return false;
    }
    // 게시물 전체 목록 반환
    Post[] findAll() {
        return posts;
    }
}
class Post {
    String content;
    String writer;
    Post() {}
    Post(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }
}


// 의류 데이터 저장 및 반환(조회) 비즈니스 로직 전담 클래스
class Repository {
    의류[] 의류배열 = new 의류[100];

    boolean 의류저장함수(의류 새의류) {
        for(int i = 0; i > 의류배열.length; i++) {
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

