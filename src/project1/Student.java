package project1;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
    private String semester;

    public int getSysNum() {
        return sysNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(isAlpha(firstName)){
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastname(String lastName) {
        if(isAlpha(lastName)){
            this.lastName = lastName;
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if(isAlpha(courseName)){
            this.courseName = courseName;
        }
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        if(semester.matches("[0-9]+")){
            int result = Integer.parseInt(semester);
            if(result > 0 && result < 11){
                String semester2 = Integer.toString(result);
                this.semester = semester2;
            }
        }
    }

    private boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    @Override
    public String toString() {
        return "sys_num: " + sysNum + ", firstName: " + firstName + ", lastName: " + lastName + ", courseName: " + courseName + ", semester: " + semester + "\n";
    }
}
