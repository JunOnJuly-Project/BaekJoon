import java.io.*;
import java.util.*;


public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        Set<String> s = new HashSet<String>();
        Set<String> h = new HashSet<String>();
        
        st = new StringTokenizer(br.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i=0;i<N;i++) s.add(br.readLine());
        for (int i=0;i<M;i++) h.add(br.readLine());
        
        s.retainAll(h);
        bw.write(s.size() + "\n");
        
        List<String> sl = new ArrayList<>(s);
        sl.sort(Comparator.naturalOrder());
        for (String str : sl) bw.write(str + "\n");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}