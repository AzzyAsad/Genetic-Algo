import java.util.ArrayList;
import java.util.Random;

public class XYZ {
	
	int[][]board;
	int n;
	ArrayList<int[][]> keepBoards;
	ArrayList<Integer> fitness;
	
	public  XYZ(int n) {
		this.n = n;
		keepBoards = new ArrayList<int[][]>();
		fitness = new ArrayList<Integer>();
		generateInitialPopulataion();		
	}
	
	private void generateInitialPopulataion() {
		Random r = new Random();
		int check = 0;
		while(check<n){
			board = new int[n][n];
			int row = 0;
			for(int i=0;i<n;i++){
				int ranNum = r.nextInt(n-1);
				board[row][ranNum] = 1;
				row++;
			}
			keepBoards.add(board);
			check++;
		}
		for (int[][] value : keepBoards) {
			System.out.println("---------------------------------------------------------------------------------------------");
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					System.out.print(value[i][j]+"  ");
				}
				System.out.println();
			}
		}
		getFitness();
	}
	
	private void getFitness(){
		for(int i=0;i<n;i++){
			int counter = 0;
			int[][] toBeChecked = keepBoards.get(i);
			int row = 0;
			for(int j=0;j<n;j++){
				if(toBeChecked[row][j] == 1){
					for(int k=row+1;k<n;k++){
						if(toBeChecked[k][j] == 1){
							counter++;
						}
					}
				}
				row++;
			}
			fitness.add(counter);
		}
		for (int i=0;i<n;i++) {
			int val = fitness.get(i);
			System.out.println(val);
			
		}
	}
}
