package students;

import java.time.LocalDate;
import java.util.UUID;

public class Student {

    private String id = UUID.randomUUID().toString();
    private String name;
    private String surname;
    private String email;
    private LocalDate birthdate;
    private LocalDate creationDate;

    public Student(String name, String surname, String email, LocalDate birthdate, LocalDate creationDate){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthdate = birthdate;
        this.creationDate = creationDate;
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


    public void setCreationDate(final LocalDate date) {
        this.creationDate = date;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(final LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
