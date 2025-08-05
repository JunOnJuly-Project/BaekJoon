import java.io.*;

public class Main {
	public void solution() throws Exception {
        // 입력을 위한 버퍼리더
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 위한 버퍼라이터
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        // 입력
		String s = br.readLine();
        // 결과 버퍼에 입력, String 으로 변환을 위한 + "" 
        bw.write(s.length() + "");
        // 출력
        bw.flush();
        // 입출력 버퍼 닫기
        br.close();
        bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}