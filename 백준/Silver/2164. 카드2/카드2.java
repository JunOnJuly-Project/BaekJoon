import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> cards = new LinkedList<>();
        for (int i=0;i<N;i++) cards.add(i+1);
        
        while (cards.size() != 1){
            cards.poll();
            cards.add(cards.poll());
        }
        
        bw.write(cards.poll()+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}