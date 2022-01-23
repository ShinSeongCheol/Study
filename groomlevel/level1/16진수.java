import java.io.*;
import java.util.Stack;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		while(input != 0){
			int remainder = input%16;
			stack.push(remainder);
			input /= 16;
		}
		
		while(!stack.empty()){
			int temp = stack.pop();
			if(temp == 10){
				System.out.print('a');
			}
			else if(temp == 11){
				System.out.print('b');
			}
			else if(temp == 12){
				System.out.print('c');
			}
			else if(temp == 13){
				System.out.print('d');
			}
			else if(temp == 14){
				System.out.print('e');
			}
			else if(temp == 15){
				System.out.print('f');
			}
			else{
				System.out.print(temp);
			}
		}
	}
}