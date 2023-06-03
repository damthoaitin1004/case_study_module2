package model.person;

import java.util.Objects;

public abstract class Person {
    private String codePerson;
    private String namePerson;
    private String dateOfBirth;
    private String gender;
    private String identityCard;
    private String phoneNumber;
    private String email;

    public Person() {

    }

    public Person(String codePerson, String namePerson, String dateOfBirth, String gender, String identityCard, String phoneNumber, String email) {
        this.codePerson = codePerson;
        this.namePerson = namePerson;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.identityCard = identityCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getCodePerson() {
        return codePerson;
    }

    public void setCodePerson(String codePerson) {
        this.codePerson = codePerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String isGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getCodePerson().equals(person.getCodePerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodePerson());
    }

    @Override
    public String toString() {
        return
                "codePerson='" + codePerson + '\'' +
                        ", namePerson='" + namePerson + '\'' +
                        ", dateOfBirth='" + dateOfBirth + '\'' +
                        ", gender=" + gender +
                        ", identityCard=" + identityCard +
                        ", phoneNumber=" + phoneNumber +
                        ", email='" + email;
    }

}
