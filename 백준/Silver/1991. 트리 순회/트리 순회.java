import java.io.*;
import java.util.*;


public class Main {
	public String preOrder(Map<Character, char[]> tree, char now) throws Exception {
		String result = "";
		
		result += now;
		
		char left = tree.get(now)[0];
		if (left!='.') {
			result += preOrder(tree, left);
		}

		char right = tree.get(now)[1];
		if (right!='.') {
			result += preOrder(tree, right);
		}
		
		return result;
	}
	
	
	public String inOrder(Map<Character, char[]> tree, char now) throws Exception {
		String result = "";
		
		char left = tree.get(now)[0];
		if (left!='.') {
			result += inOrder(tree, left);
		}
		
		result += now;

		char right = tree.get(now)[1];
		if (right!='.') {
			result += inOrder(tree, right);
		}
		
		return result;
	}
	
	
	public String postOrder(Map<Character, char[]> tree, char now) throws Exception {
		String result = "";
		
		char left = tree.get(now)[0];
		if (left!='.') {
			result += postOrder(tree, left);
		}

		char right = tree.get(now)[1];
		if (right!='.') {
			result += postOrder(tree, right);
		}
		
		result += now;
		
		return result;
	}
	
	
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        Map<Character, char[]> tree = new HashMap<>();
        for (int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	char now = st.nextToken().charAt(0);
        	char left = st.nextToken().charAt(0);
        	char right = st.nextToken().charAt(0);

        	tree.put(now, new char[] {left, right});
        }
        
        char root = 'A';
        bw.write(preOrder(tree, root) + "\n");
        bw.write(inOrder(tree, root) + "\n");
        bw.write(postOrder(tree, root) + "\n");
        				
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}