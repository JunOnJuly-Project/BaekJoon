import java.io.*;
import java.util.*;

public class Main {
	private boolean isModThree(int num) {
		return num % 3 == 0;
	}
	
	private boolean isModFive(int num) {
		return num % 5 == 0;
	}
	
	public void solution() throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int targetNum = 0;
		
		for (int i = 3; i >= 1; i--) {
			String str = br.readLine();
			
			if (str.contains("Fizz") || str.contains("Buzz")) {
				continue;
			}
			else {
				targetNum = Integer.parseInt(str) + i;
			}
		}
		
		if (isModThree(targetNum) && isModFive(targetNum)) {
			bw.write("FizzBuzz");
		}
		else if (isModThree(targetNum)) {
			bw.write("Fizz");
		}
		else if (isModFive(targetNum)) {
			bw.write("Buzz");
		}
		else {
			bw.write(targetNum + "");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}