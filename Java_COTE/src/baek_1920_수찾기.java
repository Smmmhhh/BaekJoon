import java.util.Scanner;
import java.util.Arrays;

public class baek_1920_수찾기 {
    public static void main(String[] args){
        // N입력 및 배열 초기화
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        // N개의 정수 입력받기
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }
        // 배열 오름차순 정렬
        Arrays.sort(A);

        int M = sc.nextInt();
        int[] B = new int[M];


        for(int i = 0; i < M; i++){
            B[i] = sc.nextInt();
        }
        // 2진탐색
        for(int i = 0; i < M; i++){
            int target = sc.nextInt();
            boolean find = false;
            int start = 0;
            int end = N - 1;

            while(start <= end){
                int mid = (start + end) / 2;
                int value = A[mid];

                if(target == value){
                    find = true;
                    break;
                }
                if(target > value) {
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
            if(find)  System.out.println(1);
            else System.out.println(0);
        }
    }
}
