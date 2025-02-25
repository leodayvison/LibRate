package br.com.ufc.librate.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import br.com.ufc.librate.Data.BookData;
import br.com.ufc.librate.Data.Database;
import br.com.ufc.librate.exceptions.AccountAlreadyExistsException;
import br.com.ufc.librate.exceptions.BookAlreadyExistsException;
import br.com.ufc.librate.exceptions.IncorrectCredentialsException;
import br.com.ufc.librate.model.classes.AdminAccount;
import br.com.ufc.librate.model.classes.Book;
import br.com.ufc.librate.model.classes.NormalAccount;
import br.com.ufc.librate.tools.AccountManager;
import br.com.ufc.librate.tools.BookManager;

public class Frames {
	////savlio chato

	private JFrame frame;
	private JPanel panel_1;
	private JTextField usuarioTextField;
	private JPasswordField passwordTextField;
	private JTextField signUpTextField;
	private JPasswordField passwordSignUpTextField;
	private JTextField searchTextField;
	private Book livroSelecionado = null;
	private JPanel autor;

	public static void updateUserLabel(JLabel userLabel) {
		if (AccountManager.getLoggedAccount() != null) {
			userLabel.setText("@" + AccountManager.getLoggedAccount().getUser());
		} else {
			userLabel.setText("@Usuário não logado");
		}
		userLabel.revalidate();
		userLabel.repaint();
	}

	public static void updateBioLabel(JTextArea bioTextArea) {
		if (AccountManager.getLoggedAccount() != null) {
			bioTextArea.setText(AccountManager.getLoggedAccount().getBio());
		} else {
			bioTextArea.setText("A bio ainda nao foi definida!");
		}
		bioTextArea.revalidate();
		bioTextArea.repaint();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		Database.checkAndCreateFiles();
		Database.readFiles();
		new AccountManager();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frames window = new Frames();
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
	public Frames() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("LibRate");
		frame.getContentPane().setMaximumSize(new Dimension(900, 600));
		frame.getContentPane().setBackground(new Color(0, 64, 128));
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		
		JPanel login = new JPanel();
		login.setBackground(new Color(0, 64, 128));
		frame.getContentPane().add(login, "name_335144528078500");
		login.setLayout(new BorderLayout(0, 0));

		JPanel cima = new JPanel();
		cima.setBackground(new Color(0, 64, 128));
		login.add(cima, BorderLayout.NORTH);
		
		JLabel LibRateLabel = new JLabel("");
		LibRateLabel.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/Cabeçalho-removebg-preview.png")));
		cima.add(LibRateLabel);

		JPanel baixo = new JPanel();
		baixo.setBackground(new Color(0, 64, 128));
		login.add(baixo, BorderLayout.SOUTH);

		JLabel noSignUpLabel = new JLabel("Não tem cadastro?");
		noSignUpLabel.setForeground(new Color(255, 255, 255));
		noSignUpLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		baixo.add(noSignUpLabel);

		JLabel clickHereLabel = new JLabel("<html><u>Clique Aqui</u></html>");
		clickHereLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		clickHereLabel.setForeground(new Color(255, 255, 255));
		baixo.add(clickHereLabel);

		JPanel meio = new JPanel();
		meio.setBackground(new Color(0, 64, 128));
		login.add(meio, BorderLayout.CENTER);
		GridBagLayout gbl_meio = new GridBagLayout();
		gbl_meio.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_meio.rowHeights = new int[]{0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 1, 0};
		gbl_meio.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_meio.rowWeights = new double[]{0.0, 0.0, 0.0, 4.0, 4.0, 0.0, 0.0, 3.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		meio.setLayout(gbl_meio);

		JLabel userLoginLabel = new JLabel("         Usuário:");
		userLoginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		userLoginLabel.setForeground(new Color(255, 255, 255));
		userLoginLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 23));
		GridBagConstraints gbc_userLoginLabel = new GridBagConstraints();
		gbc_userLoginLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userLoginLabel.gridx = 3;
		gbc_userLoginLabel.gridy = 3;
		meio.add(userLoginLabel, gbc_userLoginLabel);

		usuarioTextField = new JTextField();
		usuarioTextField.setColumns(50);
		GridBagConstraints gbc_usuarioTextField = new GridBagConstraints();
		gbc_usuarioTextField.insets = new Insets(0, 0, 5, 0);
		gbc_usuarioTextField.gridx = 4;
		gbc_usuarioTextField.gridy = 3;
		meio.add(usuarioTextField, gbc_usuarioTextField);


		JLabel passwordLabel = new JLabel("      Senha:");
		passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		passwordLabel.setForeground(new Color(255, 255, 255));
		passwordLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 23));
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.gridx = 3;
		gbc_passwordLabel.gridy = 4;
		meio.add(passwordLabel, gbc_passwordLabel);

		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(50);
		GridBagConstraints gbc_passwordTextField = new GridBagConstraints();
		gbc_passwordTextField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordTextField.gridx = 4;
		gbc_passwordTextField.gridy = 4;
		meio.add(passwordTextField, gbc_passwordTextField);

		JButton loginButton = new JButton("Entrar");
		loginButton.setFont(new Font("Lucida Sans", Font.PLAIN, 23));
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.insets = new Insets(0, 0, 5, 0);
		gbc_loginButton.gridx = 4;
		gbc_loginButton.gridy = 7;
		meio.add(loginButton, gbc_loginButton);

		JPanel cadastro = new JPanel();
		cadastro.setBackground(new Color(0, 64, 128));
		frame.getContentPane().add(cadastro, "name_335147810155900");
		cadastro.setLayout(new BorderLayout(0, 0));

		clickHereLabel.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				login.setVisible(false);
				cadastro.setVisible(true);
			}
		});
		//botão que leva a tela de cadastro

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 64, 128));
		cadastro.add(panel_1, BorderLayout.NORTH);

		JLabel signUpAreaLabel = new JLabel("Área de cadastro:");
		signUpAreaLabel.setForeground(new Color(255, 255, 255));
		signUpAreaLabel.setFont(new Font("Bell MT", Font.BOLD, 50));
		panel_1.add(signUpAreaLabel);

		JPanel meio_1 = new JPanel();
		meio_1.setBackground(new Color(0, 64, 128));
		cadastro.add(meio_1, BorderLayout.CENTER);
		GridBagLayout gbl_meio_1 = new GridBagLayout();
		gbl_meio_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_meio_1.rowHeights = new int[]{0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 1, 0};
		gbl_meio_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_meio_1.rowWeights = new double[]{0.0, 0.0, 0.0, 4.0, 4.0, 0.0, 0.0, 3.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		meio_1.setLayout(gbl_meio_1);

		JLabel userSignUpLabel = new JLabel("Usuário:");
		userSignUpLabel.setForeground(Color.WHITE);
		userSignUpLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 23));
		userSignUpLabel.setAlignmentX(0.5f);
		GridBagConstraints gbc_userSignUpLabel = new GridBagConstraints();
		gbc_userSignUpLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userSignUpLabel.gridx = 3;
		gbc_userSignUpLabel.gridy = 3;
		meio_1.add(userSignUpLabel, gbc_userSignUpLabel);

		signUpTextField = new JTextField();
		signUpTextField.setColumns(50);
		GridBagConstraints gbc_signUpTextField = new GridBagConstraints();
		gbc_signUpTextField.insets = new Insets(0, 0, 5, 0);
		gbc_signUpTextField.gridx = 4;
		gbc_signUpTextField.gridy = 3;
		meio_1.add(signUpTextField, gbc_signUpTextField);

		JLabel passwordSignUpLabel = new JLabel("Senha:");
		passwordSignUpLabel.setForeground(Color.WHITE);
		passwordSignUpLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 23));
		passwordSignUpLabel.setAlignmentX(0.5f);
		GridBagConstraints gbc_passwordSignUpLabel = new GridBagConstraints();
		gbc_passwordSignUpLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordSignUpLabel.gridx = 3;
		gbc_passwordSignUpLabel.gridy = 4;
		meio_1.add(passwordSignUpLabel, gbc_passwordSignUpLabel);

		passwordSignUpTextField = new JPasswordField();
		passwordSignUpTextField.setColumns(50);
		GridBagConstraints gbc_passwordSignUpTextField = new GridBagConstraints();
		gbc_passwordSignUpTextField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordSignUpTextField.gridx = 4;
		gbc_passwordSignUpTextField.gridy = 4;
		meio_1.add(passwordSignUpTextField, gbc_passwordSignUpTextField);

		JButton signUpButton = new JButton("Cadastrar");
		signUpButton.setFont(new Font("Lucida Sans", Font.PLAIN, 23));
		GridBagConstraints gbc_signUpButton = new GridBagConstraints();
		gbc_signUpButton.insets = new Insets(0, 0, 5, 0);
		gbc_signUpButton.gridx = 4;
		gbc_signUpButton.gridy = 7;
		meio_1.add(signUpButton, gbc_signUpButton);

		JPanel telaInicial = new JPanel();
		telaInicial.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(telaInicial, "name_394855230731500");
		telaInicial.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel.setBackground(new Color(255, 255, 255));
		telaInicial.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel.add(panel_3, BorderLayout.CENTER);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{53, 85, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
						
								JButton changeUserButton = new JButton(" Mudar user ");
								changeUserButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										String user = JOptionPane.showInputDialog(null, "Digite seu novo user:", "Mudar user", JOptionPane.QUESTION_MESSAGE);
										AccountManager.getLoggedAccount().changeLogin(user);
									}
								});
														
														JLabel snoopyInitialPage = new JLabel("");
														snoopyInitialPage.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/SnoopyLendoTelaInnicial.png")));
														GridBagConstraints gbc_snoopyInitialPage = new GridBagConstraints();
														gbc_snoopyInitialPage.anchor = GridBagConstraints.WEST;
														gbc_snoopyInitialPage.insets = new Insets(0, 0, 5, 5);
														gbc_snoopyInitialPage.gridx = 1;
														gbc_snoopyInitialPage.gridy = 1;
														panel_3.add(snoopyInitialPage, gbc_snoopyInitialPage);
												
														JLabel dynamicUserLabel = new JLabel("@");
														//     EDITAR!!!
														GridBagConstraints gbc_dynamicUserLabel = new GridBagConstraints();
														gbc_dynamicUserLabel.insets = new Insets(0, 0, 5, 5);
														gbc_dynamicUserLabel.gridx = 1;
														gbc_dynamicUserLabel.gridy = 2;
														panel_3.add(dynamicUserLabel, gbc_dynamicUserLabel);
										
												JLabel bioLabel = new JLabel("Amo livros!");
												GridBagConstraints gbc_bioLabel = new GridBagConstraints();
												gbc_bioLabel.insets = new Insets(0, 0, 5, 5);
												gbc_bioLabel.gridx = 1;
												gbc_bioLabel.gridy = 3;
												panel_3.add(bioLabel, gbc_bioLabel);
								
										JButton viewProfileButton = new JButton("    Ver perfil    ");
										viewProfileButton.setBackground(new Color(255, 255, 255));
										GridBagConstraints gbc_viewProfileButton = new GridBagConstraints();
										gbc_viewProfileButton.insets = new Insets(0, 0, 5, 5);
										gbc_viewProfileButton.gridx = 1;
										gbc_viewProfileButton.gridy = 4;
										panel_3.add(viewProfileButton, gbc_viewProfileButton);
										//botão de login: certificar que os dois texts labels estejam preenchidos,
										//certificar que existe esse username e a senha atrelada a ele esteja correta

								changeUserButton.setBackground(new Color(255, 255, 255));
								GridBagConstraints gbc_changeUserButton = new GridBagConstraints();
								gbc_changeUserButton.insets = new Insets(0, 0, 5, 5);
								gbc_changeUserButton.gridx = 1;
								gbc_changeUserButton.gridy = 6;
								panel_3.add(changeUserButton, gbc_changeUserButton);
				
						JButton changePasswordButton = new JButton("Mudar senha ");
						changePasswordButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String senha = JOptionPane.showInputDialog(null, "Digite sua senha:", "Mudar senha", JOptionPane.QUESTION_MESSAGE);
								AccountManager.getLoggedAccount().changePassword(senha);
							}
						});
						changePasswordButton.setBackground(new Color(255, 255, 255));
						GridBagConstraints gbc_changePasswordButton = new GridBagConstraints();
						gbc_changePasswordButton.insets = new Insets(0, 0, 5, 5);
						gbc_changePasswordButton.gridx = 1;
						gbc_changePasswordButton.gridy = 8;
						panel_3.add(changePasswordButton, gbc_changePasswordButton);
						
						JButton logoutButton = new JButton("Logout\r\n");
						logoutButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								telaInicial.setVisible(false);
								login.setVisible(true);
							}
						});
						GridBagConstraints gbc_logoutButton = new GridBagConstraints();
						gbc_logoutButton.insets = new Insets(0, 0, 5, 5);
						gbc_logoutButton.gridx = 1;
						gbc_logoutButton.gridy = 10;
						panel_3.add(logoutButton, gbc_logoutButton);

		JScrollBar scrollBar = new JScrollBar();
		telaInicial.add(scrollBar, BorderLayout.EAST);

		JPanel panel_2 = new JPanel();
		telaInicial.add(panel_2, BorderLayout.NORTH);

		searchTextField = new JTextField();
		panel_2.add(searchTextField);
		searchTextField.setColumns(30);

		JButton searchButton = new JButton("🔎");
		panel_2.add(searchButton);

		String[] columns = {"Título", "Autor", "Gênero"};

		DefaultTableModel model = new DefaultTableModel(BookManager.getBookData(), columns);

		JTable bookChart = new JTable(model);

		for (Book b : BookData.getBookList()) {
			try {
				BookManager.addBook(b, bookChart);
			} catch (BookAlreadyExistsException e) {
				System.out.println(e.getMessage());
			}
		}

		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String pesquisa = searchTextField.getText().toLowerCase();

				if(pesquisa.equals("")){
					for (Book b : BookData.getBookList()) {
					try {
						BookManager.addBook(b, bookChart);
					} catch (BookAlreadyExistsException baee) {
						System.out.println(baee.getMessage());
					}
				}

				}

				DefaultTableModel model = (DefaultTableModel) bookChart.getModel();
				model.setRowCount(0);

				List<Book> livrosEncontrados = new ArrayList<>();

				for (Book livro : BookData.getBookList()) {
					if (livro.getTitle().toLowerCase().contains(pesquisa) ||
							(livro.getAuthor() != null && livro.getAuthor().getName().toLowerCase().contains(pesquisa))) {
						livrosEncontrados.add(livro);
					}
				}

				if (livrosEncontrados.isEmpty()) {
					System.out.println("Nenhum livro encontrado.");  //faz um pop up aqui
				} else {
					System.out.println("Livros encontrados:");
					for (Book livro : livrosEncontrados) {
						Object[] row = new Object[]{
								livro.getTitle(),
								livro.getAuthor() != null ? livro.getAuthor().getName() : "Autor Desconhecido",
								livro.getGenre().getGenreString()
						};
						model.addRow(row);
					}
				}
			}
		});


		JScrollPane booklistScrollPane = new JScrollPane(bookChart);
		telaInicial.add(booklistScrollPane, BorderLayout.CENTER);

		JPanel perfil = new JPanel();
		frame.getContentPane().add(perfil, "name_399382685377000");
		perfil.setLayout(new BorderLayout(0, 0));

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		perfil.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new BorderLayout(0, 0));

		JLabel snoopyProfile = new JLabel("");
		snoopyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		snoopyProfile.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/snoopilendo.jpg")));
		panel_8.add(snoopyProfile);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(new Color(255, 255, 255));
		panel_8.add(panel_21, BorderLayout.NORTH);
		panel_21.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton returnButton = new JButton("<");
		returnButton.setBackground(new Color(255, 255, 255));
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfil.setVisible(false);
				telaInicial.setVisible(true);
			}
		});
		returnButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_21.add(returnButton);
		

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		perfil.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton changeBioButton = new JButton("Mudar bio");
		changeBioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(null, "Digite sua bio:", "Mudar bio", JOptionPane.QUESTION_MESSAGE);
				AccountManager.getLoggedAccount().setBio(input);
			}
		});
		changeBioButton.setForeground(new Color(0, 0, 128));
		changeBioButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		changeBioButton.setBackground(Color.WHITE);
		panel_9.add(changeBioButton);

		JButton likedBooksButton = new JButton("Livros curtidos");
		likedBooksButton.setForeground(new Color(0, 0, 128));
		likedBooksButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		likedBooksButton.setBackground(new Color(255, 255, 255));
		panel_9.add(likedBooksButton);

		JButton toReadBooksButton = new JButton("Lista ToRead");
		toReadBooksButton.setBackground(new Color(255, 255, 255));
		toReadBooksButton.setForeground(new Color(0, 0, 128));
		toReadBooksButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_9.add(toReadBooksButton);

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_10.setBackground(new Color(255, 255, 255));
		perfil.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new BorderLayout(0, 0));

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 255, 255));
		panel_10.add(panel_11, BorderLayout.NORTH);

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 255, 255));
		panel_10.add(panel_12, BorderLayout.CENTER);
		panel_12.setLayout(new BorderLayout(0, 0));

		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(255, 255, 255));
		panel_12.add(panel_15, BorderLayout.CENTER);

		JTextArea bioTextArea = new JTextArea();
		bioTextArea.setEditable(false);
		bioTextArea.setFont(new Font("Monospaced", Font.PLAIN, 17));
		bioTextArea.setColumns(70);
		bioTextArea.setTabSize(20);
		bioTextArea.setRows(2);
		bioTextArea.setText("Leio de tudo, mas nem tudo me agrada. 📖✨ Se o livro for bom, eu elogio; se for ruim, eu argumento. Expectativas altas, críticas sinceras e um toque de arrogância literária. Vamos discutir? 😏 #LeituraCrítica #OpiniõesFortes");
		panel_15.add(bioTextArea);
		bioTextArea.setLineWrap(true);
		bioTextArea.setWrapStyleWord(true);

		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel livro = new JPanel();
		frame.getContentPane().add(livro, "name_564775775717100");
		livro.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		livro.add(panel_5, BorderLayout.NORTH);

		JLabel dynamicUserLabel2 = new JLabel("@");
		dynamicUserLabel2.revalidate();
		dynamicUserLabel2.repaint();
		dynamicUserLabel2.setFont(new Font("Tahoma", Font.PLAIN, 29));
		panel_11.add(dynamicUserLabel2);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(new Color(255, 255, 255));
		livro.add(panel_4, BorderLayout.WEST);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{199, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 10, 0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);

		JButton returnButton2 = new JButton("<");

		GridBagConstraints gbc_returnButton2 = new GridBagConstraints();
		gbc_returnButton2.anchor = GridBagConstraints.WEST;
		gbc_returnButton2.insets = new Insets(0, 0, 5, 0);
		gbc_returnButton2.gridx = 0;
		gbc_returnButton2.gridy = 0;
		panel_4.add(returnButton2, gbc_returnButton2);
		

		JLabel snoopyBook = new JLabel("");
		GridBagConstraints gbc_snoopyBook = new GridBagConstraints();
		gbc_snoopyBook.insets = new Insets(0, 0, 5, 0);
		gbc_snoopyBook.gridx = 0;
		gbc_snoopyBook.gridy = 1;
		panel_4.add(snoopyBook, gbc_snoopyBook);
		snoopyBook.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/SnoopyCoffee.png")));

		JLabel rateLabel = new JLabel("Dê uma nota:");
		rateLabel.setFont(new Font("Monospaced", Font.PLAIN, 17));
		GridBagConstraints gbc_rateLabel = new GridBagConstraints();
		gbc_rateLabel.insets = new Insets(0, 0, 5, 0);
		gbc_rateLabel.gridx = 0;
		gbc_rateLabel.gridy = 3;
		panel_4.add(rateLabel, gbc_rateLabel);

		JLabel starImage = new JLabel("");
		starImage.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/estrelaVaziaPoo.png")));
		GridBagConstraints gbc_starImage = new GridBagConstraints();
		gbc_starImage.insets = new Insets(0, 0, 5, 0);
		gbc_starImage.gridx = 0;
		gbc_starImage.gridy = 4;
		panel_4.add(starImage, gbc_starImage);

		JLabel likeLabel = new JLabel("Curta:");
		likeLabel.setFont(new Font("Monospaced", Font.PLAIN, 17));
		GridBagConstraints gbc_likeLabel = new GridBagConstraints();
		gbc_likeLabel.insets = new Insets(0, 0, 5, 0);
		gbc_likeLabel.gridx = 0;
		gbc_likeLabel.gridy = 5;
		panel_4.add(likeLabel, gbc_likeLabel);

		JLabel emptyHeartImage = new JLabel("");
		emptyHeartImage.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/coracao.png")));
		GridBagConstraints gbc_emptyHeartImage = new GridBagConstraints();
		gbc_emptyHeartImage.insets = new Insets(0, 0, 5, 0);
		gbc_emptyHeartImage.gridx = 0;
		gbc_emptyHeartImage.gridy = 6;
		panel_4.add(emptyHeartImage, gbc_emptyHeartImage);

		JLabel addToBeReadLabel = new JLabel("<html><div style='text-align: center;'><u>Adicionar a</u><br><u>ToBeRead</u></div></html>\r\n");
		addToBeReadLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		addToBeReadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addToBeReadLabel.setFont(new Font("Monospaced", Font.PLAIN, 17));
		GridBagConstraints gbc_addToBeReadLabel = new GridBagConstraints();
		gbc_addToBeReadLabel.gridx = 0;
		gbc_addToBeReadLabel.gridy = 7;
		panel_4.add(addToBeReadLabel, gbc_addToBeReadLabel);

		JPanel panel_6 = new JPanel();
		panel_6.setPreferredSize(new Dimension(189, 10));
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBackground(new Color(255, 255, 255));
		livro.add(panel_6, BorderLayout.EAST);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{112, 0};
		gbl_panel_6.rowHeights = new int[]{36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);

		JLabel ratingsLabel = new JLabel("<html><div style='text-align: center;'>Média de<br>avaliações:</div></html>\r\n");
		ratingsLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		ratingsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ratingsLabel.setFont(new Font("Monospaced", Font.PLAIN, 17));
		GridBagConstraints gbc_ratingsLabel = new GridBagConstraints();
		gbc_ratingsLabel.insets = new Insets(0, 0, 5, 0);
		gbc_ratingsLabel.anchor = GridBagConstraints.NORTH;
		gbc_ratingsLabel.gridx = 0;
		gbc_ratingsLabel.gridy = 1;
		panel_6.add(ratingsLabel, gbc_ratingsLabel);

		JLabel numLikesLabel = new JLabel("<html><div style='text-align: center;'>Quantidade<br>de curtidas:</div></html>\r\n");
		numLikesLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		numLikesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numLikesLabel.setFont(new Font("Monospaced", Font.PLAIN, 17));
		GridBagConstraints gbc_numLikesLabel = new GridBagConstraints();
		gbc_numLikesLabel.insets = new Insets(0, 0, 5, 0);
		gbc_numLikesLabel.gridx = 0;
		gbc_numLikesLabel.gridy = 7;
		panel_6.add(numLikesLabel, gbc_numLikesLabel);

		JLabel moreAboutAuthorLabel = new JLabel("<html><div style='text-align: center;'><u>Saiba mais</u><br><u>sobre o autor!</u></div></html>\r\n");
		moreAboutAuthorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		moreAboutAuthorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moreAboutAuthorLabel.setFont(new Font("Monospaced", Font.PLAIN, 17));
		GridBagConstraints gbc_moreAboutAuthorLabel = new GridBagConstraints();
		gbc_moreAboutAuthorLabel.anchor = GridBagConstraints.SOUTH;
		gbc_moreAboutAuthorLabel.insets = new Insets(0, 0, 5, 0);
		gbc_moreAboutAuthorLabel.gridx = 0;
		gbc_moreAboutAuthorLabel.gridy = 12;
		panel_6.add(moreAboutAuthorLabel, gbc_moreAboutAuthorLabel);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(128, 128, 128));
		livro.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));

		JPanel panelf30 = new JPanel();
		panelf30.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelf30.setBackground(new Color(255, 255, 255));
		panel_7.add(panelf30, BorderLayout.NORTH);
		
		autor = new JPanel();
		frame.getContentPane().add(autor, "name_61629018393600");
		autor.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(255, 255, 255));
		autor.add(panel_13, BorderLayout.NORTH);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		JButton likeButton2 = new JButton("New button");
		panel_13.add(likeButton2);
		
		JLabel snoopyAuthor = new JLabel("");
		snoopyAuthor.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		panel_13.add(snoopyAuthor, BorderLayout.CENTER);
		snoopyAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon snoopi = new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/snoopiescreve.jpg"));
		Image snoopi1 =snoopi.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon snoopi2 = new ImageIcon(snoopi1);
		snoopyAuthor.setIcon(snoopi2);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(255, 255, 255));
		panel_13.add(panel_18, BorderLayout.NORTH);
		panel_18.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton returnButton3 = new JButton("<");
		returnButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				autor.setVisible(false);
				telaInicial.setVisible(true);
			}
		});
		returnButton3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		returnButton3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_18.add(returnButton3);
		
		
		JPanel panel_14 = new JPanel();
		autor.add(panel_14, BorderLayout.CENTER);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(255, 255, 255));
		panel_14.add(panel_16, BorderLayout.NORTH);
		ImageIcon coracaoVazio = new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/coracaoVazio (1).png"));
		
		
		
		JLabel dynamicAuthorLabel = new JLabel("nome autor");
		dynamicAuthorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dynamicAuthorLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		panel_16.add(dynamicAuthorLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_14.add(scrollPane_1, BorderLayout.CENTER);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(255, 255, 255));
		scrollPane_1.setColumnHeaderView(panel_17);
		panel_17.setLayout(new GridLayout(1, 2, 10, 10));
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(new Color(255, 255, 255));
		panel_17.add(panel_20);
		panel_20.setLayout(new BorderLayout(0, 0));
		
		JToggleButton likeButton = new JToggleButton(" Curtir");
		likeButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_20.add(likeButton);
		likeButton.setSelectedIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/coracaoCheio (2).png")));
		likeButton.setBackground(new Color(255, 255, 255));
		likeButton.setIcon(coracaoVazio);
		
		JLabel ratingsLabel2 = new JLabel("n°");
		ratingsLabel2.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/star.png")));
		ratingsLabel2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ratingsLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_17.add(ratingsLabel2);
		
		JLabel likesLabel = new JLabel("  n°");
		likesLabel.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/coracaoCheio (2).png")));
		likesLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		likesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_17.add(likesLabel);
		
		JPanel panel_19 = new JPanel();
		panel_17.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		JButton booksFromAuthorButton = new JButton(" Livros do autor");
		booksFromAuthorButton.setBackground(new Color(255, 255, 255));
		booksFromAuthorButton.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/images (1).png")));
		booksFromAuthorButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_19.add(booksFromAuthorButton);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBackground(new Color(255, 255, 255));
		scrollPane_1.setViewportView(panel_22);
		panel_22.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_23 = new JPanel();
		panel_23.setBackground(new Color(255, 255, 255));
		panel_22.add(panel_23);
		GridBagLayout gbl_panel_23 = new GridBagLayout();
		gbl_panel_23.columnWidths = new int[] {30, 0, 0, 30};
		gbl_panel_23.rowHeights = new int[] {30, 0, 0, 0, 0, 30};
		gbl_panel_23.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_23.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_23.setLayout(gbl_panel_23);
		
		JLabel lblNewLabel_12;
		GridBagConstraints gbc_lblNewLabel_12;
		
		////
		JPanel adminTelaInicial = new JPanel();
		adminTelaInicial.setBackground(Color.WHITE);
		frame.getContentPane().add(adminTelaInicial, "name_9459870208000");
		adminTelaInicial.setLayout(new BorderLayout(0, 0));
		
		
		

		JPanel panelAdmin = new JPanel();
		panelAdmin.setBorder(new LineBorder(new Color(0, 0, 128)));
		panelAdmin.setBackground(new Color(255, 255, 255));
		adminTelaInicial.add(panelAdmin, BorderLayout.WEST);
		panelAdmin.setLayout(new BorderLayout(0, 0));

		JPanel panel_3admin = new JPanel();
		panel_3admin.setBackground(new Color(255, 255, 255));
		panelAdmin.add(panel_3admin, BorderLayout.CENTER);
		GridBagLayout gbl_panel_3admin = new GridBagLayout();
		gbl_panel_3admin.columnWidths = new int[]{53, 85, 0, 0, 0, 0};
		gbl_panel_3admin.rowHeights = new int[]{0, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3admin.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3admin.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_3admin.setLayout(gbl_panel_3admin);
								changeUserButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										
									}
								});
														
														JLabel lblNewLabel_7admin = new JLabel("");
														lblNewLabel_7admin.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/snoopilendotelainicial.jpg")));
														GridBagConstraints gbc_lblNewLabel_7admin = new GridBagConstraints();
														gbc_lblNewLabel_7admin.anchor = GridBagConstraints.WEST;
														gbc_lblNewLabel_7admin.insets = new Insets(0, 0, 5, 5);
														gbc_lblNewLabel_7admin.gridx = 1;
														gbc_lblNewLabel_7admin.gridy = 1;
														panel_3.add(lblNewLabel_7admin, gbc_lblNewLabel_7admin);
										
												JLabel lblNewLabel_8admin = new JLabel("Amo livros!");
												GridBagConstraints gbc_lblNewLabel_8admin = new GridBagConstraints();
												gbc_lblNewLabel_8admin.insets = new Insets(0, 0, 5, 5);
												gbc_lblNewLabel_8admin.gridx = 1;
												gbc_lblNewLabel_8admin.gridy = 3;
												panel_3.add(lblNewLabel_8admin, gbc_lblNewLabel_8admin);
										
										JLabel adminLabel = new JLabel("Administrador");
										adminLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
										GridBagConstraints gbc_adminLabel = new GridBagConstraints();
										gbc_adminLabel.insets = new Insets(0, 0, 5, 5);
										gbc_adminLabel.gridx = 1;
										gbc_adminLabel.gridy = 2;
										panel_3admin.add(adminLabel, gbc_adminLabel);
								
										JButton addBookButton = new JButton("Adicionar livro");
										addBookButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
										addBookButton.setBackground(new Color(255, 255, 255));
										GridBagConstraints gbc_addBookButton = new GridBagConstraints();
										gbc_addBookButton.insets = new Insets(0, 0, 5, 5);
										gbc_addBookButton.gridx = 1;
										gbc_addBookButton.gridy = 4;
										panel_3admin.add(addBookButton, gbc_addBookButton);
						changePasswordButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
							}
						});
						
						JButton logoutButton2 = new JButton("Logout\r\n");
						logoutButton2.setFont(new Font("Tahoma", Font.PLAIN, 16));
						logoutButton2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								adminTelaInicial.setVisible(false);
								login.setVisible(true);
							}
						});
						
								JButton removeBookButton = new JButton("Remover livro");
								removeBookButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
								//botão de login: certificar que os dois texts labels estejam preenchidos,
								//certificar que existe esse username e a senha atrelada a ele esteja correta

								removeBookButton.setBackground(new Color(255, 255, 255));
								GridBagConstraints gbc_removeBookButton = new GridBagConstraints();
								gbc_removeBookButton.insets = new Insets(0, 0, 5, 5);
								gbc_removeBookButton.gridx = 1;
								gbc_removeBookButton.gridy = 7;
								panel_3admin.add(removeBookButton, gbc_removeBookButton);
						
						GridBagConstraints gbc_logoutButton2 = new GridBagConstraints();
						gbc_logoutButton2.insets = new Insets(0, 0, 5, 5);
						gbc_logoutButton2.gridx = 1;
						gbc_logoutButton2.gridy = 10;
						panel_3admin.add(logoutButton2, gbc_logoutButton2);

		JScrollBar scrollBarAdmin = new JScrollBar();
		adminTelaInicial.add(scrollBarAdmin, BorderLayout.EAST);

		JPanel panel_2admin = new JPanel();
		adminTelaInicial.add(panel_2admin, BorderLayout.NORTH);

		///??????
		JTextField searchTextField2 = new JTextField();
		panel_2admin.add(searchTextField2);
		searchTextField2.setColumns(30);

		JButton searchButton2 = new JButton("🔎");
		panel_2admin.add(searchButton2);

		String[] columns1 = {"Título", "Autor", "Gênero"};

		DefaultTableModel model1 = new DefaultTableModel(BookManager.getBookData(), columns);

		JTable bookChart2 = new JTable(model);

		for (Book b : BookData.getBookList()) {
			try {
				BookManager.addBook(b, bookChart2);
			} catch (BookAlreadyExistsException e) {
				System.out.println(e.getMessage());
			}
		}

		searchButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String pesquisa = searchTextField.getText().toLowerCase();

				if(pesquisa.equals("")){
					for (Book b : BookData.getBookList()) {
					try {
						BookManager.addBook(b, bookChart2);
					} catch (BookAlreadyExistsException baee) {
						System.out.println(baee.getMessage());
					}
				}

				}

				DefaultTableModel model = (DefaultTableModel) bookChart2.getModel();
				model1.setRowCount(0);

				List<Book> livrosEncontrados = new ArrayList<>();

				for (Book livro : BookData.getBookList()) {
					if (livro.getTitle().toLowerCase().contains(pesquisa) ||
							(livro.getAuthor() != null && livro.getAuthor().getName().toLowerCase().contains(pesquisa))) {
						livrosEncontrados.add(livro);
					}
				}

				if (livrosEncontrados.isEmpty()) {
					System.out.println("Nenhum livro encontrado.");  //faz um pop up aqui
				} else {
					System.out.println("Livros encontrados:");
					for (Book livro : livrosEncontrados) {
						Object[] row = new Object[]{
								livro.getTitle(),
								livro.getAuthor() != null ? livro.getAuthor().getName() : "Autor Desconhecido",
								livro.getGenre().getGenreString()
						};
						model1.addRow(row);
					}
				}
			}
		});


		JScrollPane booklistScrollPane2 = new JScrollPane(bookChart2
				);
		adminTelaInicial.add(booklistScrollPane2, BorderLayout.CENTER);

		
		

//////		 
		
		
		
		
		
		

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = usuarioTextField.getText();
				String password = new String(passwordTextField.getPassword());

				if (user.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(frame, "Campo do usuário ou senha vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					
					
					AccountManager.login(user, password, frame);
					Frames.updateUserLabel(dynamicUserLabel2);
					Frames.updateUserLabel(dynamicUserLabel);
					Frames.updateBioLabel(bioTextArea);
					login.setVisible(false);
					
					// TODO desfazer cagada
					if (AccountManager.getLoggedAccount() instanceof AdminAccount) {
						adminTelaInicial.setVisible(true);	
						usuarioTextField.setText("");
						passwordTextField.setText("");
						
					} else if (AccountManager.getLoggedAccount() instanceof NormalAccount){
						telaInicial.setVisible(true);
						usuarioTextField.setText("");
						passwordTextField.setText("");
					}
					
					
					
					
				} catch (IncorrectCredentialsException ex) {
					JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			}
		});

		viewProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaInicial.setVisible(false);
				perfil.setVisible(true);
			}
		});
		//botão para ver perfil

		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = signUpTextField.getText();
				String password = new String(passwordSignUpTextField.getPassword());

				if (user.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "Campo do usuário ou senha vazio!");
				} else {
					try {
						AccountManager.register(user, password, frame);
						Frames.updateUserLabel(dynamicUserLabel2);
						Frames.updateUserLabel(dynamicUserLabel);
						Frames.updateBioLabel(bioTextArea);
						JOptionPane.showMessageDialog(null, "Conta criada com sucesso! Seja bem vindo(a)!");
						cadastro.setVisible(false);
						telaInicial.setVisible(true);
						signUpTextField.setText("");
						passwordSignUpTextField.setText("");
					} catch (AccountAlreadyExistsException ex) {
						JOptionPane.showMessageDialog(null, "Nome de usuário já existe!");
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
				}
			}
		});
		//botão de cadastro: certificar que os dois texts labels estejam preenchidos,
		//certificar que não tem o username existentes

		JLabel nomeLivroLabel = new JLabel();
		nomeLivroLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));

		JLabel lblNewLabel_f30 = new JLabel();
		lblNewLabel_f30.setFont(new Font("Monospaced", Font.PLAIN, 20));

		JLabel lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setFont(new Font("Monospaced", Font.PLAIN, 20));

		JTextArea txtrNaAberturaDos = new JTextArea();
		txtrNaAberturaDos.setFont(new Font("Monospaced", Font.PLAIN, 17));

		bookChart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				panelf30.removeAll();
				panelf30.revalidate();
				panelf30.repaint();

				int linha = bookChart.getSelectedRow();
				String tituloLivro = bookChart.getValueAt(linha, 0).toString();
				for (Book b : BookData.getBookList()) {
					if (tituloLivro.equals(b.getTitle())) {
						livroSelecionado = b;
						break;
					}
				}

				assert livroSelecionado != null;
				nomeLivroLabel.setText(livroSelecionado.getTitle());
				panel_5.add(nomeLivroLabel);

				if (livroSelecionado.getAuthor() == null) {
					lblNewLabel_14.setText("Autor Desconhecido" + " - " + livroSelecionado.getGenre().getGenreString());
				} else {
					lblNewLabel_14.setText(livroSelecionado.getAuthor().getName() + " - " + livroSelecionado.getGenre().getGenreString());
				}
				panelf30.add(lblNewLabel_14);

				txtrNaAberturaDos.setText(livroSelecionado.getSynopsis());
				txtrNaAberturaDos.setEditable(false);
				txtrNaAberturaDos.setLineWrap(true);
				txtrNaAberturaDos.setWrapStyleWord(true);
				panel_7.add(txtrNaAberturaDos, BorderLayout.CENTER);

				if (addToBeReadLabel.getMouseListeners().length == 0) {
					addToBeReadLabel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (!(AccountManager.getLoggedAccount().getToReadBooks().contains(livroSelecionado))) {
								AccountManager.getLoggedAccount().getToReadBooks().add(livroSelecionado);
								System.out.println(livroSelecionado.getTitle() + " adicionado");
							} else {
								System.out.println("Livro já adicionado!");
							}
						}
					});
				}

				returnButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_5.remove(nomeLivroLabel);
						livro.setVisible(false);
						telaInicial.setVisible(true);
					}
				});

				telaInicial.setVisible(false);
				livro.setVisible(true);

			}
		});
		moreAboutAuthorLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			livro.setVisible(false);
			autor.setVisible(true);
			}
		});
	}
	
}
