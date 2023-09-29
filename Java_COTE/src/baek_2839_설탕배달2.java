import java.util.Scanner;

public class baek_2839_설탕배달2 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;

        while(true){
            if(N % 5 == 0) N -= 5;
            else if(N % 3 == 0) N -= 3;
            else if(N >= 5) N -= 5;
            else if(N >= 3) N -= 3;

            count++;

            if(N == 0){
                break;
            }else if(N < 3){
                count = -1;
                break;
            }
        }

        System.out.println(count);

    }
}