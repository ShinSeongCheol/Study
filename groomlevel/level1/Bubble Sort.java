import java.io.*;
import java.util.StringTokenizer;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int size = Integer.parseInt(input);
		input = br.readLine();
		int array[] = new int[size];
		StringTokenizer st = new StringTokenizer(input, " ");
		
		for(int i=0; i<size; i++){
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array.length-1; j++){
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		
		for(int i : array){
			System.out.print(i + " ");
		}
	}
}