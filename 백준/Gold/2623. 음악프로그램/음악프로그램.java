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
        
        List<Set<Integer>> tree = new ArrayList<>();
        for (int i=0;i<N+1;i++) tree.add(new HashSet<>());
        
        for (int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	List<Integer> subTopol = new ArrayList<>();
        	while (st.hasMoreTokens()) subTopol.add(Integer.parseInt(st.nextToken()));
        	for (int j=1;j<subTopol.size()-1;j++) {
        		int A, B;
        		A = subTopol.get(j);
        		B = subTopol.get(j+1);
        		
        		topol.get(B).add(A);
        		tree.get(A).add(B);   		
        	}
        }
        
        List<Integer> line = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        for (int i=1;i<N+1;i++) if (topol.get(i).isEmpty()) dq.addLast(i);
        while (!dq.isEmpty()) {
        	int curChild = dq.pollFirst();
        	line.add(curChild);
        	
        	for (int nextChild : tree.get(curChild)) {
        		topol.get(nextChild).remove(curChild);
        		
        		if (topol.get(nextChild).isEmpty()) dq.addLast(nextChild);
        	}
        }
        
        if (line.size()==N) for (int l : line) bw.write(l + "\n");
        else bw.write(0+"");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}