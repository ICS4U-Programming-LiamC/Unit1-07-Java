/**
* Generates 2D arrays populates with student names and their corresponding
* marks, geberated with standard deviation
*
* @author  Liam Csiffary
* @version 1.1
* @since   2022-03-22
*/

// import required modules
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Random;

// class
public class studentMarks {

  // Generates the random marks and populates the array of arrays with them
  public static String[][] StudentMarks(String[] arrayOfStudents, String[] arrayOfAssignments) {
    // create the random object
    Random r = new Random();

    // create the array of type array of type string
    String[][] finalArray = new String[arrayOfStudents.length][arrayOfAssignments.length + 1];

    // for each student ...
    for (int studentName = 0; studentName < arrayOfStudents.length; studentName++) {
      // should reset the array so it can be refiled
      String[] tempArray = new String[arrayOfAssignments.length + 1];
      
      // puts name in the first slot
      tempArray[0] = arrayOfStudents[studentName];

      // for each in assignments ...
      for (int mark = 0; mark < arrayOfAssignments.length; mark++) {
        // pupulate inner array skipping the first index
        // which contains the students name
        tempArray[mark + 1] = Double.toString(r.nextGaussian() * 10 + 75);
      }

      // add the generated array to the final array
      finalArray[studentName] = tempArray;
    }
    return finalArray;
  }


  // generates the arrays from the files
  public static String[] ArrayGenerator(File file) throws Exception {

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

    // create array of length
    String[] array = new String[originalListString.size()];

    // fill the array
    for (int i = 0; i < array.length; i++) {
      array[i] = originalListString.get(i);
    }

    return array;
  }

  // code from https://www.w3schools.com/java/java_files_create.asp
  // my comments to prove I know what is happening though
  public static void CreateFile() {
    try {
      // creates the file name/object
      File myObj = new File("StudentMarks.txt");

      // if it is able to create a new file
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      
      // otherwise states that the file already exists
      } else {
        System.out.println("File already exists.");
      }
    
    // if exeception
    } catch (IOException e) {
      System.out.println("An error occurred.");
    
      // traces it I guess?
      e.printStackTrace();
    }
  }

  // also from https://www.w3schools.com/java/java_files_create.asp
  public static void Writer(String[][] arr) {
    try {
      // creates file writing object
      FileWriter myWriter = new FileWriter("StudentMarks.txt");

      // my code
      // just writes to the file the same way you'd print it to the terminal
      // except with myWriter.write instead of System.out.print()
      for (int each = 0; each < arr.length; each++) {
        for (int index = 0; index < arr[each].length; index++) {
          myWriter.write(arr[each][index] + ", ");
        }
        myWriter.write("\n");
      }

      // closes the file
      myWriter.close();
      System.out.println("Successfully wrote to the file.");

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws Exception {
    // generates new file and creates the array using the ArrayGenerator
    File file = new File(
        "C:/Users/s299776/ICS4U/Unit1/Java/Unit1-07-Java/students.txt");
    
    String[] studentArray = ArrayGenerator(file);

    // repeats but for the marks
    file = new File(
        "C:/Users/s299776/ICS4U/Unit1/Java/Unit1-07-Java/students.txt");
    
    String[] assignArray = ArrayGenerator(file);

    // gets the final array from the StudentMarks function
    String[][] finalArr = StudentMarks(studentArray, assignArray);

    // creates and writes to a new file called "StudentMarks.txt"
    CreateFile();
    Writer(finalArr);

  }
}
