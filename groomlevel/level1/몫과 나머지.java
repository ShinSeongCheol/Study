import java.io.*;
import java.util.StringTokenizer;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		int num1 = Integer.parseInt(st.nextToken()), num2 = Integer.parseInt(st.nextToken());
		
		System.out.print(num1/num2 + " " + num1%num2);
	}
}