package Model;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.*;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import static Model.Data.dataEncryption.createSecretKey;
import static Model.Data.dataEncryption.encrypt;

public class Data {
    //private long myUserID;
    private static FileWriter loginsWriter;
    private static FileWriter accountsWriter;
    private static FileReader loginsReader;
    private static FileReader accountsReader;
    private BigDecimal myBalance;
    private String myUserName;
    private int myPinCode;
    private String myPassword; //Will change in order to encrypt later
    private BigDecimal myWallet;
    public static HashMap logins = new HashMap<String, String>();
    public static ArrayList accounts = new ArrayList<Data>();

    public Data(String userName, int pinCode, String password, BigDecimal wallet) {
        //myUserID = userID;
        myUserName = userName;
        myPinCode = pinCode;
        myPassword = password;
        myWallet = wallet;
        myBalance = new BigDecimal(0.00);
    }
    public BigDecimal getMyBalance() {
        return myBalance;
    }
    public BigDecimal getMyWallet() {
        return myWallet;
    }
    public static void loadData() {
        try {
            loginsWriter = new FileWriter(new File("logins.txt"));
            loginsWriter.write(logins.toString());
            loginsWriter.flush();
            loginsWriter.close();
        }
        catch (IOException e) {
            System.out.println("logins text file not found");
        }
        try {
            accountsWriter = new FileWriter(new File("accounts.txt"));
            accountsWriter.write(accounts.toString());
            accountsWriter.flush();
            accountsWriter.close();
        }
        catch (IOException e) {
            System.out.println("accounts text file not found");
        }
    }
    public static Data signUp() throws GeneralSecurityException, UnsupportedEncodingException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a valid username");
        String tempName = sc.nextLine();
        System.out.println("Please enter a 4 number pincode");
        int tempCode = sc.nextInt();
        System.out.println("please enter a strong password");
        String tempPassword = sc.next();
//        byte[] salt = new String("12345678").getBytes();
//        int iterationCount = 40000;
//        int keyLength = 128;
//        SecretKeySpec key = createSecretKey(tempPassword.toCharArray(),
//                salt, iterationCount, keyLength);
//        System.out.println("Original password: " + tempPassword);
//        String tempEncryptedPassword = encrypt(tempPassword, key);
//        System.out.println("Encrypted password: " + tempEncryptedPassword);
        System.out.println("Please enter how much money you have");
        BigDecimal tempWallet = new BigDecimal(sc.nextDouble());
        sc.close();
        if (logins.containsKey(tempName)) {
            throw new IllegalArgumentException("Username already exists");
        }
        Data accountInfo = new Data(tempName, tempCode, tempPassword, tempWallet);
        accounts.add(accountInfo);
        logins.put(accountInfo.myUserName, accountInfo.myPassword);
//        try {
//            loginsWriter = new FileWriter(new File("logins.txt"));
//            loginsWriter.write(logins.toString());
//            loginsWriter.flush();
//            loginsWriter.close();
//        }
//        catch (IOException e) {
//            System.out.println("logins text file not found");
//        }
//        try {
//            accountsWriter = new FileWriter(new File("accounts.txt"));
//            accountsWriter.write(accounts.toString());
//            accountsWriter.flush();
//            accountsWriter.close();
//        }
//        catch (IOException e) {
//            System.out.println("accounts text file not found");
//        }

        return (Data)accounts.get(accounts.size()-1);
    }
    public static Data logIn() throws GeneralSecurityException, UnsupportedEncodingException {
        Scanner sc = new Scanner(System.in);
        StringBuilder stb = new StringBuilder();
        //while (true) {
            try {
                loginsReader = new FileReader(new File("logins.txt"));
                //StringBuilder tempLogins = new StringBuilder();
                String tempLogins = Files.readString(Path.of("logins.txt"));
                //while (loginsReader) {
                   // tempLogins.append(loginsReader.read());
               // }
                        //loginsReader.toString();
                //System.out.println(tempLogins);
                String tempKey = "";
                tempLogins = tempLogins.substring(1);
                for (int i = 0; i < tempLogins.length(); i++) {
                    if (tempLogins.charAt(i) == '=') {
                        tempKey = stb.toString();
                        stb.delete(0, stb.length());
                    }
                    else if (tempLogins.charAt(i) == '}') {
                        String tempValue = stb.toString();
                        stb.delete(0, stb.length());
                        logins.put(tempKey, tempValue);
                        tempValue = "";
                        tempKey = "";
                    }
                    else {
                        stb.append(tempLogins.charAt(i));
                    }
                }
            }
            catch (IOException e) {
                System.out.println("logins file not found");
            }
            System.out.println(logins);
            System.out.println("Please enter a valid username");
            String tempName = sc.nextLine();
            System.out.println("please enter a valid password");
            String tempPassword = sc.next();
//            byte[] salt = new String("12345678").getBytes();
//            int iterationCount = 40000;
//            int keyLength = 128;
//            SecretKeySpec key = createSecretKey(tempPassword.toCharArray(),
//                salt, iterationCount, keyLength);
//        System.out.println("Original password: " + tempPassword);
//        String tempEncryptedPassword = encrypt(tempPassword, key);
        if(logins.containsKey(tempName)) {
            if (logins.get(tempName).equals(tempPassword)) {
                System.out.println(accounts);
                return (Data) accounts.get(accounts.indexOf(tempName));
            } else {
                System.out.println("Username and password do not match");
                return null;
            }
        }
        else {
            System.out.println("Username and password do not match");
            return null;
        }
        //}
    }
    public void withdrawal(BigDecimal amount) {
        if (amount.compareTo(new BigDecimal(0)) < 0) {
            throw new IllegalArgumentException("Please enter a positive number.");
        }
        else if (myBalance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("You cannot withdrawal more than your balance.");
        }
        else {
            myWallet.add(amount);
            myBalance.subtract(amount);
        }
        System.out.println("Money in wallet: " + myWallet);
        System.out.println("Money in bank: " + myBalance);
    }
    public void deposit(BigDecimal amount) {
        if (amount.compareTo(new BigDecimal(0)) < 0) {
            throw new IllegalArgumentException("Please enter a positive number.");
        }
        else if (myWallet.compareTo(amount) < 0) {
            throw new IllegalArgumentException("You cannot deposit more than your wallet.");
        }
        else {
            myBalance.add(amount);
            myWallet.subtract(amount);
        }
        System.out.println("Money in wallet: " + myWallet);
        System.out.println("Money in bank: " + myBalance);
        }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("Username:");
        sb.append(myUserName);
        sb.append(":");
        //sb.append(" Balance:");
        sb.append(myBalance);
        sb.append(",");
        return sb.toString();
    }
    protected class dataEncryption {
//        public static void main(String[] args) throws Exception {
//            String password = System.getProperty("password");
//            if (password == null) {
//                throw new IllegalArgumentException("Run with -Dpassword=<password>");
//            }
//
//            // The salt (probably) can be stored along with the encrypted data
//            byte[] salt = new String("12345678").getBytes();
//
//            // Decreasing this speeds down startup time and can be useful during testing, but it also makes it easier for brute force attackers
//            int iterationCount = 40000;
//            // Other values give me java.security.InvalidKeyException: Illegal key size or default parameters
//            int keyLength = 128;
//            SecretKeySpec key = createSecretKey(password.toCharArray(),
//                    salt, iterationCount, keyLength);
//
//            String originalPassword = "secret";
//            System.out.println("Original password: " + originalPassword);
//            String encryptedPassword = encrypt(originalPassword, key);
//            System.out.println("Encrypted password: " + encryptedPassword);
//            String decryptedPassword = decrypt(encryptedPassword, key);
//            System.out.println("Decrypted password: " + decryptedPassword);
//        }

        protected static SecretKeySpec createSecretKey(char[] password, byte[] salt, int iterationCount, int keyLength) throws NoSuchAlgorithmException, InvalidKeySpecException {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterationCount, keyLength);
            SecretKey keyTmp = keyFactory.generateSecret(keySpec);
            return new SecretKeySpec(keyTmp.getEncoded(), "AES");
        }

        protected static String encrypt(String property, SecretKeySpec key) throws GeneralSecurityException, UnsupportedEncodingException {
            Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            pbeCipher.init(Cipher.ENCRYPT_MODE, key);
            AlgorithmParameters parameters = pbeCipher.getParameters();
            IvParameterSpec ivParameterSpec = parameters.getParameterSpec(IvParameterSpec.class);
            byte[] cryptoText = pbeCipher.doFinal(property.getBytes("UTF-8"));
            byte[] iv = ivParameterSpec.getIV();
            return base64Encode(iv) + ":" + base64Encode(cryptoText);
        }

        private static String base64Encode(byte[] bytes) {
            return Base64.getEncoder().encodeToString(bytes);
        }

        protected static String decrypt(String string, SecretKeySpec key) throws GeneralSecurityException, IOException {
            String iv = string.split(":")[0];
            String property = string.split(":")[1];
            Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            pbeCipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(base64Decode(iv)));
            return new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
        }

        private static byte[] base64Decode(String property) throws IOException {
            return Base64.getDecoder().decode(property);
        }
    }
}