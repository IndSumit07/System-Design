package Tomato.models;

import java.util.*;

public class Menu {
    private final List<MenuItem> items;

    public Menu(){
        items = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item){
        items.add(item);
    }

    public List<MenuItem> getMenuItems(){
        return new ArrayList<>(items);
    }

    public void removeMenuItem(MenuItem item){
        items.remove(item);
    }

    public MenuItem findItemByCode(String code) {
        for (MenuItem item : items) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }
}
