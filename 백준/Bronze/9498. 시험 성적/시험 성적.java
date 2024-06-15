//시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int score = Integer.parseInt(st.nextToken());

        if(score< 60)
            System.out.println("F");
        else if(score < 70)
            System.out.println("D");
        else if(score < 80)
            System.out.println("C");
        else if(score < 90)
            System.out.println("B");
        else
            System.out.println("A");
    }
}
