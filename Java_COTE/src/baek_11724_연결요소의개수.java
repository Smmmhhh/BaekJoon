import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek_11724_연결요소의개수 {
    public static void main(String[] args) throws Exception {
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {     //노드번호 1번부터 시작
            list[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }
        Solve(list, visited, N, M);
    }

    private static void Solve(ArrayList<Integer>[] list, boolean[] v, int n, int m) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (v[i]) continue;
            count++;
            DFS(list, v, i);
        }
        System.out.println(count);
    }

    private static void DFS(ArrayList<Integer>[] list, boolean[] v, int s) {
        v[s] = true;
        for(int i : list[s]){
            if (v[i]) continue;
            DFS(list, v, i);
        }
    }
}
