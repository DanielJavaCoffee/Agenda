package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import janelas.JanelaPadrao;
import model.SorteioDeTelaImagens;
import model.Util;
import ouvinte.OuvinteTelaDeEnviarEmail;

public class TelaEnviarEmail extends JanelaPadrao {

	OuvinteTelaDeEnviarEmail ouvinte = new OuvinteTelaDeEnviarEmail(this);

	private JTextArea areaMensagem;
	private JTextField assunto;
	private JTextField email;
	private JButton enviar;
	private JButton voltar;

	public TelaEnviarEmail(String titulo) {
		super(titulo, "ENVIAR EMAIL");
		adicionarJLabel();
		adicionarCampo();
		adicionarBotaoEnviar();
		adicionarBotaoVoltar();
		adicionarImagem();
		setVisible(true);
	}

	private void adicionarJLabel() {

		JLabel assunto = new JLabel("Assunto:");
		assunto.setBounds(20, 90, 130, 30);
		assunto.setFont(Util.font);
		assunto.setOpaque(true);
		assunto.setBackground(new Color(46, 139, 87));
		assunto.setForeground(Color.WHITE);
		add(assunto);

		JLabel emailCliente = new JLabel("Emial:");
		emailCliente.setBounds(20, 150, 130, 30);
		emailCliente.setFont(Util.font);
		emailCliente.setOpaque(true);
		emailCliente.setBackground(new Color(46, 139, 87));
		emailCliente.setForeground(Color.WHITE);
		add(emailCliente);

		JLabel mensagem = new JLabel("Mensagem:");
		mensagem.setBounds(20, 230, 130, 30);
		mensagem.setFont(Util.font);
		mensagem.setOpaque(true);
		mensagem.setBackground(new Color(46, 139, 87));
		mensagem.setForeground(Color.WHITE);
		add(mensagem);
	}

	private void adicionarCampo() {

		assunto = new JTextField();
		assunto.setBounds(160, 90, 250, 30);
		add(assunto);

		email = new JTextField();
		email.setBounds(160, 150, 250, 30);
		add(email);

		areaMensagem = new JTextArea();
		JScrollPane painel = new JScrollPane(areaMensagem);
		painel.setBounds(160, 230, 250, 90);
		areaMensagem.setLineWrap(true);
		areaMensagem.setWrapStyleWord(true);
		add(painel);
	}

	private void adicionarBotaoEnviar() {

		enviar = new JButton("Enviar Email");
		enviar.setIcon(new ImageIcon("icones/icons8-gmail-20.png"));
		enviar.setBounds(490, 400, 160, 30); // esquerda para direita, B, C, comprimento, altura;
		enviar.addActionListener(enviar());
		enviar.setFont(Util.font);
		enviar.setBackground(new Color(46, 139, 87));
		enviar.setForeground(Color.WHITE);
		add(enviar);
	}

	public ActionListener enviar() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedEnviar(e, "Enviar Email");
			}
		};
	}

	private void adicionarBotaoVoltar() {

		voltar = new JButton("Voltar");
		voltar.setIcon(new ImageIcon("icones/icons8-rotate-left-20.png"));
		voltar.setBounds(20, 400, 160, 30); // esquerda para direita, B, C, comprimento, altura
		voltar.addActionListener(voltar());
		voltar.setFont(Util.font);
		voltar.setBackground(new Color(46, 139, 87));
		voltar.setForeground(Color.WHITE);
		add(voltar);
	}

	public ActionListener voltar() {

		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedVoltar(e, "Voltar");
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

	public JTextField getEmail() {
		return email;
	}

	public JTextField getAssunto() {
		return assunto;
	}

	public JTextArea getAreaMensagem() {
		return areaMensagem;
	}

	public JButton getVoltar() {
		return voltar;
	}

	public JButton getEnviar() {
		return enviar;
	}
}
