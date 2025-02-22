package br.com.ufc.librate.tools;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.ufc.librate.Data.AccountData;
import br.com.ufc.librate.exceptions.*;
import br.com.ufc.librate.model.classes.Account;
import br.com.ufc.librate.model.classes.NormalAccount;

public class AccountManager {
	private static NormalAccount loggedAccount;

	private static HashMap<String, NormalAccount> accountMap = new HashMap<>();

    public AccountManager() {
        AccountData.readFileAccount();
        for (NormalAccount acc : AccountData.accountList) {
            if (!(AccountManager.accountMap.containsKey(acc.getUser()))) {
                AccountManager.accountMap.put(acc.getUser(), acc);

            }
        }
    }
    public static NormalAccount getLoggedAccount() {
		return loggedAccount;
	}

	public static void setLoggedAccount(NormalAccount loggedAccount) {
		AccountManager.loggedAccount = loggedAccount;
	}

	public static HashMap<String, NormalAccount> getAccountMap() {
		return accountMap;
	}

	public static void login(String user, String password, JFrame frame) throws IncorrectCredentialsException, IOException {
        if(!(AccountManager.accountMap.containsKey(user) && AccountManager.accountMap.get(user).getPassword().equals(password))){
            throw new IncorrectCredentialsException();
        } else {
            // TODO code that will run when user successfully logins
        	JOptionPane.showMessageDialog(frame, "Login bem-sucedido!");

        	AccountManager.loggedAccount = AccountManager.accountMap.get(user);

        }
    }

    public static void register(String user, String password, JFrame frame) throws AccountAlreadyExistsException, IOException, IOException {

    	if (AccountManager.accountMap.containsKey(user)) {
    		throw new AccountAlreadyExistsException();
    	} else {
			NormalAccount newAcc = new NormalAccount(user, password);
			AccountManager.setLoggedAccount(newAcc);
            AccountData.writeFileAccount(user, password);
            AccountData.readFileAccount();
    		AccountManager.accountMap.put(user, newAcc);
    		JOptionPane.showMessageDialog(frame, "Usuário cadastrado!");
    	}

    }
}
