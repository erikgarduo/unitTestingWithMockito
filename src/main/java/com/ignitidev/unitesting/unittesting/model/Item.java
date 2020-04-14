package com.ignitidev.unitesting.unittesting.model;

public class Item {

  int id;
  String name;
  int price;
  int quantity;

  public Item(int id, String name, int price, int quantity) {
    super();
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public String toString() {
    return String.format("Item[%d, %s, %d, %d]", id, name, price, quantity);
  }

}
