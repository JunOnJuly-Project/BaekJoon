import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        List<Set<Integer>> topol = new ArrayList<>();
        for (int i=0;i<N+1;i++) topol.add(new HashSet<>());
        
        List<List<Integer>> tree = new ArrayList<>();
        for (int i=0;i<N+1;i++) tree.add(new ArrayList<>());
        
        for (int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int A, B;
        	A = Integer.parseInt(st.nextToken());
        	B = Integer.parseInt(st.nextToken());
        	
        	topol.get(B).add(A);
        	tree.get(A).add(B);
        }
        
        Deque<Integer> dq = new LinkedList<>();
        for (int i=1;i<N+1;i++) if (topol.get(i).isEmpty()) dq.addLast(i);
        while (!dq.isEmpty()) {
        	int curChild = dq.pollFirst();
        	bw.write(curChild + " ");
        	
        	for (int nextChild : tree.get(curChild)) {
        		topol.get(nextChild).remove(curChild);
        		
        		if (topol.get(nextChild).isEmpty()) dq.addLast(nextChild);
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