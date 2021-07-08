package nl.novi.jdemeijervandriel.tailorism.domain;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customerdetails")
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "bank_account")
    private String bankAccount;

    @OneToOne(mappedBy = "customerDetails")
    private File file;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "customerDetails")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "customerDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Order> orders;



    public CustomerDetails(){}

    public CustomerDetails(String firstName, String lastName){}

    public CustomerDetails(String firstName, String lastName, String telephoneNumber, String bankAccount){
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.bankAccount = bankAccount;
    }

    public void setOrders(Set<Order> orders){this.orders = orders;}

    public Set<Order> getOrders() {
        return orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address savedAddress) {
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
