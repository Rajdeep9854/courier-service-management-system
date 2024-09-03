package com.courier.ui;

import com.courier.model.Customer;
import com.courier.model.Delivery;
import com.courier.model.Parcel;
import com.courier.service.CustomerService;
import com.courier.service.DeliveryService;
import com.courier.service.ParcelService;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static ParcelService parcelService = new ParcelService();
    private static CustomerService customerService = new CustomerService();
    private static DeliveryService deliveryService = new DeliveryService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Courier Service Management System");
            System.out.println("1. Manage Parcels");
            System.out.println("2. Manage Customers");
            System.out.println("3. Delivery Operations");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    manageParcels();
                    break;
                case 2:
                    manageCustomers();
                    break;
                case 3:
                    manageDeliveries();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void manageParcels() {
        while (true) {
            System.out.println("Parcel Management");
            System.out.println("1. Add Parcel");
            System.out.println("2. View Parcels");
            System.out.println("3. Update Parcel");
            System.out.println("4. Delete Parcel");
            System.out.println("5. Back");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    viewParcels();
                    break;
                case 3:
                    updateParcel();
                    break;
                case 4:
                    deleteParcel();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void manageCustomers() {
        while (true) {
            System.out.println("Customer Management");
            System.out.println("1. Register Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Back");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    viewCustomers();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void manageDeliveries() {
        while (true) {
            System.out.println("Delivery Operations");
            System.out.println("1. Schedule Delivery");
            System.out.println("2. Update Delivery Status");
            System.out.println("3. View Delivery History");
            System.out.println("4. Back");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    scheduleDelivery();
                    break;
                case 2:
                    updateDeliveryStatus();
                    break;
                case 3:
                    viewDeliveryHistory();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void addParcel() {
        Parcel parcel = new Parcel();
        System.out.println("Enter sender name:");
        parcel.setSenderName(scanner.nextLine());
        System.out.println("Enter sender address:");
        parcel.setSenderAddress(scanner.nextLine());
        System.out.println("Enter recipient name:");
        parcel.setRecipientName(scanner.nextLine());
        System.out.println("Enter recipient address:");
        parcel.setRecipientAddress(scanner.nextLine());
        System.out.println("Enter weight:");
        parcel.setWeight(scanner.nextDouble());
        scanner.nextLine();  // Consume newline
        System.out.println("Enter status (Scheduled, In Transit, Delivered):");
        parcel.setStatus(scanner.nextLine());
        parcelService.addParcel(parcel);
        System.out.println("Parcel added successfully.");
    }

    private static void viewParcels() {
        List<Parcel> parcels = parcelService.getAllParcels();
        for (Parcel parcel : parcels) {
            System.out.println(parcel);
        }
    }

    private static void updateParcel() {
        System.out.println("Enter parcel ID to update:");
        int parcelId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Parcel parcel = new Parcel();
        parcel.setParcelId(parcelId);
        System.out.println("Enter new sender name:");
        parcel.setSenderName(scanner.nextLine());
        System.out.println("Enter new sender address:");
        parcel.setSenderAddress(scanner.nextLine());
        System.out.println("Enter new recipient name:");
        parcel.setRecipientName(scanner.nextLine());
        System.out.println("Enter new recipient address:");
        parcel.setRecipientAddress(scanner.nextLine());
        System.out.println("Enter new weight:");
        parcel.setWeight(scanner.nextDouble());
        scanner.nextLine();  // Consume newline
        System.out.println("Enter new status (Scheduled, In Transit, Delivered):");
        parcel.setStatus(scanner.nextLine());
        parcelService.updateParcel(parcel);
        System.out.println("Parcel updated successfully.");
    }

    private static void deleteParcel() {
        System.out.println("Enter parcel ID to delete:");
        int parcelId = scanner.nextInt();
        parcelService.deleteParcel(parcelId);
        System.out.println("Parcel deleted successfully.");
    }

    private static void addCustomer() {
        Customer customer = new Customer();
        System.out.println("Enter customer name:");
        customer.setCustomerName(scanner.nextLine());
        System.out.println("Enter email:");
        customer.setEmail(scanner.nextLine());
        System.out.println("Enter phone number:");
        customer.setPhoneNumber(scanner.nextLine());
        customerService.addCustomer(customer);
        System.out.println("Customer registered successfully.");
    }

    private static void viewCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private static void updateCustomer() {
        System.out.println("Enter customer ID to update:");
        int customerId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        System.out.println("Enter new customer name:");
        customer.setCustomerName(scanner.nextLine());
        System.out.println("Enter new email:");
        customer.setEmail(scanner.nextLine());
        System.out.println("Enter new phone number:");
        customer.setPhoneNumber(scanner.nextLine());
        customerService.updateCustomer(customer);
        System.out.println("Customer updated successfully.");
    }

    private static void deleteCustomer() {
        System.out.println("Enter customer ID to delete:");
        int customerId = scanner.nextInt();
        customerService.deleteCustomer(customerId);
        System.out.println("Customer deleted successfully.");
    }

    private static void scheduleDelivery() {
        Delivery delivery = new Delivery();
        System.out.println("Enter parcel ID:");
        delivery.setParcelId(scanner.nextInt());
        System.out.println("Enter customer ID:");
        delivery.setCustomerId(scanner.nextInt());
        scanner.nextLine();  // Consume newline
        System.out.println("Enter delivery date (yyyy-mm-dd):");
        delivery.setDeliveryDate(Date.valueOf(scanner.nextLine()));
        System.out.println("Enter delivery status (Scheduled, In Transit, Delivered):");
        delivery.setDeliveryStatus(scanner.nextLine());
        System.out.println("Enter delivery cost:");
        delivery.setDeliveryCost(scanner.nextDouble());
        scanner.nextLine();  // Consume newline
        deliveryService.scheduleDelivery(delivery);
        System.out.println("Delivery scheduled successfully.");
    }

    private static void updateDeliveryStatus() {
        System.out.println("Enter delivery ID to update:");
        int deliveryId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter new status (Scheduled, In Transit, Delivered):");
        String status = scanner.nextLine();
        deliveryService.updateDeliveryStatus(deliveryId, status);
        System.out.println("Delivery status updated successfully.");
    }

    private static void viewDeliveryHistory() {
        List<Delivery> deliveries = deliveryService.getDeliveryHistory();
        for (Delivery delivery : deliveries) {
            System.out.println(delivery);
        }
    }
}

