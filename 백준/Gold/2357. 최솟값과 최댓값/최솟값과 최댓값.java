import java.util.*;
import java.io.*;

class SegTree {
	private int[] tree;
	private int[][] segtree;
	
	public SegTree(int[] tree) {
		this.tree = tree;
		this.segtree = new int[tree.length * 4][2];
		initTree(1,  0, tree.length - 1);
	}
	
	public int[] initTree(int index, int left, int right) {
		if (left == right) {
			segtree[index] = new int [] {tree[left], tree[left]};
			return segtree[index];
		}
		
		int center = (left + right) / 2;
		
		int[] leftNode = initTree(index * 2, left, center);
		int[] rightNode = initTree(index * 2 + 1, center + 1, right);
		segtree[index] = new int[] {
				Math.max(leftNode[0], rightNode[0]),
				Math.min(leftNode[1], rightNode[1])
				};
		
		return segtree[index];
	}
	
	public int[] subTree(int index, int start, int end, long left, long right) {
		int[] result = new int[2];
		
		int half = (start + end) / 2;
		
		if (left == start && right == end) {
			return segtree[index];
		}
		
		else if (left <= half && right > half) {
			int[] leftNode =  subTree(index * 2, start, half , left, half);
			int[] rightNode = subTree(index * 2 + 1, half + 1 , end, half + 1, right);
			
			result[0] = Math.max(leftNode[0], rightNode[0]);
			result[1] = Math.min(leftNode[1], rightNode[1]);
		}
		
		else if (left <= half) {
			result = subTree(index * 2, start, half , left, right);
		}
		
		else {
			result = subTree(index * 2 + 1, half + 1 , end, left, right);
		}
		
		return result;
	}
}

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[N];
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}
		
		SegTree segTree = new SegTree(tree);
		
		for (int i = 0; i < M; i++) {
			int a, b;
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			int[] maxMin = segTree.subTree(1, 0, tree.length-1, a-1, b-1);
			
			bw.write(maxMin[1] + " " + maxMin[0] + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}