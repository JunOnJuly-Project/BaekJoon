import java.io.*;
import java.util.*;


public class Main {
	public boolean isAllFill(int[][] map) throws Exception{
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				if (map[i][j]==0) return false;
			}
		}
		
		return true;
	}

	
	public boolean[] makeCandid(int[][] map, int i, int j) {
		boolean[] candid = new boolean[9];
		for (int k=0;k<9;k++) if (j!=k && map[i][k]!=0) candid[map[i][k]-1] = true; 
		for (int k=0;k<9;k++) if (i!=k && map[k][j]!=0) candid[map[k][j]-1] = true; 
		for (int k=i/3*3;k<i/3*3+3;k++) for (int l=j/3*3;l<j/3*3+3;l++) if (i!=k && j!=l && map[k][l]!=0) candid[map[k][l]-1] = true;
		
		return candid;
	}
	

	
	public boolean hasCandid(boolean candid[]) {
		for (int i=0;i<9;i++) if (!candid[i]) return true;
		
		return false;
	}
	
	
	public void sudoku(int[][] map) throws Exception {
		if (isAllFill(map)) return;
		
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				if (map[i][j]==0) {
					boolean[] candid = makeCandid(map, i, j);
					
					if (!hasCandid(candid)) return;
					
					for (int k=0;k<9;k++) {
						if (!candid[k]) {
							map[i][j] = k+1;
							sudoku(map);
							
							if (isAllFill(map)) return;
							candid[k] = true;
						}
					}
					
					map[i][j] = 0;
					return;
				}
			}
		}
	}
	
	
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[][] map = new int[9][9];
        int[][][] candid = new int[9][9][9];
        for (int i=0;i<9;i++) {
        	String num = br.readLine();
        	for (int j=0;j<9;j++) {
        		map[i][j] = num.charAt(j)-'0';
        	}
        }
        
        sudoku(map);
        
        for (int i=0;i<9;i++) {
        	for (int j=0;j<9;j++) {
        		bw.write(map[i][j]+"");
        	}
        	bw.write("\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}