package org.example.catsgram.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping("/demo")
    public String demoEndPoint() {
        return "hello from demo";
    }

}
class Item {

    private String itemName;
    private int id;

    public Item(String itemName, int id) {
        this.itemName = itemName;
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
