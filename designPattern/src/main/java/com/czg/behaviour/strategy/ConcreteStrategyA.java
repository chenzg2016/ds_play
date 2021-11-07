package com.czg.behaviour.strategy;

/**
 * @author chenzg
 * @date 2020-05-21 10:35
 * @description
 */
public class ConcreteStrategyA implements Strategy{

    @Override
    public void strategyMethod() {
        System.out.println("具体策略A的策略方法被访问！");
    }
}
