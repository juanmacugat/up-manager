package students;

import java.util.Date;
import java.util.UUID;

public class Student {

    private String id = UUID.randomUUID().toString();
    private String name;
    private String surname;
    private String email;
    private Date birthday;
    private Date creation_date;

    public Student(String name, String surname, String email, Date birthday, Date creationDate){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.creation_date = creationDate;
    }

    public Student() {

    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setBirthday(final Date birthday) {
        this.birthday = birthday;
    }

    public void setCreation_date(final Date creation) {
        this.creation_date = creation;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
