import java.io.*;
import java.util.*;

public class Main {
	String popAll(Deque<Character> stack, boolean dir) {
		StringBuffer resultSb = new StringBuffer();
		
		while(stack.isEmpty() == false) {
			int idx = dir ? 0 : resultSb.length();
			
			resultSb.insert(idx, stack.pop());
		}
		
		return resultSb.toString();
	}
	
	public void solution() throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer resultSb = new StringBuffer();
		
		String S = br.readLine();
		int SLen = S.length();
		
		Deque<Character> stack = new LinkedList<>();
		boolean inBracket = false;
		for (int i = 0; i < SLen; i++) {
			char c = S.charAt(i);
			
			if (c == '<') {
				resultSb.append(popAll(stack, false));
				stack.push(c);
				inBracket = true;
			}
			
			else if (c == '>') {
				stack.push(c);
				resultSb.append(popAll(stack, true));
				inBracket = false;
			}
			
			else if (c == ' ' && inBracket == false) {
				resultSb.append(popAll(stack, false));
				resultSb.append(c);
			}
			
			else {
				stack.push(c);
			}
		}
		
		resultSb.append(popAll(stack, false));
		
		bw.write(resultSb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}