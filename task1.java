import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class task1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

			if(args.length > 0) {
				
				//set default delimiter
				char delimiter = '-';
				File file = null;
			
				
				//check each argument for the delimiter flag
				  for(int arg = 0; arg < args.length; arg++) {
			            
					  if(args[arg].contains("-d")) {
						  
						  //if found - set the delimiter value to the following command line argument
						  delimiter = args[arg+1].replaceAll("\"", "").charAt(0);
  
					  } 
					  
					  //if the file argument hasn't yet been identified, check if the argument is a file
					 if(file == null) {
						  
						 //create a temporary file object from the argument
						  File tempFile = new File(args[arg]);
						  
						  //check if temporary file exists
						  if(tempFile.exists()) {
							  
							  //declare the correct argument as the file to be read in the application
							  file = tempFile;
							  tempFile = null;
						  }
						  
						  
					  }
				  }	  
					
				
					 //Create the scanner object to read the file 						
					  Scanner sc = new Scanner(file);
					  
					  //An Array list storing the lines of content in the file
					  ArrayList<String> lines = new ArrayList<>();
				
					  //If there is another line, add it to the array list
					  while (sc.hasNextLine()) {
								
						  lines.add(sc.nextLine());
					  }

					  for(int i=0; i<lines.size(); i++) {
						  
						  //split up the tokens in each line into an array
						  String line = lines.get(i);
						  String[] tokens = line.split(" ");
						  
						  //create a line break based on the length of the full line
						  String brk = line;
						  brk = brk.replace('.', delimiter).replace(' ', delimiter);
					
						  //print first line and break
						  System.out.println(line);
						  System.out.println(brk);
						  
						  //print the tokens on new lines
						  for(int j=0; j<tokens.length; j++) {
						
							tokens[j] = tokens[j].replaceAll("\"","");
							System.out.println(tokens[j]);
						
						  }
						  
						  //create a line break for the next line of content in the file
						  System.out.println(" ");
				
					  }
			
				  }
			}
	}


