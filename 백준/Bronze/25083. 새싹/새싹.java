import java.io.*;
import java.util.*;

public class Main{
    public void solution() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        bw.write("         ,r\'\"7\n");
        bw.write("r`-_   ,\'  ,/\n");
        bw.write(" \\. \". L_r\'\n");
        bw.write("   `~\\/\n");
        bw.write("      |\n");
        bw.write("      |\n");
        
        bw.flush();
        bw.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}