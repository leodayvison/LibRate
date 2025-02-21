package br.com.ufc.librate.Data;

import br.com.ufc.librate.model.classes.Account;
import br.com.ufc.librate.model.classes.NormalAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountData {
    public static List<Account> accountList = new ArrayList<>();

    public static List<Account> getAccountList() {
        return accountList;
    }

    public static void writeFileAccount(String user, String password) throws IOException {
        String dataAccount = user + ":" + password;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(dataAccount);
            writer.newLine();
        } catch (IOException ioe) {
            ioe.getMessage();
        }
    }

    public static void readFileAccount(){
        try(BufferedReader reader = new BufferedReader(new FileReader("users.txt"))){
            String line;
            AccountData.accountList.clear();
            while((line = reader.readLine()) != null){
                String[] parts = line.split(":");
                if(parts.length == 2){
                    String user = parts[0];
                    String password = parts[1];
                    AccountData.accountList.add(new NormalAccount(user,password));
                }else{
                    System.out.println("Formato invalido:" + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
