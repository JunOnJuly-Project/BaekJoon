import java.io.*;
import java.util.*;

public class Main {	
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int nA, nB;
        nA = Integer.parseInt(st.nextToken());
        nB = Integer.parseInt(st.nextToken());
        
        Set<Integer> setA = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++) {
        	setA.add(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
        	setA.remove(Integer.parseInt(st.nextToken()));
        }
        
        List<Integer> listA = new ArrayList<>(setA);
        listA.sort(null);
        
        bw.write(setA.size() + "\n");
        for (int num : listA) {
        	bw.write(num + " ");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}