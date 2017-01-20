import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CSV {

	private String[][] data;

	public CSV(int linesSkip, String filename) throws IOException {
		Scanner in = null, In = null;
		int length = 0, width = 0;
		String input = "";

		try {
			in = new Scanner(new BufferedReader(new FileReader(filename)));
			in.useDelimiter(",");
			while (in.hasNextLine()) {
				input = in.nextLine();
				width++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		String[] inArray = input.split(",");
		length = inArray.length;
		System.out.println(width + " " + length);
		String[][] data = new String[width + 100][length];
		int row = 0;
		try {
			In = new Scanner(new BufferedReader(new FileReader(filename)));
			while (In.hasNextLine()) {
				input = In.nextLine();
				String[] arr = input.split(",");
				for (int i = 0; i < arr.length; i++) {
					data[row][i] = (arr[i]);
				}
				row++;
			}
		} catch (Exception e) {
			System.out.println("Second Block!");
		}
		this.data = data;
	}
	public String getOne(int row, int col){
		return this.data[row][col];
	}
	public String[]getRow(int row){
		String[] out= new String[this.data.length];
		for(int i = 0; i<data[0].length; i++){
			out[i]= this.getOne(row,i);
			System.out.println(out[i]);		
		}
		return out;
	}
	public static void main(String[] args) throws IOException {
		CSV test = new CSV(0, "Test.txt");
		String [] rowOne=test.getRow(0);
		System.out.println(rowOne.length);		
		for(int i = 0; i<rowOne.length; i++){
			System.out.println(rowOne[i]);		
		}
	}
}