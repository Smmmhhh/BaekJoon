import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class baek_7795_먹을것인가먹힐것인가 {
    static int Bmin;
    static int Bmax;

    public static void arrPrint(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int binarySearch(int[] A, int[] B) {
        //B배열만 정렬
        Arrays.sort(B);

        int count = 0;
        int start = 0, end = B.length - 1;
        int mid = 0;

        for (int i = 0; i < A.length; i++) {
            start = 0;
            end = B.length - 1;
            int index = 0;
            while (start <= end) {
                mid = (start + end) / 2;

                if(A[i] > B[mid]){
                    start = mid + 1;
                    index = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
            count += index;
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        //TestCase 반복
        for (int i = 0; i < T; i++) {
            Bmin = Integer.MAX_VALUE;
            Bmax = Integer.MIN_VALUE;
            int N = sc.nextInt();
            int M = sc.nextInt();
            //N크기의 A배열 초기화, M크기의 B배열 초기화
            int[] A = new int[N];
            int[] B = new int[M];

            //배열 입력받기
            for (int j = 0; j < A.length; j++) {
                A[j] = sc.nextInt();
            }
            for (int k = 0; k < B.length; k++) {
                B[k] = sc.nextInt();
                //B배열의 최대값 최소값 구하기
                if (Bmax < B[k]) Bmax = B[k];
                if (Bmin > B[k]) Bmin = B[k];
            }

            //binarySearch Start
            int count = binarySearch(A, B);
            System.out.println(count);

/*            //출력 테스트
            arrPrint(A);
            arrPrint(B);*/


        }

    }
}
