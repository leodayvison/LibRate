package br.com.ufc.librate.tools;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.ufc.librate.Data.AccountData;
import br.com.ufc.librate.exceptions.IncorrectCredentialsException;
import br.com.ufc.librate.exceptions.AccountAlreadyExistsException;
import br.com.ufc.librate.model.classes.Account;
import br.com.ufc.librate.model.classes.NormalAccount;

public class AccountManager {
	public static Map<String, Account> accountMap = new HashMap<String, Account>();

    public AccountManager() {
        AccountData.readFileAccount();
        for (Account acc : AccountData.accountList) {
            if (!(AccountManager.accountMap.containsKey(acc.getUser()))) {
                AccountManager.accountMap.put(acc.getUser(), acc);

            }
        }
    }


    public static void login(String user, String password, JFrame frame) throws IncorrectCredentialsException, IOException {
        if(!(AccountManager.accountMap.containsKey(user) && AccountManager.accountMap.get(user).getPassword().equals(password))){
            throw new IncorrectCredentialsException();
        } else {
            // TODO code that will run when user successfully logins
        	JOptionPane.showMessageDialog(frame, "Login bem-sucedido!");
        }
    }
    
    public static void register(String user, String password, JFrame frame) throws AccountAlreadyExistsException, IOException {
    	
    	if (AccountManager.accountMap.containsKey(user)) {
    		throw new AccountAlreadyExistsException();
    	} else {
    		Account newAcc = new NormalAccount(user, password);
            AccountData.writeFileAccount(user, password);
            AccountData.readFileAccount();
    		AccountManager.accountMap.put(user, newAcc);
    		JOptionPane.showMessageDialog(frame, "Usuário cadastrado!");
    	}
    	
    }
}
