package br.com.ufc.librate.tools;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.ufc.librate.Data.AccountData;
import br.com.ufc.librate.exceptions.IncorrectCredentialsException;
import br.com.ufc.librate.model.classes.Account;
import br.com.ufc.librate.model.classes.NormalAccount;

public class AccountManager {
	private static Account LoggedAccount = new NormalAccount("leo", "base", "base");

	private static Map<String, Account> accountMap = new HashMap<String, Account>();

    public AccountManager() {
        AccountData.readFileAccount();
        for (Account acc : AccountData.accountList) {
            if (!(AccountManager.accountMap.containsKey(acc.getUser()))) {
                AccountManager.accountMap.put(acc.getUser(), acc);

            }
        }
    }
    public static Account getLoggedAccount() {
		return LoggedAccount;
	}

	public static void setLoggedAccount(Account loggedAccount) {
		LoggedAccount = loggedAccount;
	}

	public static Map<String, Account> getAccountMap() {
		return accountMap;
	}

	public static void setAccountMap(Map<String, Account> accountMap) {
		AccountManager.accountMap = accountMap;
	}

	public static void login(String user, String password, JFrame frame) throws IncorrectCredentialsException{


    public static void login(String user, String password, JFrame frame) throws IncorrectCredentialsException, IOException {
        if(!(AccountManager.accountMap.containsKey(user) && AccountManager.accountMap.get(user).getPassword().equals(password))){
            throw new IncorrectCredentialsException();
        } else {
            // TODO code that will run when user successfully logins
        	JOptionPane.showMessageDialog(frame, "Login bem-sucedido!");

        	AccountManager.LoggedAccount = AccountManager.accountMap.get(user);

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
