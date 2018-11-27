package classRoom;

import Attributes.*;
import java.util.Scanner; 

public class RoleCall {
	
	public static void main(String[] args) {
		
		//part 1 continued: 
//		Create three instances of type Student. 
//		Read the values for those students from the user’s input.
//	
//		Print out the names of those students, their grades, 
//		and their GPAs. Then, print out the average GPA of all three students.
//		
		String name; 
		int[] grades = new int[3]; 
		double gpa;
		
		Scanner s = new Scanner(System.in); 
		
		System.out.println("Part 1");
		System.out.println("What is the student's name:");
		name = s.next(); 
		System.out.println("What are their 3 most recent grades?");
		for (int i = 0; i < 3; ++i) {
			grades[i] = s.nextInt();
		}
		System.out.println("What is their GPA?"); 
		gpa = s.nextDouble(); 
		
		Student Helen = new Student(name, grades, gpa); 
		
		Helen.Profile(); 
		/////
		
		System.out.println("What is the student's name:");
		name = s.next(); 
		System.out.println("What are their 3 most recent grades?");
		for (int i = 0; i < 3; ++i) {
			grades[i] = s.nextInt();
		}
		System.out.println("What is their GPA?"); 
		gpa = s.nextDouble(); 
		
		Student Cindy = new Student(name, grades, gpa); 
		Cindy.Profile();
		
		///
		
		System.out.println("What is the student's name:");
		name = s.next(); 
		System.out.println("What are their 3 most recent grades?");
		for (int i = 0; i < 3; ++i) {
			grades[i] = s.nextInt();
		}
		System.out.println("What is their GPA?"); 
		gpa = s.nextDouble(); 
		
		Student Zack = new Student(name, grades, gpa); 
		Zack.Profile();
		
		////Avg GPA of Helen, Cindy, and Zack
		
		System.out.println("Average GPA: " + (Helen.getGPA() + Cindy.getGPA() + Zack.getGPA())/3); 
	
//		2. Array of Students
//
//		Create an array of type Student with three positions. 
//		Read in their info just like before.
//
//		Print out the names of those students, their grades, and their GPAs. 
//		Then, print out the average GPA of all three students.
//		
		System.out.println();
		System.out.println("Part 2"); 
		Student[] people = new Student[3];
		
		for (int i = 0; i < 3; ++i) {
			
			System.out.println("What is the student's name:");
			name = s.next(); 
			System.out.println("What are their 3 most recent grades?");
			for (int j = 0; j < 3; ++j) {
				grades[j] = s.nextInt();
			}
			System.out.println("What is their GPA?"); 
			gpa = s.nextDouble(); 
			
			people[i] = new Student(name, grades, gpa); 
			people[i].Profile();	
			
		}
		
		//get average GPA of the 3 students in people 
		System.out.println("Average GPA: " + (people[0].getGPA() + people[1].getGPA() + people[2].getGPA())/3); 
		
//		3. Modify the Length of the Array
//
//		Ask the user to input the number of students 
//		they would like to enter. Store this in an integer named numStudents. 
//		Create an array of type Student with [numStudents] positions. 
//		Read through their info using a loop.
//
//		Using a second loop, print out the names of those students, 
//		their grades, and their GPAs. Finally, print the average GPA of all students.
		
		System.out.println();
		System.out.println("Part 3"); 
		System.out.println("Please enter the number of students in the classroom:");
		
		int numStudents; 
		numStudents = s.nextInt(); 
		
		Student[] classRoom = new Student[numStudents]; 
		
		//reading in Student's info
		for (int i = 0; i < numStudents; ++i) {
			
			System.out.println("What is the student's name:");
			name = s.next(); 
			System.out.println("What are their 3 most recent grades?");
			for (int j = 0; j < 3; ++j) {
				grades[j] = s.nextInt();
			}
			System.out.println("What is their GPA?"); 
			gpa = s.nextDouble(); 
			
			classRoom[i] = new Student(name, grades, gpa); 
			
			//printing out names of those students, grades, and GPAs. 
			classRoom[i].Profile();
			
		}
		
		System.out.println("The average GPA of the class is: ");
		System.out.println(AverageGPA(classRoom)); 

		//part 4 continued: 
//		in your main method, ask the user to 
//		input the number of students they would 
//		like to enter and store this in an integer 
//		named numStudents. (see above)
//	
//		Create an array of type Student with 
//		[numStudents] positions and 
//		read their information through a loop. (see above) 
//		Using another loop, have each student talk 
//		about their school life.
		
		//talk about school life
		System.out.println();
		System.out.println("Part 4");
		System.out.println("Now, let's introduce ourselves: ");
		
		for (int i = 0; i < classRoom.length; ++i) {
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
		
		System.out.println("Here are all the courses we are offering this year: ");
		
		for (int i = 0; i < catalog.length; ++i) {
			System.out.println(i + ". " + catalog[i].getCode() + " - " + catalog[i].getSubject());
		}
		
		//initializing courses for entire class 
		for (int i = 0; i < classRoom.length; ++i) {
		System.out.println(classRoom[i].getName() + ", which course would you like to take? \n Press 0, 1 or 2 ");
		
		int choice = s.nextInt(); 
		boolean done = false; 
		while(done == false) {
			
			switch(choice) {
				case 0: 
					classRoom[i].addCourse(catalog[0]);
					done = true; 
					break;
				case 1: 
					classRoom[i].addCourse(catalog[1]);
					done = true;
					break;
				case 2: 
					classRoom[i].addCourse(catalog[2]); 
					done = true;
					break; 
				default:
					System.out.println(classRoom[i].getName() + ", you didn't enter a valid selection. \n"
							+ "Please select either 0, 1 or 2 ONLY!");
					choice = s.nextInt();
					
				}
			}
		
		}
		
		//close the scanner! 
		s.close(); 
		System.out.println();
		System.out.println("Now each student will re-introduce themselves and talk about their chosen courses!");
	
		for (int i = 0; i < classRoom.length; ++i) {
			classRoom[i].getInfo();
			classRoom[i].getCourse();
		}
		
	}
	
	//returns the average GPA of a class of students 
	public static double AverageGPA(Student[] classRoom) {
		
		double avg=0; 
		for (int i = 0; i < classRoom.length; ++i) {
			avg+=classRoom[i].getGPA(); 
		}
		return avg/(classRoom.length); 
	}
	

}
