package Controller;

import Model.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

///import java.io.UnsupportedEncodingException;
//import java.security.GeneralSecurityException;
//import java.util.Scanner;

public class Main implements ActionListener {
    private static JLabel logInPassword1, logInLabel, signUpLabel, signUpPassword1, pinCodeLabel, walletLabel, withdrawalBalance, depositBalance, withdrawalWallet, depositWallet;
    private static JTextField logInusername, signUpUserName, pincode, wallet, depositAmount, withdrawalAmount;
    private static JButton logInButton, signInButton, signUpButton, signUpButton2, withdrawalB, depositB, depositSubmit, withdrawalSubmit;
    private static JPasswordField logInPassword, signUpPassword;
    private static JPanel welcomePanel;
    private static JFrame welcomeFrame, signUpFrame, logInFrame, bankFrame, depositFrame;
    private static Data currentUser;
    public static void welcome_setUp() {
        welcomePanel = new JPanel();
        //panel.setVisible(true);
        welcomePanel.setLayout(null);
        // JFrame class
        welcomeFrame = new JFrame();

        welcomeFrame.setVisible(true);
        welcomeFrame.setTitle("WELCOME");
        welcomeFrame.setLocation(new Point(500, 300));
        welcomeFrame.add(welcomePanel);
        welcomeFrame.setSize(new Dimension(800, 600));
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        signInButton = new JButton("Login");
        signInButton.setBounds(100, 110, 100, 25);
        signInButton.setForeground(Color.WHITE);
        signInButton.setBackground(Color.BLACK);
        signInButton.addActionListener((ActionListener) new Main());
        welcomePanel.add(signInButton);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(100, 55, 100, 20);
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(Color.BLACK);
        signUpButton.addActionListener((ActionListener) new Main());
        welcomePanel.add(signUpButton);
    }

    public static void logIn_setUp() {
        JPanel logInPanel = new JPanel();
        //panel.setVisible(true);
        logInPanel.setLayout(null);
        // JFrame class
        logInFrame = new JFrame();

        logInFrame.setVisible(true);
        logInFrame.setTitle("LOG IN");
        logInFrame.setLocation(new Point(500, 300));
        logInFrame.add(logInPanel);
        logInFrame.setSize(new Dimension(800, 600));
        logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Username label constructor
        logInLabel = new JLabel("Username");
        logInLabel.setBounds(100, 8, 70, 20);
        logInPanel.add(logInLabel);
        // Username TextField constructor
        logInusername = new JTextField();
        logInusername.setBounds(100, 27, 193, 28);
        logInPanel.add(logInusername);
        // Password Label constructor
        logInPassword1 = new JLabel("Password");
        logInPassword1.setBounds(100, 55, 70, 20);
        logInPanel.add(logInPassword1);
        // Password TextField
        logInPassword = new JPasswordField();
        logInPassword.setBounds(100, 75, 193, 28);
        logInPanel.add(logInPassword);
        // Button constructor
        logInButton = new JButton("Login");
        logInButton.setBounds(100, 110, 90, 25);
        logInButton.setForeground(Color.WHITE);
        logInButton.setBackground(Color.BLACK);
        logInButton.addActionListener((ActionListener) new Main());
        logInPanel.add(logInButton);
    }
    public static void signUp_setUp() {
        JPanel signUpPanel = new JPanel();
        //panel.setVisible(true);
        signUpPanel.setLayout(null);
        // JFrame class
        signUpFrame = new JFrame();

        signUpFrame.setVisible(true);
        signUpFrame.setTitle("signUp");
        signUpFrame.setLocation(new Point(500, 300));
        signUpFrame.add(signUpPanel);
        signUpFrame.setSize(new Dimension(800, 600));
        signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Username label constructor
        signUpLabel = new JLabel("Username");
        signUpLabel.setBounds(100, 8, 70, 20);
        signUpPanel.add(signUpLabel);
        // Username TextField constructor
        signUpUserName = new JTextField();
        signUpUserName.setBounds(100, 27, 193, 28);
        signUpPanel.add(signUpUserName);



        // Password Label constructor

        signUpPassword1 = new JLabel("Password");
        signUpPassword1.setBounds(100, 55, 70, 20);
        signUpPanel.add(signUpPassword1);
        // Password TextField
        signUpPassword = new JPasswordField();
        signUpPassword.setBounds(100, 75, 193, 28);
        signUpPanel.add(signUpPassword);

        pinCodeLabel = new JLabel("Desired Pincode");
        pinCodeLabel.setBounds(100, 100, 190, 20);
        signUpPanel.add(pinCodeLabel);

        pincode = new JTextField();
        pincode.setBounds(100, 125, 193, 28);
        signUpPanel.add(pincode);

        walletLabel = new JLabel("How much money do you have?");
        walletLabel.setBounds(100, 150, 190, 20);
        signUpPanel.add(walletLabel);

        wallet = new JTextField();
        wallet.setBounds(100, 175, 193, 28);
        signUpPanel.add(wallet);
        // Button constructor
        signUpButton2 = new JButton("Sign up");
        signUpButton2.setBounds(100, 200, 90, 25);
        signUpButton2.setForeground(Color.WHITE);
        signUpButton2.setBackground(Color.BLACK);
        signUpButton2.addActionListener((ActionListener) new Main());
        signUpPanel.add(signUpButton2);
    }
        public static void bank_setUp() {
            JPanel bankPanel = new JPanel();
            //panel.setVisible(true);
            bankPanel.setLayout(null);
            // JFrame class
            bankFrame = new JFrame();

            bankFrame.setVisible(true);
            bankFrame.setTitle("BANKING SHIT");
            bankFrame.setLocation(new Point(500, 300));
            bankFrame.add(bankPanel);
            bankFrame.setSize(new Dimension(800, 600));
            bankFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            withdrawalB = new JButton("withdrawal");
            withdrawalB.setBounds(100, 200, 120, 25);
            withdrawalB.setForeground(Color.WHITE);
            withdrawalB.setBackground(Color.BLACK);
            withdrawalB.addActionListener((ActionListener) new Main());
            bankPanel.add(withdrawalB);

            depositB = new JButton("deposit");
            depositB.setBounds(500, 200, 120, 25);
            depositB.setForeground(Color.WHITE);
            depositB.setBackground(Color.BLACK);
            depositB.addActionListener((ActionListener) new Main());
            bankPanel.add(depositB);
        }
        public static void deposit_setup() {
            JPanel depositPanel = new JPanel();
            depositPanel.setLayout(null);
            depositFrame = new JFrame();

            depositFrame.setVisible(true);
            depositFrame.setTitle("Deposit");
            depositFrame.setLocation(new Point(500, 300));
            depositFrame.add(depositPanel);
            depositFrame.setSize(new Dimension(800, 600));
            depositFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            depositWallet = new JLabel("Wallet: " + currentUser.getMyWallet());
            depositWallet.setBounds(100, 300, 120, 25);
            depositWallet.setForeground(Color.BLACK);
            depositWallet.setBackground(Color.BLACK);
            depositPanel.add(depositWallet);

            depositBalance = new JLabel("Balance: " + currentUser.getMyBalance());
            depositBalance.setBounds(500, 300, 120, 25);
            depositBalance.setForeground(Color.BLACK);
            depositBalance.setBackground(Color.BLACK);
            depositPanel.add(depositBalance);

            depositAmount = new JTextField();
            depositAmount.setBounds(100, 27, 193, 28);
            depositPanel.add(depositAmount);

            depositSubmit = new JButton("submit");
            depositSubmit.setBounds(500, 200, 120, 25);
            depositSubmit.setForeground(Color.WHITE);
            depositSubmit.setBackground(Color.BLACK);
            depositSubmit.addActionListener((ActionListener) new Main());
            depositPanel.add(depositSubmit);
        }


    public static void main(String[] args) {
        Data.loadData();
        welcome_setUp();
    }

    public static void showIncorrectCredentials() {
        JOptionPane.showMessageDialog(welcomeFrame, "Username and password do not match");
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(signInButton)) {
            //welcomeFrame.dispose();
            logIn_setUp();
            welcomeFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            welcomeFrame.dispose();
            //welcomePanel.setVisible(false);
        }
        if (e.getSource().equals(signUpButton)) {
            signUp_setUp();
            welcomeFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            welcomeFrame.dispose();
        }
        if (e.getSource().equals(logInButton)) {
            if (Data.logIn(logInusername.getText(), logInPassword.getText())) {
                //currentUser = Data.getUser(logInusername.getText());
                setCurrentUser(logInusername.getText());
                System.out.println(currentUser);
                logInFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                //logInFrame.dispose();
                bank_setUp();
            }
            else {
                showIncorrectCredentials();
            }
        }
        if (e.getSource().equals(signUpButton2)) {
            if (Data.signUp(signUpUserName.getText(), signUpPassword.getText(), pincode.getText(), new BigDecimal(Double.valueOf(wallet.getText())))) {
                logIn_setUp();
                signUpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                signUpFrame.dispose();
            }
            else {
                showIncorrectCredentials();
            }
        }
        if (e.getSource().equals(depositB)) {
            deposit_setup();
        }
        if (e.getSource().equals(depositSubmit)) {
            currentUser.deposit(BigDecimal.valueOf(Double.valueOf(depositAmount.getText())));
        }

    }
    public void setCurrentUser(String name) {
        currentUser = Data.getUser(name);
    }
//        String Username = logInusername.getText();
//        String Password1 = logInPassword.getText();
//
//        if (Username.equals("section.io") && Password1.equals("123"))
//            JOptionPane.showMessageDialog(null, "Login Successful");
//        else
//            JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
//        }
    }


//    //private Scanner sc = new Scanner(System.in);
//    public static void main(String[] args) throws GeneralSecurityException, UnsupportedEncodingException {
//        Data.loadData();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Do you have an account with us?");
//        while(true) {
//            System.out.println("Please Type 'Y' for yes, and 'N' for no");
//            String option = sc.next();
//            if (option.equalsIgnoreCase("y")) {
//                while (true) {
//                    Data.logIn();
//
//                    break;
//                }
//            } else if (option.equalsIgnoreCase("n")) {
//                Data.signUp();
//                break;
//            } else {
//                //System.out.println("Please enter 'Y' or 'N'");
//            }
//            break;
//        }
//        System.out.println("Would you like to:\n Deposit(1)\n Withdrawal(2) \n Check balance and wallet(3)");
//        while (true) {
//            sc.nextLine();
//            int choice = sc.nextInt();
//            if (choice == 1) {
//
//            }
//            else if (choice == 2) {
//
//            }
//            else if (choice == 3) {
//
//            }
//            else {
//
//            }
//        }
//        //System.out.println("accounts " +Data.accounts);
//        //System.out.println("Logins " + Data.logins);
//    }
//}
