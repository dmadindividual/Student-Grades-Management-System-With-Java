import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Student {
    private String student_name;
    private HashMap<String, Integer> grades;

    public Student(String student_name) {
        this.student_name = student_name;
        this.grades = new HashMap<>();
    }

    public void add_grade(String subject, int student_grade) {
        grades.put(subject, student_grade);
    }

    public double calculate_average() {
        int total = 0;
        for (int grade : grades.values()) {
            total += grade;
        }
        return !grades.isEmpty() ? (double) total / grades.size() : 0.0;
    }

    public void display_student_info() {
        System.out.println("Student Name: " + student_name);
        System.out.println("Grades: " + grades);
        System.out.println("Average Grade: " + calculate_average());
    }

    public String getStudent_name() {
        return student_name;
    }
}

public class GradeSystem {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new student");
            System.out.println("2. Add grade for a student");
            System.out.println("3. Display all students");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1 -> {
                    System.out.print("Name of Student: ");
                    String studentName = scanner.nextLine();
                    studentList.add(new Student(studentName));
                    System.out.println("Student added.");
                }

                case 2 -> {
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    Student student = find_student(studentList, studentName);
                    if (student != null) {
                        System.out.println("Enter Subject: ");
                        String subject = scanner.nextLine();
                        System.out.println("Enter Grade: ");
                        int student_grade = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        student.add_grade(subject, student_grade);
                        System.out.println("Grade Added");
                    } else {
                        System.out.println("Student Not Found");
                    }
                }

                case 3 -> {
                    for (Student s : studentList) {
                        s.display_student_info(); // No need to print, just call the method
                    }
                }

                case 4 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }

                default -> {
                    System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }

    public static Student find_student(ArrayList<Student> studentList, String studentName) {
        for (Student student : studentList) {
            if (student.getStudent_name().equalsIgnoreCase(studentName)) { // Case insensitive comparison
                return student;
            }
        }
        return null;
    }
}
