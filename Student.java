package Attributes;

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
	public Student (String Name, int[] Grades, double GPA) {
		this.Name = Name; 
		this.Grades = Grades; 
		this.GPA = GPA; 
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
	}
	public double getGPA() {
		return this.GPA;
	}
	public void setGPA(double gPA) {
		this.GPA = gPA;
	} 
	
	//prints the object's attributes 
	public void Profile(){
		
		System.out.println("Name: " + this.Name);
		System.out.print("Grades: ");
		for (int i = 0; i < 3; ++i) {
			System.out.print(this.Grades[i] + " ");
		}
		System.out.println();
		System.out.println("GPA: " + this.GPA);
		System.out.println();
	}
	
//	4. Add Methods
//
//	Modify the Student class and add a method 
//	whose signature is: public void getInfo(). 
//
//	This method will print information about 
//	a student’s school life. The method should 
//	print out a line that looks something like 
//	this: My name is Mike. I'm in grade 15 and I have a 4.0 GPA.
//
//	Then, in your main method, ask the user to 
//	input the number of students they would 
//	like to enter and store this in an integer 
//	named numStudents.
//
//	Create an array of type Student with 
//	[numStudents] positions and 
//	read their information through a loop. 
//	Using another loop, have each student talk 
//	about their school life.
	
	public void getInfo() {
		System.out.println("My name is " + this.getName() + "\n"
				+ "I'm in grade 15 and I have a " + this.getGPA() + " GPA.");
		
	}
	
	//part 5 continued: 
//	Modify the Student class as follows:
//
//		- Add a variable of type Course.
//		- Then, add the following methods:
//
//		public void addCourse(Course c). This sets the student's current course to a given.
//
//		public void getCourse(). This makes student talk about their current course
//
//		- The getCourse() method should look like this:
//		“I’m currently talking CS135 - Intro to Object Oriented Programming with Professor Joseph”

	public void addCourse(Course c) {
		this.course = c; 
	}
	
	public void getCourse() {
		System.out.println("I'm currently taking " + 
		this.course.getCode() + " - " + this.course.getSubject()
		+ " with Professor " + this.course.getInstructor());
	}

}
