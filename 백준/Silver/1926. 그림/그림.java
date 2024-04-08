import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1,1,0,0}; // 상, 하 ,좌 ,우
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;

    static int height;
    static int width;
    static int[][] paper;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken()); //도화지 세로 크기
        width = Integer.parseInt(st.nextToken()); //도화지 가로 크기

        paper = new int [height][width]; //도화지 설정
        visited = new boolean [height][width]; //방문 체크 초기화
        int max = 0;
        int count = 0;

        //그림 입력 받기
        for(int i = 0; i<height; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<width; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //전체 BFS paper 돌림
       for(int i=0; i<height; i++){
           for(int j=0; j<width; j++){

               if(paper[i][j] != 1) continue;
               if(visited[i][j]) continue;

               Painting newPainting =  new Painting(i, j);
               int curArea = BFS(newPainting);
               max = Math.max(max, curArea);
               count ++;
           }
       }


        System.out.println(count);
        System.out.println(max);
    }

    static int  BFS(Painting Painting){
        int area = 1;
        Queue<Painting> q = new ArrayDeque<>();

        //제일 처음 painting q에 추가
        q.add(Painting);
        visited[Painting.x][Painting.y] = true;

        //q 빌때 까지 4방 탐색
        while(!q.isEmpty()){
            Painting curPainting = q.poll();
            for(int i=0; i<4; i++){
                int nextX = curPainting.x + dx[i];
                int nextY = curPainting.y + dy[i];
                //범위 벗어나면 넘어가
                if((nextX < 0 || nextX >= height || nextY < 0 || nextY >= width) )
                    continue;
                //방문했으면 넘어가
                if(visited[nextX][nextY])
                    continue;
                //그림일 경우
                if(paper[nextX][nextY] == 1){
//                    System.out.println("nextX : " + nextX + "nextY : " + nextY + "isPainting : " + paper[nextX][nextY] );


                    q.add(new Painting(nextX, nextY));
                    visited[nextX][nextY] = true;
                    area += 1;
                }
            }
        }




        return area;
    }

    static class Painting{
        int x; // 그림의 x 좌표
        int y; // 그림의 y 좌표


        Painting(int x  , int y){
            this.x = x;
            this.y = y;
        }
    }

}
