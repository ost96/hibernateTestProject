package project1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Student_DAOTest {
    private static Student_DAO student_dao;
    private static Student student;
    private boolean success;

    @BeforeClass
    public static void setup() {
        student_dao = new Student_DAO();
        student_dao.setup();
        populateDatabase();
    }

    private static void populateDatabase() {
        student_dao = new Student_DAO();
        student_dao.setup();
        student = new Student("Kuba", "Ostrowski", "Computer Science", 6);
        student_dao.save(student);
        student = new Student("Jacek", "Wilczyński", "Computer Science", 6);
        student_dao.save(student);
        student = new Student("Paweł", "Lis", "Robotics", 4);
        student_dao.save(student);
        student = new Student("Michał", "Jakubiak", "Electrical Engineering", 7);
        student_dao.save(student);
        student = new Student("Konrad", "Bielecki", "Computer Science", 2);
        student_dao.save(student);
    }

    @Test
    public void testSave_noSysNum() {
        student = new Student("Marcin", "Testowy", "IT", 1);
        success = student_dao.save(student);
        // should work
        assertTrue(success);
    }

    @Test
    public void testSave_uniqueSysNum() {
        student = new Student(7, "Marcin", "Testowy", "IT", 1);
        success = student_dao.save(student);
        // should work
        assertTrue(success);
    }

    @Test
    public void testSave_duplicateSysNum() {
        student = new Student(1, "Marcin", "Testowy", "IT", 1);
        success = student_dao.save(student);
        // should work, because the sysNum is generated automatically anyway
        assertTrue(success);
    }

    @Test
    public void testSave_negativeSysNum() {
        student = new Student(-1, "Marcin", "Testowy", "IT", 1);
        success = student_dao.save(student);
        // should work, because the sysNum is generated automatically anyway
        assertTrue(success);
    }

    @Test
    public void testSave_validNullableData() {
        student = new Student("Marcin", "Testowy");
        success = student_dao.save(student);
        // should work, because 'course_name' and 'semester' columns can be null
        assertTrue(success);
    }

    @Test
    public void testSave_invalidNullableData() {
        student = new Student();
        success = student_dao.save(student);
        // shouldn't work, because the 'first_name' and 'last_name' columns can't be null
        assertFalse(success);
    }

    @After
    public void cleanup() {
        if (success)
            student_dao.delete(student);
        success = false;
    }

    @AfterClass
    public static void teardown() {
        student_dao.exit();
    }
}
