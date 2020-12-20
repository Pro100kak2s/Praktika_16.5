package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class RestaurantOrder implements Order {
    public Order2Linked list;
    public RestaurantOrder(){
        list=new Order2Linked();
    }
    public RestaurantOrder(Collection<Item> collection){
        list=new Order2Linked(collection);
    }
    public boolean addItem(Item item){
        return list.addLast(item);
    }
    public int getCountOfOrders(){
        return list.size;
    }
    public boolean delete(String name){
        list.removeAt(name);
        return true;
    }
    public int deleteAll(String name){
        int c=0;
        while(list.removeAt(name)){
            c++;
        }
        return c;
    }
    public Item[] getArray(){
        return (Item[]) list.toArray();
    }
    public void show(){
        list.printList();
    }
    public int getSumOfPrice() {
        int cost = 0;
        for (Item item : list.toArray()) {
            cost+= item.getPrice();
        }
        return cost;
    }
    public Object[] getArrayOfItemsName(){
        HashSet names=new HashSet<>();
        for(Item item:list.toArray()){
            names.add(item.getDescription());
        }
        return  names.toArray();
    }
    public int getItemCount(String name){
        int count=0;
        for(Item item:list.toArray()){
            if(item.getName().equals(name)){
                count++;
            }
        }
        return count;
    }
    public Object[] sortedOrderByCost(){
        return  Arrays.stream(list.toArray()).sorted((i1, i2) -> (int)(i2.getPrice()-i1.getPrice())).toArray();
    }
}
