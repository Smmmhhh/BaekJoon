import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baek_22233_가희와키워드 {
    public static void main(String[] args) throws IOException{

        // 키워드 개수 N, 블로그에 쓴 글의개수 M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 키워드를 HashSet에 넣어주기
        HashSet<String> keyWord = new HashSet<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            keyWord.add(st.nextToken());
        }

        // 블로그 작성글 수 만큼 키워드 찾기
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            String str = br.readLine();                // 블로그 키워드 str으로 입력받기
            String[] writing = str.split(",");  //입력받은 str을 "," 를 기준으로 나누기
            int result = solution(keyWord, writing);    // HashMap Size를  result 변수에 담아주기
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    private static int solution(HashSet<String> keyword, String[] writing){
        //writing 배열의 갯수만큼 반복해야함
        for (String s : writing)  keyword.remove(s);   // 사용된 블로그의 키워드는 메모장에서 삭제
        return keyword.size();
    }
}
