package com.czg.behaviour.strategy;

/**
 * @author chenzg
 * @date 2020-05-21 10:35
 * @description
 */
public class StrategyPattern {

    public static void main(String[] args) {
        Context context = new Context();
        Strategy a = new ConcreteStrategyA();
        context.setStrategy(a);
        a.strategyMethod();

        Strategy b = new ConcreteStrategyB();
        context.setStrategy(b);
        b.strategyMethod();
    }

}
