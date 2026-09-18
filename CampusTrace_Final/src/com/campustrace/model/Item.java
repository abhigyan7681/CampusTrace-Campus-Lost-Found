package com.campustrace.model;

public class Item {
    private int itemId;
    private ItemType type;
    private String name;
    private String category;
    private String location;
    private String date;
    private String description;
    private ItemStatus status;

    public Item(int itemId, ItemType type, String name, String category,
                String location, String date, String description,
                ItemStatus status) {
        this.itemId = itemId;
        this.type = type;
        this.name = name;
        this.category = category;
        this.location = location;
        this.date = date;
        this.description = description;
        this.status = status;
    }

    public int getItemId() { return itemId; }
    public ItemType getType() { return type; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getLocation() { return location; }
    public String getDate() { return date; }
    public String getDescription() { return description; }
    public ItemStatus getStatus() { return status; }
    public void setStatus(ItemStatus status) { this.status = status; }

    public String toString() {
        return "Item{id=" + itemId + ", type=" + type
                + ", name='" + name + "', category='" + category
                + "', location='" + location + "', date='" + date
                + "', status=" + status + ", description='" + description + "'}";
    }
}
