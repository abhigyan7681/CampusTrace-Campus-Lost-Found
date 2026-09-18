package com.campustrace.repository;

import com.campustrace.model.*;
import java.io.*;
import java.util.*;

public class ItemRepository {
    private final File file = new File("data/items.txt");
    private final List<Item> items = new ArrayList<>();

    public ItemRepository() {
        load();
    }

    public List<Item> findAll() {
        return new ArrayList<>(items);
    }

    public void save(Item item) {
        items.add(item);
        persist();
    }

    public Item findById(int id) {
        for (Item item : items) {
            if (item.getItemId() == id) return item;
        }
        return null;
    }

    public void persist() {
        ensureFile();
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (Item item : items) {
                writer.println(item.getItemId() + "|" + item.getType() + "|"
                        + clean(item.getName()) + "|" + clean(item.getCategory()) + "|"
                        + clean(item.getLocation()) + "|" + clean(item.getDate()) + "|"
                        + clean(item.getDescription()) + "|" + item.getStatus());
            }
        } catch (IOException ex) {
            throw new RuntimeException("Could not save items.");
        }
    }

    private void load() {
        ensureFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] p = line.split("\\|", -1);
                if (p.length == 8) {
                    items.add(new Item(Integer.parseInt(p[0]), ItemType.valueOf(p[1]),
                            p[2], p[3], p[4], p[5], p[6], ItemStatus.valueOf(p[7])));
                }
            }
        } catch (Exception ex) {
            System.out.println("Starting with empty item data.");
        }
    }

    private void ensureFile() {
        File parent = file.getParentFile();
        if (!parent.exists()) parent.mkdirs();
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException ex) {
            throw new RuntimeException("Could not create item storage.");
        }
    }

    private String clean(String value) {
        return value.replace("|", "/").replace("\\n", " ");
    }
}
