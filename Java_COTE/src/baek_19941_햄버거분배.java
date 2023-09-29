import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class baek_19941_햄버거분배 {
    public static void main(String[] args) {

        // 입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String str = sc.next();
        char[] c = new char[N];

        for (int i = 0; i < N; i++) {
            c[i] = str.charAt(i);
        }

        boolean[] result = new boolean[N];
        Arrays.fill(result, false);

        int count = 0;
        //사람찾기
        for (int i = 0; i < N; i++) {
            if (c[i] == 'P') {
                int left = i - M;
                int right = i + M;

                for (int j = left; j <= right; j++) {
                    if(j >= 0 && j < N) {
                        if (c[j] == 'H' && !result[j]) {
                            count++;
                            result[j] = true;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(count);

    }
}
