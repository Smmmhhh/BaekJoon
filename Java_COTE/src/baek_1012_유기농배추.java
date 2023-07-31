import java.util.Scanner;

public class baek_1012_유기농배추 {
    static int T;
    static int cul;
    static int row;
    static int q;
    static int[][] arr;
    static int count;
    static boolean v[][];
    static int[] dirX = {0, 0, -1, 1};   // 상하좌우 //좌우
    static int[] dirY = {-1, 1, 0, 0};   // 상하좌우 //상하
    static int dC, dR;
    static int[] p;

    private static void arrPirint() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void Input() {
        Scanner sc = new Scanner(System.in);
        // TestCase
        T = sc.nextInt();
        p = new int[T];
        for (int i = 0; i < T; i++) {
            count = 0;
            //입력받기
            cul = sc.nextInt();
            row = sc.nextInt();
            q = sc.nextInt();
            arr = new int[cul][row];
            v = new boolean[cul][row];

            for (int j = 0; j < q; j++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                arr[s][e] = 1;
            }
            p[i] = Insepection();
            //출력 테스트
            //arrPirint();
        }
    }

    private static int Insepection(){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(!v[i][j] && arr[i][j] == 1){
                    count++;
                    DFS(i, j);
                }
            }
        }
        return count;
    }

    private static void DFS(int pCul, int pRow){
        //방문배열 True
        v[pCul][pRow] = true;
        //가로세로 탐색 시작
        for(int i = 0; i < 4; i++){
            dC = dirY[i] + pCul;
            dR = dirX[i] + pRow;

            if(rI() && !v[dC][dR] && arr[dC][dR] == 1){
                DFS(dC, dR);
            }
        }

    }

    private static boolean rI(){
        return ((dC >= 0 && dC < cul) && (dR >= 0 && dR < row));
    }

    public static void main(String[] args) {
        Input();
        for(int i = 0; i < T; i++){
            System.out.println(p[i]);
        }
    }
}
