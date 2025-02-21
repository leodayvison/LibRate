package br.com.ufc.librate.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import br.com.ufc.librate.collections.BookGenre;
import br.com.ufc.librate.model.classes.Book;
import java.awt.FlowLayout;

public class Frames {

	private JFrame frame;
	private JPanel panel_1;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textFieldCadastro;
	private JPasswordField passwordFieldCadastro;
	private JTextField pesquisarTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
			@Override
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
		
		JLabel lblNewLabel_7 = new JLabel("@user");
		//     EDITAR!!!
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 0;
		panel_3.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
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
		
//		Book[] livros = { new Book("Jogos Vorazes", 2008, BookGenre.FICTION, 0, "Livros distopia"),
//						  new Book("Confissões",2017,BookGenre.THRILLER,0,"Livro de suspense")
//						  };
		
//Tentamos implementar objetos de Book, não deu certo EDITAR!!!!!
		
		String[][] data = {
				{"Jogos Vorazes", "Suzanne Collins", "Ficção"}, {"Confissões", "Kanae Minato", "Suspense"}
//				{livros[0].getTitle(),livros[0].getAuthor().getName(),livros[0].getGenre().toString()},
//				{livros[1].getTitle(),livros[1].getAuthor().getName(),livros[1].getGenre().toString()},
		};
		
		String [] columns = {"Título", "Autor", "Gênero"};
		
		DefaultTableModel model = new DefaultTableModel(data, columns);
		
		JTable tabelaLivros = new JTable(model);
		
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
		
		JButton btnNewButton_1 = new JButton("Livros curtidos");
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		panel_9.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Lista ToRead");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setForeground(new Color(0, 0, 128));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_9.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("?");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_9.add(btnNewButton_3);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_10.setBackground(new Color(255, 255, 255));
		perfil.add(panel_10, BorderLayout.CENTER);
		
		JPanel livro = new JPanel();
		frame.getContentPane().add(livro, "name_564775775717100");
		livro.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		livro.add(panel_5, BorderLayout.NORTH);
	
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		livro.add(panel_4, BorderLayout.WEST);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{199, 0};
		gbl_panel_4.rowHeights = new int[]{229, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\maria\\OneDrive\\Imagens\\Capturas de tela\\Captura de tela 2025-02-20 111024.png"));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_10.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 0;
		panel_4.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		JButton voltarInicialButton = new JButton("voltar");
		
		GridBagConstraints gbc_voltarInicialButton = new GridBagConstraints();
		gbc_voltarInicialButton.insets = new Insets(0, 0, 5, 0);
		gbc_voltarInicialButton.gridx = 0;
		gbc_voltarInicialButton.gridy = 1;
		panel_4.add(voltarInicialButton, gbc_voltarInicialButton);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 0, 128));
		livro.add(panel_6, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		livro.add(panel_7, BorderLayout.EAST);
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campo do usuário ou senha vazio!");
				}
				else if(textField.getText().equalsIgnoreCase("entrar") && passwordField.getText().equalsIgnoreCase("1111")) {
					//conta e senha correta pertecentes ao arquivo
					
					//EDITAR PARA PERCORRER AS CONTAS!!!!
					
					login.setVisible(false);
					telaInicial.setVisible(true);
				}
				else if(textField.getText().equalsIgnoreCase("usuarioexistente") && passwordField.getText().equalsIgnoreCase("1111")) {
					//"usuario existente" seria uma conta que estaria no nosso arquivo, porem a senha estaria errada
					
					//EDITAR PARA PERCORRER O ARQUIVO E VER SE O NOME DE USUARIO EXISTE E ANALISAR A SENHA ATRELADA A ELE!!!!
					
					JOptionPane.showMessageDialog(null, "Senha incorreta!");
				}
				else {
					//caso da conta que nao estaria no nosso arquivo
					
					//EDITAR PARA PERCORRER O ARQUIVO E VER SE O NOME DE USUARIO EXISTE!!!!
					
					int resposta = JOptionPane.showConfirmDialog(null, "Usuário não existe. Quer criar uma conta?", null, 2);
					if(JOptionPane.OK_OPTION == resposta) {
						login.setVisible(false);
						cadastro.setVisible(true);
					}
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
				if(textFieldCadastro.getText().equals("") || passwordFieldCadastro.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campo do usuário ou senha vazio!");
				}
				else if(textFieldCadastro.getText().equalsIgnoreCase("userexistente")) {
					//"user existente" user qualquer que existe nos arquivos
					
					//EDITAR PARA PERCORRER O ARQUIVO E VER SE NÃO EXISTE NOME DE USUARIO IGUAL!!!!
					
					JOptionPane.showMessageDialog(null, "Nome de usuário já existe!");
				}
				else {
					//caso em que o nome de usuario não existe
					JOptionPane.showMessageDialog(null, "Conta criada com sucesso! Seja bem vindo(a)!");
					cadastro.setVisible(false);
					telaInicial.setVisible(true);
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
	}
	
	
}
