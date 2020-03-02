package ContactFile;

import java.io.*;
import java.util.*;

public class ContactImple implements ContactInter {
    private Scanner sc = new Scanner(System.in);
    private File file = new File(" Contact.txt ");
    private List<String> stringlist1 = new ArrayList<>();
    private List<WriteContactFile> writeContactFileList = new ArrayList<>();

    @Override
    public void writeContact() {
        List<String> stringlist = new ArrayList<>();
        stringlist.clear();
        System.out.println(" Enter name ");
        sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(" Enter number ");
        sc = new Scanner(System.in);
        String number = sc.nextLine();
        stringlist.add(number);
        stringlist1.add(number);
        WriteContactFile writeContactFile = new WriteContactFile(name, stringlist);
        writeContactFileList.add(writeContactFile);

        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(String.valueOf(writeContactFile));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void readContact() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String row;
            StringBuilder stringBuilder = new StringBuilder();
            while ((row = bufferedReader.readLine()) != null) {
                stringBuilder.append(row);
            }
            inputStreamReader.close();
            bufferedReader.close();
            System.out.println(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addContactNumber() {
        int index = 0;
        System.out.println(" Enter Name ");
        sc = new Scanner(System.in);
        String name = sc.nextLine();
        for (int i = 0; i < writeContactFileList.size(); i++) {
            if (writeContactFileList.get(i).getName().equals(name)) {
                index = i;
            }
        }
        System.out.println(" Enter number ");
        sc = new Scanner(System.in);
        String number = sc.nextLine();
        writeContactFileList.get(index).getContactnumber().add(number);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(String.valueOf(writeContactFileList));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void searchContact() {
        System.out.println("Enter name or Enter number ");
        sc = new Scanner(System.in);
        String nameOrNumber = sc.nextLine();
        for (int i = 0; i < writeContactFileList.size(); i++) {
            if (writeContactFileList.get(i).getName().equals(nameOrNumber)) {
                System.out.println(writeContactFileList.get(i));
                break;
            }
//            else {
//                for (int i1 = 0; i1 <stringlist1.size(); i1++) {
//                    if (stringlist1.get(i1).equals(nameOrNumber)){
//                        System.out.println(writeContactFileList.get(i).toString());
//                        break;
        }
    }


    @Override
    public void editeContact() {
        WriteContactFile writeContactFile = new WriteContactFile();
        int index = 0;
        System.out.println(" Siz qaysi Contactni numberni ozgartirmoqchisiz ? ");
        sc = new Scanner(System.in);
        String name = sc.nextLine();
        for (int i = 0; i < writeContactFileList.size(); i++) {
            if (writeContactFileList.get(i).getName().equals(name)) {
                index = i;

            }
        }
        for (int i1 = 0; i1 < writeContactFileList.get(index).getContactnumber().size(); i1++) {
            System.out.println((i1 + 1) + " -> " + writeContactFileList.get(index).getContactnumber().get(i1));
        }

        System.out.println(" Siz qaysi nomerini ozgartirmoqchisiz ");
        int n1 = sc.nextInt();
        for (int i1 = 0; i1 < writeContactFileList.get(index).getContactnumber().size(); i1++) {
            if (n1 == i1 + 1) {

                System.out.println(" Enter Number ");
                String number = sc.next();


                List<String> newNumber = new ArrayList<>();
                newNumber.add(number);
                writeContactFile.setContactnumber(newNumber);
                writeContactFileList.add(writeContactFile);


            }
        }

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(String.valueOf(writeContactFileList));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteContact() {
        System.out.println(" O'chiraydigon contact nameni kiriting  ");
        sc = new Scanner(System.in);
        String name = sc.nextLine();
        for (int i = 0; i < writeContactFileList.size(); i++) {
            if (writeContactFileList.get(i).getName().equals(name)) {
                writeContactFileList.remove(i);
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(String.valueOf(writeContactFileList));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
