package com.czg.optional;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author chenzg
 * @date 8/2/21 10:07 PM
 * @description
 */
public class OptionalTest {

    public static void main(String[] args) {

        //Optional.of()或者Optional.ofNullable()：创建Optional对象，差别在于of不允许参数是null，而ofNullable则无限制。
        // 参数不能是null
        Optional<Integer> optional1 = Optional.of(1);

        // 参数可以是null
        Optional<Integer> optional2 = Optional.ofNullable(null);

        // 参数可以是非null
        Optional<Integer> optional3 = Optional.ofNullable(2);


        //Optional.empty()：所有null包装成的Optional对象
        Optional<Integer> optional4 = Optional.ofNullable(null);
        Optional<Integer> optional5 = Optional.ofNullable(null);
        System.out.println(optional4 == optional5);// true
        System.out.println(optional5 == Optional.<Integer>empty());// true

        Object o1 = Optional.<Integer>empty();
        Object o2 = Optional.<String>empty();
        System.out.println(o1 == o2);// true

        //isPresent()：判断值是否存在

        Optional<Integer> optional6 = Optional.ofNullable(1);
        Optional<Integer> optional7 = Optional.ofNullable(null);

        // isPresent判断值是否存在
        System.out.println(optional6.isPresent() == true);
        System.out.println(optional7.isPresent() == false);

        //ifPresent(Consumer consumer)：如果option对象保存的值不是null，则调用consumer对象，否则不调用

        Optional<Integer> optional8 = Optional.ofNullable(1);
        Optional<Integer> optional9 = Optional.ofNullable(null);

        // 如果不是null,调用Consumer
        optional8.ifPresent(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println("value is " + t);
            }
        });

        // null,不调用Consumer
        optional9.ifPresent(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println("value is " + t);
            }
        });

        //orElse(value)：如果optional对象保存的值不是null，则返回原来的值，否则返回value

        Optional<Integer> optional10 = Optional.ofNullable(1);
        Optional<Integer> optional11 = Optional.ofNullable(null);

        // orElse
        System.out.println(optional10.orElse(1000) == 1);// true
        System.out.println(optional11.orElse(1000) == 1000);// true

        //orElseGet(Supplier supplier)：功能与orElse一样，只不过orElseGet参数是一个对象

        Optional<Integer> optional12 = Optional.ofNullable(1);
        Optional<Integer> optional13 = Optional.ofNullable(null);

        System.out.println(optional12.orElseGet(() -> {
            return 1000;
        }) == 1);//true

        System.out.println(optional13.orElseGet(() -> {
            return 1000;
        }) == 1000);//true

        //orElseThrow()：值不存在则抛出异常，存在则什么不做，有点类似Guava的Precoditions

        Optional<Integer> optional14 = Optional.ofNullable(1);
        Optional<Integer> optional15 = Optional.ofNullable(null);

        //try
        //{
        //    // 抛出异常
        //    optional14.orElseThrow(()->{throw new IllegalStateException();});
        //}
        //catch(IllegalStateException e )
        //{
        //    e.printStackTrace();
        //}
        //try
        //{
        //    // 抛出异常
        //    optional15.orElseThrow(()->{throw new IllegalStateException();});
        //}
        //catch(IllegalStateException e )
        //{
        //    e.printStackTrace();
        //}

        //filter(Predicate)：判断Optional对象中保存的值是否满足Predicate，并返回新的Optional。

        Optional<Integer> optional16 = Optional.ofNullable(1);
        Optional<Integer> optional17 = Optional.ofNullable(null);

        Optional<Integer> filter1 = optional16.filter((a) -> a == null);
        Optional<Integer> filter2 = optional16.filter((a) -> a == 1);
        Optional<Integer> filter3 = optional17.filter((a) -> a == null);
        System.out.println(filter1.isPresent());// false
        System.out.println(filter2.isPresent());// true
        System.out.println(filter2.get().intValue() == 1);// true
        System.out.println(filter3.isPresent());// false

        //map(Function)：对Optional中保存的值进行函数运算，并返回新的Optional(可以是任何类型)

        Optional<Integer> optional18 = Optional.ofNullable(1);
        Optional<Integer> optional19 = Optional.ofNullable(null);

        Optional<String> str1Optional = optional18.map((a) -> "key" + a);
        Optional<String> str2Optional = optional19.map((a) -> "key" + a);

        System.out.println(str1Optional.get());// key1
        System.out.println(str2Optional.isPresent());// false
        //flatMap()：功能与map()相似，差别请看如下代码。
        // flatMap方法与map方法类似，区别在于mapping函数的返回值不同。
        // map方法的mapping函数返回值可以是任何类型T，而flatMap方法的mapping函数必须是Optional。

        Optional<Integer> optional20 = Optional.ofNullable(1);

        Optional<Optional<String>> strOptional1 = optional20.map((a) -> {
            return Optional.<String>of("key" + a);
        });

        Optional<String> strOptional2 = optional20.flatMap((a) -> {
            return Optional.<String>of("key" + a);
        });

        System.out.println(strOptional1.get().get());// key1
        System.out.println(strOptional2.get());// key1
    }
}
