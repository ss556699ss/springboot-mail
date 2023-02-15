package com.mark.springbootmall.constant;

import java.time.Instant;

public class MyTest {
    public static void main(String[] args) {

        //轉string
        ProductCategory category = ProductCategory.FOOD;
        String s = category.name();
        System.out.println(s);

        //去查詢有沒有CAR
        String s2 = "CAR";
        ProductCategory category2 = ProductCategory.valueOf(s2);
        System.out.println(category2);



    }
}
