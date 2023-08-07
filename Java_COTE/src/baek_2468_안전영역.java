import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class baek_2468_안전영역 {
    static int N;               //지역 & 2차원 배열의 행과 열의 개수
    static int[][] arr;         // 2차원 배열 선언
    static boolean[][] v;       // 방문 배열 선언
    static int[] dX = {0, 0, -1, 1};    //상하좌우 중 좌우
    static int[] dY = {-1, 1, 0, 0};    //상하좌우 중 상하
    static ArrayList<Integer> li = new ArrayList<>();   //높이정보 리스트
    static int count;

    public static void main(String[] args) throws IOException {
        //입력받기
        Input();
        //Inspection
        ISP();
        //리스트 요소 중 가장 큰 값을 출력해야 하므로 내림차순 정렬
        li.sort(Collections.reverseOrder());
        //정답 출력
        System.out.println(li.get(0));
    }

    private static void Input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 행렬 N입력받기, 2차원 배열 및 방문배열 객체생성
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        v = new boolean[N][N];

        //2차원 배열 입력받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                //리스트에 없는 값을 입력받으면 리스트에 해당 값 입력
                if (!li.contains(arr[i][j])) {
                    li.add(arr[i][j]);
                }
            }
        }
/*        // 출력확인
        arrPrint();*/
    }

    private static void ISP() {
        //리스트 요소가 1이면 수행하지 않고 return
        if(li.size() == 1){
            return;
        }

        for (int k = 0; k < li.size(); k++) {   //list 크기만큼 반복
            //방문배열 초기화
            visitArrReset();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (!v[i][j] && arr[i][j] > li.get(k)) {
                        count++;
                        dfs(i, j, li.get(k));  //dfs 호출
                    }
                }
            }
            li.set(k, count);
            count = 0;
        }
    }
    private static void visitArrReset(){
        for(int i = 0; i < v.length; i++){
            Arrays.fill(v[i],false);
        }
    }
    private static void dfs(int c, int r, int li) {
        //이미 방문한 경우  return
        if (v[c][r]) return;

        //방문배열 true
        v[c][r] = true;

        //인접요소 검사
        for (int i = 0; i < 4; i++) {
            int cul = dY[i] + c;
            int row = dX[i] + r;

            if (rangeInterlock(cul, row) && !v[cul][row] && arr[cul][row] > li) {
                dfs(cul, row, li);
            }

        }
    }

    private static boolean rangeInterlock(int c, int r) {
        return (c >= 0 && c < N) && (r >= 0 && r < N);
    }

    private static void arrPrint() {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
