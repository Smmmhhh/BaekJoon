import java.util.Scanner;

public class beak_2512_예산 {
    public static void main(String[] args) {
        // N입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        //변수 선언
        long sum = 0;
        long left = 0;
        long right = Integer.MIN_VALUE;

        //N개의 정수 입력받기
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];  //입력받으며 합계구하기
            right = Math.max(right, arr[i]);    //입력받으며 최대값 구하기
        }
        // 총 예산 입력받기
        long M = sc.nextLong();

        //n개의 정수들의 합이 M보다 작을경우 최댓값 출력
        if (sum <= M) {
            System.out.println(right);
        } else {
            long result = binarySearch(arr, M, left, right);    //예산이 부족한 경우 이진탐색 실행
            System.out.println(result);
        }
    }

    private static long binarySearch(int[] arr, long M, long left, long right) {
        long val = 0;

        while (left <= right) {
            long mid = (left + right) / 2;     //내야할 예산
            long sum = 0;       // 모든 지방의 예산 합

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= mid) sum += mid;
                else sum += arr[i];
            }

            if (sum <= M) left = mid + 1;
            else right = mid - 1;

        }
        return right;
    }
}
