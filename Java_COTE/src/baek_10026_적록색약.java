import java.util.Arrays;
import java.util.Scanner;

public class baek_10026_적록색약 {
    static int N;           //배열크기
    static char[][] arr1;    //공간배열(적록색약X)
    static char[][] arr2;    //공간배열(적록색약O)
    static boolean[][] v;   //방문배열
    static int[] dirX = {0, 0, -1, 1};  //상하좌우 -> 좌우
    static int[] dirY = {-1, 1, 0, 0};  //상하좌우 -> 상하
    static int[] count = new int[3];
    static int nC, nR;

    private static void Input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        //배열 초기화
        arr1 = new char[N][N];
        arr2 = new char[N][N];
        v = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                arr1[i][j] = str.charAt(j);
                arr2[i][j] = str.charAt(j);

                if(str.charAt(j) == 'G'){
                    arr2[i][j] = 'R';
                }

            }
        }

    }

    /*    private static void arrPrint(){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }*/
    private static void Inspection(boolean blindness) {
        char[] color = {'R', 'G', 'B'};
        Arrays.fill(count, 0);
        for(int i = 0; i < N; i++){
            Arrays.fill(v[i], false);
        }

        if (blindness) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!v[i][j] && arr1[i][j] == 'R') {
                        count[0]++;
                        DFS(i, j, color[0], true);
                    } else if (!v[i][j] && arr1[i][j] == 'G') {
                        count[1]++;
                        DFS(i, j, color[1], true);
                    } else if (!v[i][j] && arr1[i][j] == 'B') {
                        count[2]++;
                        DFS(i, j, color[2], true);
                    }
                }
            }
        }else{
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!v[i][j] && arr2[i][j] == 'R') {
                        count[0]++;
                        DFS(i, j, color[0], false);
                    } else if (!v[i][j] && arr2[i][j] == 'B') {
                        count[2]++;
                        DFS(i, j, color[2], false);
                    }
                }
            }
        }
    }

    private static void DFS(int c, int r, char color, boolean blindness) {
        v[c][r] = true;

        for (int i = 0; i < 4; i++) {
            nC = dirY[i] + c;
            nR = dirX[i] + r;
            if(blindness) {
                if (rI() && !v[nC][nR] && arr1[nC][nR] == color) {
                    DFS(nC, nR, color, true);
                }
            } else {
                if (rI() && !v[nC][nR] && arr2[nC][nR] == color) {
                    DFS(nC, nR, color, false);
                }
            }
        }
    }

    private static boolean rI() {
        return (nC >= 0 && nC < N) && (nR >= 0 && nR < N);
    }

    private static int print() {
        int sum = 0;
        for (int e : count)
            sum += e;
        return sum;
    }

    public static void main(String[] args) {
        //입력받기
        Input();
        // 적록색약이 아닌 검사시작
        Inspection(true);
        System.out.print(print() + " ");
        // 적록색약 검사시작
        Inspection(false);
        System.out.println(print());



        //출력 테스트
        //arrPrint();
    }
}
