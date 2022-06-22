import java.util.Scanner;

//class to add, delete and search for students in the course
public class Student extends TheEnrolmentRegister{
    //string to store student name
    private String name;
    //string to store date of birth (dd/mm/yyyy)
    private String dob;
    //string to store address
    private String address;
    //string to store gender
    private String gender;
    //string array to store name, date of birth, address and gender
    private String[] student = new String[4];
    //string to know if user wants to add student
    private String add;
    //string to know if user wants to delete student
    private String delete;
    //string to know if user wants to search student
    private String search;
    //int to store number of empty spaces in array
    int ecount = 0;
    //int to store number of filled spaces in array
    int count = 0;
    
    //method to add students and their details to the course
    public void addStudent() {
        //create new student
        student = new String[4];
        //ask user if they want to continue
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to add a student?(y/n)");
        add = input.nextLine();
        //loop until user does not say y
        while(add.equals("y")){
             int studentCount = 0;
            //find number of students in studentDetails array
            //increment counter to add new student after other students
            for(String element : studentDetails){
                //try to test code for errors
                try{
                if (element != null){
                    studentCount++;
                }
                }
                //catch to stop exception errors
                catch (Exception ex){}
            }
            //if there are already 20 students in array
            if (studentCount == 20){
                //tell user it is full and break the loop to send them back to main menu
                System.out.println("*Notice: student record full, please delete an entry before trying again*");
                break;
            }
            System.out.println(" ");
            System.out.println("*Notice: students with incomplete details will not be added*");
            System.out.println(" ");
            //ask user to enter student name
            System.out.println("Enter student's name");
            name = input.nextLine();
        
            //ask user to enter student date of birth
            System.out.println("Enter student's date of birth (00/00/0000)");
            dob = input.nextLine();
        
            //ask user to enter student address
            System.out.println("Enter student's address");
            address = input.nextLine();
        
            //ask user to enter student gender
            System.out.println("Enter student's gender (male/female)");
            gender = input.nextLine();
            //while loop
            while(true){
                if(gender.equals("male") || gender.equals("female")){
                    break;
                }
                System.out.println("Gender was input incorrectly please enter 'male' or 'female'");
                gender = input.nextLine();
            }
            
            //add details to student array
            //make student details lower case
            if(name.length() > 1) {
                student[0] = "name: " + name.toLowerCase();
            }
            if(dob.length() > 1) {
                student[1] = "age: " + dob.toLowerCase();
            }
            if(address.length() > 1) {
                student[2] = "address: " + address.toLowerCase();
            }
            if(gender.length() > 3) {
                student[3] = "gender: " + gender.toLowerCase();
            }
            //if there is incomplete details tell the user
            if (student[0] == null||student[1] == null||student[2] == null||student[3] == null){
                System.out.println("Student details incomplete, try again");
            }
            //if there are no incomplete details
            else
                //add student details to studentDetails array
                studentDetails[studentCount] = student[0] + " " + student[1] + " " + student[2] + " " + student[3];
            //ask user if they to add another student
            System.out.println("Do you want to add another student?(y/n)");
            add = input.nextLine();
            }//end of while loop
    }//end of addStudent()
    //method to delete students from the course
    public void deleteStudent() {
        count = 0;
        ecount = 0;
        int index = 0;
        //Scanner instance to get user input
        Scanner input = new Scanner(System.in);
        //ask user if they want to continue
        System.out.println("Do you want to delete a student?(y/n)");
        delete = input.nextLine();
        //loop until user does not say y
        while(delete.equals("y")){
            //ask user to enter name
            System.out.println("Enter student name to delete");
            String inputName = input.nextLine();
            String deleteName = inputName.toLowerCase() + " ";
            for(int i = 0; i < studentDetails.length; i++){
                //try to test code for errors
                try{
                //if searched name matches a students name
                //make searched name lowercase incase user entered in upper case
                if (studentDetails[i].contains(deleteName)){
                    index = i;
                }
                else
                    //add 1 to count
                    count++;
                }
                //catch to stop errors and add 1 to ecount
                catch (Exception ex){ecount++;}
            }
            
            //if the length of the array has been searched through
            if (count + ecount == studentDetails.length){
                //tell user that searched student name is not in the array
                System.out.println(deleteName + " does not exist");
            }
            
            String[] copy = new String[studentDetails.length - 1];
            for(int i = 0, j = 0; i < studentDetails.length; i++){
                if(i != index){
                    copy[j++] = studentDetails[i];
                }
            }
            studentDetails = new String[20];
                for(int i = 0; i < studentDetails.length; i++){
                    try{
                    studentDetails[i] = copy[i];
                    }
                    catch (Exception ex){}
                }
            //ask user if they to delete another student
            System.out.println("Do you want to delete another student?(y/n)");
            delete = input.nextLine();
        }//end of while loop
    }//end of deleteStudent()

    //method to search for students by name.
    public void searchStudent() {
        count = 0;
        ecount = 0;
        //Scanner instance to get user input
        Scanner input = new Scanner(System.in);
        //ask user if they want to continue
        System.out.println("Do you want to search for a student?(y/n)");
        search = input.nextLine();
        //loop until user does not say y
        while(search.equals("y")){
            //ask user to enter name
            System.out.println("Enter student name to search");
            String searchName = input.nextLine();
            //for each element in the array
            for(String element : studentDetails){
                //try to test code for errors
                try{
                //if searched name matches a students name
                //make searched name lowercase incase user entered in upper case
                if (element.contains(searchName.toLowerCase())){
                    System.out.println(" ");
                    //display details of chosen student
                    System.out.println(element);
                }
                else
                    //add 1 to count
                    count++;
                }
                //catch to stop errors and add 1 to ecount
                catch (Exception ex){ecount++;}
            }
            //if the length of the array has been searched through
            if (count + ecount == studentDetails.length){
                //tell user that searched student name is not in the array
                System.out.println(searchName + " does not exist");
            }
            //ask user if they to search for another student
            System.out.println("Do you want to search for another student?(y/n)");
            search = input.nextLine();
        }//end of while loop
    }//end of searchStudent()
}//end of Student class