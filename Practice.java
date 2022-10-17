package Example;

	
	import java.io.File;
	import java.io.IOException;
	import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

	public class Practice {
	    static String DIRECTORY;
	    File folder_name;

	    public Practice() {
	        DIRECTORY = System.getProperty("user.dir");
	        folder_name = new File(DIRECTORY+"/files");
	        if (!folder_name.exists())
	            folder_name.mkdirs();
	        System.out.println("DIRECTORY : "+ folder_name.getAbsolutePath());
	    }

	    private static final String WELCOME_MESSAGE =
	            "\n Application Name : Lockers.in \n"+
	                    "\n Develpes Details : Ashutosh Tiwari \n";

	    private static final String MAIN_MENU =
	            "\nMAIN MENU - Select any of the following: \n"+
	                    "1 -> List files in directory\n"+
	                    "2 -> Add, Delete or Search file in directory\n"+
	                    "3 -> Exit Program\n";

	    private static final String SECOND_MENU =
	            "   \nSelect any of the following: \n"+
	                    "   a -> Add a file\n"+
	                    "   b -> Delete a file\n"+
	                    "   c -> Search a file\n"+
	                    "   d -> GO BACK TO MAIN MENU\n";

	    void showPrimaryMenu() {
	        System.out.println(MAIN_MENU);
	        try{
	            Scanner scanner = new Scanner(System.in);
	            int option = scanner.nextInt();
	            switch (option){
	                case 1 : {
	                    showFiles();
	                    showPrimaryMenu();
	                }
	                case 2 : {
	                    showSecondaryMenu();
	                }
	                case 3 : {
	                    System.out.println("Thank You");
	                    System.exit(0);
	                }
	                default: showPrimaryMenu();
	            }
	        }
	        catch (Exception e){
	            System.out.println("Please enter 1, 2 or 3");
	            showPrimaryMenu();
	        }
	    }

	    void showSecondaryMenu() {
	        System.out.println(SECOND_MENU);
	        try{
	            Scanner scanner = new Scanner(System.in);
	            char[] input = scanner.nextLine().toLowerCase().trim().toCharArray();
	            char option = input[0];

	            switch (option){
	                case 'a' : {
	                    System.out.print("# Adding a file... Please Enter a File Name : ");
	                    String filename = scanner.next().trim();
	                    addFile(filename);
	                    break;
	                }
	                case 'b' : {
	                    System.out.print("# Deleting a file... Please Enter a File Name : ");
	                    String filename = scanner.next().trim();
	                    deleteFile(filename);
	                    break;
	                }
	                case 'c' : {
	                    System.out.print("# Searching a file... Please Enter a File Name : ");
	                    String filename = scanner.next().trim();
	                    searchFile(filename);
	                    break;
	                }
	                case 'd' : {
	                    System.out.println("GO BACK TO MAIN MENU");
	                    showPrimaryMenu();
	                    break;
	                }
	                default : System.out.println("Please enter a, b, c or d");
	            }
	            showSecondaryMenu();
	        }
	        catch (Exception e){
	            System.out.println("Please enter a, b, c or d");
	            showSecondaryMenu();
	        }
	    }

	    void showFiles() {
	        if (folder_name.list().length==0)
	            System.out.println("The folder is empty");
	        else {
	            String[] list = folder_name.list();
	            System.out.println("The files in "+ folder_name +" are :");
	            //Arrays.sort(list);
	            /*for (String str:list) {
	                System.out.println(str);
	            }*/
	            for(int i = 0; i<folder_name.list().length-1; i++)   
	            {  
	            for (int j = i+1; j<list.length; j++)   
	            {  
	            //compares each elements of the array to all the remaining elements  
	            if(list[i].compareToIgnoreCase(list[j])>0)   
	            {  
	            //swapping array elements  
	            String temp = list[i];  
	            list[i] = list[j];  
	            list[j] = temp;  
	            }  
	            }  
	            }  
	            System.out.println(Arrays.toString(list));  
	        }
	    }

	    void addFile(String filename) throws IOException {
	        File filepath = new File(folder_name +"/"+filename);
	        String[] list = folder_name.list();
	        for (String file: list) {
	            if (filename.equals(file)) {
	                System.out.println("File " + filename + " already exists at " + folder_name);
	                return;
	            }
	        }
	        filepath.createNewFile();
	        System.out.println("File "+filename+" added to "+ folder_name);
	    }

	    void deleteFile(String filename) {
	        File filepath = new File(folder_name +"/"+filename);
	        String[] list = folder_name.list();
	        for (String file: list) {
	            if (filename.equals(file) && filepath.delete()) {
	                System.out.println("File " + filename + " deleted from " + folder_name);
	                return;
	            }
	        }
	        System.out.println("Delete Operation failed. FILE NOT FOUND");
	    }

	    void searchFile(String filename) {
	        String[] list = folder_name.list();
	        for (String file: list) {
	            if (filename.equals(file)) {
	                System.out.println("FOUND : File " + filename + " exists at " + folder_name);
	                return;
	            }
	        }
	        System.out.println("File NOT found (FNF)");
	    }

	    public static void main(String[] args) {
	        System.out.println(WELCOME_MESSAGE);
	        Practice menu = new Practice();
	        menu.showPrimaryMenu();
	    }
	}

