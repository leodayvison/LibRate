package br.com.ufc.librate.tools;

import java.util.Map;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.ufc.librate.exceptions.IncorrectCredentialsException;
import br.com.ufc.librate.model.classes.Account;
import br.com.ufc.librate.model.classes.NormalAccount;

public class AccountManager {
	private static Map<String, Account> accountMap = new HashMap<String, Account>();

    public AccountManager() {
    	AccountManager.accountMap.put("leozz", new NormalAccount("leozz", "senhasegura", "leodayvison"));
    }
    
    
    public static void login(String user, String password, JFrame frame) throws IncorrectCredentialsException{
        if(!(AccountManager.accountMap.containsKey(user) && AccountManager.accountMap.get(user).getPassword().equals(password))){
            throw new IncorrectCredentialsException();
        } else {
            // TODO code that will run when user successfully logins
        	JOptionPane.showMessageDialog(frame, "Login bem-sucedido!");
        }
    }
}
