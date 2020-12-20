package com.company;


import java.util.Collection;

public class Order2Linked {
    private static class Node{
        Order2Linked.Node next;
        Order2Linked.Node prev;
        Item element;
        Node(Item element){
            this.element=element;
        }
    }
    private Node head;
    private Node tail;
    public int size=0;
    public Order2Linked(){
        head=null;
        tail=null;
    }
    public Order2Linked(Collection<Item> collection){
        addAll(collection);
    }
    boolean isEmpty(){
        return head==null;
    }
    public boolean addLast(Item element){
        Node temp=new Node(element);
        if(isEmpty()){
            head=temp;
        }else{
            tail.next=temp;
        }
        temp.prev=tail;
        tail=temp;
        size++;
        return true;
    }
    public void addByIndex(Item data, int index){
        Node temp=head;
        int i=0;
        while(i!=index&&temp!=null){
            temp=temp.next;
            i++;
        }
        Node newNode=new Node(data);
        temp.prev.next=newNode;
        newNode.prev=temp.prev;
        temp.prev=newNode;
        newNode.next=temp;
    }
    public void removeFirst(){
        if(head.next==null) tail=null;
        else head.next.prev=null;
        head=head.next;
    }
    public void removeLast(){
        if(head.next==null) head=null;
        else tail.prev.next=null;
        tail=tail.prev;
    }
    public boolean removeAt(String name){
        Node temp=tail;
        while (!temp.element.getDescription().equals(name)) {
            temp = temp.prev;
            if (temp == null) return false;
        }
        if(temp==head) removeFirst();
        else temp.prev.next=temp.next;
        if(temp==tail) removeLast();
        else temp.next.prev=temp.prev;
        size--;
        return true;
    }
    private void addAll(Collection<Item> collection){
        for(Item item:collection){
            addLast(item);
        }
    }
    public void printList(){
        Node temp = head;
        do {
            System.out.print(temp.element+" ");
            temp=temp.next;
        }while(temp!=null);
    }
    public Item[] toArray (){
        Item[] objects=new Item[size];
        int i=0;
        Node temp=head;
        do{
            objects[i++]=temp.element;
            temp=temp.next;
        }while (temp!=null);
        return objects;
    }
}
