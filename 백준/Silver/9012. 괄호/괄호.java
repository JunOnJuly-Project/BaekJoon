import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        for (int i=0;i<N;i++){
            String st = br.readLine();
            Stack<Character> stk = new Stack<>();
            String result = "";
            for (int j=0;j<st.length();j++){
                char c = st.charAt(j);
                if (c == '(') stk.push(c);
                else{
                    if (stk.empty()){
                        result = "NO";
                        break;
                    } 
                    else stk.pop();
                }
            }
            
            result = result != "" ? result : stk.empty() ? "YES" : "NO";
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