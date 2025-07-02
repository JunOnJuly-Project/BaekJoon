import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuffer sb;
        while (true){
            String s = br.readLine();
            if (s.equals("0")) break;
            
            sb = new StringBuffer(s);
            String rs = sb.reverse().toString();
            
            String result = s.equals(rs) ? "yes" : "no";
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