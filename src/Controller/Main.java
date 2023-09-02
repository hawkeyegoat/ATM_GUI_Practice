package Controller;
import Model.Data;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Scanner;
public class Main {
    //private Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws GeneralSecurityException, UnsupportedEncodingException {
        Data.loadData();
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you have an account with us?");
        while(true) {
            System.out.println("Please Type 'Y' for yes, and 'N' for no");
            String option = sc.next();
            if (option.equalsIgnoreCase("y")) {
                while (true) {
                    Data.logIn();

                    break;
                }
            } else if (option.equalsIgnoreCase("n")) {
                Data.signUp();
                break;
            } else {
                //System.out.println("Please enter 'Y' or 'N'");
            }
            break;
        }
        System.out.println("Would you like to:\n Deposit(1)\n Withdrawal(2) \n Check balance and wallet(3)");
        while (true) {
            sc.nextLine();
            int choice = sc.nextInt();
            if (choice == 1) {

            }
            else if (choice == 2) {

            }
            else if (choice == 3) {

            }
            else {

            }
        }
        //System.out.println("accounts " +Data.accounts);
        //System.out.println("Logins " + Data.logins);
    }
}
