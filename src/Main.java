import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
//		TruckPopUpService truckPopUpService = new TruckPopUpService();
//
//		List<List<Integer>> test1 = new ArrayList<List<Integer>>();
//		test1.add(Arrays.asList(1, 1, 0, 0));
//		test1.add(Arrays.asList(0, 0, 1, 0));
//		test1.add(Arrays.asList(0, 0, 0, 0));
//		test1.add(Arrays.asList(1, 0, 1, 1));
//		test1.add(Arrays.asList(1, 1, 1, 1));
//		truckPopUpService.showGrid(5, 4, test1);
//
//		List<List<Integer>> test2 = new ArrayList<List<Integer>>();
//		test2.add(Arrays.asList(1, 1, 0, 0));
//		test2.add(Arrays.asList(0, 0, 0, 0));
//		test2.add(Arrays.asList(0, 0, 1, 1));
//		test2.add(Arrays.asList(0, 0, 0, 0));
//		truckPopUpService.showGrid(4, 4, test2);
//
//		List<List<Integer>> test3 = new ArrayList<List<Integer>>();
//		test3.add(Arrays.asList(1, 0, 0, 0, 0, 0, 0));
//		test3.add(Arrays.asList(0, 1, 0, 0, 0, 0, 0));
//		test3.add(Arrays.asList(0, 0, 1, 0, 0, 0, 0));
//		test3.add(Arrays.asList(0, 0, 0, 1, 0, 0, 0));
//		test3.add(Arrays.asList(0, 0, 0, 0, 1, 0, 0));
//		test3.add(Arrays.asList(0, 0, 0, 0, 0, 1, 0));
//		test3.add(Arrays.asList(0, 0, 0, 0, 0, 0, 1));
//		truckPopUpService.showGrid(7, 7, test3);

//		int M[][] = new int[][] {
//			{1, 1, 0, 0}, 
//			{0, 0, 1, 0}, 
//			{1, 0, 0, 1}, 
//			{1, 0, 1, 1},
//			{1, 1, 1, 1}
//		};
		
//		int M[][] = new int[][] {
//			{1, 1, 0, 0}, 
//			{0, 0, 0, 0}, 
//			{0, 0, 1, 1}, 
//			{0, 0, 1, 1},
//			{0, 0, 0, 0}
//		};
		
		int M[][] = new int[][] {
			{1, 0, 0, 0, 0, 0, 0}, 
			{0, 1, 0, 0, 0, 0, 0}, 
			{0, 0, 1, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 1, 0}, 
			{0, 0, 0, 0, 0, 0, 1}
		};
		
		Islands I = new Islands();
		System.out.println("Number of islands is: " + I.countIslands(M));
	}
}

class Islands {
    // No of rows and columns 
    static final int ROW = 7, COL = 7; 
  
    // A function to check if a given cell (row, col) can 
    // be included in DFS 
    boolean isSafe(int M[][], int row, int col, 
                   boolean visited[][]) 
    { 
        // row number is in range, column number is in range 
        // and value is 1 and not yet visited 
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]); 
    } 
  
    // A utility function to do DFS for a 2D boolean matrix. 
    // It only considers the 8 neighbors as adjacent vertices 
    void DFS(int M[][], int row, int col, boolean visited[][]) 
    { 
        // These arrays are used to get row and column numbers 
        // of 8 neighbors of a given cell 
        int rowNbr[] = new int[] {1, 0, -1, 0}; 
        int colNbr[] = new int[] {0, 1, 0, -1}; 
  
        // Mark this cell as visited 
        visited[row][col] = true; 
  
        // Recur for all connected neighbours 
        for (int k = 0; k < 4; ++k) 
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) 
                DFS(M, row + rowNbr[k], col + colNbr[k], visited); 
    } 
  
    // The main function that returns count of islands in a given 
    // boolean 2D matrix 
    int countIslands(int M[][]) 
    { 
        // Make a bool array to mark visited cells. 
        // Initially all cells are unvisited 
        boolean visited[][] = new boolean[ROW][COL]; 
  
        // Initialize count as 0 and travese through the all cells 
        // of given matrix 
        int count = 0; 
        for (int i = 0; i < ROW; ++i) 
            for (int j = 0; j < COL; ++j) 
                if (M[i][j] == 1 && !visited[i][j]) // If a cell with 
                { // value 1 is not 
                    // visited yet, then new island found, Visit all 
                    // cells in this island and increment island count 
                    DFS(M, i, j, visited); 
                    ++count; 
                } 
  
        return count; 
    } 
}
