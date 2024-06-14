import java.util.*;
import java.io.*;

public class Main {


    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;

    static ArrayList<Integer> areaList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //지도의 크기

        map = new int[N][N];

        //입력 받기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        BFS();
    }


    public static void BFS(){
        Queue<Position> q = new LinkedList<>();
        int count = 0;
        int area = 0;

        //map 전탐
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                //만약 map이 숫자가 1일 경우
                if(map[i][j]==1){
                    q.add(new Position(i , j)); //q에 추가
                    map[i][j] = 2; //방문 처리
                    area = 1;

                    while(!q.isEmpty()){
                        Position cur = q.poll(); //현재 위치

                        //4방 탐색
                        for(int k=0; k<4; k++){
                            int nextX = cur.x+dx[k];
                            int nextY = cur.y+dy[k];

                            //범위 벗어나면 continue
                            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
                                continue;

                            //범위 안에 있고, 방문하지 않고, 집일 경우
                            else if(map[nextX][nextY]==1){
                                map[nextX][nextY] = 2; //방문 처리
                                q.add(new Position(nextX , nextY)); // 다음 탐색 지역 추가
                                area ++; //넓이 추가
                            }

                        }
                    }

                    areaList.add(area);
                    count++;

                }

            }
        }

        System.out.println(count);

        //오름차순 정렬
        areaList.sort(Comparator.naturalOrder());

        for(int i=0; i<areaList.size(); i++){
            System.out.println(areaList.get(i));
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

    //디버깅용 map 출력 함수
    public static void printMap(int N){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
