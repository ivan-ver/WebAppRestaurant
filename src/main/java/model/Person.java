package model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "person", schema = "public")
public class Person extends AbstractBaseEntity {

    private String email;
    private String person_name;
    private String password;
    private String status;
    private List<Assessment> assessments;

    public Person(int id, String email, String user_name, String password, String status) {
        super(id);
        this.email = email;
        this.person_name = user_name;
        this.password = password;
        this.status = status;
    }

    public Person() { }

    @Basic
    @Column(name = "email")
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "person_name")
    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String name) {
        this.person_name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }
}
