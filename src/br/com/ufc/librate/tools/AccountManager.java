package br.com.ufc.librate.tools;

import java.util.Map;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.ufc.librate.exceptions.IncorrectCredentialsException;
import br.com.ufc.librate.model.classes.Account;
import br.com.ufc.librate.model.classes.NormalAccount;

public class AccountManager {
	private static Account LoggedAccount = new NormalAccount("leo", "base", "base");
	
	private static Map<String, Account> accountMap = new HashMap<String, Account>();

    public AccountManager() {
    	AccountManager.accountMap.put("leozz", new NormalAccount("leozz", "senhasegura", "leodayvison"));
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
        if(!(AccountManager.accountMap.containsKey(user) && AccountManager.accountMap.get(user).getPassword().equals(password))){
            throw new IncorrectCredentialsException();
        } else {
            // TODO code that will run when user successfully logins
        	JOptionPane.showMessageDialog(frame, "Login bem-sucedido!");
        	
        	AccountManager.LoggedAccount = AccountManager.accountMap.get(user);
        	
        }
    }
}
