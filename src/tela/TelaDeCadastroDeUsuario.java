package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import janelas.JanelaPadrao;
import model.SorteioDeTelaImagens;
import model.Util;
import ouvinte.OuvinteTelaDeCadastroDeUsuario;


public class TelaDeCadastroDeUsuario extends JanelaPadrao {
	
	OuvinteTelaDeCadastroDeUsuario ouvinte = new OuvinteTelaDeCadastroDeUsuario(this);
	
	private JTextField campoNome;
	private JTextField campoEmail;
	private JPasswordField campoSenha01;
	private JPasswordField campoSenha02;
	private JButton buttonSalvar;
	
	

	public TelaDeCadastroDeUsuario(String titulo) {
		super(titulo, "CADASTRAMENTO DO USUÁRIO");
		adicionarJLabel();
		adicionarJTextFiled();
		buttonSalvar();
		adicionarImagem();
		setVisible(true);
		
	}
	
	private void adicionarJLabel() {
		JLabel nome = new JLabel("Nome:", JLabel.CENTER);
		nome.setBounds(30, 90, 95, 30);
		nome.setFont(Util.font);
		nome.setOpaque(true);
		nome.setBackground(new Color(46,139,87));
		nome.setForeground(Color.WHITE);
		add(nome);
		
		JLabel email = new JLabel("Email:", JLabel.CENTER);
		email.setBounds(30, 160, 95, 30);
		email.setFont(Util.font);
		email.setOpaque(true);
		email.setBackground(new Color(46,139,87));
		email.setForeground(Color.WHITE);
		add(email);
		
		JLabel senha01 = new JLabel("Senha:", JLabel.CENTER);
		senha01.setBounds(30, 230, 95, 30);
		senha01.setFont(Util.font);
		senha01.setOpaque(true);
		senha01.setBackground(new Color(46,139,87));
		senha01.setForeground(Color.WHITE);
		add(senha01);
		
		JLabel senha02 = new JLabel("Senha: ", JLabel.CENTER);
		senha02.setBounds(30, 300, 95, 30);
		senha02.setFont(Util.font);
		senha02.setOpaque(true);
		senha02.setBackground(new Color(46,139,87));
		senha02.setForeground(Color.WHITE);
		add(senha02);
	}
	
	private void adicionarJTextFiled() {
		
		campoNome = new JTextField();
		campoNome.setBounds(130, 90, 250, 30);
		add(campoNome);
		
		campoEmail =  new JTextField();
		campoEmail.setBounds(130, 160, 250, 30);
		add(campoEmail);
		
		campoSenha01 = new JPasswordField();
		campoSenha01.setBounds(130, 230, 200, 30);
		add(campoSenha01);
		
		campoSenha02 = new JPasswordField();
		campoSenha02.setBounds(130, 300, 200, 30);
		add(campoSenha02);
	}
	
	private void buttonSalvar() {
		buttonSalvar = new JButton("Salvar");
		buttonSalvar.setBounds(520, 400, 130, 30);
		buttonSalvar.setBackground(new Color(46,139,87));
		buttonSalvar.setForeground(Color.WHITE);
		buttonSalvar.setFont(Util.font);
		buttonSalvar.addActionListener(salvar());
		add(buttonSalvar);
	}
	
	public ActionListener salvar() {
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
				
			}
		};
	}
	
	public void adicionarImagem() {

		SorteioDeTelaImagens sorteioDeTelaImagens = new SorteioDeTelaImagens();

		JLabel imagem = new JLabel();
		imagem.setIcon(new ImageIcon(sorteioDeTelaImagens.sorteioDeTela()));
		imagem.setBounds(0, 30, 700, 500);
		add(imagem);
	}
	
	public JTextField getCampoNome() {
		return campoNome;
	}

	public JTextField getCampoEmail() {
		return campoEmail;
	}

	public JPasswordField getCampoSenha01() {
		return campoSenha01;
	}

	public JPasswordField getCampoSenha02() {
		return campoSenha02;
	}

	public JButton getButtonSalvar() {
		return buttonSalvar;
	}
}
