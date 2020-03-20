import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class Sort{
	public static void sortArrays(String line){
		String[] semicolon_split = line.split(";");
		String[] s1 = semicolon_split[0].split(",");
		String[] s2 = semicolon_split[1].split(",");
		String[] s3 = new String[s1.length + s2.length];

		int comp = 0, i = 0, j = 0, k = 0;

		//Compare current elements of both arrays, add the smaller one
		while(i < s1.length && j < s2.length){
			comp = s1[i].compareTo(s2[j]);
			if(comp < 0){
				s3[k] = s1[i];
				k++;
				i++;
			}
			else{
				s3[k] = s2[j];
				k++;
				j++;
			}
		}

		//Add remaining elements of array1
		while(i < s1.length){
			s3[k] = s1[i];
			k++;
			i++;
		}

		//Add remaining elements of array2
		while(j < s2.length){
			s3[k] = s2[j];
			k++;
			j++;
		}

		//Print out sorted array
		for(int h = 0; h < s3.length; h++){
			System.out.print(s3[h] + " ");
		}
		System.out.println();
	}

	public static void main (String[] args)  { 
    	String filename = args[0];

    	try {
    		File myObj = new File(filename);
    		Scanner myReader = new Scanner(myObj);
    		while (myReader.hasNextLine()) {
        		String data = myReader.nextLine();
        		sortArrays(data);
      		}
    		myReader.close();
    	} catch (FileNotFoundException e) {
      		System.out.println("File not found.");
    	}
    }
}