package com.company;


import java.util.Arrays;

public class test {
    public static void main(String[] args){
        Item dish1=new Dish(1000,"Рыба","Фарель");
        Item dish2=new Dish(450,"Рыба","Треска");
        Item dish3=new Dish(1000,"Рыба","Фарель");
        Item drink1=new Drink(200,"коктейль","молочный");
        Item drink2=new Drink(500,"коктейль","клубничный");
        Order order1=new InternetOrder();
        order1.addItem(dish1);
        order1.addItem(drink1);
        Order order2=new InternetOrder();
        order2.addItem(dish2);
        order2.addItem(drink2);
        OrderManager orderManager=new OrderManager();
        orderManager.add("Москва",order1);
        orderManager.add("Москва",order2);
        orderManager.addItemToOrder("Москва",dish3);
        System.out.println(orderManager.CountOfOrderName("Рыба"));
        orderManager.show();
    }
}
