package by.tms.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class Operation {
    @NotEmpty (message = "Value should not be empty")
    @NotBlank
    @NotNull (message = "Value cannot be null")
    private Double value1;

    @NotEmpty (message = "Value should not be empty")
    @NotBlank
    @NotNull (message = "Value cannot be null")
    private Double value2;

    @NotEmpty
    @NotNull (message = "Operation cannot be null")
    private String operation;

    public Operation(Double value1, Double value2, String operation) {
        this.value1 = value1;
        this.value2 = value2;
        this.operation = operation;
    }

    public Double getValue1() {
        return value1;
    }

    public void setValue1(Double value1) {
        this.value1 = value1;
    }

    public Double getValue2() {
        return value2;
    }

    public void setValue2(Double value2) {
        this.value2 = value2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                ", operation='" + operation + '\'' +
                '}';
    }
}
