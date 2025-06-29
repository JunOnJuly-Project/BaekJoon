import java.io.*;

import java.util.StringTokenizer;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a,b;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            bw.write(a+b+"\n");
        }
        br.close();

        bw.flush();
        bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}