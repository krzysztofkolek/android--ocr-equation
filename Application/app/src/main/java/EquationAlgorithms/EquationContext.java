package EquationAlgorithms;

public class EquationContext {

    EquationStrategy strategy = null;

    public EquationContext(EquationStrategy strategy) {
        this.strategy = strategy;
    }

    public double getResult() {
        strategy.preprocess();
        return strategy.getResult();
    }
}
