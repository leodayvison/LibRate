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
import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JSplitPane;

public class Frames {

	private JFrame frame;
	private JPanel panel_1;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textFieldCadastro;
	private JPasswordField passwordFieldCadastro;
	private JTextField pesquisarTextField;
	private Book livroSelecionado = null;
	private JPanel autor;
	private JTable tabelaAutor;

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

        JLabel lblNewLabel_13 = new JLabel("");
        lblNewLabel_13.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/Cabeçalho-removebg-preview.png")));
        cima.add(lblNewLabel_13);

        JPanel baixo = new JPanel();
        baixo.setBackground(new Color(0, 64, 128));
        login.add(baixo, BorderLayout.SOUTH);

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
        lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 23));
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
        lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD, 23));
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
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Lucida Sans", Font.PLAIN, 23));
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton.gridx = 4;
        gbc_btnNewButton.gridy = 7;
        meio.add(btnNewButton, gbc_btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("Não tem cadastro?");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_1.gridx = 4;
        gbc_lblNewLabel_1.gridy = 9;
        meio.add(lblNewLabel_1, gbc_lblNewLabel_1);
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Lucida Sans", Font.PLAIN, 20));

        JLabel lblNewLabel_2 = new JLabel("<html><u>Clique Aqui</u></html>");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.gridx = 4;
        gbc_lblNewLabel_2.gridy = 10;
        meio.add(lblNewLabel_2, gbc_lblNewLabel_2);
        lblNewLabel_2.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
        lblNewLabel_2.setForeground(new Color(255, 255, 255));

        JPanel cadastro = new JPanel();
        cadastro.setBackground(new Color(0, 64, 128));
        frame.getContentPane().add(cadastro, "name_335147810155900");
        cadastro.setLayout(new BorderLayout(0, 0));
        //botão que leva a tela de cadastro

        lblNewLabel_2.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                login.setVisible(false);
                cadastro.setVisible(true);
            }
        });

        panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 64, 128));
        cadastro.add(panel_1, BorderLayout.NORTH);

        JLabel lblNewLabel_13_1 = new JLabel("");
        lblNewLabel_13_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_13_1);
        lblNewLabel_13_1.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/Cabeçalho-removebg-preview.png")));


        JPanel meio_1 = new JPanel();
        meio_1.setBackground(new Color(0, 64, 128));
        cadastro.add(meio_1, BorderLayout.CENTER);
        GridBagLayout gbl_meio_1 = new GridBagLayout();
        gbl_meio_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gbl_meio_1.rowHeights = new int[]{0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 1, 0};
        gbl_meio_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_meio_1.rowWeights = new double[]{0.0, 0.0, 0.0, 4.0, 4.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        meio_1.setLayout(gbl_meio_1);

        JLabel lblNewLabel_3 = new JLabel("Cadastre-se:");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_3.gridx = 4;
        gbc_lblNewLabel_3.gridy = 2;
        meio_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD, 30));

		JLabel lblNewLabel_5 = new JLabel("Usuário:");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Cambria", Font.BOLD, 30));
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
		lblNewLabel_4_1.setFont(new Font("Cambria", Font.BOLD, 30));
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

        JButton irParaLogin = new JButton("Já tem uma conta? Faça o Login.");
        irParaLogin.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
        irParaLogin.setForeground(new Color(255, 255, 255));
        irParaLogin.setBackground(new Color(0, 64, 128));
        irParaLogin.setContentAreaFilled(false);
        GridBagConstraints gbc_irParaLogin = new GridBagConstraints();
        gbc_irParaLogin.gridx = 4;
        gbc_irParaLogin.gridy = 10;
        meio_1.add(irParaLogin, gbc_irParaLogin);

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

        JButton mudarUserButton = new JButton(" Mudar user ");
        mudarUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = JOptionPane.showInputDialog(null, "Digite seu novo user:", "Mudar user", JOptionPane.QUESTION_MESSAGE);
                AccountManager.getLoggedAccount().changeLogin(user);
            }
        });

        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/SnoopyLendoTelaInnicial.png")));
        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
        gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_7.gridx = 1;
        gbc_lblNewLabel_7.gridy = 1;
        panel_3.add(lblNewLabel_7, gbc_lblNewLabel_7);

        JLabel userRealLabel = new JLabel("@");
        //     EDITAR!!!
        GridBagConstraints gbc_userRealLabel = new GridBagConstraints();
        gbc_userRealLabel.insets = new Insets(0, 0, 5, 5);
        gbc_userRealLabel.gridx = 1;
        gbc_userRealLabel.gridy = 2;
        panel_3.add(userRealLabel, gbc_userRealLabel);

        JLabel lblNewLabel_8 = new JLabel("Amo livros!");
        GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
        gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_8.gridx = 1;
        gbc_lblNewLabel_8.gridy = 3;
        panel_3.add(lblNewLabel_8, gbc_lblNewLabel_8);

        JButton verPerfilButton = new JButton("    Ver perfil    ");
        verPerfilButton.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc_verPerfilButton = new GridBagConstraints();
        gbc_verPerfilButton.insets = new Insets(0, 0, 5, 5);
        gbc_verPerfilButton.gridx = 1;
        gbc_verPerfilButton.gridy = 4;
        panel_3.add(verPerfilButton, gbc_verPerfilButton);
        //botão de login: certificar que os dois texts labels estejam preenchidos,
        //certificar que existe esse username e a senha atrelada a ele esteja correta

        mudarUserButton.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc_mudarUserButton = new GridBagConstraints();
        gbc_mudarUserButton.insets = new Insets(0, 0, 5, 5);
        gbc_mudarUserButton.gridx = 1;
        gbc_mudarUserButton.gridy = 6;
        panel_3.add(mudarUserButton, gbc_mudarUserButton);

        JButton mudarSenhaButton = new JButton("Mudar senha ");
        mudarSenhaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String senha = JOptionPane.showInputDialog(null, "Digite sua senha:", "Mudar senha", JOptionPane.QUESTION_MESSAGE);
                AccountManager.getLoggedAccount().changePassword(senha);
            }
        });
        mudarSenhaButton.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc_mudarSenhaButton = new GridBagConstraints();
        gbc_mudarSenhaButton.insets = new Insets(0, 0, 5, 5);
        gbc_mudarSenhaButton.gridx = 1;
        gbc_mudarSenhaButton.gridy = 8;
        panel_3.add(mudarSenhaButton, gbc_mudarSenhaButton);

        JButton btnNewButton_1 = new JButton("Logout\r\n");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                telaInicial.setVisible(false);
                login.setVisible(true);
            }
        });
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton_1.gridx = 1;
        gbc_btnNewButton_1.gridy = 10;
        panel_3.add(btnNewButton_1, gbc_btnNewButton_1);

        JScrollBar scrollBar = new JScrollBar();
        telaInicial.add(scrollBar, BorderLayout.EAST);

        JPanel panel_2 = new JPanel();
        telaInicial.add(panel_2, BorderLayout.NORTH);

        pesquisarTextField = new JTextField();
        panel_2.add(pesquisarTextField);
        pesquisarTextField.setColumns(30);

        JButton pesquisarButton = new JButton("🔎");
        panel_2.add(pesquisarButton);

        String[] columns = {"Título", "Autor", "Gênero"};

        DefaultTableModel model = new DefaultTableModel(BookManager.getBookData(), columns);

        JTable tabelaLivros = new JTable(model);

        for (Book b : BookData.getBookList()) {
            try {
                BookManager.addBook(b, tabelaLivros);
            } catch (BookAlreadyExistsException e) {
                System.out.println(e.getMessage());
            }
        }

        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pesquisa = pesquisarTextField.getText().toLowerCase();

                if (pesquisa.equals("")) {
                    for (Book b : BookData.getBookList()) {
                        try {
                            BookManager.addBook(b, tabelaLivros);
                        } catch (BookAlreadyExistsException baee) {
                            System.out.println(baee.getMessage());
                        }
                    }

                }

                DefaultTableModel model = (DefaultTableModel) tabelaLivros.getModel();
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


        JScrollPane scrollPane = new JScrollPane(tabelaLivros);
        telaInicial.add(scrollPane, BorderLayout.CENTER);

        JPanel perfil = new JPanel();
        frame.getContentPane().add(perfil, "name_399382685377000");
        perfil.setLayout(new BorderLayout(0, 0));

        JPanel panel_8 = new JPanel();
        panel_8.setBackground(new Color(255, 255, 255));
        perfil.add(panel_8, BorderLayout.NORTH);
        panel_8.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/snoopilendo.jpg")));
        panel_8.add(lblNewLabel_6);

        JPanel panel_21 = new JPanel();
        panel_21.setBackground(new Color(255, 255, 255));
        panel_8.add(panel_21, BorderLayout.NORTH);
        panel_21.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JButton botaoVoltar_1 = new JButton("<");
        botaoVoltar_1.setBackground(new Color(255, 255, 255));
        botaoVoltar_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                perfil.setVisible(false);
                telaInicial.setVisible(true);
            }
        });
        botaoVoltar_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_21.add(botaoVoltar_1);


        JPanel panel_9 = new JPanel();
        panel_9.setBackground(new Color(255, 255, 255));
        perfil.add(panel_9, BorderLayout.SOUTH);
        panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton mudarBioButton_1 = new JButton("Mudar bio");
        mudarBioButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Digite sua bio:", "Mudar bio", JOptionPane.QUESTION_MESSAGE);
                AccountManager.getLoggedAccount().setBio(input);
            }
        });
        mudarBioButton_1.setForeground(new Color(0, 0, 128));
        mudarBioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        mudarBioButton_1.setBackground(Color.WHITE);
        panel_9.add(mudarBioButton_1);

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
        lblNewLabel_10.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/SnoopyCoffee.png")));

        JLabel deUmaNota = new JLabel("Dê uma nota:");
        deUmaNota.setFont(new Font("Monospaced", Font.PLAIN, 17));
        GridBagConstraints gbc_deUmaNota = new GridBagConstraints();
        gbc_deUmaNota.insets = new Insets(0, 0, 5, 0);
        gbc_deUmaNota.gridx = 0;
        gbc_deUmaNota.gridy = 3;
        panel_4.add(deUmaNota, gbc_deUmaNota);

        JLabel imagemEstrela = new JLabel("");
        imagemEstrela.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/estrelaVaziaPoo.png")));
        GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
        gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_13.gridx = 0;
        gbc_lblNewLabel_13.gridy = 4;
        panel_4.add(imagemEstrela, gbc_lblNewLabel_13);

        JLabel lblNewLabel_12_1 = new JLabel("Curta:");
        lblNewLabel_12_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
        GridBagConstraints gbc_lblNewLabel_12_1 = new GridBagConstraints();
        gbc_lblNewLabel_12_1.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_12_1.gridx = 0;
        gbc_lblNewLabel_12_1.gridy = 5;
        panel_4.add(lblNewLabel_12_1, gbc_lblNewLabel_12_1);

        JLabel lblNewLabel_15 = new JLabel("");
        lblNewLabel_15.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/coracao.png")));
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
		ImageIcon snoopi = new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/snoopiescreve.jpg"));
		Image snoopi1 =snoopi.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon snoopi2 = new ImageIcon(snoopi1);

		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(255, 255, 255));
		panel_13.add(panel_18, BorderLayout.NORTH);
		panel_18.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JButton botaoVoltar = new JButton("<");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				autor.setVisible(false);
				telaInicial.setVisible(true);
			}
		});
		botaoVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoVoltar.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_18.add(botaoVoltar);

		JPanel panel_19 = new JPanel();
		panel_13.add(panel_19, BorderLayout.SOUTH);
		panel_19.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_20 = new JPanel();
		panel_20.setBackground(new Color(255, 255, 255));
		panel_19.add(panel_20);

		JLabel snooopy = new JLabel("");
		panel_20.add(snooopy);
		snooopy.setBackground(new Color(255, 255, 255));
		snooopy.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		snooopy.setHorizontalAlignment(SwingConstants.RIGHT);
		snooopy.setIcon(snoopi2);

		JPanel panel_22 = new JPanel();
		panel_22.setBackground(new Color(255, 255, 255));
		panel_19.add(panel_22);
		panel_22.setLayout(new BorderLayout(0, 0));

		JLabel descrição = new JLabel("Descrição:");
		descrição.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_22.add(descrição, BorderLayout.NORTH);

		JTextArea txtrAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa = new JTextArea();
		txtrAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.setText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		txtrAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.setRows(5);
		txtrAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.setWrapStyleWord(true);
		txtrAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.setLineWrap(true);
		txtrAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.setEditable(false);
		panel_22.add(txtrAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa, BorderLayout.CENTER);


		JPanel panel_14 = new JPanel();
		autor.add(panel_14, BorderLayout.CENTER);
		panel_14.setLayout(new BorderLayout(0, 0));

		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(255, 255, 255));
		panel_14.add(panel_16, BorderLayout.NORTH);
		ImageIcon coracaoVazio = new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/coracaoVazio (1).png"));
		panel_16.setLayout(new BorderLayout(0, 0));

		JPanel panel_17_1 = new JPanel();
		panel_17_1.setBackground(Color.WHITE);
		panel_16.add(panel_17_1, BorderLayout.SOUTH);
		panel_17_1.setLayout(new GridLayout(1, 2, 10, 10));

		JPanel panel_20_1 = new JPanel();
		panel_20_1.setBackground(Color.WHITE);
		panel_17_1.add(panel_20_1);
		panel_20_1.setLayout(new BorderLayout(0, 0));

		JToggleButton botaoCurtida = new JToggleButton(" Curtir");
		panel_20_1.add(botaoCurtida, BorderLayout.CENTER);
		botaoCurtida.setFont(new Font("Tahoma", Font.PLAIN, 18));
		botaoCurtida.setSelectedIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/coracaoCheio (2).png")));
		botaoCurtida.setBackground(new Color(255, 255, 255));
		botaoCurtida.setIcon(coracaoVazio);

		JLabel avaliação_1 = new JLabel("n°");
		avaliação_1.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/star.png")));
		avaliação_1.setHorizontalAlignment(SwingConstants.CENTER);
		avaliação_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_17_1.add(avaliação_1);

		JLabel lblNewLabel_11_1 = new JLabel("  n°");
		lblNewLabel_11_1.setIcon(new ImageIcon(Frames.class.getResource("/br/com/ufc/librate/gui/imagens/coracaoCheio (2).png")));
		lblNewLabel_11_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_17_1.add(lblNewLabel_11_1);

		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(255, 255, 255));
		panel_16.add(panel_17, BorderLayout.NORTH);
		panel_17.setLayout(new GridLayout(1, 2, 0, 0));

		JLabel nomeAutorLabel = new JLabel("nome autor");
		nomeAutorLabel.setBackground(new Color(255, 255, 255));
		nomeAutorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nomeAutorLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		panel_17.add(nomeAutorLabel);

		JPanel panel_23 = new JPanel();
		panel_23.setBackground(new Color(255, 255, 255));
		panel_17.add(panel_23);

		JScrollPane scrollPane_1 = new JScrollPane(tabelaAutor);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_14.add(scrollPane_1, BorderLayout.CENTER);

		tabelaAutor = new JTable();
		tabelaAutor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Título", "Gênero"
			}
		));
		scrollPane_1.setViewportView(tabelaAutor);

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
        mudarUserButton.addActionListener(new ActionListener() {
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

        JLabel lblNewLabel_9 = new JLabel("Administrador");
        lblNewLabel_9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
        GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
        gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_9.gridx = 1;
        gbc_lblNewLabel_9.gridy = 2;
        panel_3admin.add(lblNewLabel_9, gbc_lblNewLabel_9);

        JButton verPerfilButtonadmin = new JButton("Adicionar livro");
        verPerfilButtonadmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
        verPerfilButtonadmin.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc_verPerfilButtonadmin = new GridBagConstraints();
        gbc_verPerfilButtonadmin.insets = new Insets(0, 0, 5, 5);
        gbc_verPerfilButtonadmin.gridx = 1;
        gbc_verPerfilButtonadmin.gridy = 4;
        panel_3admin.add(verPerfilButtonadmin, gbc_verPerfilButtonadmin);
        mudarSenhaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton btnNewButton_1admin = new JButton("Logout\r\n");
        btnNewButton_1admin.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton_1admin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminTelaInicial.setVisible(false);
                login.setVisible(true);
            }
        });

        JButton mudarUserButtonadmin = new JButton("Remover livro");
        mudarUserButtonadmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
        //botão de login: certificar que os dois texts labels estejam preenchidos,
        //certificar que existe esse username e a senha atrelada a ele esteja correta

        mudarUserButtonadmin.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc_mudarUserButtonadmin = new GridBagConstraints();
        gbc_mudarUserButtonadmin.insets = new Insets(0, 0, 5, 5);
        gbc_mudarUserButtonadmin.gridx = 1;
        gbc_mudarUserButtonadmin.gridy = 7;
        panel_3admin.add(mudarUserButtonadmin, gbc_mudarUserButtonadmin);

        GridBagConstraints gbc_btnNewButton_1admin = new GridBagConstraints();
        gbc_btnNewButton_1admin.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton_1admin.gridx = 1;
        gbc_btnNewButton_1admin.gridy = 10;
        panel_3admin.add(btnNewButton_1admin, gbc_btnNewButton_1admin);

        JScrollBar scrollBarAdmin = new JScrollBar();
        adminTelaInicial.add(scrollBarAdmin, BorderLayout.EAST);

        JPanel panel_2admin = new JPanel();
        adminTelaInicial.add(panel_2admin, BorderLayout.NORTH);

        ///??????
        JTextField pesquisarTextFieldadmin = new JTextField();
        panel_2admin.add(pesquisarTextFieldadmin);
        pesquisarTextFieldadmin.setColumns(30);

        JButton pesquisarButtonadmin = new JButton("🔎");
        panel_2admin.add(pesquisarButtonadmin);

        String[] columns1 = {"Título", "Autor", "Gênero"};

        DefaultTableModel model1 = new DefaultTableModel(BookManager.getBookData(), columns);

        JTable tabelaLivros1 = new JTable(model);

        for (Book b : BookData.getBookList()) {
            try {
                BookManager.addBook(b, tabelaLivros1);
            } catch (BookAlreadyExistsException e) {
                System.out.println(e.getMessage());
            }
        }

        pesquisarButtonadmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pesquisa = pesquisarTextField.getText().toLowerCase();

                if (pesquisa.equals("")) {
                    for (Book b : BookData.getBookList()) {
                        try {
                            BookManager.addBook(b, tabelaLivros1);
                        } catch (BookAlreadyExistsException baee) {
                            System.out.println(baee.getMessage());
                        }
                    }

                }

                DefaultTableModel model = (DefaultTableModel) tabelaLivros1.getModel();
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


		JScrollPane scrollPaneadmin = new JScrollPane(tabelaLivros1
				);
		adminTelaInicial.add(scrollPaneadmin, BorderLayout.CENTER);

		JPanel adicionarLivro = new JPanel();
		adicionarLivro.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(adicionarLivro, "name_78778782162400");
		adicionarLivro.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_24 = new JPanel();
		panel_24.setBackground(new Color(255, 255, 255));
		adicionarLivro.add(panel_24);
		panel_24.setLayout(new BorderLayout(0, 0));

		JPanel panel_25 = new JPanel();
		panel_24.add(panel_25, BorderLayout.NORTH);

		JLabel lblNewLabel_11 = new JLabel("New label");
		panel_25.add(lblNewLabel_11);

		JPanel panel_26 = new JPanel();
		panel_24.add(panel_26, BorderLayout.CENTER);


//////		 


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

                    // TODO desfazer cagada
                    if (AccountManager.getLoggedAccount() instanceof AdminAccount) {
                        adminTelaInicial.setVisible(true);
                        textField.setText("");
                        passwordField.setText("");

                    } else if (AccountManager.getLoggedAccount() instanceof NormalAccount) {
                        telaInicial.setVisible(true);
                        textField.setText("");
                        passwordField.setText("");
                    }


                } catch (IncorrectCredentialsException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

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

                if(user.length() > 20) {
                	JOptionPane.showMessageDialog(frame, "Limite de 20 caracteres excedido!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(user.matches("[a-z0-9]+") == false) {
                	JOptionPane.showMessageDialog(frame, "Nome de usuário deve conter apenas números e letras minúsculas!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (user.isEmpty() || password.isEmpty()) {
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
                        textFieldCadastro.setText("");
                        passwordFieldCadastro.setText("");
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

        tabelaLivros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                panelf30.removeAll();
                panelf30.revalidate();
                panelf30.repaint();

                int linha = tabelaLivros.getSelectedRow();
                String tituloLivro = tabelaLivros.getValueAt(linha, 0).toString();
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

                if (lblNewLabel_9_2.getMouseListeners().length == 0) {
                    lblNewLabel_9_2.addMouseListener(new MouseAdapter() {
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
        lblNewLabel_9_1_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                livro.setVisible(false);
                autor.setVisible(true);
            }
        });
    }
	
}
