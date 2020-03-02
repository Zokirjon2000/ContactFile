package ContactFile;

import java.util.Scanner;

public class ContactMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactInter contactInter = new ContactImple();
        while (true) {
            boolean IsHave = false;
            System.out.println(" 1-> Write Contact " +
                    " 2-> Read Contact " +
                    " 3-> Add Contact " +
                    " 4-> Search Contact " +
                    " 5-> Edite Contact " +
                    " 6-> Delete Contact " +
                    " 7-> Exit ");
            int n = sc.nextInt();
            switch (n){
                case 1:
                    contactInter.writeContact();
                    break;
                case 2:
                    contactInter.readContact();
                    break;
                case 3:
                    contactInter.addContactNumber();
                    break;
                case 4:
                    contactInter.searchContact();
                    break;
                case 5:
                    contactInter.editeContact();
                    break;
                case 6:
                    contactInter.deleteContact();
                    break;
                case 7:
                    IsHave = true;
                    break;
            }
            if (IsHave){
                break;
            }

        }
    }
}
