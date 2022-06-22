import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

//class to start and exit program
public class TheEnrolmentRegister { 
    //array to store student details from text file
    static String[] studentDetails = new String[20];
    //string to store course name from text file
    static String course;
    //string to store lecturer involved from text file
    static String lecturer;
    //main method to start the program
    public static void main(String[] args) {  
        //instance of current class
        TheEnrolmentRegister program = new TheEnrolmentRegister();
    	//call start method
    	program.start();
    }//end of main()
    //method to start the program
    private void start() {
        int i = 0;
        //Scanner instance to read text file
        Scanner scan = null;
        //read from StudentDetails.txt to find student details
        try {
        //File instance to reference course details text file
        File file = new File("StudentDetails.txt");
        scan = new Scanner(file);
        } catch (FileNotFoundException ex) { 
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
        }
        //read text file
        while (scan.hasNextLine())
        { String record = scan.nextLine(); 
            studentDetails[i] = record;
            i++;
        }
        // Close the file
        scan.close();
        
        // from CourseDetails.txt to find course details
        try {
        //File instance to reference course details text file
        File file = new File("CourseDetails.txt");
        scan = new Scanner(file);
        } catch (FileNotFoundException ex) { 
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
        }
        //read text file
        while (scan.hasNextLine())
        { String record = scan.nextLine();
            if (record.contains("Course:"))
            {course = record;}
            if (record.contains("Lecturer:"))
            {lecturer = record;}
        }
        // Close the file
        scan.close();
        while(true){
        //Scanner instance to get user input
        Scanner input = new Scanner(System.in);
   	//display the menu options
        System.out.println(" ");
        System.out.println("The Enrolment Register");
        System.out.println("1:Add a student");
        System.out.println("2:Delete a student");
        System.out.println("3:Search for a student");
        System.out.println("4:Report course details");
        System.out.println("5:Exit the program");
        System.out.println("Choose a number from above:");
        //allow user to input a number from the list of options
        int choice = 0;
        try{
            choice = Integer.parseInt(input.nextLine());
            if(choice > 5||choice < 1){
                System.out.println("*Notice: number can only be between 1-5*");
            }
        }
        catch (NumberFormatException num){System.out.println("*Notice: can only enter a number*");}
        System.out.println(" ");
        if(choice == 1) {
            Student s = new Student();
            s.addStudent();
        }
        if(choice == 2) {
            Student s = new Student();
            s.deleteStudent();
        }
        if(choice == 3) {
            Student s = new Student();
            s.searchStudent();
        }
        if(choice == 4) {
            TheEnrolmentRegister e = new TheEnrolmentRegister();
            Report r = new Report();
            r.reportCourse();
        }
        if(choice == 5) {
            exit();
        }
        }//end of menu while loop
    }//end of start()
    //method to exit the program
    private void exit() {
        //PrintWriter instance to write to text file
        PrintWriter out = null;
        //save course details to CourseDetails.txt
        try {
        out = new PrintWriter("CourseDetails.txt");
        } catch (FileNotFoundException ex){ 
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
        }
        //Write lecturer string to text file
            out.println(lecturer);
        //Write lecturer string to text file
            out.println(course);

        // Close the files.
        out.close();
        
        //save student details to StudentDetails.txt
        try {
        out = new PrintWriter("StudentDetails.txt");
        } catch (FileNotFoundException ex){ 
            System.out.println(ex.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(1);
        }
        //write each record on array to text file using enhanced for loop
        for(String element : studentDetails){
            //try to test code for errors
            try{
            if (element != null){
                out.println(element.toLowerCase());
            }
            }
            //catch to stop errors
            catch (Exception ex){}
        }
        // Close the files.
        out.close();
        
        //exit the program
        System.out.println("Thanks for using The Enrolment Register");
        System.exit(0);
    }//end of exit()   
}//end of TheEnrolmentRegister class
