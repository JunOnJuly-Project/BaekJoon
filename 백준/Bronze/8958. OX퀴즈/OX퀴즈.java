import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int result = 0;
            
            String str = br.readLine();
            
            int cnt = 0;
            for (int j = 0; j < str.length(); j++){
                if (str.charAt(j) == 'O') {
                    result += ++ cnt;
                }
                
                else {
                    cnt = 0;
                }
            }
            
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}