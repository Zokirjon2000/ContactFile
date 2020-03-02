package uz.pdp.contact.utils;

import uz.pdp.contact.models.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileService {

    public static void writeFile(File file, String text, boolean a) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file, a);
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Contact> getContactList(File file) {
        List<Contact> contactList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String row;
            while ((row = bufferedReader.readLine()) != null) {
                int i = row.indexOf("%");
                String contactName = row.substring(0, i);
                String numbersString = row.substring(i + 1);
                String[] numberArray = numbersString.split("#");
                List<String> numberList = Arrays.asList(numberArray);
                Contact contact = new Contact(contactName, numberList);
                contactList.add(contact);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contactList;
    }
}
