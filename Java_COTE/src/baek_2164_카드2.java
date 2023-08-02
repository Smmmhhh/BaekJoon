import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_2164_카드2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 큐 선언
        Queue<Integer> qu = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            qu.add(i);
        }
        
        while(qu.size() != 1){
            qu.poll();
            int temp = qu.poll();
            qu.add(temp);

        }
        System.out.println(qu.peek());


    }
}
