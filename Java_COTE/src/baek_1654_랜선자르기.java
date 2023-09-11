/*
1. 입력받은 랜선의 길이중 가장 큰 값을  max값으로 설정한다.
2. max값에 +1 을 해준다.
3. mid 값을 (max + 1) / 2 로 설정한다.
4. 입력받은 랜선의 요소들을 mid값으로 나누어 랜선을 만드는 count 갯수를 구한다.
5. 랜선의 갯수가 입력받은 n개보다 작다면 랜선의 max값을 mid값으로 바꾸어준다.
6. 1~5의 과정을 반복하며 count 의 값이 n개보다 크거나 같으면 min값을 출력시켜준다.
 */

import java.util.Scanner;

public class baek_1654_랜선자르기 {
    public static void main(String[] args){

        // 입력받기
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        int[] A = new int[K];

        //입력받으면서 max값 구하기
        long max = 0;
        for(int i = 0; i < A.length; i++){
            A[i] = sc.nextInt();
            if(max < A[i]) max = A[i];
        }
        // 최대 길이 구하기
        max++;
        long min = 0;
        long mid = 0;

        while(min < max){
            mid = (max + min) / 2;
            long count = 0;

            for(int i = 0; i < A.length; i++){
                count += (A[i] / mid);
            }
            if(count < N){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        System.out.println(min - 1);

    }

}
