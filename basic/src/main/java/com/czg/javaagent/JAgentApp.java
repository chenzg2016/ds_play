package com.czg.javaagent;

import java.lang.instrument.Instrumentation;

/**
 * @author chenzg
 * @date 2019.04.10 11:05
 * @description
 **/
public class JAgentApp {
    /**
     * 该方法在main方法之前运行，与main方法运行在同一个JVM中
     * 并被同一个System ClassLoader装载
     * 被统一的安全策略(security policy)和上下文(context)管理
     *
     * @param agentOps
     * @param inst
     */
    public static void  premain(String agentOps,Instrumentation inst){

        System.out.println("====premain 方法执行");
        System.out.println(agentOps);
    }

    /**
     * 如果不存在 premain(String agentOps, Instrumentation inst)
     * 则会执行 premain(String agentOps)
     *
     * @param agentOps
     */
    public static void premain(String agentOps){

        System.out.println("====premain方法执行2====");
        System.out.println(agentOps);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub


    }
}
