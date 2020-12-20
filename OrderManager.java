package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OrderManager extends InternetOrder {
    private HashMap<String, Order> orderHashMap;

    OrderManager() {
        orderHashMap = new HashMap<>();
    }

    public boolean add(String address, Order order) {
        orderHashMap.put(address, order);
        return true;
    }

    public Order getOrder(String address) {
        return orderHashMap.get(address);
    }

    public boolean delete(String address) {
        orderHashMap.remove(address);
        return true;
    }

    public boolean addItemToOrder(String address, Item item) {
        Order order = getOrder(address);
        if (order == null) {
             order=new InternetOrder();
             order.addItem(item);
             orderHashMap.put(address,order);
        }
        return getOrder(address).addItem(item);
    }

    public Object[] getArrayOfOrders(){
        return orderHashMap.entrySet().toArray();
    }

    public int getSumOfOrders(){
        return orderHashMap.size();
    }

    public Item[] getArrayOfItems(Order order){
      return   order.getArray();
    }

    public int CountOfOrderName(String name){
        int count=0;
        Iterator<Map.Entry<String,Order>> itr= orderHashMap.entrySet().iterator();
        while(itr.hasNext()){
            count+=itr.next().getValue().getItemCount(name);
        }
        return count;
    }
    public void show(){
        for(Map.Entry entry:orderHashMap.entrySet()){
            System.out.println("Адрес: "+entry.getKey()+" Заказ: "+ Arrays.toString(getArrayOfItems((Order) entry.getValue())));
        }
    }
    }


