import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int N = Integer.parseInt(br.readLine());
        Set<String> sts = new HashSet<String>();
        for (int i=0;i<N;i++){
            sts.add(br.readLine());
        }
        
        String[] sta = sts.toArray(new String[0]);
        Arrays.sort(sta, (a, b) -> {
            if (a.length() != b.length()) return a.length() - b.length();
            else return a.compareTo(b);
        });
            
        for (String s : sta) bw.write(s + "\n");
        br.close();
        
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}