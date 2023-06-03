package model.person;

public class Customer extends Person {
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String codePerson, String namePerson, String dateOfBirth, String gender, String identityCard, String phoneNumber, String email, String customerType, String address) {
        super(codePerson, namePerson, dateOfBirth, gender, identityCard, phoneNumber, email);
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() +
                "customerType='" + customerType + '\'' +
                ", address='" + address;
    }
}
