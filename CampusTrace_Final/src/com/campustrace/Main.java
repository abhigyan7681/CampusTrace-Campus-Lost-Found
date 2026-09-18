package com.campustrace;

import com.campustrace.model.*;
import com.campustrace.repository.ClaimRepository;
import com.campustrace.repository.ItemRepository;
import com.campustrace.service.ClaimService;
import com.campustrace.service.ItemService;
import com.campustrace.util.InputValidator;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ItemService itemService =
            new ItemService(new ItemRepository());
    private static final ClaimService claimService =
            new ClaimService(new ClaimRepository(), itemService);

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("CampusTrace - Campus Lost & Found");

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1": reportItem(ItemType.LOST); break;
                    case "2": reportItem(ItemType.FOUND); break;
                    case "3": displayItems(itemService.getAllItems()); break;
                    case "4": searchItems(); break;
                    case "5": submitClaim(); break;
                    case "6": displayClaims(claimService.getAllClaims()); break;
                    case "7": updateClaimStatus(); break;
                    case "8": markItemReturned(); break;
                    case "9": running = false; System.out.println("Exiting CampusTrace."); break;
                    default: System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Something went wrong: " + ex.getMessage());
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. Report lost item");
        System.out.println("2. Report found item");
        System.out.println("3. View all items");
        System.out.println("4. Search items");
        System.out.println("5. Submit claim");
        System.out.println("6. View claims");
        System.out.println("7. Approve or reject claim");
        System.out.println("8. Mark item as returned");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void reportItem(ItemType type) {
        String name = readRequired("Enter item name: ");
        String category = readRequired("Enter category: ");
        String location = readRequired("Enter location: ");
        String description = readRequired("Enter description: ");

        Item item = itemService.addItem(type, name, category, location, description);
        System.out.println("Item added successfully. Item ID: " + item.getItemId());
    }

    private static void searchItems() {
        String keyword = readRequired("Enter keyword: ");
        displayItems(itemService.searchItems(keyword));
    }

    private static void submitClaim() {
        int itemId = readInt("Enter found item ID: ");
        if (!itemService.isFoundItem(itemId)) {
            System.out.println("Claims can only be submitted for found items.");
            return;
        }
        if (!itemService.isActiveItem(itemId)) {
            System.out.println("This item is no longer active.");
            return;
        }

        String proof = readRequired("Enter proof of ownership: ");
        Claim claim = claimService.addClaim(itemId, 1, proof);
        System.out.println("Claim submitted successfully. Claim ID: " + claim.getClaimId());
    }

    private static void updateClaimStatus() {
        int claimId = readInt("Enter claim ID: ");
        System.out.println("1. Approve");
        System.out.println("2. Reject");
        String choice = scanner.nextLine().trim();

        if ("1".equals(choice)) {
            claimService.updateStatus(claimId, ClaimStatus.APPROVED);
            System.out.println("Claim approved.");
        } else if ("2".equals(choice)) {
            claimService.updateStatus(claimId, ClaimStatus.REJECTED);
            System.out.println("Claim rejected.");
        } else {
            System.out.println("Invalid status choice.");
        }
    }

    private static void markItemReturned() {
        int itemId = readInt("Enter item ID: ");
        itemService.markReturned(itemId);
        System.out.println("Item marked as returned.");
    }

    private static void displayItems(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("No items found.");
            return;
        }
        for (Item item : items) {
            System.out.println(item);
        }
    }

    private static void displayClaims(List<Claim> claims) {
        if (claims.isEmpty()) {
            System.out.println("No claims found.");
            return;
        }
        for (Claim claim : claims) {
            System.out.println(claim);
        }
    }

    private static String readRequired(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (InputValidator.isNonEmpty(value)) {
                return value;
            }
            System.out.println("This field cannot be empty.");
        }
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine().trim());
    }
}
