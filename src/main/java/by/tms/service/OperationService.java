package by.tms.service;

import by.tms.entity.Operation;

public class OperationService {

    public static Double getResultOperation(Operation operation) {
        Double result = 0.0;
        Double value1 = operation.getValue1();
        Double value2 = operation.getValue2();
        String operation1 = operation.getOperation();
        switch (operation1) {
            case "sum":
                result = value1 + value2;
                break;
            case "dif":
                result = value1 - value2;
                break;
            case "mult":
                result = value1 * value2;
                break;
            case "div":
                result = value1 / value2;
                break;
        }
        return result;
    }

}
