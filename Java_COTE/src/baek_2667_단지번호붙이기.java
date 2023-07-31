import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class baek_2667_단지번호붙이기 {

    // 입력배열 및 방문 배열 선언, 변수 선언
    static int[][] arr;
    static boolean[][] v;
    static int dirX[] = { 0, 0, -1, 1 }; // 상하좌우 중 좌우
    static int dirY[] = { -1, 1, 0, 0 }; // 상하좌우 중 상하
    static ArrayList<Integer> list = new ArrayList<>();
    static int count, number;
    static int nC, nR;
    static int N;

    public static void main(String[] args) {

        // 입력받기
        Input();
        // 배열 요소 검사
        Inspection();
        // 리스트 정렬
        Collections.sort(list);
        // 출력
        System.out.println(number);
        for (int e : list) {
            System.out.println(e);
        }
    }

    private static void Input() {
        // 크기 N입력받기 및 N개의 크기 배열 객체생성
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        v = new boolean[N][N];

        // 자료 입력받기
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
    }

    private static void Inspection() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (!v[i][j] && arr[i][j] == 1) {
                    count = 0; // 카운터 0으로 초기화
                    number++; // 단지 더해주기
                    DFS(i, j);
                    list.add(count);
                }
            }
        }
    }

    private static void DFS(int cul, int row) {
        v[cul][row] = true;
        //arr[cul][row] = number;	//없어도 상관없음 단지별 번호 부여하기 위함
        count++;

        for (int i = 0; i < 4; i++) {
            nC = dirX[i] + cul;
            nR = dirY[i] + row;

            if (rangeCheck() && !v[nC][nR] && arr[nC][nR] == 1) {
                v[nC][nR] = true;
                //arr[nC][nR] = number;		//없어도 상관없음 단지별 번호 부여하기 위함

                DFS(nC, nR);
            }
        }

    }

    private static boolean rangeCheck() {
        return ((nC >= 0 && nC < N) && (nR >= 0 && nR < N));
    }

}
