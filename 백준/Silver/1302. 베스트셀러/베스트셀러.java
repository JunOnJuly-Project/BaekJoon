import java.io.*;
import java.util.*;

public class Main {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Set<String> bookNames = new HashSet<>();
		Map<String, Integer> bookSoldCount = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String book = br.readLine();
			bookSoldCount.put(
					book, 
					bookSoldCount.getOrDefault(book, 0) + 1
			);
			
			bookNames.add(book);
		}
		
		List<String> bookNamesList = new ArrayList<>(bookNames);
		bookNamesList.sort((a, b) -> {
			int aCnt = bookSoldCount.get(a);
			int bCnt = bookSoldCount.get(b);
			
			return aCnt == bCnt ?
					a.compareTo(b) :
					bCnt - aCnt;
		});
		
		bw.write(bookNamesList.get(0));
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}