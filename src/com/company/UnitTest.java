package com.company;
import static org.junit.Assert.*;
import java.io.*;
import java.util.Scanner;

import org.junit.*;

public class UnitTest {
    public static StudentEnrolmentManagerImpl tester = new StudentEnrolmentManagerImpl();
    InputStream sysInBackup = System.in;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Before class");
    }

    @Before
    public void setUpBeforeMethod() throws Exception {
        System.out.println("Before each method");
    }

    @AfterClass
    public static void setUpAfterClass() throws Exception {
        System.out.println("After class");
    }

    @After
    public void setUpAfterMethod() throws Exception {
        System.out.println("After each method");
    }

    @Test
    public void testOpenCSV(){
        System.out.println("Test if data from file is written into hashset or not");
        String sampleFile = "data.csv";
        tester.openCSV(sampleFile);
        assertTrue(!tester.studentEnrolmentList.isEmpty());
    }

    @Test
    public void testAdd(){
        int iniSize = tester.studentEnrolmentList.size();
        tester.add();
        assertTrue(tester.studentEnrolmentList.size() > iniSize);
    }

    @Test
    public void testPrintCourse(){
        try {
            String sampleStudentId = "S101312";
            tester.printCourse(sampleStudentId);
        } catch(Exception e) {
            fail("Shouldn't have thrown any exception");
        }
    }

    @Test
    public void testUpdate(){
        int iniSize = tester.studentEnrolmentList.size();
        String sampleStudentId = "S101312";
        tester.update("S101312");
        assertTrue(tester.studentEnrolmentList.size() > iniSize);
    }

    @Test
    public void testDelete(){
        int iniSize= tester.studentEnrolmentList.size();
        String sampleStudentId = "S101312";
        tester.delete("S101312");
        assertTrue(tester.studentEnrolmentList.size() < iniSize);
    }

    @Test
    public void testGetOne(){
        tester.add();
        assertTrue(!tester.studentEnrolmentList.isEmpty());
    }

    @Test
    public void testGetAll(){
        tester.add();
        assertTrue(!tester.studentEnrolmentList.isEmpty());
    }

    @Test
    public void testPrintStudent(){
        try {
            String sampleCourseId = "COSC4340";
            tester.printCourse(sampleCourseId);
        } catch(Exception e) {
            fail("Shouldn't have thrown any exception");
        }
    }

    @Test
    public void testPrintCourseSemester(){
        try {
            String sampleSemester = "2021A";
            tester.printCourseSemester(sampleSemester);
        } catch(Exception e) {
            fail("Shouldn't have thrown any exception");
        }
    }
}
