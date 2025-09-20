import java.io.*;
import java.util.*;

public class Main {
	boolean isAllModUnique(int[] ids, int div) {
		Set<Integer> mods = new HashSet<>();
		for (int id : ids) {		
			if (mods.add(id % div) == false) {
				return false;
			}
		}
		
		return true;
	}
	
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	int G = Integer.parseInt(br.readLine());
        	int[] ids = new int[G];
        	for (int j = 0; j < G; j++) {
        		ids[j] = Integer.parseInt(br.readLine());
        	}
        	
        	int div = 1;
        	while (isAllModUnique(ids, div) == false) {
    			div += 1;
        	}
        	
        	bw.write(div + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}