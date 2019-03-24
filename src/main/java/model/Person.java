package model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.*;

@Entity
@NamedQueries({
        @NamedQuery(name = Person.BY_EMAIL, query = "FROM Person WHERE email = :email"),
})
@Table(name = "person", schema = "public")
public class Person extends AbstractBaseEntity {

    public static final String BY_EMAIL = "Person.getByEmail";

    private String email;
    private String person_name;
    private String password;
    private String status;
    private Set<Assessment> assessments;
    private boolean enabled = true;


    public Person(int id, String email, String person_name, String password, String status, Set<Assessment> assessments, boolean enabled) {
        super(id);
        this.email = email;
        this.person_name = person_name;
        this.password = password;
        this.status = status;
        this.assessments = assessments;
        this.enabled = enabled;
    }

    public Person(String email, String person_name, String password, String status, Set<Assessment> assessments, boolean enabled) {
        this.email = email;
        this.person_name = person_name;
        this.password = password;
        this.status = status;
        this.assessments = assessments;
        this.enabled = enabled;
    }

    public Person() { }

    @Basic
    @Column(name = "email", unique = true)
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
    @JsonIgnore
    public Set<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(Set<Assessment> assessments) {
        this.assessments = assessments;
    }

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                ", person_name='" + person_name + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", assessments=" + assessments +
                ", enabled=" + enabled +
                '}';
    }
}
