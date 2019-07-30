package com.coolopool.coolopool.Class;

public class CartItem {

    public static int counter = 1;

    String type;
    String item;
    int cost;
    String current_count;

    public CartItem(String type, String item, int cost) {
        this.type = type;
        this.item = item;
        this.cost = cost;
        this.current_count = ""+CartItem.counter;
        CartItem.counter ++;
    }


    public String getDetails(){
        return type+" | "+item;
    }

    public int getCost() {
        return cost;
    }

    public String getCurrent_count() {
        return current_count;
    }
}
