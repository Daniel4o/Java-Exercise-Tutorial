public class SimpleCalculator {
    private double firstNumber;
    private double secondNumber;

public double getFirstNumber() {
    return firstNumber;
}

public double getSecondNumber() {
    return secondNumber;
}

public void setFirstNumber(double firstNumber) {
    this.firstNumber = firstNumber;
}

public  void setSecondNumber(double secondNumber) {
    this.secondNumber= secondNumber;
}

public double getAdditionResult() {
    return this.getFirstNumber() + getSecondNumber();
}

public double getSubtractionResult() {
    return this.getFirstNumber() - getSecondNumber();
}

public double getMultiplicationResult() {
    return this.getFirstNumber() * this.getSecondNumber();
}

public double getDivisionResult() {
    if(secondNumber == 0) return 0;
    return this.getFirstNumber() / this.getSecondNumber();
}
}
