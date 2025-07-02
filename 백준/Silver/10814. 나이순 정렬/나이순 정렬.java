import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        List<List<String>> mem = new ArrayList<>();
        for (int i = 0; i < 201; i++) {
            mem.add(new ArrayList<>());
        }
        
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            
            mem.get(age).add(name);
        }
        
        for (int i=0;i<201;i++){
            for (String name : mem.get(i)) bw.write(String.format("%d %s\n", i, name));
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}