/*
문제 접근방법
1. A -> B의 방향으로 찾아갈지 or B -> A의 방향으로 찾아갈지 선택한다.
1-1. A -> B의 방향으로 찾아가기 위해서는 BFS 알고리즘을 이용한다.
1-2. B -> A의 방향으로 찾아가기 위해서는 디그리 알로리즘을 이용한다.

 - BFS 알고리즘 풀이방법 -
1. A값을 Queue에 담아주고 반복문을 시작한다.
2. Queue의 요소들을 (temp * 10) + 1 <= B , temp * 2 <= B 조건을 검사 후 계산된 값을 add해준다.
(동시에 count++)
3. 요소들을 검사하며 B와 같은값이 있을경우 count를 return해주고, Queue의 요소가 없어지면
만들 수 없는 경우에 해당하기 때문에 -1을 리턴한다.
 */

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class baek_16953_AB_BFS {

    private static int bfs(long A, long B) {
        Queue<Long> qu = new LinkedList<>();
        int count = 1;

        qu.add(A);
        while (!qu.isEmpty()) {
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                long temp = qu.poll();
                if (temp == B) return count;

                if ((temp * 10) + 1 <= B) qu.add(temp * 10 + 1);
                if (temp * 2 <= B) qu.add(temp * 2);
                //출력확인용
                list(qu, count);
            }
            count++;
        }
        return -1;

    }

    private static void list(Queue<Long> qu, int count){
        int i = 0;
        System.out.print(count + "번째 loop ");
        for(Long e : qu){
            i++;
            System.out.print("index" + i + " : " + e + " , ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        int result = bfs(A, B);
        System.out.println(result);
    }
}
