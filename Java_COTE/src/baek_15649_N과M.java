import java.util.Scanner;

public class baek_15649_N과M {

    static int[] arr;
    static boolean[] v;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M + 1];
        v = new boolean[N + 1];
        dfs(1);
    }

    private static void dfs(int level){

        if(level > M){
            arrPrint();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!v[i]) {
                v[i] = true;    //방문배열 true
                arr[level] = i;
                dfs(level + 1);
                v[i] = false;
            }
        }

    }

    private static void arrPrint(){
        for(int i = 1; i <= M; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

