package uz.pdp.contact.service;

import uz.pdp.contact.models.Contact;
import uz.pdp.contact.utils.FileService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactService implements ContactInterface {
    private Scanner scanner = new Scanner(System.in);
    private File file = new File("contact.txt");

    @Override
    public void addContact() {
        System.out.println("Contact name:");
        String contactName = scanner.next();
        System.out.println("Contact number:");
        String number = scanner.next();
        List<String> numberList = new ArrayList<>();
        numberList.add(number);
        Contact contact = new Contact(contactName, numberList);
        FileService.writeFile(file, contact.toString(), true);
    }

    @Override
    public void searchContact() {
        System.out.println("Contact name:");
        String contactName = scanner.next();
        List<Contact> contactList = FileService.getContactList(file);
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getContactName().toLowerCase().contains(contactName.toLowerCase())) {
                System.out.println(contactList.get(i).getContactName() + " -> ");
                List<String> numbers = contactList.get(i).getNumbers();
                for (String number : numbers) {
                    System.out.println(number);
                }
            }
        }
    }

    @Override
    public void deleteContact() {
        System.out.println("Delete contact name:");
        String deleteContactName = scanner.next();
        List<Contact> contactList = FileService.getContactList(file);
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getContactName().equals(deleteContactName)) {
                contactList.remove(i);
            }
        }

        FileService.writeFile(file, getStringContact(contactList), false);
    }

    @Override
    public void editContact() {
        List<Contact> contactList = FileService.getContactList(file);
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println((i + 1) + " -> " + contactList.get(i).getContactName());
        }
        System.out.println("Qaysi contactni o'zgartirmoqchisiz?");
        int n = scanner.nextInt();
        Contact contact = contactList.get(n - 1);
        for (int i = 0; i < contact.getNumbers().size(); i++) {
            System.out.println((i + 1) + " -> " + contact.getNumbers().get(i));
        }
        System.out.println("Qaysi contact numberni o'zgartirasiz?");
        int n1 = scanner.nextInt();

        System.out.println("Contact numberni kirit:");
        String number = scanner.next();
        contact.getNumbers().set(n1 - 1, number);

        FileService.writeFile(file, getStringContact(contactList), false);
    }

    @Override
    public void addNumberByContactName() {
        System.out.println("Contact name:");
        String contactName = scanner.next();
        List<Contact> contactList = FileService.getContactList(file);
        int index = -1;
        boolean isHave = false;
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getContactName().equals(contactName)) {
                isHave = true;
                index = i;
                break;
            }
        }
        if (isHave) {
            System.out.println("New contact number:");
            String number = scanner.next();
            List<String> stringList = new ArrayList<>(contactList.get(index).getNumbers());
            stringList.add(number);
            contactList.get(index).setNumbers(stringList);
        } else {
            System.out.println("404");
        }
        FileService.writeFile(file, getStringContact(contactList), false);
    }

    public String getStringContact(List<Contact> contactList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < contactList.size(); i++) {
            Contact contact = contactList.get(i);
            stringBuilder.append(contact);
        }
        return stringBuilder.toString();
    }
}
