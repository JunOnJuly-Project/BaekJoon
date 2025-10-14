import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String state = br.readLine();
		int stateLen = state.length();
		boolean[] stateArr = new boolean[stateLen];
		for (int i = 0; i < stateLen; i++) {
			stateArr[i] = state.charAt(i) == 'Y' ? true : false;
		}
		
		int cnt = 0;
		for (int i = 0; i < stateLen; i++) {
			if (stateArr[i]) {
				for (int j = i + 1; j < stateLen + 1; j += i + 1) {
					stateArr[j - 1] = !stateArr[j - 1];
				}
			cnt += 1;
			}
		}
		
		bw.write(cnt + "");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}