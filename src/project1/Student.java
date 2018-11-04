package project1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @Column(name="sys_num")
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private int sysNum;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="course_name")
    private String courseName;

    @Column(name="semester")
    private int semester;

    public int getSysNum() {
        return sysNum;
    }

    public void setSyNum(int sysNum) {
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
        return "sys_num: " + sysNum + ", firstName: " + firstName + ", lastName: " + lastName + ", courseName: " + courseName + ", semester: " + semester + "\n";
    }
}
