import java.util.ArrayList;
import java.util.Scanner;

public class baek_2606_바이러스 {
    static int count = 0;

    public static void main(String[] args) {
        // 컴퓨터 수, 컴퓨터 쌍의 수
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 리스트 배열생성, 방문 배열 생성
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        boolean[] v = new boolean[n + 1];

        // 리스트배열 초기화
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        // 리스트에 연결요소 저장하기
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            // 양쪽연결
            list[s].add(e);
            list[e].add(s);
        }

        // 방문 메소드 실행(1번에 인접한 요소만 찾아야 하므로 1을 넣어줌)
        DFS(list, v, 1);

        // 출력
        System.out.println(count - 1);
    }

    private static void DFS(ArrayList<Integer>[] list, boolean[] v, int t) {
        if (v[t])
            return;
        // 방문안했으면 방문배열 true
        v[t] = true;
        count++; // 카운터 더해주기

        // 해당 노드의 인접리스트를 DFS재귀함수 호출
        for (int i = 0; i < list[t].size(); i++) {
            if (!v[list[t].get(i)]) {
                DFS(list, v, list[t].get(i));
            }
        }
    }

}
