import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int t=0;t<T;t++) {
        	st = new StringTokenizer(br.readLine());
        	int N, K;
        	N = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	        	
        	int[] time = new int[N+1];
        	st = new StringTokenizer(br.readLine());
        	for (int i=1;i<N+1;i++) time[i] = Integer.parseInt(st.nextToken());
        	        	
        	List<Set<Integer>> topol = new ArrayList<>();
        	for (int i=0;i<N+1;i++) topol.add(new HashSet<>()); 
        	
        	List<List<Integer>> tree = new ArrayList<>();
        	for (int i=0;i<N+1;i++) tree.add(new ArrayList<>()); 
        	
        	for (int i=0;i<K;i++) {
        		st = new StringTokenizer(br.readLine());
        		int X, Y;
        		X = Integer.parseInt(st.nextToken());
        		Y = Integer.parseInt(st.nextToken());
        		
        		topol.get(Y).add(X);
        		tree.get(X).add(Y);
        	}
        	
        	int W = Integer.parseInt(br.readLine());
        	
        	int[] minTime = new int[N+1];
        	PriorityQueue<Integer[]> dq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        	for (int i=1;i<N+1;i++) {
        		if (topol.get(i).isEmpty()) dq.add(new Integer[] {i, time[i]});
        	}
        	
        	while (!dq.isEmpty()) {
        		Integer[] cur = dq.poll();
        		Integer curBuild = cur[0];
        		Integer curTime = cur[1];
        		
        		minTime[curBuild] = curTime;
        		
        		for (Integer nextBuild : tree.get(curBuild)) {
        			topol.get(nextBuild).remove(curBuild);
        			if (topol.get(nextBuild).isEmpty()) {
        				dq.add(new Integer[] {nextBuild, curTime+time[nextBuild]});
        			}
        		}
        	}
        	
        	bw.write(minTime[W] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}