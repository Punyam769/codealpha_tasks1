import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Integer> grades;

    Student(String name) {
        this.name = name;
        grades = new ArrayList<>();
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double getAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / (double) grades.size();
    }

    int getHighest() {
        int max = Integer.MIN_VALUE;
        for (int grade : grades) {
            if (grade > max) max = grade;
        }
        return max;
    }

    int getLowest() {
        int min = Integer.MAX_VALUE;
        for (int grade : grades) {
            if (grade < min) min = grade;
        }
        return min;
    }

    void printSummary() {
        System.out.println("Name: " + name);
        System.out.println("Grades: " + grades);
        System.out.printf("Average: %.2f\n", getAverage());
        System.out.println("Highest: " + getHighest());
        System.out.println("Lowest: " + getLowest());
        System.out.println("----------------------------------");
    }
}

public class StudentGradeTracker {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\nStudent Grade Tracker");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade to Student");
            System.out.println("3. Show All Students Report");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            option = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addGradeToStudent();
                    break;
                case 3:
                    showAllReports();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (option != 0);
    }

    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        students.add(new Student(name));
        System.out.println("Student added successfully.");
    }

    static void addGradeToStudent() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        System.out.println("Select a student:");
        for (int i = 0; i < students.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, students.get(i).name);
        }
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // clear buffer
        if (choice < 1 || choice > students.size()) {
            System.out.println("Invalid student number.");
            return;
        }
        Student selected = students.get(choice - 1);
        System.out.print("Enter grade to add: ");
        int grade = sc.nextInt();
        selected.addGrade(grade);
        System.out.println("Grade added to " + selected.name);
    }

    static void showAllReports() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("\n===== Student Reports =====");
        for (Student s : students) {
            s.printSummary();
        }
    }
}
