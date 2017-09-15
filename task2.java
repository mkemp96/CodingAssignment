import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;
import org.apache.commons.io.*;



public class task2 {

	public static void main(String[] args) throws IOException {
		
		
		//Declare and initialize the source and destination paths from the command line arguments
		Path src = Paths.get(args[0]);
		Path dest = Paths.get(args[1]);
		
		//declare the file extension variable
		String exc= null;
		
		//check if file extension constraint is present, if so attach to exception variable
		if(args.length == 3) {
			
			exc = args[2].toString();
		}
		
		//error handling - if error with part of the directory, application doesn't fail
		try {
			
			//copy the contents of the source directory, with a filter
		    FileUtils.copyDirectory(src, dest, new FileFilter() {
		    	
		    	//function to determine whether to accept file/directories being filtered
		    	 public boolean accept(File pathname) {
		    	      
		    	String name = pathname.getName();
		    		  
				//check if a file extension exception has been declared
		    	if(exc != null) {
		    		  
		    		//if file is of the declared exception, return false
		    	    return !(name.endsWith(exc) && pathname.isDirectory());
		    	        
		    	}
		    	else {
		    			  
					return true;
		    	}
		    	}
		    	
		    }, true);
		    
		    //print data on the nature if error is returned when attempting to copy contents of the path to destination
		} catch (IOException e) {
			
		    e.printStackTrace();
		}
		

	}

}
