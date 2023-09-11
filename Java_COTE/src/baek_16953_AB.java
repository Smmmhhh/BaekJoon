/*
문제 접근방법
1. A -> B의 방향으로 찾아갈지 or B -> A의 방향으로 찾아갈지 선택한다.
1-1. A -> B의 방향으로 찾아가기 위해서는 BFS 알고리즘을 이용한다.
1-2. B -> A의 방향으로 찾아가기 위해서는 디그리 알로리즘을 이용한다.

 - 디그리 알고리즘 풀이방법 -
1. B의 값 끝자리가 "1" 이라면 1을 빼준 값을 구한다. ex) 40021 -> 4002
2. B의 값이 짝수라면 "2" 로 값을 나누어 준다. ex) 4002 -> 2001
3. 위 과정을 반복하며 COUNT를 세어준다.
4. 위 과정을 반복할 때 마다 B와 A의 값을 비교하며 A=B 라면 반복문을 종료한다.
5. 만약 A > B 라면 만들 수 없는 경우에 해당하기 때문에 -1을 출력한다.

※ 연산을 진행하다가 B의값이 홀수가 된다면 만들 수 없는 경우에 해당하기 때문에 반복문을 종료한다.
 */

import java.util.Scanner;

public class baek_16953_AB {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        int count = 1;

        while (true) {
            if (B % 10 == 1) B /=  10;
            else if(B % 2 == 0) B /= 2;
            else if(B % 2 == 1){
                count = -1;
                break;
            }

            count++;

            if(A == B) break;
            else if(A > B) {
                count = -1;
                break;
            }
        }
        System.out.println(count);

    }
}
