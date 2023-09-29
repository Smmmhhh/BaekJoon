import java.util.Scanner;

public class baek_2805_나무자르기 {
    public static void main(String[] args){
        // 나무의수 N, 나무의 길의 M입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long M = sc.nextLong();
        int[] arr = new int[N];
        long max = Integer.MIN_VALUE;
        //나무의 높이를 입력받는다.
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        long result = binarySearch(arr, M, max);
        System.out.println(result);
    }

    private static long binarySearch(int[] arr, long M, long Max){
        long min = 0;
        long max = Max;
        long mid = 0;

        while(min <= max){
            mid = (min + max) / 2;
            long sum = 0;

            for(int i = 0; i < arr.length; i++){
                if(arr[i] > mid) sum += arr[i] - mid;
            }
            if (sum < M){
                max = mid - 1;
            }else {
                min = mid + 1;
            }
        }
        return max;
    }
}
