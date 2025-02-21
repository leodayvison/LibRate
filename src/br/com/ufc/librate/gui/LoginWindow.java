package br.com.ufc.librate.gui;
// teste fjdkslhfjklfdshfjkdshnkjflfdskjnf
import java.awt.EventQueue;


import javax.swing.JFrame;

import br.com.ufc.librate.Data.AccountData;
import br.com.ufc.librate.Data.AuthorData;
import br.com.ufc.librate.Data.BookData;
import br.com.ufc.librate.tools.AccountManager;
import br.com.ufc.librate.exceptions.*;
import br.com.ufc.librate.Data.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginWindow {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {

		Database.checkAndCreateFiles();
		Database.readFiles();
		System.out.println(AccountData.getAccountList().size());
		new AccountManager();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Main label 
		JLabel loginPanelLabel = new JLabel("Login roxeda");
		loginPanelLabel.setBounds(194, 11, 91, 14);
		frame.getContentPane().add(loginPanelLabel);

		// user label
		JLabel userLabel = new JLabel("Usuário:");
		userLabel.setBounds(46, 78, 46, 14);
		frame.getContentPane().add(userLabel);

		//pass label
		JLabel passwordLabel = new JLabel("Senha: ");
		passwordLabel.setBounds(46, 121, 46, 14);
		frame.getContentPane().add(passwordLabel);

		// user text field
		textField = new JTextField();
		textField.setBounds(115, 75, 213, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		//password text field
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 118, 213, 20);
		frame.getContentPane().add(passwordField);

		// login button
		JButton loginButton = new JButton("LOGIN");
		loginButton.setBounds(115, 187, 106, 30);
		frame.getContentPane().add(loginButton);

		JButton registerButton = new JButton("CADASTRAR");
		registerButton.setBounds(277, 187, 106, 30);
		frame.getContentPane().add(registerButton);

		// login button action

		// adding listener            creating anonymous listener instance
		loginButton.addActionListener(new ActionListener() {
			// method that says what happens when the event is triggered
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();
				String password = new String(passwordField.getPassword());

				// TODO guardar contas registradas em arquivo e arrumar o método de login em Interactions
				try {
					AccountManager.login(user, password, frame);
				} catch (IncorrectCredentialsException ex) {
					JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			}
		});
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();
				String password = new String(passwordField.getPassword());

				try {
					AccountManager.register(user, password, frame);
				} catch (AccountAlreadyExistsException ex) {
					JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			}
		});

	}
}
