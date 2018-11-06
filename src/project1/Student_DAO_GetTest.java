package project1;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class Student_DAO_GetTest
{
        private static   Student_DAO student_dao = new Student_DAO();
        private static Student student=new Student();
        private static boolean success;
        private static void populateDatabase() {
            student_dao.setup();
            student = new Student(1,"Kuba", "Ostrowski", "Computer Science", 6);
            student_dao.save(student);
            student = new Student(2,"Jacek", "Wilczyński", "Computer Science", 6);
            student_dao.save(student);
            student = new Student(3,"Paweł", "Lis", "Robotics", 4);
            student_dao.save(student);
            student = new Student(4,"Michał", "Jakubiak", "Electrical Engineering", 7);
            student_dao.save(student);
            student = new Student(5,"Konrad", "Bielecki", "Computer Science", 2);
            student_dao.save(student);
    }

    @Before
    public void setup() {
        student_dao = new Student_DAO();
        student_dao.setup();
        populateDatabase();
    }

    @Test
    public void testGet() {
        // setup();
        Student stud=new Student(6,"Andrzej","Test","Electrical Enginering",1);
        student_dao.save(stud);
        Student retref=student_dao.get(stud);
        assertEquals(retref.toString(), stud.toString());
    }
    @Test
    public void testGetPremade() {
        // setup();
        Student retref=student_dao.get(student);
        assertEquals(retref.toString(), student.toString());
    }

    @Test
    public void testNoNumGet() {
        // setup();
        Student stud=new Student("Andrzej","Test","Electrical Enginering",1);
        student_dao.save(stud);
        Student retref=student_dao.get(stud);
        assertEquals(retref.toString(), stud.toString());
    }

    @Test
    public void testGetNoExist()
        // setup();
    {
        Student stud=new Student(17,"Andrzej","Test","Electrical Enginering",1);
        Student retref=student_dao.get(stud);
        assertNull(retref);
    }
    @Test
    public void testGetNullNotInBase()
    // setup();
    {
        Student stud=new Student("Andrzej","Test","Electrical Enginering",1);
        Student retref=student_dao.get(stud);
        assertNull(retref);
    }
}