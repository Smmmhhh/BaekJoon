import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*배열값을 오름차순 정렬 후 start 포인트는 배열의 첫요소,
end 포인트는 배열의 마지막 요소로 지정 후 two pointer 알고리즘을 사용해서
nlog(n)의 시간복잡도로 문제를 푼다.*/

public class baek_2470_두용액 {
    private static void find(int[] arr, int ps, int ng) {
        int val = Integer.MAX_VALUE;
        int s = 0;
        int e = arr.length - 1;
        int sTemp = 0, eTemp = 0;

        Arrays.sort(arr);   //배열 값 정렬

        if (ps == 0) {          // 배열의 요소가 음수밖에 없을 때는 요소의 end, end-1이 가장 0에 가까운 값이다.
            System.out.println(arr[arr.length - 2] + " " + arr[arr.length - 1]);
            return;
        }else if (ng == 0) {    // 배열의 요소가 양수밖에 없을 때는 요소의 start, start + 1 이 가장 0에 가까운 값이다.
            System.out.println(arr[0] + " " + arr[1]);
            return;
        }else {                 // 양수와 음수가 모두 있을 때 two pointer
            while (s < e) {
                int sum = arr[s] + arr[e];
                if (Math.abs(sum) < val) {    //val값이 sum의 절대값 보다 더 크면 sum이 0에 더 가까운수
                    val = Math.abs(sum);
                    sTemp = arr[s];
                    eTemp = arr[e];
                }
                if (sum < 0) {       //음수일때는 s++
                    s++;
                } else if (sum > 0) { //양수일때는 e++
                    e--;
                } else if (sum == 0) {
                    System.out.println(arr[s] + " " + arr[e]);
                    return;
                }
            }
        }
        System.out.println(sTemp + " " + eTemp);
    }

    public static void main(String[] args) throws IOException {

        //입력받기, 배열 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        int positive = 0;
        int negative = 0;

        // 배열 값 입력 받을 때 양수 와 음수 카운터 체크
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (positive == 0 && A[i] > 0) {    //양수가 하나 이상있는지 체크
                positive++;
            } else if (negative == 0 && A[i] < 0) {
                negative++;                     //음수가 하나 이상있는지 체크
            }
        }
        find(A, positive, negative);
    }
}