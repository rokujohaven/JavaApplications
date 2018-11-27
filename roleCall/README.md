# oopPractice
object oriented programming exercises

Student Class Assignment

1. Student Class

Create a Student class to store information about a student.
This includes  Name, Grades (array of ints), and GPA.

Create three instances of type Student. Read the values for those students from the user’s input.

Print out the names of those students, their grades, and their GPAs. Then, print out the average GPA of all three students.


2. Array of Students

Create an array of type Student with three positions. Read in their info just like before.

Print out the names of those students, their grades, and their GPAs. Then, print out the average GPA of all three students.

3. Modify the Length of the Array

Ask the user to input the number of students they would like to enter. Store this in an integer named numStudents. Create an array of type Student with [numStudents] positions. Read through their info using a loop.

Using a second loop, print out the names of those students, their grades, and their GPAs. Finally, print the average GPA of all students.

4. Add Methods

Modify the Student class and add a method whose signature is: public void getInfo(). 

This method will print information about a student’s school life. The method should print out a line that looks something like this: My name is Mike. I'm in grade 15 and I have a 4.0 GPA.

Then, in your main method, ask the user to input the number of students they would like to enter and store this in an integer named numStudents.

Create an array of type Student with [numStudents] positions and 
read their information through a loop. Using another loop, have each student talk about their school life.

5. Finally

Create a Course class to store information about a course.
This includes a course code, subject, and instructor name.

In main, create an array of type Course with three positions and make up information for each (You do NOT have to use user input for this.)

Modify the Student class as follows:

- Add a variable of type Course.
- Then, add the following methods:

public void addCourse(Course c). This sets the student's current course to a given.

public void getCourse(). This makes student talk about their current course

- The getCourse() method should look like this:
“I’m currently talking CS135 - Intro to Object Oriented Programming with Professor Joseph”

- As usual, in the main method create an array of students and get their info from a loop.

- This time, however, you'll also ask which course they're taking.
You should print out a list of all courses in your Course[] array like so:

1) CS135 | Intro to Object Oriented Programming | Joseph
2) CS145 | Intro to Algorithm Design | Stevens
3) CS235 | Object Oriented Programming II | Robin

- Add the course based on what the user selects.

- Finally, using another loop, have each student talk about 
their school life and their current course
