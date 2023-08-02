/*
       산술평균 : N개의 수들의 합을 N으로 나눈 값
       중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우
       그 중앙에 위치하는 값
       최빈값 : N개의 수들 중 가장 많이 나타나는 값
       범위 : N개의 수들 중 최댓값과 최솟값의 차이*/

import java.util.*;

public class baek_2108_통계학_2 {

    static Map<Integer, Integer> hm;

    public static void main(String[] args) {
        //입력 및 배열선언
        Scanner sc = new Scanner(System.in);
        hm = new HashMap<>();

        int N = sc.nextInt();
        int[] A = new int[N];
        // 수 입력받기
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 맵에넣기
        for (int i = 0; i < N; i++) {
            if (hm.containsKey(A[i])) {
                int temp = hm.get(A[i]) + 1;
                hm.put(A[i], temp);
            } else {
                hm.put(A[i], 1);
            }
        }

        Arrays.sort(A);
        Calculate(A);
    }


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
        List<Integer> li = new ArrayList<>(hm.keySet());
        li.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                int temp1 = o1;
                int temp2 = o2;
                if(hm.get(o1) > hm.get(o2)){
                    return -1;
                } else if (hm.get(o1) < hm.get(o2)) {
                    return 1;
                }else {
                    if(temp1 > temp2){
                        return 1;
                    }else if (temp1 < temp2){
                        return -1;
                    }else {
                        return 0;
                    }
                }
            }
        });

        int temp1 = li.get(0);
        int temp2 = 0;
        if(li.size() > 1) temp2 = li.get(1);

        if(hm.get(temp1) == hm.get(temp2)){     //카운터가 같은게 있다면 2번째 인덱스 출력
            System.out.println(li.get(1));
        }else System.out.println(li.get(0));    //그게 아니라면 0번 인덱스 출력

        //범위
        int max = arr[arr.length - 1];
        int min = arr[0];
        int range = max - min;
        System.out.println(range);
    }
}
