import java.io.*;
import java.util.*;

public class Main {

    static int [][]map; //미로 배열
    static boolean[][] visited; //방문 처리 배열

    static int [] dx = {-1,1,0,0}; //상하좌우
    static int [] dy = {0,0,-1,1};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int [N][M]; //미로 초기화
        visited = new boolean[N][M]; // 방문 초기화

        
        //미로 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0'; //붙어서 입력 받음
            }
        }

        int ans = BFS(new Find(0,0, 1));


        System.out.println(ans);

    }

    static int BFS(Find find){
        Queue<Find> q = new ArrayDeque<>();

        q.add(find);
        visited[find.x][find.y] = true;


        //q가 완전히 빌때 까지
        while(!q.isEmpty()){
            Find curFind = q.poll();

            if(curFind.x == N-1 && curFind.y == M-1)
                return curFind.count;

            //4방 탐색
            for(int i=0; i<4; i++){
                int nextX = curFind.x + dx[i];
                int nextY = curFind.y + dy[i];

                //범위 벗어나면 continue
                if(nextX <0 || nextX >= N || nextY < 0 || nextY >= M)
                    continue;
                //방문 헀으면 continue
                if(visited[nextX][nextY])
                    continue;

                //이동할 수 있을 경우
                if(map[nextX][nextY] == 1){
                    visited[nextX][nextY] = true; //방문 처리
                    q.add(new Find(nextX, nextY, curFind.count + 1) ); //q에 추가
                }
                

            }

        }
        return 0;
    }

    static class Find{
        int x ;
        int y ;
        int count;

        Find(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
