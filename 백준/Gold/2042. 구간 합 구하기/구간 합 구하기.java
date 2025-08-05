import java.util.*;
import java.io.*;

class SegTree {
	private long[] tree;
	private long[] segtree;
	
	public SegTree(long[] tree) {
		this.tree = tree;
		this.segtree = new long[tree.length * 4];
		initTree(1,  0, tree.length - 1);
	}
	
	public long initTree(int index, int left, int right) {
		if (left == right) {
			segtree[index] = tree[left];
			return segtree[index];
		}
		
		int center = (left + right) / 2;
		segtree[index] = initTree(index * 2, left, center) + initTree(index * 2 + 1, center + 1, right);
		
		return segtree[index];
	}
	
	public long changeTree(int index, int start, int end, long changeIdx, long changeNum) {
		int half = (start + end) / 2;
		long changeValue = 0;
		
		if (start == changeIdx && end == changeIdx) {
			long preValue = segtree[index];
			segtree[index] = changeNum;
			
			return segtree[index] - preValue;
		}
		
		if (changeIdx <= half) {
			changeValue += changeTree(index * 2, start, half, changeIdx, changeNum);
			segtree[index] += changeValue;
		}
		
		else {
			changeValue += changeTree(index * 2 + 1, half + 1, end, changeIdx, changeNum);
			segtree[index] += changeValue;
		}
		
		return changeValue;
	}
	
	public long subsumTree(int index, int start, int end, long left, long right) {
		long result = 0;
		
		int half = (start + end) / 2;
		
		if (left == start && right == end) {
			return segtree[index];
		}
		
		else if (left <= half && right > half) {
			result += subsumTree(index * 2, start, half , left, half);
			result += subsumTree(index * 2 + 1, half + 1 , end, half + 1, right);
		}
		
		else if (left <= half) {
			result += subsumTree(index * 2, start, half , left, right);
		}
		
		else {
			result += subsumTree(index * 2 + 1, half + 1 , end, left, right);
		}
		
		return result;
	}
}

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M, K;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		long[] nums = new long[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		
		long[][] queries = new long[M+K][3];
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			queries[i] = new long[] {
					Long.parseLong(st.nextToken()),
					Long.parseLong(st.nextToken()),
					Long.parseLong(st.nextToken())
			};
		}
		
		SegTree segtree = new SegTree(nums);
		
		for (long[] query : queries) {
			if (query[0] == 1) {
				segtree.changeTree(1, 0, nums.length-1, query[1]-1, query[2]);
			}
			
			else {
				bw.write(segtree.subsumTree(1, 0, nums.length-1, query[1]-1, query[2]-1)+ "\n");
			}
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}