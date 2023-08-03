import java.util.*;

public class baek_1260_DFS와BFS {
    static ArrayList<Integer>[] li;    // 인접리스트
    static boolean[] vs;                // 방문배열
    static int N, M, V;

    public static void main(String[] args) {
        Input();
        //DFS 실행
        DFS(V);
        System.out.println();
        //BFS 실행
        BFS(V);
    }

    private static void Input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();       // 노드의 수
        M = sc.nextInt();       // 간선의 개수
        V = sc.nextInt();       // 시작할 정점의 번호

        //ArrayList배열 ArrayList 객체 초기화, 방문배열 초기화
        li = new ArrayList[N + 1];
        vs = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            li[i] = new ArrayList<>();
        }
        //인접리스트 생성
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            li[s].add(e);
            li[e].add(s);
        }

        //ArrayList의 요소를 오름차순 정렬 해줘야함
        for(int i = 1; i <= N; i++){
            Collections.sort(li[i]);
        }
    }

    private static void DFS(int v) {
        if (vs[v]) return;
        vs[v] = true;
        System.out.print(v + " ");

        for(int i : li[v]){
            if(!vs[i]){
                DFS(i);
            }
        }

    }

    private static void BFS(int v){
        Arrays.fill(vs, false);
        // BFS는 Queue 자료구조 이용
        // 1. 입력받은 인접리스트 요소를 Queue에 삽입
        // 2. 해당 인접 리스트의 요소를 기준으로 반목문 실행
        // 3. 리스트의 요소들이 방문한 이력이 없으면 큐에 삽입
        vs[v] = true;
        Queue<Integer> qu = new LinkedList<>();
        qu.add(v);

        while (!qu.isEmpty()){
            int temp = qu.poll();
            System.out.print(temp + " ");
            for(int e : li[temp]){
                if(!vs[e]){
                    vs[e] = true;
                    qu.add(e);
                }
            }
        }

    }
}
