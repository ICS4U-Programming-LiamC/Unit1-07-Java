/**
* Generates 2D arrays populates with student names and their corresponding
* marks, geberated with standard deviation
*
* @author  Liam Csiffary
* @version 1.0
* @since   2022-03-22
*/

import java.io.File;
import java.util.*;

public class studentMarks {
  public static String[] Mode(String[] arrayOfStudents, String[] arrayOfAssignments) {
    String[] finalArray = new String[arrayOfStudents.length];
    return finalArray;
  }


  public static String[] arrayGenerator(file file) {
    // defining vars
    List<String> originalListString = new ArrayList<String>();

    System.out.println(file);
    Scanner scStudent = new Scanner(file);

    // pass the path to the file as a parameter
    while (scStudent.hasNextLine()) {
      originalListString.add(scStudent.nextLine());
    }

    // for testing purposes
    System.out.println(originalListString);

    String[] array = new String[originalListString.size()];

    for (int i = 0; i < array.length; i++) {
      array[i] = originalListString.get(i);
    }

    return array;
  }


  public static void main(String[] args) throws Exception {
    File file = new File(
        "C:/Users/s299776/ICS4U/Unit1/Java/Unit1-07-Java/students.txt");
    
    String[] studentArray = arrayGenerator(file);

    file = File(
        "C:/Users/s299776/ICS4U/Unit1/Java/Unit1-07-Java/students.txt");
    
    String[] assignArray = arrayGenerator(file);

    finalArr = StudentMarks(studentArray, assignArray);
    


  }
}
