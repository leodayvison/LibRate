package br.com.ufc.librate.Data;

import br.com.ufc.librate.model.classes.Account;
import br.com.ufc.librate.model.classes.AdminAccount;
import br.com.ufc.librate.model.classes.NormalAccount;
import br.com.ufc.librate.tools.AccountManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountData {
    public static List<NormalAccount> accountList = new ArrayList<>();

    public static List<NormalAccount> getAccountList() {
        return accountList;
    }

    public static void writeFileAccount(NormalAccount account) throws IOException {
        String dataAccount = account.getUser() + ":" + account.getPassword() + ":" + account.getBio();
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
                    if(user.equals("admin")){
                        AdminAccount adm = new AdminAccount();
                        AccountManager.getAccountMap().put("admin",adm);
                    }
                    AccountData.accountList.add(new NormalAccount(user,password));
                }else if(parts.length == 3){
                    String user = parts[0];
                    String password = parts[1];
                    String bio = parts[2];
                    AccountData.accountList.add(new NormalAccount(user,password,bio));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
