import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class baek_4963_섬의개수 {
     static int N, M;    // N, M 입력받기
     static int[][] arr; // 2차원 배열 선언
     static boolean[][] v;   // 방문 배열 선언
     static int[] dX = {0, 1, 1, 1, 0, -1, -1, -1};    //12시 방향부터 X값 셋팅
     static int[] dY = {-1, -1, 0, 1, 1, 1, 0, -1};    //12시 방향부터 Y값 셋팅
     static int count;

     public static void main(String[] args) throws IOException{
          Input();
     }

     private static void Input() throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer st;

          while(true){
               st = new StringTokenizer(br.readLine());
               N = Integer.parseInt(st.nextToken());
               M = Integer.parseInt(st.nextToken());

               // N과 M이 0이 아닐 때 까지 반복
               if(N == 0 && M == 0) break;

               arr = new int[M][N];          //2차원 배열 새로운 객체 생성

               for(int i = 0; i < M; i++){
                    st = new StringTokenizer(br.readLine());
                    for(int j = 0; j < N; j++){
                         arr[i][j] = Integer.parseInt(st.nextToken());
                    }
               }
               inspection(M, N);
/*               //출력 테스트
               arrPrint();*/
          }
     }

     private static void inspection(int c, int r){
          // 방문배열 초기화
          v = new boolean [c][r];
          for(int i = 0; i < c; i++){
               for(int j = 0; j < r; j++){
                    if(!v[i][j] && arr[i][j] != 0){
                         count++;
                         dfs(i ,j);
                    }
               }
          }
          System.out.println(count);
          count = 0;
     }

     private static void dfs(int c, int r){
          if(v[c][r]) return;

          v[c][r] = true;

          for(int i = 0; i < 8; i++){
               int cul = dY[i] + c;
               int row = dX[i] + r;

               if(rangeInterlock(cul, row) && !v[cul][row] && arr[cul][row] != 0){
                    dfs(cul, row);
               }
          }
     }

     private static boolean rangeInterlock(int c, int r){
          return (c >= 0 && c < M) && (r >= 0 && r < N);
     }

     private static void arrPrint(){
          for(int i = 0; i < arr.length; i++){
               for(int j = 0; j < arr[i].length; j++){
                    System.out.print(arr[i][j] + " ");
               }
               System.out.println();
          }
          System.out.println();
     }

}
