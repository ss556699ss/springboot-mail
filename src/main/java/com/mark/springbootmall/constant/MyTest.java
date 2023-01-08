package com.mark.springbootmall.constant;

import java.time.Instant;

public class MyTest {
    public static void main(String[] args) {
        ProductCategory category = ProductCategory.FOOD;
        String s = category.name();
        System.out.println(s);

        String s2 = "CAR";
        ProductCategory category2 = ProductCategory.valueOf(s2);
        System.out.println(category2);

        Instant in1 = Instant.now();
        Instant in2 = Instant.ofEpochSecond(1593439200L);
        System.out.println("in1:"+in1);
        System.out.println("in2:"+in2);


    }
}
