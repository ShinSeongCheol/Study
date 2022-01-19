import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		for(int i=0; i<Integer.parseInt(input); i++)
			System.out.println("Hello Goorm !");
	}
}