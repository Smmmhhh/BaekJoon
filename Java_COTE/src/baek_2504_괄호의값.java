import java.util.Scanner;

public class baek_2504_괄호의값 {

    private static int Inspection(char[] arr, int start, int end) {
        // 배열의 길이가 홀수면 잘못된 식이기 때문에 return
        if (arr.length % 2 != 0) {
            return -1;
        }
        if (start >= end){
            return 0;
        }

        int s = start;
        int e = end;
        char cTemp = arr[s];

        int ns = 0, ne = 0;

        // 첫 스타트가 '(' 일때
        if (cTemp == '(') {
            for (int i = s+1; i <= e; i += 2) {
                if (arr[i] == ')' && i-1 != '(') {
                    System.out.println(" ')' 찾음");
                    if(i > s+1){
                        ns = start + 1;
                        ne = i - 1;
                        return 2 * Inspection(arr, ns, ne);
                    }else{
                        ns = start+1;
                        ne = i-1;
                        System.out.println(ns + "," + ne + "시작");
                        int temp1 = 2 + Inspection(arr, ns, ne);
                        System.out.println(i+1 + "," + end + "시작");
                        int temp2 = Inspection(arr, i+1, end);
                        return temp1 + temp2;
                    }
                } else {
                    System.out.println(" ')' 못 찾음");
                }
            }
        }

        // 첫 스타트가 '[' 일때
/*        if (cTemp == '[') {
            for (int i = s+1; i <= e; i += 2) {
                if (arr[i] == ']') {
                    System.out.println(" ']' 찾음");
                    break;
                } else {
                    System.out.println(" ']' 못 찾음");
                }
            }
        }*/
        return 0;
    }


        public static void main (String[]args){
            // 문자열 입력 및 배열 선언
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            char[] C = new char[str.length()];

            // 입력받은 문자를 배열의 요소로 변환
            for (int i = 0; i < C.length; i++) {
                C[i] = str.charAt(i);
            }

            int temp = Inspection(C, 0, C.length - 1);
            System.out.println(temp);
/*      //입력값 출력 테스트
        //print(C);*/

        }
/*        private static void print ( char[] arr){
            for (char e : arr) {
                System.out.print(e + " ");
            }
        }*/
}
