package codes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CCCJ5S2 {

	//Based on Mr. Chow's code
	
	public static void main(String[] args)throws Exception {

		InputStreamReader keyboard = new InputStreamReader(System.in);
		BufferedReader input= new BufferedReader(keyboard);
		int M = Integer.parseInt(input.readLine());
		int N = Integer.parseInt(input.readLine());
		
		int target = M*N;

		int [][] array = new int[M+1][N+1], visitedArray = new int [M+1][N+1], possibleArray = new int [M*N][2];
		
		possibleArray[0][0] = 1;
		possibleArray[0][1] = 1;
		visitedArray[1][1] = 1;
		
		int fIndex = 0, sIndex = 0; //index of factor and search
		boolean possible = false;

		//Manually population of the array
		for(int i = 1; i <= M; i++){
			
			String[] inputArray = input.readLine().split(" ");
			
			for(int j = 1; j <= N; j++)
				array[i][j] = Integer.parseInt(inputArray[j-1]);
			
		}
		
		do {

			int number = array[possibleArray[sIndex][0]][possibleArray[sIndex][1]];
			
			for(int factor = 1; factor <= Math.sqrt(number); factor++){
				
				if(number%factor == 0){
					
					if(number/factor <= M && factor <= N && visitedArray[number/factor][factor] == 0){
						
							fIndex++;
							possibleArray[fIndex][0] = number/factor;
							possibleArray[fIndex][1] = factor;
							visitedArray[number/factor][factor] = 1;
							
					}
					
					if(number/factor <= N && factor <=M && visitedArray[factor][number/factor] == 0){
						
							fIndex++;
							possibleArray[fIndex][0] = factor;
							possibleArray[fIndex][1] = number/factor;
							visitedArray[factor][number/factor] = 1;
							
					}
				}
			}
			
			if(number == target){
				
				possible=true;
				System.out.println("yes");
				break;
				
			}
			
			sIndex++;
			
		} while(sIndex <= fIndex);
		
		if(!possible)
			System.out.println("no");
	}

}