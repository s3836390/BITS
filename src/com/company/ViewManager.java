package com.company;
import java.util.*;

public class ViewManager {
    private final StudentEnrolmentManagerImpl studentEnrolmentManagerImpl;

    public ViewManager(StudentEnrolmentManagerImpl studentEnrolmentManagerImpl) {
        this.studentEnrolmentManagerImpl = studentEnrolmentManagerImpl;
    }
    public void mainScreen() {
        System.out.println("Do you want to load a file from somewhere? Y/N");
        Scanner scanner = new Scanner(System.in);
        String ynChoice = scanner.nextLine();
        if (ynChoice.equals("Y")){
            System.out.println("Please enter your filename or path");
            String filename = scanner.nextLine();
            studentEnrolmentManagerImpl.openCSV(filename);
        } else if (ynChoice.equals("N")) {
            System.out.println("Using default file sample");
            String filename = "default.csv";
            studentEnrolmentManagerImpl.openCSV(filename);
        }
        System.out.println("Main Screen");
        System.out.println("Type a number to execute from the following actions");
        int choice;
        do {
            System.out.println("1- Enroll a student for 1 semester:");
            System.out.println("2- Update an enrolment of a student for 1 semester:");
            System.out.println("3- Delete an enrolment of a course for 1 student:");
            System.out.println("4- Get one student enrolment (print one student):");
            System.out.println("5- Get all student enrolments (print all students):");
            System.out.println("6- Print all courses for 1 student in 1 semester:");
            System.out.println("7- Print all students of 1 course in 1 semester:");
            System.out.println("8- Prints all courses offered in 1 semester:");
            System.out.println("9- Quit");

            choice = scanner.nextInt();
            scanner.nextLine();


            if (choice == 1) {
                studentEnrolmentManagerImpl.add();

            } else if (choice == 2) {
                System.out.println("Please enter the student id:");
                String studentId2= scanner.nextLine();
                studentEnrolmentManagerImpl.printCourse(studentId2);
                System.out.println("1- Add new course to the list:");
                System.out.println("2- Delete a course from the list:");
                int updateChoice = scanner.nextInt();
                scanner.nextLine();
                if (updateChoice == 1){
                    studentEnrolmentManagerImpl.update(studentId2);
                } else {
                    studentEnrolmentManagerImpl.delete(studentId2);
                }

            } else if (choice == 3) {
                System.out.println("Please enter the student id:");
                String studentId2= scanner.nextLine();
                studentEnrolmentManagerImpl.delete(studentId2);

            }else if (choice == 4) {
                System.out.println("Please enter the student id:");
                String studentId2= scanner.nextLine();
                System.out.println("Please enter the course id:");
                String courseId2= scanner.nextLine();
                System.out.println(studentEnrolmentManagerImpl.getOne(studentId2, courseId2));

            } else if (choice == 5) {
                System.out.println(Arrays.deepToString(studentEnrolmentManagerImpl.getAll().toArray()));


            } else if (choice == 6) {
                System.out.println("Please enter the student id:");
                String studentId2= scanner.nextLine();
                studentEnrolmentManagerImpl.printCourse(studentId2);

            } else if (choice == 7) {
                System.out.println("Please enter the course id:");
                String courseId2= scanner.nextLine();
                studentEnrolmentManagerImpl.printStudent(courseId2);

            } else if (choice == 8) {
                System.out.println("Please enter the semester:");
                String semester= scanner.nextLine();
                studentEnrolmentManagerImpl.printCourseSemester(semester);

            }


        } while (choice != 9);
        System.out.println("Exit..");
    }
}
