package Attributes;
import java.util.Scanner;

public class Student {
	
	//Part 1
//	Create a Student class to store information about a student.
//	This includes  Name, Grades (array of ints), and GPA.
//
//	Create three instances of type Student. 
//	Read the values for those students from the user’s input.
//
//	Print out the names of those students, their grades, 
//	and their GPAs. Then, print out the average GPA of all three students.
	
	private String Name; 
	private int[] Grades; 
	private double GPA;
	private Course course; //part 5 
	
	
	//constructor 
	public Student (String Name, int[] Grades) {
		this.Name = Name; 
		this.Grades = Grades; 
	}
	
	//default constructor 
	public Student() {
		this.Name = "Anonymous";
		this.Grades = new int[] {}; 
		this.GPA = 0; 
	}
	//getters and setters
	public String getName() {
		return this.Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public int[] getGrades() {
		return this.Grades;
	}
	
	public void setGrades(int[] grades) {
		this.Grades = grades;
		this.GPA = calculateGPA(this.Grades);
	}
	public double getGPA() {
		return this.GPA;
	}
	//calculates the gpa on a 4.0 scale, if grades are between 0 and 100
	private double calculateGPA(int[] grades) {
		double gPA = 0; 
		for (int i = 0; i < grades.length; ++i) {
			gPA += grades[i]; 
		}
		return (gPA/grades.length)/25; 
	} 
	
	//prints the object's attributes 
	public void Profile(){
		
		System.out.println("Name: " + this.Name);
		System.out.print("Grades: ");
		for (int i = 0; i < this.Grades.length; ++i) {
			System.out.print(this.Grades[i] + " ");
		}
		System.out.println();
		System.out.println("GPA: " + this.GPA);
		System.out.println();
	}
	
	public void getInfo() {
		System.out.println("My name is " + this.getName() + "\n"
				+ "I'm in grade 15 and I have a " + this.getGPA() + " GPA.");
		
	}


	public void addCourse(Course c) {
		this.course = c; 
	}
	
	public void getCourse() {
		System.out.println("I'm currently taking " + 
		this.course.getCode() + " - " + this.course.getSubject()
		+ " with Professor " + this.course.getInstructor());
	}
	
//	6. Finally
//
//	Change the Grades[]  variable in your Student class to hold  an array of Integer instead of an array of int , and change the  GPA variable to hold a Double object instead of a double primitive. Make any necessary changes to your getters setters, contractors and methods in your main class so they work with the new data types of you class variable.
//	Please write a method that takes a string and initializes a Student object using the information found within the string. The information in the string will be as follows: 
//	StudentName, [grade1, grade2, grade3], [courseCode, subject, InstructorName]
//	For example :
//	String s="Pedro Peres, [100,95,80], [Cis-101, Java, James]";
//	String s = "Steve Smit, [90, 70,55, 40,80], [Cis-203, Java Developer, Marcial]";
	
//	Step 7:
//	In your main method create an array of strings  filled with 10 strings of data in the same format as the ones we used in step 6 ("Pedro Peres, [100,95,80], [Cis-101, Java, James]") and create 10 instances of Student using the data from that array (by making use of the method you created in step 6)
//
//	Create a method that takes an array of Student object as arguments and print the name and GPA of each student with GPA above the average
//	Create a method that takes an int n and array of Student object as arguments and print the name and GPA of the n higest GPAs of within the array of Students
//	Create a method that takes an int n and array of Student object as arguments and prints the n Courses with the highest average GPAs based on the students that are taking that class


}
