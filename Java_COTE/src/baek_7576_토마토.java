import javax.swing.plaf.basic.BasicFormattedTextFieldUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_7576_토마토 {
    static int[][] arr; //2차원 배열 선언
    static boolean[][] v;   // 방문배열 선언
    static int N, M;    // 상자크기 변수 선언
    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {-1, 1, 0, 0};
    static Queue<int []> qu = new LinkedList<>();
    static int count;

    public static void main(String[] args) throws IOException {
        // 입력받기 메서드 호출
        int size = Input();
        // 입력을 받았는데 익은 토마토가 없다면 -1 출력
        if(size == 0){
            System.out.println(-1);
            return;
        }
        // bfs 검사시작
        bfs();
        // 검사를 했지만 처음부터 토마토가 익어있는 상태면 0출력
        if(count == 0){
            System.out.println(0);
            return;
        }
        // 박스검사 후 토마토가 익을 최소 일수 출력, 하지만 하나라도 익지 않은 토마토가 있으면 -1출력
        if(boxInspection()){
            System.out.println(count-1);
        }else {
            System.out.println(-1);
        }
    }

    private static int Input() throws IOException {
        // 상자 크기 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //배열 객체생성
        arr = new int[M][N];
        v = new boolean[M][N];

        //토마토 상태 입력받기
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                //익은 토마토는 Queue에 넣어두기
                if(arr[i][j] == 1){
                    qu.add(new int[] {i, j});
                    v[i][j] = true;
                }
            }
        }
        return qu.size();   //익은 토마토 갯수 반환
/*        //출력테스트
        arrPrint();*/
    }

    private static void bfs(){

        while(!qu.isEmpty()){
            int[] x = qu.poll();
            int iCul = x[0];
            int iRow = x[1];

            for(int i = 0; i < 4; i++){
                int cul = iCul + dY[i];
                int row = iRow + dX[i];

                if(rangeInterlock(cul, row) && !v[cul][row] && arr[cul][row] == 0){
                    v[cul][row] = true;
                    qu.add(new int[] {cul, row});
                    arr[cul][row] = arr[iCul][iRow] +1;
                    count = arr[iCul][iRow] +1;
                }
            }
        }
    }

    private static boolean rangeInterlock(int c, int r){
        return (c >= 0 && c < M) && (r >= 0 && r < N);
    }

    private static boolean boxInspection(){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    private static void arrPrint(){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
