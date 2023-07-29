package core.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "`User`")
public class User extends BaseEntityModel {

    @Column(name = "`FirstName`")
    private String firstName;
    @Column(name = "`LastName")
    private String lastName;
    @Column(name = "`Age`")
    private Integer age;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public User(){};
    public User(String firstName,String lastName, Integer age)
    {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }
}
