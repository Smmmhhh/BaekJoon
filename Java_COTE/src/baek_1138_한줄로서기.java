import java.util.Scanner;
import java.util.Arrays;

public class baek_1138_한줄로서기 {
    public static void main(String[] args) {
        // N입력받기 및 N배열선언
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 정답 배열선언
        int[] answer = new int[N];

        // 순서 알고리즘
        /**
         *  입력받은 요소들 중 첫번째 요소부터 빈칸을 세어준 뒤 값을 채워 넣어준다.
         */
        for (int i = 0; i < N; i++) {
            int count = 0;
            int val = arr[i];

            for (int j = 0; j < N; j++) {
                if (answer[j] == 0) count++;
                if (count > val) {
                    answer[j] = i+1;
                    break;
                }
            }
        }
        // 정답출력
        for (int e : answer) {
            System.out.print(e + " ");
        }
    }
}
