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
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import br.com.ufc.librate.Data.BookData;
import br.com.ufc.librate.Data.Database;
import br.com.ufc.librate.exceptions.AccountAlreadyExistsException;
import br.com.ufc.librate.exceptions.BookAlreadyExistsException;
import br.com.ufc.librate.exceptions.IncorrectCredentialsException;
import br.com.ufc.librate.tools.AccountManager;
import br.com.ufc.librate.tools.BookManager;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
public class Frames {

	private JFrame frame;
	private JPanel panel_1;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textFieldCadastro;
	private JPasswordField passwordFieldCadastro;
	private JTextField pesquisarTextField;
	
//	private String[][] bookData = {{"teste", "teste", "teste"}, {"teste2", "teste2", "teste2"}};
	private List<List<String>> bookDataAux;

	public static  void updateUserLabel(JLabel userLabel) {
		if (AccountManager.getLoggedAccount() != null) {
			userLabel.setText("@" + AccountManager.getLoggedAccount().getUser());
		} else {
			userLabel.setText("@Usuário não logado");
		}
		userLabel.revalidate();
		userLabel.repaint();
	}
	public static  void updateBioLabel(JTextArea bioTextArea) {
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
		frame = new JFrame();
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

		JLabel LibRate = new JLabel("LibRate");
		LibRate.setForeground(new Color(255, 255, 255));
		LibRate.setFont(new Font("Bell MT", Font.BOLD, 65));
		cima.add(LibRate);

		JPanel baixo = new JPanel();
		baixo.setBackground(new Color(0, 64, 128));
		login.add(baixo, BorderLayout.SOUTH);

		JLabel lblNewLabel_1 = new JLabel("Não tem cadastro?");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		baixo.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("<html><u>Clique Aqui</u></html>");
		lblNewLabel_2.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		baixo.add(lblNewLabel_2);

		JPanel meio = new JPanel();
		meio.setBackground(new Color(0, 64, 128));
		login.add(meio, BorderLayout.CENTER);
		GridBagLayout gbl_meio = new GridBagLayout();
		gbl_meio.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_meio.rowHeights = new int[]{0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 1, 0};
		gbl_meio.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_meio.rowWeights = new double[]{0.0, 0.0, 0.0, 4.0, 4.0, 0.0, 0.0, 3.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		meio.setLayout(gbl_meio);

		JLabel lblNewLabel = new JLabel("         Usuário:");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 3;
		meio.add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		textField.setColumns(50);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 3;
		meio.add(textField, gbc_textField);


		JLabel lblNewLabel_4 = new JLabel("      Senha:");
		lblNewLabel_4.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("MS UI Gothic", Font.PLAIN, 23));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 3;
		gbc_lblNewLabel_4.gridy = 4;
		meio.add(lblNewLabel_4, gbc_lblNewLabel_4);

		passwordField = new JPasswordField();
		passwordField.setColumns(50);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 4;
		gbc_passwordField.gridy = 4;
		meio.add(passwordField, gbc_passwordField);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setFont(new Font("Lucida Sans", Font.PLAIN, 23));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 7;
		meio.add(btnNewButton, gbc_btnNewButton);

		JPanel cadastro = new JPanel();
		cadastro.setBackground(new Color(0, 64, 128));
		frame.getContentPane().add(cadastro, "name_335147810155900");
		cadastro.setLayout(new BorderLayout(0, 0));

		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				login.setVisible(false);
				cadastro.setVisible(true);
			}
		});
		//botão que leva a tela de cadastro

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 64, 128));
		cadastro.add(panel_1, BorderLayout.NORTH);

		JLabel lblNewLabel_3 = new JLabel("Área de cadastro:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Bell MT", Font.BOLD, 50));
		panel_1.add(lblNewLabel_3);

		JPanel meio_1 = new JPanel();
		meio_1.setBackground(new Color(0, 64, 128));
		cadastro.add(meio_1, BorderLayout.CENTER);
		GridBagLayout gbl_meio_1 = new GridBagLayout();
		gbl_meio_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_meio_1.rowHeights = new int[]{0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 1, 0};
		gbl_meio_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_meio_1.rowWeights = new double[]{0.0, 0.0, 0.0, 4.0, 4.0, 0.0, 0.0, 3.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		meio_1.setLayout(gbl_meio_1);

		JLabel lblNewLabel_5 = new JLabel("Usuário:");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Lucida Sans", Font.PLAIN, 23));
		lblNewLabel_5.setAlignmentX(0.5f);
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 3;
		meio_1.add(lblNewLabel_5, gbc_lblNewLabel_5);

		textFieldCadastro = new JTextField();
		textFieldCadastro.setColumns(50);
		GridBagConstraints gbc_textFieldCadastro = new GridBagConstraints();
		gbc_textFieldCadastro.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCadastro.gridx = 4;
		gbc_textFieldCadastro.gridy = 3;
		meio_1.add(textFieldCadastro, gbc_textFieldCadastro);

		JLabel lblNewLabel_4_1 = new JLabel("Senha:");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Lucida Sans", Font.PLAIN, 23));
		lblNewLabel_4_1.setAlignmentX(0.5f);
		GridBagConstraints gbc_lblNewLabel_4_1 = new GridBagConstraints();
		gbc_lblNewLabel_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4_1.gridx = 3;
		gbc_lblNewLabel_4_1.gridy = 4;
		meio_1.add(lblNewLabel_4_1, gbc_lblNewLabel_4_1);

		passwordFieldCadastro = new JPasswordField();
		passwordFieldCadastro.setColumns(50);
		GridBagConstraints gbc_passwordFieldCadastro = new GridBagConstraints();
		gbc_passwordFieldCadastro.insets = new Insets(0, 0, 5, 0);
		gbc_passwordFieldCadastro.gridx = 4;
		gbc_passwordFieldCadastro.gridy = 4;
		meio_1.add(passwordFieldCadastro, gbc_passwordFieldCadastro);

		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.setFont(new Font("Lucida Sans", Font.PLAIN, 23));
		GridBagConstraints gbc_cadastrar = new GridBagConstraints();
		gbc_cadastrar.insets = new Insets(0, 0, 5, 0);
		gbc_cadastrar.gridx = 4;
		gbc_cadastrar.gridy = 7;
		meio_1.add(cadastrar, gbc_cadastrar);

		JPanel telaInicial = new JPanel();
		telaInicial.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(telaInicial, "name_394855230731500");
		telaInicial.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel.setBackground(new Color(255, 255, 255));
		telaInicial.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel snoopyIcon = new JLabel("");
		snoopyIcon.setIcon(new ImageIcon("C:\\Users\\maria\\OneDrive\\Imagens\\Capturas de tela\\Captura de tela 2025-02-18 125945.png"));
		panel.add(snoopyIcon, BorderLayout.NORTH);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel.add(panel_3, BorderLayout.CENTER);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{53, 85, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{21, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);

		JLabel userRealLabel = new JLabel("@");
		//    EDITAR!!!
		GridBagConstraints gbc_userRealLabel = new GridBagConstraints();
		gbc_userRealLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userRealLabel.gridx = 1;
		gbc_userRealLabel.gridy = 0;
		panel_3.add(userRealLabel, gbc_userRealLabel);

		JLabel lblNewLabel_8 = new JLabel("Amo livros!");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 1;
		panel_3.add(lblNewLabel_8, gbc_lblNewLabel_8);

		JButton verPerfilButton = new JButton("    Ver perfil    ");
		verPerfilButton.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_verPerfilButton = new GridBagConstraints();
		gbc_verPerfilButton.insets = new Insets(0, 0, 5, 5);
		gbc_verPerfilButton.anchor = GridBagConstraints.WEST;
		gbc_verPerfilButton.gridx = 1;
		gbc_verPerfilButton.gridy = 2;
		panel_3.add(verPerfilButton, gbc_verPerfilButton);

		JButton mudarUserButton = new JButton(" Mudar user ");
		mudarUserButton.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_mudarUserButton = new GridBagConstraints();
		gbc_mudarUserButton.insets = new Insets(0, 0, 5, 5);
		gbc_mudarUserButton.gridx = 1;
		gbc_mudarUserButton.gridy = 4;
		panel_3.add(mudarUserButton, gbc_mudarUserButton);

		JButton mudarSenhaButton = new JButton("Mudar senha ");
		mudarSenhaButton.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_mudarSenhaButton = new GridBagConstraints();
		gbc_mudarSenhaButton.insets = new Insets(0, 0, 5, 5);
		gbc_mudarSenhaButton.gridx = 1;
		gbc_mudarSenhaButton.gridy = 6;
		panel_3.add(mudarSenhaButton, gbc_mudarSenhaButton);

		JScrollBar scrollBar = new JScrollBar();
		telaInicial.add(scrollBar, BorderLayout.EAST);

		JPanel panel_2 = new JPanel();
		telaInicial.add(panel_2, BorderLayout.NORTH);

		pesquisarTextField = new JTextField();
		panel_2.add(pesquisarTextField);
		pesquisarTextField.setColumns(30);

		JButton pesquisarButton = new JButton("🔎");
		panel_2.add(pesquisarButton);

		String [] columns = {"Título", "Autor", "Gênero"};
		
		DefaultTableModel model = new DefaultTableModel(BookManager.getBookData(), columns);
		
		JTable tabelaLivros = new JTable(model);

	for(Book b : BookData.getBookList()) {
		try {
			BookManager.addBook(b, tabelaLivros);
		} catch (BookAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
	}

		JScrollPane scrollPane = new JScrollPane(tabelaLivros);
		telaInicial.add(scrollPane, BorderLayout.CENTER);

		JPanel perfil = new JPanel();
		frame.getContentPane().add(perfil, "name_399382685377000");
		perfil.setLayout(new BorderLayout(0, 0));

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		perfil.add(panel_8, BorderLayout.NORTH);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\maria\\OneDrive\\Área de Trabalho\\Captura de tela 2025-02-21 104650.png"));
		panel_8.add(lblNewLabel_6);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		perfil.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton voltarPraInicialButton = new JButton("<");
		voltarPraInicialButton.setForeground(new Color(0, 0, 128));
		voltarPraInicialButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_9.add(voltarPraInicialButton);

		JButton livrosCurtidosButton = new JButton("Livros curtidos");
		livrosCurtidosButton.setForeground(new Color(0, 0, 128));
		livrosCurtidosButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		livrosCurtidosButton.setBackground(new Color(255, 255, 255));
		panel_9.add(livrosCurtidosButton);

		JButton listaToReadButton = new JButton("Lista ToRead");
		listaToReadButton.setBackground(new Color(255, 255, 255));
		listaToReadButton.setForeground(new Color(0, 0, 128));
		listaToReadButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_9.add(listaToReadButton);

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
		bioTextArea.setFont(new Font("Monospaced", Font.PLAIN, 17));
		bioTextArea.setColumns(70);
		bioTextArea.setTabSize(20);
		bioTextArea.setRows(2);
		bioTextArea.setText("Leio de tudo, mas nem tudo me agrada. 📖✨ Se o livro for bom, eu elogio; se for ruim, eu argumento. Expectativas altas, críticas sinceras e um toque de arrogância literária. Vamos discutir? 😏 #LeituraCrítica #OpiniõesFortes");
		panel_15.add(bioTextArea);
		bioTextArea.setLineWrap(true);
		bioTextArea.setWrapStyleWord(true);

		JPanel livro = new JPanel();
		frame.getContentPane().add(livro, "name_564775775717100");
		livro.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		livro.add(panel_5, BorderLayout.NORTH);

		JLabel userLabel = new JLabel("@");
		userLabel.revalidate();
		userLabel.repaint();
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		panel_11.add(userLabel);

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
								
										JButton voltarInicialButton = new JButton("<");
										
												GridBagConstraints gbc_voltarInicialButton = new GridBagConstraints();
												gbc_voltarInicialButton.anchor = GridBagConstraints.WEST;
												gbc_voltarInicialButton.insets = new Insets(0, 0, 5, 0);
												gbc_voltarInicialButton.gridx = 0;
												gbc_voltarInicialButton.gridy = 0;
												panel_4.add(voltarInicialButton, gbc_voltarInicialButton);
										
												JLabel lblNewLabel_10 = new JLabel("");
												GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
												gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
												gbc_lblNewLabel_10.gridx = 0;
												gbc_lblNewLabel_10.gridy = 1;
												panel_4.add(lblNewLabel_10, gbc_lblNewLabel_10);
												lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\maria\\OneDrive\\Imagens\\Capturas de tela\\Captura de tela 2025-02-22 173258.png"));
										
										JLabel lblNewLabel_12 = new JLabel("Dê uma nota:");
										lblNewLabel_12.setFont(new Font("Monospaced", Font.PLAIN, 17));
										GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
										gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 0);
										gbc_lblNewLabel_12.gridx = 0;
										gbc_lblNewLabel_12.gridy = 3;
										panel_4.add(lblNewLabel_12, gbc_lblNewLabel_12);
										
										JLabel lblNewLabel_13 = new JLabel("");
										lblNewLabel_13.setIcon(new ImageIcon("C:\\Users\\maria\\OneDrive\\Imagens\\estrela.png"));
										GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
										gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 0);
										gbc_lblNewLabel_13.gridx = 0;
										gbc_lblNewLabel_13.gridy = 4;
										panel_4.add(lblNewLabel_13, gbc_lblNewLabel_13);
										
										JLabel lblNewLabel_12_1 = new JLabel("Curta:");
										lblNewLabel_12_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
										GridBagConstraints gbc_lblNewLabel_12_1 = new GridBagConstraints();
										gbc_lblNewLabel_12_1.insets = new Insets(0, 0, 5, 0);
										gbc_lblNewLabel_12_1.gridx = 0;
										gbc_lblNewLabel_12_1.gridy = 5;
										panel_4.add(lblNewLabel_12_1, gbc_lblNewLabel_12_1);
										
										JLabel lblNewLabel_15 = new JLabel("");
										lblNewLabel_15.setIcon(new ImageIcon("C:\\Users\\maria\\OneDrive\\Imagens\\coracao.png"));
										GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
										gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 0);
										gbc_lblNewLabel_15.gridx = 0;
										gbc_lblNewLabel_15.gridy = 6;
										panel_4.add(lblNewLabel_15, gbc_lblNewLabel_15);
										
										JLabel lblNewLabel_9_2 = new JLabel("<html><div style='text-align: center;'><u>Adicionar a</u><br><u>ToBeRead</u></div></html>\r\n");
										lblNewLabel_9_2.setHorizontalTextPosition(SwingConstants.CENTER);
										lblNewLabel_9_2.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel_9_2.setFont(new Font("Monospaced", Font.PLAIN, 17));
										GridBagConstraints gbc_lblNewLabel_9_2 = new GridBagConstraints();
										gbc_lblNewLabel_9_2.gridx = 0;
										gbc_lblNewLabel_9_2.gridy = 7;
										panel_4.add(lblNewLabel_9_2, gbc_lblNewLabel_9_2);
										
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
										
										JLabel lblNewLabel_9_1 = new JLabel("<html><div style='text-align: center;'>Média de<br>avaliações:</div></html>\r\n");
										lblNewLabel_9_1.setHorizontalTextPosition(SwingConstants.CENTER);
										lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel_9_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
										GridBagConstraints gbc_lblNewLabel_9_1 = new GridBagConstraints();
										gbc_lblNewLabel_9_1.insets = new Insets(0, 0, 5, 0);
										gbc_lblNewLabel_9_1.anchor = GridBagConstraints.NORTH;
										gbc_lblNewLabel_9_1.gridx = 0;
										gbc_lblNewLabel_9_1.gridy = 1;
										panel_6.add(lblNewLabel_9_1, gbc_lblNewLabel_9_1);
										
										JLabel lblNewLabel_9_1_1 = new JLabel("<html><div style='text-align: center;'>Quantidade<br>de curtidas:</div></html>\r\n");
										lblNewLabel_9_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
										lblNewLabel_9_1_1.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel_9_1_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
										GridBagConstraints gbc_lblNewLabel_9_1_1 = new GridBagConstraints();
										gbc_lblNewLabel_9_1_1.insets = new Insets(0, 0, 5, 0);
										gbc_lblNewLabel_9_1_1.gridx = 0;
										gbc_lblNewLabel_9_1_1.gridy = 7;
										panel_6.add(lblNewLabel_9_1_1, gbc_lblNewLabel_9_1_1);
										
										JLabel lblNewLabel_9_1_1_1 = new JLabel("<html><div style='text-align: center;'><u>Saiba mais</u><br><u>sobre o autor!</u></div></html>\r\n");
										lblNewLabel_9_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
										lblNewLabel_9_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel_9_1_1_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
										GridBagConstraints gbc_lblNewLabel_9_1_1_1 = new GridBagConstraints();
										gbc_lblNewLabel_9_1_1_1.anchor = GridBagConstraints.SOUTH;
										gbc_lblNewLabel_9_1_1_1.insets = new Insets(0, 0, 5, 0);
										gbc_lblNewLabel_9_1_1_1.gridx = 0;
										gbc_lblNewLabel_9_1_1_1.gridy = 12;
										panel_6.add(lblNewLabel_9_1_1_1, gbc_lblNewLabel_9_1_1_1);
										
										JPanel panel_7 = new JPanel();
										panel_7.setBackground(new Color(128, 128, 128));
										livro.add(panel_7, BorderLayout.CENTER);
										panel_7.setLayout(new BorderLayout(0, 0));
										
										JPanel panel_13 = new JPanel();
										panel_7.add(panel_13, BorderLayout.NORTH);
										
										JLabel lblNewLabel_11 = new JLabel("Nome do autor ");
										lblNewLabel_11.setFont(new Font("Monospaced", Font.PLAIN, 20));
										panel_13.add(lblNewLabel_11);
										
										JLabel lblNewLabel_14 = new JLabel("- gênero");
										lblNewLabel_14.setFont(new Font("Monospaced", Font.PLAIN, 20));
										panel_13.add(lblNewLabel_14);
										
										JTextArea txtrNaAberturaDos = new JTextArea();
										txtrNaAberturaDos.setFont(new Font("Monospaced", Font.PLAIN, 17));
										txtrNaAberturaDos.setText("Na abertura dos Jogos Vorazes, a organização não recolhe os corpos dos combatentes caídos e dá tiros de canhão até o final. Cada tiro, um morto. Onze tiros no primeiro dia. Treze jovens restaram, entre eles, Katniss. Para quem os tiros de canhão serão no dia seguinte?...\r\n\r\nApós o fim da América do Norte, uma nova nação chamada Panem surge. Formada por doze distritos, é comandada com mão de ferro pela Capital. Uma das formas com que demonstra seu poder sobre o resto do carente país é com Jogos Vorazes, uma competição anual transmitida ao vivo pela televisão, em que um garoto e uma garota de doze a dezoito anos de cada distrito são selecionados e obrigados a lutar até a morte!");
										txtrNaAberturaDos.setEditable(false);
										txtrNaAberturaDos.setLineWrap(true);
										txtrNaAberturaDos.setWrapStyleWord(true);
										panel_7.add(txtrNaAberturaDos, BorderLayout.CENTER);
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();
				String password = new String(passwordField.getPassword());

				if (user.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(frame, "Campo do usuário ou senha vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					AccountManager.login(user, password, frame);
					Frames.updateUserLabel(userLabel);
					Frames.updateUserLabel(userRealLabel);
					Frames.updateBioLabel(bioTextArea);
					login.setVisible(false);
					telaInicial.setVisible(true);
				} catch (IncorrectCredentialsException ex) {
					JOptionPane.showMessageDialog(frame, "Senha incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			}
		});

		//botão de login: certificar que os dois texts labels estejam preenchidos,
		//certificar que existe esse username e a senha atrelada a ele esteja correta

		verPerfilButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaInicial.setVisible(false);
				perfil.setVisible(true);
			}
		});
		//botão para ver perfil

		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textFieldCadastro.getText();
				String password = new String(passwordFieldCadastro.getPassword());

				if (user.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "Campo do usuário ou senha vazio!");
				} else {
					try {
						AccountManager.register(user, password, frame);
						Frames.updateUserLabel(userLabel);
						Frames.updateUserLabel(userRealLabel);
						Frames.updateBioLabel(bioTextArea);
						JOptionPane.showMessageDialog(null, "Conta criada com sucesso! Seja bem vindo(a)!");
						cadastro.setVisible(false);
						telaInicial.setVisible(true);
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

		tabelaLivros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tabelaLivros.getSelectedRow();
				String tituloLivro = tabelaLivros.getValueAt(linha, 0).toString();

				JLabel nomeLivroLabel = new JLabel(tituloLivro);
				nomeLivroLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
				panel_5.add(nomeLivroLabel);

				voltarInicialButton.addActionListener(new ActionListener() {
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
		//event de clicar na lista e entrar no panel livro

		voltarPraInicialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfil.setVisible(false);
				telaInicial.setVisible(true);
			}
		});
		//event de clicar no voltar do perfil e voltar p pagina inicial

	}


}