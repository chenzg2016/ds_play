package com.czg.container;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

public class ListAndSetCompareTest {



        private static final int totalCount = 1000000000;

//        static List<UserCompositeTypeEnum> listStr = Lists.newArrayList(UserCompositeTypeEnum.SHOP,
//                UserCompositeTypeEnum.SELLER, UserCompositeTypeEnum.HSP, UserCompositeTypeEnum.ADMIN);
//
//        static Set<UserCompositeTypeEnum> setStr = Sets.newHashSet(UserCompositeTypeEnum.SHOP,
//                UserCompositeTypeEnum.SELLER, UserCompositeTypeEnum.HSP, UserCompositeTypeEnum.ADMIN);

        static List list = Lists.newLinkedList();

        static Set set = Sets.newHashSet();

        public static void main(String[] args) {
//        init();
            long start2 = System.currentTimeMillis();
            for (int i = 0; i < totalCount; i++) {
            testSet();
//                testCompositeSet();
            }
            long end2 = System.currentTimeMillis();
            System.out.println("set测试:" + (end2 - start2) + "");

            long start = System.currentTimeMillis();
            for (int k = 0; k < totalCount; k++) {
            testList();
//                testCompositelist();
            }

            long end = System.currentTimeMillis();
            System.out.println("list测试:" + (end - start + ""));
        }

//        public static int testCompositelist() {
//            if (listStr.contains(UserCompositeTypeEnum.ADMIN)) {
//                return UserCompositeTypeEnum.ADMIN.getCode();
//            }
//            return 1;
//        }
//
//        public static int testCompositeSet() {
//            if (setStr.contains(UserCompositeTypeEnum.ADMIN)) {
//                return UserCompositeTypeEnum.ADMIN.getCode();
//            }
//            return 1;
//        }

        public static int testList() {
            if (list.contains(2)) {
                return 2;
            }
            return 1;
        }

        public static int testSet() {
            if (set.contains(3)) {
                return 3;
            }
            return 1;
        }
        public static void init() {
            long start0 = System.currentTimeMillis();
            for (int m = 0; m < totalCount; m++) {
                list.add(m);
            }
            long end0 = System.currentTimeMillis();
            System.out.println("set init cost:" + (end0 - start0) + "ms");

            long start1 = System.currentTimeMillis();
            for (int n = 0; n < totalCount; n++) {
                set.add(n);
            }
            long end1 = System.currentTimeMillis();
            System.out.println("list init cost:" + (end1 - start1) + "ms");

        }

}
