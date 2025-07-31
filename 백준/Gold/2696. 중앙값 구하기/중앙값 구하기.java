import java.util.*;
import java.io.*;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0;t<T;t++) {
			int M = Integer.parseInt(br.readLine());
			int[] results = new int[(M+1)/2];
			
			PriorityQueue<Integer> pqLeft = new PriorityQueue<Integer>((a, b) -> b-a);
			PriorityQueue<Integer> pqRight = new PriorityQueue<Integer>((a, b) -> a-b);
			
			for (int i=0;i<=M/10;i++) {
				st = new StringTokenizer(br.readLine()); 
				for (int j=0;j<(10*(i+1)<=M ? 10 : M%10);j++) {
					int N = Integer.parseInt(st.nextToken());
					
					if (j%2==0) pqLeft.add(N);
					else pqRight.add(N);
					
					if (!pqRight.isEmpty() && !pqLeft.isEmpty()) {
						if (pqRight.peek()<pqLeft.peek()) {
							int peekLeft = pqLeft.poll();
							int peekRIght = pqRight.poll();
							
							pqLeft.add(peekRIght);
							pqRight.add(peekLeft);
						}
					}
					
					if (j%2==0) results[(10*i+j+1)/2] = pqLeft.peek();
				}
				
			}
			
			bw.write(results.length + "\n");
			
			int rl = results.length;
			for (int i=0;i<=rl/10;i++) {
				int j=0;
				for (j=0;j<(10*(i+1)<=rl ? 10 : rl%10);j++) {
					bw.write(results[10*i+j] + " ");
				}
				
				if  (j!=0) bw.write("\n");
			}
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}