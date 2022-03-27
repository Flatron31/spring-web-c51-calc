package by.tms.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "operations")
public class Operation {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty (message = "Value should not be empty")
    @NotNull (message = "Value cannot be null")
    @Pattern(regexp = "^[-+]?[0-9]*[.,]?[0-9]+(?:[eE][-+]?[0-9]+)?$", message = "\n" +
            "Invalid value")
    private String value1;

    @NotEmpty (message = "Value should not be empty")
    @NotNull (message = "Value cannot be null")
    @Pattern(regexp = "^[-+]?[0-9]*[.,]?[0-9]+(?:[eE][-+]?[0-9]+)?$", message = "\n" +
            "Invalid value")
    private String value2;

    @NotEmpty
    @NotNull (message = "Operation cannot be null")
    private String operation;

    private double result;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    public User getUser() {
        return user;
    }

    public Operation() {
    }

    public Operation(String value1, String value2, String operation) {
        this.value1 = value1;
        this.value2 = value2;
        this.operation = operation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                ", operation='" + operation + '\'' +
                ", result=" + result +
                '}';
    }
}
