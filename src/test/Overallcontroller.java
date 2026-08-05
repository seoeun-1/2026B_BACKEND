package test;

import java.util.Scanner;

public class Overallcontroller {
    public static void main(String[] args) {
        Post[] posts = new Post[100];
        Scanner scan = new Scanner(System.in);
        for (;;){
            System.out.println("=======my community=======");
            System.out.println("1.게시물 글쓰기 2. 게시물 출력");
            System.out.println("===========================");
            System.out.println("선택");
            int ch = scan.nextInt();

            if (ch == 1) {
                scan.nextLine();
                System.out.println("내용: ");
                String content = scan.nextLine();
                System.out.println("작성자: ");
                String writer = scan.nextLine();

                Post post = new Post(content, writer);
                boolean result = false;

                for (int index = 0; index <= posts.length -1; index++){
                    if(posts[index] == null){
                        posts[index] = post;
                        result = true;
                        break;
                    }
                }

                if (result){
                    System.out.println("글쓰기 성공");
                }
                else{
                    System.out.println("글쓰기 실패");
                }
            }   
                else if(ch == 2){
                    for(Post post : posts){
                        if (post != null){
                            System.out.printf(" 작성자: %s 내용: %s \n", post.writer, post.contnet);
                        }
                    }
                }

        }
    }
}

class Post{ // <--- 첫글자 대문자
    String contnet;
    String writer;

    public Post() {}

    public Post(String contnet, String writer){
        this.contnet = contnet;
        this.writer = writer;
    }
}
