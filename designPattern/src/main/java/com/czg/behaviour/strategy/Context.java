package com.czg.behaviour.strategy;

/**
 * @author chenzg
 * @date 2020-05-21 10:37
 * @description
 */
public class Context {

    private Strategy strategy;


    public Strategy getStrategy(){

        return strategy;
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }


    public void strategyMethod(){
        strategy.strategyMethod();
    }
}
