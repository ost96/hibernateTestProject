package project1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Student_DAO {

    protected SessionFactory sessionFactory;
    protected Session session;

    protected void setup() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    protected void exit(){
        sessionFactory.close();
    }

    protected void insertData(){
        Student student = new Student();
        student.setFirstName("Kuba");
        student.setLastname("Ostrowski");
        student.setCourseName("IT");
        student.setSemester(6);

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(student);
            //session.update(student);
            //session.delete(student);
            //Student selectedStudent = (Student) session.get(student.getClass(), student.getSysNum());
            //System.out.println(selectedStudent);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
    }

    public static void main(String[] args){
        Student_DAO student_dao = new Student_DAO();
        student_dao.setup();
        student_dao.insertData();
        student_dao.exit();
    }
}