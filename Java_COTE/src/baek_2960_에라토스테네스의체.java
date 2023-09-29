import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class baek_2960_에라토스테네스의체 {
    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        ArrayList<Integer> li = new ArrayList<>();

        // 수열 입력받기
        for (int i = 0; i < N - 1; i++) {
            li.add(i + 2);
        }

        int P = 2;
        int index = li.indexOf(P);
        li.remove(index);
        P = P * 2;
        int count = 1;
        int findValue = 0;
        int standart = 2;
        while (K != count) {
            for(int i = 0; i < li.size(); i++){
            if (li.contains(P)) {
                index = li.indexOf(P);
                findValue = li.remove(index);
                count++;
                if (count == K) break;
                P += standart;
            }

            } else { //남은 수들 중 소수찾기
                P = find(li);
                standart = P;
            }
        }
        System.out.println(findValue);
    }

    private static int find(ArrayList<Integer> li) {
        List<Integer> fli = new ArrayList<>();
        for (int i = 0; i < li.size(); i++) {
            for (int j = 1; j <= li.get(i); j++) {
                if(li.get(i) % j == 0 || li.get(i) % j == li.get(i)) fli.add(li.get(i) / j);

            }
            if (fli.size() == 2) {
                return li.get(i);
            } else {
                fli.clear();
            }
        }
        return -1;*/
    }
}

