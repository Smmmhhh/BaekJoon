/*
       산술평균 : N개의 수들의 합을 N으로 나눈 값
       중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우
       그 중앙에 위치하는 값
       최빈값 : N개의 수들 중 가장 많이 나타나는 값
       범위 : N개의 수들 중 최댓값과 최솟값의 차이*/

import java.util.*;

public class baek_2108_통계학 {
    public static void main(String[] args) {
        //입력 및 배열선언
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        // 수 입력받기
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        Calculate(A);
        /*출력확인*/
        //arrPrint(A);
    }

    /*    private static void arrPrint(int[] arr){
            for(int e : arr){
                System.out.print(e + " ");
            }
        }*/
    private static void Calculate(int[] arr) {
        double sum = 0;
        //산술평균
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double avg = sum / arr.length;
        System.out.println(Math.round(avg));

        //중앙 값
        int mid = arr[arr.length / 2];
        System.out.println(mid);

        //최빈값
        int count = 0;
        int s = 0;
        int e = s + 1;
        int temp = 0;
        boolean result = false;
        ArrayList<Integer> li = new ArrayList<>();

        while (e <= arr.length - 1) {
            if (arr[s] == arr[e]) {
                result = true;
                count++;
                e++;
                if (temp < count) {
                    li.clear();
                    li.add(arr[s]);
                } else if (temp == count) {
                    li.add(arr[s]);
                }
                continue;
            } else {
                e++;
                s = e - 1;
            }
            if (result) {
                if (count > temp) {
                    temp = count;
                }
                count = 0;
                result = false;
            }
        }
        // 최빈값 출력
        if (li.size() > 1) {
            System.out.println(li.get(1));
        } else if (li.size() == 1) {
            System.out.println(li.get(0));
        } else if (arr.length > 1) {
            System.out.println(arr[1]);
        } else {
            System.out.println(arr[0]);
        }

        //범위
        int max = arr[arr.length - 1];
        int min = arr[0];
        int range = max - min;
        System.out.println(range);
    }
}
