package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        while (true) {
            System.out.println("\n===== LearnTrack Menu =====");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("4. Exit");
            System.out.println("Select any option from the menu:");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    studentMenu(scanner, studentService);
                    break;

                case 2:
                    courseMenu(scanner, courseService);
                    break;

                case 3:
                    enrollmentMenu(scanner, enrollmentService);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ---------------- STUDENT MENU ----------------

    private static void studentMenu(Scanner scanner, StudentService studentService) {

        System.out.println("\n--- Student Menu ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Find Student by ID");
        System.out.println("4. Update Student");
        System.out.println("5. Deactivate Student");
        System.out.println("6. Activate Student");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                scanner.nextLine();

                System.out.print("First Name: ");
                String firstName = scanner.nextLine();

                System.out.print("Last Name: ");
                String lastName = scanner.nextLine();

                System.out.print("Email: ");
                String email = scanner.nextLine();

                System.out.print("Batch: ");
                String batch = scanner.nextLine();

                studentService.addStudent(firstName, lastName, email, batch);
                System.out.println("Student added!");
                break;

            case 2:
                List<Student> students = studentService.getAllStudents();
                for (Student s : students) {
                    System.out.println("ID: " + s.getId() + " - " + s.getDisplayName() + " Batch: " + s.getBatch() + " - " + s.getEmail() + " - " + " | Active: " + s.isActive());
                }
                break;

            case 3:
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();

                try {
                    Student student = studentService.getStudentById(id);
                    System.out.println("ID: " + student.getId() + " - " + student.getDisplayName() +
                            " Batch: " + student.getBatch() + " - " + student.getEmail() +
                            " | Active: " + student.isActive());
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 4:
                System.out.print("Enter ID: ");
                int updateId = scanner.nextInt();
                scanner.nextLine();

                System.out.print("First Name: ");
                String newFirstName = scanner.nextLine();

                System.out.print("Last Name: ");
                String newLastName = scanner.nextLine();

                System.out.print("Email: ");
                String newEmail = scanner.nextLine();

                System.out.print("Batch: ");
                String newBatch = scanner.nextLine();

                System.out.print("Active (true/false): ");
                boolean active = scanner.nextBoolean();

                try {
                    studentService.updateStudent(updateId, newFirstName, newLastName, newEmail, newBatch, active);
                    System.out.println("Student updated!");
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 5:
                System.out.print("Enter ID: ");
                int deactivateId = scanner.nextInt();

                try {
                    studentService.deactivateStudent(deactivateId);
                    System.out.println("Student deactivated!");
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 6:
                System.out.print("Enter ID: ");
                int activateId = scanner.nextInt();

                try{
                    studentService.activateStudent(activateId);
                    System.out.println("Student activated!");
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;

            default:
                System.out.println("Invalid option!");
        }
    }

    // ---------------- COURSE MENU ----------------

    private static void courseMenu(Scanner scanner, CourseService courseService) {

        System.out.println("\n--- Course Menu ---");
        System.out.println("1. Add Course");
        System.out.println("2. Update Course");
        System.out.println("3. View All Courses");
        System.out.println("4. Deactivate Courses");
        System.out.println("5. Activate Courses");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                scanner.nextLine();

                System.out.print("Course Name: ");
                String name = scanner.nextLine();

                System.out.print("Description: ");
                String desc = scanner.nextLine();

                System.out.print("Duration (weeks): ");
                int duration = scanner.nextInt();

                courseService.addCourse(name, desc, duration);
                System.out.println("Course added!");
                break;

            case 2:
                System.out.print("Enter ID: ");
                int updateId = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Course Name: ");
                String newName = scanner.nextLine();

                System.out.print("Description: ");
                String newDesc = scanner.nextLine();

                System.out.print("Duration (weeks): ");
                int newDuration = scanner.nextInt();

                System.out.print("Active (true/false): ");
                boolean active = scanner.nextBoolean();

                try {
                    courseService.updateCourse(updateId, newName, newDesc, newDuration, active);
                    System.out.println("Course updated!");
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 3:
                List<Course> courses = courseService.getAllCourses();
                for (Course c : courses) {
                    System.out.println("ID: " + c.getId() + " - " + c.getCourseName() + " | Duration: " + c.getDurationInWeeks() + " weeks - " + c.getDescription());
                }
                break;

            case 4:
                System.out.print("Enter ID: ");
                int deactivateId = scanner.nextInt();

                try {
                    courseService.deactivateCourse(deactivateId);
                    System.out.println("Course deactivated!");
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 5:
                System.out.print("Enter ID: ");
                int activateId = scanner.nextInt();

                try{
                    courseService.activateCourse(activateId);
                    System.out.println("Course activated!");
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;

            default:
                System.out.println("Invalid option!");
        }
    }

    // ---------------- ENROLLMENT MENU ----------------

    private static void enrollmentMenu(Scanner scanner, EnrollmentService enrollmentService) {

        System.out.println("\n--- Enrollment Menu ---");
        System.out.println("1. Enroll Student");
        System.out.println("2. View Enrollments by Student");
        System.out.println("3. View Enrollments by ID");
        System.out.println("4. Update Enrollment Status");
        System.out.println("5. Update Enrollment Date");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Student ID: ");
                int studentId = scanner.nextInt();

                System.out.print("Course ID: ");
                int courseId = scanner.nextInt();

                scanner.nextLine();
                System.out.print("Date: ");
                String date = scanner.nextLine();

                try {
                    enrollmentService.enrollStudent(studentId, courseId, date, "ACTIVE");
                    System.out.println("Enrollment successful!");
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.print("Student ID: ");
                int id = scanner.nextInt();

                try {
                    List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudent(id);
                    for (Enrollment e : enrollments) {
                        System.out.println("Course ID: " + e.getCourseId() + " | Status: " + e.getStatus());
                    }
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 3:
                System.out.print("Enrollment ID: ");
                int enrollmentId = scanner.nextInt();

                try{
                    Enrollment enrollment = enrollmentService.getEnrollmentById(enrollmentId);
                    System.out.println("Student ID: " + enrollment.getStudentId() + " | Course ID: " + enrollment.getCourseId() + " | Date: " + enrollment.getEnrollmentDate() + " | Status: " + enrollment.getStatus());
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 4:
                System.out.print("Enrollment ID: ");
                int Id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("New Status: ");
                String newStatus = scanner.nextLine();

                try {
                    enrollmentService.updateEnrollmentStatus(Id, newStatus);
                    System.out.println("Enrollment status updated!");
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 5:
                System.out.println("Enrollment ID: ");
                int enrollmentID = scanner.nextInt();
                scanner.nextLine();

                System.out.print("New Date: ");
                String newDate = scanner.nextLine();

                try{
                    enrollmentService.updateEnrollmentDate(enrollmentID, newDate);
                    System.out.println("Enrollment date updated!");
                } catch (EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;

            default:
                System.out.println("Invalid option!");
        }
    }
}