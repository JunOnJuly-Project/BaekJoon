import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String form = br.readLine();
        Stack<Character> operator = new Stack<>();
        String result = "";
        
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('(', 3);
        priority.put(')', 2);
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 0);
        priority.put('/', 0);
       
        for (int i=0;i<form.length();i++) {
        	char token = form.charAt(i);
        	
        	if (!priority.containsKey(token)) result += token;
        	else if (token=='(') operator.add(token);
        	else {
        		while (!operator.isEmpty() && priority.get(operator.peek())<=priority.get(token)) {
        			result += operator.pop();
        		}
        		
        		if (token==')') operator.pop();
        		else operator.add(token);
        	}
        }
        
        while (!operator.isEmpty()) result += operator.pop();
        
        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}