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

    protected boolean save(Student student) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            if (session != null)
                session.close();
        }
    }

    protected Student get(Student student) {
        Student selectedStudent = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            selectedStudent = session.get(student.getClass(), student.getSysNum());
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return selectedStudent;
    }

    protected boolean update(Student student) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            if (session != null)
                session.close();
        }
    }

    protected boolean delete(Student student) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (session.getTransaction() != null)
                session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            if (session != null)
                session.close();
        }
    }

    public static void main(String[] args) {
        Student_DAO student_dao = new Student_DAO();
        student_dao.setup();
        Student student = new Student(0, "Kuba", "Ostrowski", "IT", 6);
        Student selectedStudent = student_dao.get(student);
        System.out.println(selectedStudent);
        student_dao.exit();
    }
}