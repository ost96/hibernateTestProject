package project1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Student_DAOSaveTest {
    private static Student_DAO student_dao;
    private Student student;
    private boolean success;

    @BeforeClass
    public static void setup() {
        student_dao = new Student_DAO();
        student_dao.setup();
    }

    @Test
    public void testSave_validData() {
        student = new Student(1, "Kuba", "Ostrowski", "IT", 6);
        success = student_dao.save(student);
        assertTrue(success);
    }

    @Test
    public void testSave_invalidSysNum() {
        student = new Student(0, "Kuba", "Ostrowski", "IT", 6);
        success = student_dao.save(student);
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
