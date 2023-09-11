import java.util.Scanner;

public class back_2824_최대공약수 {
    private static void multiple(long num1, long num2){

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long num1 = 1;
        long num2 = 1;
        long no = 0;

        // N입력받기(첫번째 최대공약수 값의 요소)
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            no = sc.nextInt();
            num1 *= no;
        }
        // M입력받기(두번째 최대공약수 값의 요소)
        int M = sc.nextInt();
        for(int i = 0; i < M; i++){
            no = sc.nextInt();
            num2 *= no;
        }
        //multiple(num1,num2);
    }
}
