import java.util.Scanner;

//class to print out course details
public class Report extends TheEnrolmentRegister{
    //integer to store max number of students that can be stored
    private int length;
    //integer that stores number of spaces that have been cycled through
    private int i;
    //integer to store the number of students from the studentDetails array
    private float studentCount = 0;
    //integer to store the number of female students from the studentDetails array
    private float femaleCount = 0;
    //integer to store the percentage of female students from the studentDetails array
    private float femalePercent = 0;
    
    //method to print out course details
    public void reportCourse() {
        System.out.println(" ");
        System.out.println("=======================================================================================================");
        System.out.println("||");
        System.out.println("||Thank you for opening the course report. Below you will find the course,");
        System.out.println("||lecturer(s), along with the amount of students attending the course and the % of females on the course");
        System.out.println("||");
        System.out.println("=======================================================================================================");
        System.out.println("||");
        //print course name 
        System.out.println("||" + course);
        System.out.println("||");
        //print lecturer involved
        System.out.println("||" + lecturer);
        System.out.println("||");
        //length stores max length of studentDetails array
        length = studentDetails.length;
        //loop until the max length of array
        for(i = 0; i < length; i++){
            //try to test code for errors
            try{
            if (studentDetails[i] != null){
                studentCount++;
            }
            if (studentDetails[i].contains("female")){
                femaleCount++;
            }
            }
            //catch to stop errors
            catch (Exception ex){}
        }
        femalePercent = (femaleCount / studentCount)*100;
        //total number of students enrolled
        //percentage of students who are male/female.
        System.out.println("||The total number of students on the course is: " + (int)studentCount);
        System.out.println("||");
        System.out.println("||The percentage of females on the course is: " + (int)femalePercent + "%");
        System.out.println("||");
        System.out.println("||The percentage of males on the course is: " + (100 - (int)femalePercent) + "%");
        System.out.println("||");
        System.out.println("=======================================================================================================");
        System.out.println(" ");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter any character to return to main menu");
        input.nextLine();
    }
}//end of Report class
