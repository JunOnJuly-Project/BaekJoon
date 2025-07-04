import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        String[] board = new String[N];
        for (int i=0;i<N;i++){
            board[i] = br.readLine();
        }
        
        int minCnt = 32;
        for (int i=0;i<=N-8;i++){
            for (int j=0;j<=M-8;j++){
                
                int corCnt = 0;
                for (int ii=0;ii<8;ii++){
                    for (int jj=0;jj<8;jj++){
                        if (board[i+ii].charAt(j+jj) == "WB".charAt((ii+jj)%2)){
                            corCnt += 1;
                        }
                    }
                }
                
                corCnt = corCnt<32 ? corCnt : 64-corCnt;
                minCnt = corCnt<minCnt ? corCnt : minCnt;
            }
        }
        
        bw.write(minCnt+"");
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}