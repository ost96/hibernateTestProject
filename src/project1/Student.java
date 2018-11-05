package project1;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="sys_num", nullable = false)
    private int sysNum;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="course_name")
    private String courseName;

    @Column(name="semester")
    private int semester;

    public Student() {}

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName, String courseName, int semester) {
        this(firstName, lastName);
        this.courseName = courseName;
        this.semester = semester;
    }

    public Student(int sysNum, String firstName, String lastName, String courseName, int semester) {
        this(firstName, lastName, courseName, semester);
        this.sysNum = sysNum;
    }

    public int getSysNum() {
        return sysNum;
    }

    public void setSysNum(int sysNum) {
        this.sysNum = sysNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "sys_num: " + sysNum + ", firstName: " + firstName + ", lastName: " + lastName + ", courseName: " + courseName + ", semester: " + semester;
    }
}
