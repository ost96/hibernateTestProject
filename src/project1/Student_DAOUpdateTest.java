package project1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Student_DAOUpdateTest {

    private static Student_DAO student_dao;
    private static Student student;
    private boolean success;

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

    @BeforeClass
    public static void setup() {
        student_dao = new Student_DAO();
        student_dao.setup();
        populateDatabase();
    }

    @Test
    public void testUpdate_noSysNum() {
        student = new Student("Marcin", "Testowy", "IT", 1);
        success = student_dao.update(student);
        // should not work, to update data sysNum is required
        assertFalse(success);
    }

    @Test
    public void testUpdate_notExistingSysNum() {
        student = new Student(7, "Marcin", "Testowy", "IT", 1);
        success = student_dao.update(student);
        // should not work, existing sysNum is required
        assertFalse(success);
    }

    @Test
    public void testUpdate_negativeSysNum() {
        student = new Student(-1, "Marcin", "Testowy", "IT", 1);
        success = student_dao.update(student);
        // should not work, because ther won't be negative sysNums in database
        assertFalse(success);
    }

    @Test
    public void testUpdate_validNullableData() {
        student = new Student("Marcin", "Testowy");
        success = student_dao.update(student);
        // should not work, because there is no sysNum given
        assertFalse(success);
    }

    @Test
    public void testUpdate_invalidNullableData() {
        student = new Student();
        success = student_dao.update(student);
        // shouldn't work, because the 'first_name' and 'last_name' columns can't be null
        assertFalse(success);
    }

    @Test
    public void testUpdate_validDataAllFields() {
        student = new Student(6, "Marcin", "Testowy", "IT", 1);
        student_dao.save(student); //assumption that save method is working correctly
        success = student_dao.update(student);
        if (success)
            student_dao.delete(student);
        // should work
        assertTrue(success);
    }

    @AfterClass
    public static void teardown() {
        student_dao.exit();
    }
}
