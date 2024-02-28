import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1 = Create, 2 = Read, 3 = Update, 4 = Delete, 5 = Exit");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // Consume invalid input
                continue;
            }
            int choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter Id, Name, Age, Email, Course");
                    int id = sc.nextInt();
                    sc.nextLine(); // Consume newline character
                    String name = sc.nextLine();
                    int age = sc.nextInt();
                    sc.nextLine(); // Consume newline character
                    String email = sc.nextLine();
                    String course = sc.nextLine();
                    Student student = new Student(id, name, age, email, course);
                    StudentDao.createStudent(student);
                    System.out.println("Student created successfully: " + student);
                    break;

                case 2:
                    ArrayList<Student> list = StudentDao.readAllStudents();
                    System.out.println("List of Students:");
                    for (Student s : list) {
                        System.out.println(s);
                    }
                    break;
                case 3:
                    System.out.println("Enter Id, New Name, New Age, New Email, New Course:");
                    id = sc.nextInt();
                    sc.nextLine(); // Consume newline character
                    name = sc.nextLine();
                    age = sc.nextInt();
                    sc.nextLine(); // Consume newline character
                    email = sc.nextLine();
                    course = sc.nextLine();
                    Student updatedStudent = new Student(id, name, age, email, course);
                    StudentDao.updateStudent(updatedStudent);
                    System.out.println("Student updated successfully.");
                    break;
                case 4:
                    System.out.println("Enter Id to delete:");
                    id = sc.nextInt();
                    StudentDao.deleteStudent(id);
                    System.out.println("Student deleted successfully.");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close(); // Close the scanner when done
    }
}
