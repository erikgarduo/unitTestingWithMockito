package com.ignitidev.unitesting.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ignitidev.unitesting.unittesting.model.Item;

@RestController
public class ItemController {

  @GetMapping("/dummy-item")
  public Item itemDummy() {
    return new Item(1, "Ball", 10, 100);
  }
}
