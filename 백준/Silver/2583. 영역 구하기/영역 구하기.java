import java.util.*;
import java.io.*;

public class Main {

    static int[][] map ;
    static int M; //세로
    static int N; //가로
    static int K; //사각형 수

    static int[] areaList;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        areaList = new int [M*N];


        //사각형 채우기
       for(int i = 0 ; i < K ; i++){
           st = new StringTokenizer(br.readLine());
           int firstX = Integer.parseInt(st.nextToken()); //왼쪽 아래 꼭짓점 x
           int firstY = Integer.parseInt(st.nextToken()); //왼쪽 아래 꼭짓점 y

           int secondX = Integer.parseInt(st.nextToken()); //오른쪽 상단 꼭짓점 x
           int secondY = Integer.parseInt(st.nextToken()); //오른쪽 상단 꼭짓점 y

           for(int j = firstY ; j < secondY ; j++) {
               for (int k = firstX; k < secondX; k++) {
                   map[j][k] = 1;
               }
           }
       }

       BFS();
    }

    public static void BFS(){
        int count = 0; //영역의 수
        Queue<Position> q = new LinkedList<>();

        //완탐
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){


                //아직 방문 안했고 사각형 영역이 아닌 경우
                if(map[i][j] == 0){
                    q.add(new Position(i,j));
                    map[i][j] = 2; //방문 처리
                    count ++;


                    while(!q.isEmpty()){
                        Position cur = q.poll();

                        //4방 탐색
                        for(int k = 0; k<4; k++){
                            int nextX = cur.x + dx[k];
                            int nextY = cur.y + dy[k];

                            //범위 체크
                            if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N)
                                continue;

                            //방문을 안했고 사각형이 아니면
                            else if(map[nextX][nextY] == 0){
                                q.add(new Position(nextX,nextY)); //q에 추가
                                map[nextX][nextY] = 2; //방문 체크
                                areaList[count] ++; //넓이 체크
                            }
                        }
                    }


                }
            }
        }

        System.out.println(count);

        //정렬
        Arrays.sort(areaList);
        
        for(int i = count ; i > 0 ; i--){
            System.out.print(areaList[(M*N )- i ]+ 1 + " ");
        }


    }

    public static class Position{
        int x;
        int y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    //디버깅용 map 출력
    public static void printMap(){
        for(int i = 0 ; i < M ; i++){
            for(int j=0; j < N; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
