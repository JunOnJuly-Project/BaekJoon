import java.util.*;
import java.io.*;

public class Main {
    // 문장의 유효성 검사 메서드
	public boolean isBalanced(String line) throws Exception {
		// 스택
    	Deque<Character> stk = new LinkedList<>();
    	// 순서대로 삽입
    	for (int i = 0; i < line.length(); i++) {
    		// 해당하는 문자
    		char c = line.charAt(i);
    		// 좌측 괄호일 때
    		if (c == '(' || c == '[') {
    			stk.addLast(c);
    		}
    		
    		// 우측 괄호일 때
    		else if (c == ')') {
    			// 스택에 저장된 마지막 문자가 ( 이면 우선 패스
    			if (stk.isEmpty() != true && stk.pollLast() == '(') {
    				continue;
    			}
    			// 다른 문자면 균형잡힌 문자열이 아님
    			else {
    				return false;
    			}
    		}
    		
    		else if (c == ']') {
    			// 스택에 저장된 마지막 문자가 [ 이면 우선 패스
    			if (stk.isEmpty() != true && stk.pollLast() == '[') {
    				continue;
    			}
    			// 다른 문자면 균형잡힌 문자열이 아님
    			else {
    				return false;
    			}
    		}
    	}
    	
    	// 다 돌고 스택에 남은 원소가 없으면 균형잡힌 문자열
    	if (stk.isEmpty()) {
    		return true;
    	}
    	// 있으면 균형잡힌 문자열 아님
    	else {
    		return false;
    	}
	}
	
	public void solution() throws Exception {
		// 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String line;
        
        while ((line = br.readLine()).equals(".") != true) {
            // 메서드 호출
        	if (isBalanced(line)) {
        		bw.write("yes\n");
        	}
        	
        	else {
        		bw.write("no\n");
        	}
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}