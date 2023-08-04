import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Bfs {
    int cul;
    int row;

    Bfs(int cul, int row) {
        this.cul = cul;
        this.row = row;
    }
}

public class baek_2178_미로탐색 {
    static int[][] arr;
    static boolean[][] v;
    static int[] dX = {0, 0, -1, 1};  //상하좌우 중 좌우
    static int[] dY = {-1, 1, 0, 0};  //상하좌우 중 상하
    static int N, M;

    public static void main(String[] args) {
        Input();
        int count = BFS(0, 0);
        System.out.println(count);
    }

    private static void Input() {
        //입력받기
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        //배열 객체 생성
        arr = new int[N][M];
        v = new boolean[N][M];
        // 미로 입력받기
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - 0x30;
            }
        }
    }

    private static int BFS(int c, int r) {
        //큐 및 변수 선언
        Queue<Bfs> qu = new LinkedList<>();
        int count = 1;
        //방문배열 체크, 큐에 삽입
        v[c][r] = true;
        qu.add(new Bfs(c, r));

        while (!qu.isEmpty()) {
            int cul = qu.peek().cul;
            int row = qu.peek().row;
            qu.poll();

            for (int i = 0; i < 4; i++) {
                int iCul = dX[i] + cul;
                int iRow = dY[i] + row;

                if (indexRange(iCul, iRow) && !v[iCul][iRow] && arr[iCul][iRow] <= count && arr[iCul][iRow] != 0) {
                    //방문배열 체크
                    v[iCul][iRow] = true;
                    //검사 좌표의 인접 좌표들은 현재 검사 좌표 값 +1 을 해준다.
                    arr[iCul][iRow] = arr[cul][row] + 1;
                    //큐에 요소삽입
                    qu.add(new Bfs(iCul, iRow));
                }
            }
        }
        count = arr[N-1][M-1];  //마지막 좌표 값 출력
        return count;
    }

    private static boolean indexRange(int cul, int row) {
        return (cul >= 0 && cul < N) && (row >= 0 && row < M);
    }

/*    private static void arrPrint() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }*/
}
