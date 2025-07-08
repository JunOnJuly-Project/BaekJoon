import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        List<Integer[]> table = new ArrayList<>();
        for (int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	table.add(new Integer[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        
        table.sort((Integer[] a, Integer[] b) -> {
        	if (a[1]!=b[1]) return a[1]-b[1];
        	else return a[0]-b[0];
        });
        
        int end = 0;
        int cnt = 0;
        for (Integer[] i : table) {
        	int s, e;
        	s = i[0];
        	e = i[1];
        	
        	if (s>=end) {
        		end = e;
        		cnt += 1;
        	}
        }
        
        bw.write(cnt+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}