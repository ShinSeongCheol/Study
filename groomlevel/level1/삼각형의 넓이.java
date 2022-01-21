import java.io.*;
import java.util.StringTokenizer;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		float w=Float.parseFloat(st.nextToken()), h=Float.parseFloat(st.nextToken());
		System.out.print(w*h/2);
	}
}