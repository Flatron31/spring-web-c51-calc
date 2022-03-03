package by.tms.entity;

public class Calc {
    private double value1;
    private double value2;
    private String operation;

    public Calc(double value1, double value2, String operation) {
        this.value1 = value1;
        this.value2 = value2;
        this.operation = operation;
    }

    public double getValue1() {
        return value1;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public double getValue2() {
        return value2;
    }

    public void setValue2(double value2) {
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
        return "Calc{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                ", operation='" + operation + '\'' +
                '}';
    }
}
