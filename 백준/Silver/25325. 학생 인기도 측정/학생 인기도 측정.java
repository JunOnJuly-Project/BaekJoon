import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		String[] names = new String[n];
		Map<String, Integer> students = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			String student = st.nextToken();
			students.put(student, 0);
			names[i] = student;
		}
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			while (st.hasMoreTokens()) {
				String student = st.nextToken();
				students.put(student, students.get(student) + 1);
			}
		}
		
		Arrays.sort(names, (a, b) -> {
			int aCnt = students.get(a);
			int bCnt = students.get(b);
			
			return aCnt == bCnt ?
					a.compareTo(b) : bCnt - aCnt;
		});
		
		for (String name : names) {
			bw.write(String.format("%s %d\n", name, students.get(name)));
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}