package com.company;
import java.util.*;
import java.io.*;
public class StudentEnrolmentManagerImpl implements StudentEnrolmentManager{
    HashSet<StudentEnrolment> studentEnrolmentList = new HashSet<StudentEnrolment>();


    public void openCSV(String filename){
        try {
            String line = "";
            BufferedReader buffer = new BufferedReader(new FileReader(filename));
            while ((line = buffer.readLine()) != null)
            {
                String[] tempStuEnlList = line.split(",");
                Student student = new Student(tempStuEnlList[0],tempStuEnlList[1],tempStuEnlList[2]);
                Course course = new Course(tempStuEnlList[3],tempStuEnlList[4],tempStuEnlList[5]);
                String studentSemester = tempStuEnlList[6];
                StudentEnrolment studentEnrolment = new StudentEnrolment(student,course,studentSemester);
                studentEnrolmentList.add(studentEnrolment);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter student id");
        String studentId = scanner.nextLine();
        System.out.println("Please enter student name");
        String studentName = scanner.nextLine();
        System.out.println("Please enter student birth date");
        String studentBd = scanner.nextLine();
        Student student = new Student(studentId,studentName,studentBd);
        System.out.println("Please enter course id");
        String courseId = scanner.nextLine();
        System.out.println("Please enter course name");
        String courseName = scanner.nextLine();
        System.out.println("Please enter course credit");
        String courseCredit = scanner.nextLine();
        Course course = new Course(courseId,courseName,courseCredit);
        System.out.println("Please enter student semester");
        String studentSemester = scanner.nextLine();
        StudentEnrolment studentEnrolment = new StudentEnrolment(student, course,studentSemester);
        studentEnrolmentList.add(studentEnrolment);
        System.out.println("Student enrolled successfully");
        System.out.println(studentEnrolmentList);
        Iterator<StudentEnrolment> it = studentEnrolmentList.iterator();
        System.out.println(it.next().course.name);

    }

    @Override
    public void printCourse(String studentId){
        System.out.println("List of already enrolled courses:");
        Iterator<StudentEnrolment> it = studentEnrolmentList.iterator();
        System.out.println(it.next().student.name);
        while(it.hasNext()) {
            StudentEnrolment currentStdEnl = it.next();
            if (currentStdEnl.student.id.equals(studentId)){
                System.out.println(currentStdEnl.course.id + " " + currentStdEnl.course.name);
            }
        }

    }
    public void update(String studentId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the id of the course you want to add");
        String courseId = scanner.nextLine();
        System.out.println("Please enter the name of the course you want to add");
        String courseName = scanner.nextLine();
        System.out.println("Please enter the number of credit of the course you want to add");
        String courseCredit = scanner.nextLine();
        System.out.println("Please enter the semester of the course you want to add");
        String courseSemester = scanner.nextLine();
        Course course = new Course(courseId,courseName,courseCredit);

        String studentName= "x";
        String studentBd= "x";
        Student student = null;

        for (StudentEnrolment element : studentEnrolmentList) {
            if (element.student.id.equals(studentId)){
                studentName = element.student.name;
                studentBd = element.student.birthdate;
                student = new Student(studentId,studentName,studentBd);
                break;
            }
        }
        StudentEnrolment studentEnrolment = new StudentEnrolment(student,course,courseSemester);
        studentEnrolmentList.add(studentEnrolment);
        System.out.println("New course enrolled successfully");

    }

    @Override
    public void delete(String studentId) {
        Scanner scanner = new Scanner(System.in);
        StudentEnrolment holder = null;
        System.out.println("Please enter the id of the course you want to add");
        String courseId = scanner.nextLine();
        for (StudentEnrolment element : studentEnrolmentList) {
            if (element.student.id.equals(studentId)){
                if (element.course.id.equals(courseId)){
                    holder = element;
                }
            }
        }
        studentEnrolmentList.remove(holder);
        System.out.println("Course not found");

    }

    @Override
    public StudentEnrolment getOne(String studentId, String courseId) {
        for (StudentEnrolment element : studentEnrolmentList) {
            if (element.student.id.equals(studentId)){
                if (element.course.id.equals(courseId)){
                    return element;
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<StudentEnrolment> getAll() {
        ArrayList<StudentEnrolment> Enrolments = new ArrayList<StudentEnrolment>();
        for (StudentEnrolment element : studentEnrolmentList) {
            Enrolments.add(element);
        }
        return Enrolments;
    }
    @Override
    public void printStudent(String courseId){
        for (StudentEnrolment element : studentEnrolmentList) {
            if (element.course.id.equals(courseId)){
                System.out.println(element.student.id + " " + element.student.name);
            }
        }

    }

    @Override
    public void printCourseSemester(String semester){
        for (StudentEnrolment element : studentEnrolmentList) {
            if (element.semester.equals(semester)){
                System.out.println(element.course.id + " " + element.course.name);
            }
        }

    }
}
