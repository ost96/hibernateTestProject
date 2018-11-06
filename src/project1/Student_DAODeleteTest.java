package project1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Student_DAODeleteTest {
        private static boolean succes;
        private static   Student_DAO student_dao = new Student_DAO();
        private static Student student=new Student();
        private static Student arbStudRef;
        private static void populateDatabase() {
            student_dao.setup();
            student = new Student(1,"Kuba", "Ostrowski", "Computer Science", 6);
            student_dao.save(student);
            student = new Student(2,"Jacek", "Wilczyński", "Computer Science", 6);
            student_dao.save(student);
            arbStudRef=student;
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
         public  void testSySnDelete(){
            succes=student_dao.delete(arbStudRef);
            assert(succes);
            assertNull(student_dao.get(arbStudRef));
        }
    @Test
    public  void testDelNoExist(){
        succes=student_dao.delete(new Student());
        assertFalse(succes);
    }
    @Test
    public  void testDelWrongNum(){
        succes=student_dao.delete(new Student(14,"Konrad", "Bielecki", "Computer Science", 2));
        assertFalse(succes);
    }
}