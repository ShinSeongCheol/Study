import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int price = 1000-Integer.parseInt(input);
		int array[] = new int[4];
		
		while(price!=0){
			if(price>=500){
				price -= 500;
				array[0]++;
			}else if(price<500 && price>=100){
				price -= 100;
				array[1]++;
			}else if(price<100 && price>=50){
				price -= 50;
				array[2]++;
			}else if(price<50 && price>=10){
				price -= 10;
				array[3]++;
			}
		}
		
		for(int i : array){
			System.out.print(i + " ");
		}
	}
}