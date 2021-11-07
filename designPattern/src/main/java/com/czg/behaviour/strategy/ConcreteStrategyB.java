package com.czg.behaviour.strategy;

/**
 * @author chenzg
 * @date 2020-05-21 10:35
 * @description
 */
public class ConcreteStrategyB implements Strategy{

    @Override
    public void strategyMethod() {
        System.out.println("具体策略B的策略方法被访问！");
    }
}
