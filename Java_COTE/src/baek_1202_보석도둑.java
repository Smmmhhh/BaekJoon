import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 무게를 오름차순 무게가 같다면, 가격은 내림차순을 진행해준다.
2. 가방 무게는 오름차순으로 정렬한다.
3. 1번가방부터 반복문 시작
3-1. 1번 가방의 무게보다 작거나 같은값을 우선순위 큐에 넣는다. (내림차순)
3-2. 1~3 반복
*/

public class baek_1202_보석도둑 {
    public static void main(String[] args) throws IOException {

        //보석의 개수 N, 가방의 개수 K
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //보석 클래스 배열 선언, 가방 무게 배열선언
        Jewel[] jw = new Jewel[N];
        int[] b = new int[K];
        //보석 값 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jw[i] = new Jewel(weight, price);
        }
        //가방 무게 입력받기
        for (int i = 0; i < K; i++) {
            b[i] = Integer.parseInt(br.readLine());
        }

        // 보석 값 정렬(무게를 오름차순, 가격을 내림차순)
        Arrays.sort(jw, new Jewel());
        // 가방 무게 오름차순 정렬
        Arrays.sort(b);
        //보석 값, 가장 무게 출력 테스트
        Inspection(jw, b);
        //bagPrint(b);
    }

    static void Inspection(Jewel[] jw, int[] b) {
        //가방보다 작거나 같은 무게를 가진 보석의 가격을 내림차순으로 정렬(우선순위 큐)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            while (j < jw.length && jw[j].getWeight() <= b[i]) {
                pq.offer(jw[j].getPrice());
                j++;
            }
            if (!pq.isEmpty())
                sum += pq.poll();
        }
        System.out.println(sum);
    }

    static void jewelPirnt(Jewel[] jw) {
        for (Jewel e : jw) {
            System.out.println(e.getWeight() + " " + e.getPrice());
        }
    }

    static void bagPrint(int[] arr) {
        for (int e : arr) {
            System.out.print(e + " ");
        }
    }
}

class Jewel implements Comparator<Jewel> {
    int weight;
    int price;

    Jewel() {
    }

    Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compare(Jewel o1, Jewel o2) {
        if (o1.weight > o2.weight) {            //무게 오름차순
            return 1;
        } else if (o1.weight < o2.weight) {
            return -1;
        } else {
            if (o1.price > o2.price) {          //가격 내림차순
                return -1;
            } else if (o1.price < o2.price) {
                return 1;
            } else {
                return 0;
            }
        }
    }

}