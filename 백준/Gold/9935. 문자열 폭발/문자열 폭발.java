import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String from = br.readLine();
		int fromLen = from.length();
		
		String target = br.readLine();
		int targetLen = target.length();
		
		for (int i = 0; i < fromLen; i++) {
			sb.append(from.charAt(i));
			int sbLen = sb.length();
			int searchStartIdx = sbLen - targetLen;
			
			if (sbLen >= targetLen && sb.substring(searchStartIdx).equals(target)) {
				sb.delete(searchStartIdx, sbLen + 1);
			}
		}
		
		bw.write(sb.length() == 0 ? "FRULA" : sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}