package com.czg.park;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenzg
 * @date 2019.04.14 12:40
 * @description
 **/
public class ParkPlace {

        private int sCount;
        private int mCount;
        private int lCount;

        public ParkPlace(int sCount, int mCount, int lCount){
            this.sCount = sCount;
            this.mCount = mCount;
            this.lCount = lCount;
        }

        private Map in(String type){
            switch(type) {
                case "S":
                    ;
                case "M":
                    ;
                case "L":
                    ;
                default:
                    ;

            }
            return  new HashMap();
        }

}
