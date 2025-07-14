import java.io.*;
import java.util.*;


public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Set<Integer> nums = new HashSet<>();
        for (int i=0;i<10;i++){
            nums.add(Integer.parseInt(br.readLine())%42);
        }
        
        bw.write(nums.size()+"");
        br.close();
        bw.flush();
        bw.close();
	}
    
    
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}