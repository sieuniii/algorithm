import java.util.*;
import java.io.*;


public class Main {
    static int[] visited = new int[100001];
    static int N; // 수빈 위치
    static int K; //동생 위치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N != K){
            BFS();
        }
        System.out.print(visited[K]);
        br.close();
    }

    public static void BFS(){
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = 1;

        while(!q.isEmpty()){
            int cur = q.poll(); //확인할 좌표

            for(int i=0; i<3; i++){
                int next;

                if(i == 0){
                    next = cur + 1; //오른쪽으로 걷기
                }
               else if(i == 1){
                    next = cur - 1; //왼쪽으로 걷기
                }
                else{
                    next = cur * 2; //순간이동
                }

                //next가 동생의 위치일 경우
                if(next == K){
//                    System.out.println("find");
                    visited[K] = visited[cur];
                    return ; //끝낸다
                }

                //next가 동생의 위치가 아닐 경우
                //next가 범위를 벗어나는 경우 -> 넘어감
                if(next < 0 || next >= visited.length)
                    continue;

                //아직 방문을 안했을 경우
                else if(visited[next] == 0){
                    q.add(next); //q에 추가
                    visited[next] = visited[cur] + 1; // 1 초 추가
                }
            }
        }
    }
}
