package com.company;

public interface Order {
    boolean addItem(Item item);
    boolean delete(String name);
    int deleteAll(String name);
    int getCountOfOrders();
    Item[] getArray();
    int getSumOfPrice();
    int getItemCount(String name);
    Object[] getArrayOfItemsName();
    Object[] sortedOrderByCost();
}
