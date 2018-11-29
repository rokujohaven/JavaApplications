package classRoom;

import Attributes.*;
import java.util.Scanner; 

public class RoleCall {
	
	public static void main(String[] args) {
		

//		Allows a professor to register a classroom of students, input their grades, and calculate GPA
		
		System.out.println("Hello professor, how many students are in your class?");
		Scanner s = new Scanner(System.in);
		int numPeople = s.nextInt(); 
		
		//creates a class of size numPeople
		Student[] classRoom = addClass(numPeople);
		
		///Print class profile for each student
		
		System.out.println("Class Profile: ");
		for (int i = 0; i < numPeople; ++i) {
			classRoom[i].Profile();
		}
		////Print class average
		System.out.println("Average class GPA is: " + AverageGPA(classRoom)); 
		System.out.println();
		//part 4: 
		
		//talk about school life
		System.out.println("Now, the students will introduce themselves...");
		System.out.println();
		
		for (int i = 0; i < numPeople; ++i) {
			classRoom[i].getInfo();
		}
	
		//part 5 continued: 
		//In main, create an array of type Course 
		//with three positions and make up information 
		//for each (You do NOT have to use user input for this.)
		
		System.out.println();
		System.out.println("Part 5");
		Course[] catalog = {new Course("CS135", "Intro to Object Oriented Programming", "Joseph"), 
							new Course("CS145", "Intro to Algorithm Design", "Stevens"), 
							new Course("CS235", "Object Oriented Programming II", "Robin")};
		
//		- As usual, in the main method create an array of students and get their info from a loop.
//
//		- This time, however, you'll also ask which course they're taking.
		
//		You should print out a list of all courses in your Course[] array like so:
//
//		1) CS135 | Intro to Object Oriented Programming | Joseph
//		2) CS145 | Intro to Algorithm Design | Stevens
//		3) CS235 | Object Oriented Programming II | Robin
//
//		- Add the course based on what the user selects.
//
//		- Finally, using another loop, have each student talk about 
//		their school life and their current course
		
		selectCourse(classRoom, catalog); 
		
		//close the scanner! 
		s.close(); 
		System.out.println();
		System.out.println("Now each student will re-introduce themselves and talk about their chosen courses!");
		System.out.println();
		for (int i = 0; i < classRoom.length; ++i) {
			classRoom[i].getInfo();
			classRoom[i].getCourse();
		}
		
	}
	
	//part 1 continued: 
//	Create three instances of type Student. 
//	Read the values for those students from the user’s input.
//
//	Print out the names of those students, their grades, 
//	and their GPAs. Then, print out the average GPA of all three students.
//	
	public static Student addStudent(Student person, int numTests) {
		
		//this method initializes an already declared Student object and returns this object
		Scanner s = new Scanner(System.in); 
		String name; 
		System.out.println("What is the student's name:");
		name = s.next(); 
		System.out.println("What are their " + numTests + " most recent grades?");
		int[] g = new int[numTests]; 
		for (int i = 0; i < g.length; ++i) {
			g[i] = s.nextInt();
		}

		person.setName(name);
		person.setGrades(g);
		
		return person; 
		
	}
	public static Student[] addClass(int classSize) {
		
		//this method creates a new class of size classSize
		//and returns an array of Students
		
		//not void because classRoom array was not created in the main, we create it here.  
		
		Student[] classRoom = new Student[classSize]; 
		Scanner s = new Scanner(System.in); 
		System.out.println("How many tests do they have?");
		int noTests; 
		noTests = s.nextInt();
		
		
		for (int i =0; i < classSize; ++i) {
			classRoom[i] = addStudent(new Student(), noTests);
		}
		
		return classRoom;
		
	}

	//returns the average GPA of a class of students 
	public static double AverageGPA(Student[] classRoom) {
		
		double avg=0; 
		for (int i = 0; i < classRoom.length; ++i) {
			avg+=classRoom[i].getGPA(); 
		}
		return avg/(classRoom.length); 
	}
	
	public static void selectCourse(Student[] classRoom, Course[] catalog) {
		
		//this method guides each student in the class to select 1 course from the catalog
		//void because arrays pass by reference 
		System.out.println("Here are all the courses we are offering this year: ");
		Scanner s = new Scanner(System.in);
		
		//print available courses
		for (int i = 0; i < catalog.length; ++i) {
			System.out.println((i+1) + ") " + catalog[i].getCode() + " - " + catalog[i].getSubject()
					+ " with " + catalog[i].getInstructor());
		}
		
		//initializing courses for entire class 
		for (int i = 0; i < classRoom.length; ++i) {
		System.out.println(classRoom[i].getName() + ", which course would you like to take? ");
		
		int choice = s.nextInt(); 
		boolean done = false; 
		while (!done) {
		if (choice > 0 && choice <= catalog.length) {
			classRoom[i].addCourse(catalog[choice-1]);
			done = true; 
			}
		else {
			System.out.println(classRoom[i].getName() + ", you didn't enter a valid selection. \n"
					+ "Please try again.");
			choice = s.nextInt();
				}
				
			}
		
		}
	}
}
