package com.czg.dubbo.loadbanlance;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chenzg
 * @date 9/30/21 10:11 AM
 * @description
 *
 * 加权轮循均衡算法
 */
public class RoundRobinLoadBalance {



    public static void main(String[] args) throws IOException {
        //默认invoker{"1":"1","2":"2","3":"3","4","4"}
        //循环调用1000次的结果
        for(int i = 0; i < 1000; i ++){
            int mod = i % 10;
            Map<String,IntegerWrapper> invokerToWeightMap = new LinkedHashMap<String, IntegerWrapper>();
            invokerToWeightMap.put("1", new IntegerWrapper(1));
            invokerToWeightMap.put("2", new IntegerWrapper(2));
            invokerToWeightMap.put("3", new IntegerWrapper(3));
            invokerToWeightMap.put("4", new IntegerWrapper(4));
            for (int j = 0; j < 4; j++) {
                //遍历invoker的数量
                for (Map.Entry<String, IntegerWrapper> each : invokerToWeightMap.entrySet()) {
                    final String k = each.getKey();
                    //invoker的权重
                    final IntegerWrapper v = each.getValue();
                    //通过 (i+1) *  invokerToWeightMap.size轮获取invoker
                    if (mod == 0 && v.getValue() > 0) {
                        System.out.println("服务："+k);
                        return ;
                    }
                    if (v.getValue() > 0) {
                        //当前invoker的可调用次数减1
                        v.decrement();
                        mod--;
                    }
                }
            }
        }
    }

    private static final class IntegerWrapper {
        private int value;

        public IntegerWrapper(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void decrement() {
            this.value--;
        }
    }
}
