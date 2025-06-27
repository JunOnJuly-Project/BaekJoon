import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[3];
		for (int i=0;i<3;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		if (nums[0] == nums[1] && nums[1] == nums[2]) {
			System.out.println(nums[0] * 1000 + 10000);
		}
		else if (nums[0] == nums[1] || nums[1] == nums[2]) {
			System.out.println(nums[1] * 100 + 1000);
		}
		else if (nums[0] == nums[2]) {
			System.out.println(nums[0] * 100 + 1000);
		}
		else {
			System.out.println(Arrays.stream(nums).max().getAsInt() * 100);
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}