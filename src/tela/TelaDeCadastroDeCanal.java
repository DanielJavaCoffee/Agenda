package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

import janelas.JanelaPadrao;
import model.SorteioDeTelaImagens;
import ouvinte.OuvinteTelaDeCadastroDeCanal;

public class TelaDeCadastroDeCanal extends JanelaPadrao {

	OuvinteTelaDeCadastroDeCanal ouvinte = new OuvinteTelaDeCadastroDeCanal(this);

	private JTextField campoNome;
	private JTextField campoLinkNumero;
	private JButton buttonVoltar;
	private JButton buttonSalvar;

	public TelaDeCadastroDeCanal(String titulo) {
		super(titulo);
		titulo();
		adicionarJLabel();
		adicionarJTextField();
		adicionarJButtonVoltar();
		adicionarJButtonSalvar();
		adicionarImagem();
		setVisible(true);

	}

	private void titulo() {
		ImageIcon icon = new ImageIcon("src/Imagens/cats-removebg-preview.png");
		JLabel jLabel = new JLabel("CADASTRAMENTO DE CANAL", icon, JLabel.CENTER);
		jLabel.setBounds(0, 0, 700, 70);
		jLabel.setFont(new Font("Impact",Font.ITALIC, 30));
		jLabel.setOpaque(true);
		jLabel.setBackground(new Color(46,139,87));
		jLabel.setForeground(Color.WHITE);
		add(jLabel);
	}

	private void adicionarJLabel() {

		JLabel nomeDoCanal = new JLabel("Nome Do Canal:");
		nomeDoCanal.setBounds(30, 100, 250, 30);
		nomeDoCanal.setFont(new Font("Arial Black",Font.ITALIC, 17));
	    nomeDoCanal.setOpaque(true);
		nomeDoCanal.setBackground(new Color(46,139,87));
		nomeDoCanal.setForeground(Color.WHITE);
		add(nomeDoCanal);

		JLabel formarDeAssistir = new JLabel("Link Ou Número Do Canal:");
		formarDeAssistir.setBounds(30, 180, 250, 30);
		formarDeAssistir.setFont(new Font("Arial Black", Font.ITALIC, 17));
		formarDeAssistir.setOpaque(true);
		formarDeAssistir.setBackground(new Color(46, 139, 87));
		formarDeAssistir.setForeground(Color.WHITE);
		add(formarDeAssistir);

	}

	private void adicionarJTextField() {

		campoNome = new JTextField();
		campoNome.setBounds(300, 100, 200, 30);
		add(campoNome);

		campoLinkNumero = new JFormattedTextField();
		campoLinkNumero.setBounds(300, 180, 200, 30);
		add(campoLinkNumero);
	}

	private void adicionarJButtonVoltar() {

		buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(30, 400, 100, 30);
		buttonVoltar.addActionListener(voltar());
		buttonVoltar.setBackground(new Color(46,139,87));
		buttonVoltar.setForeground(Color.WHITE);
		buttonVoltar.setFont(new Font("Arial Black", Font.ITALIC, 15));
		add(buttonVoltar);
	}

	public ActionListener voltar() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}

	private void adicionarJButtonSalvar() {

		buttonSalvar = new JButton("Salvar");
		buttonSalvar.setBounds(550, 400, 100, 30);
		buttonSalvar.addActionListener(salvar());
		buttonSalvar.setBackground(new Color(46,139,87));
		buttonSalvar.setForeground(Color.WHITE);
		buttonSalvar.setFont(new Font("Arial Black", Font.ITALIC, 15));
		add(buttonSalvar);
	}

	public ActionListener salvar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedsalvar(e);
			}
		};
	}
	
	public void adicionarImagem() {
		
		SorteioDeTelaImagens sorteioDeTelaImagens = new SorteioDeTelaImagens();
		
		JLabel imagem = new JLabel();
        imagem.setIcon(new ImageIcon(sorteioDeTelaImagens.sorteioDeTela()));
        imagem.setBounds(0, 30, 700, 450);
        add(imagem);
	}

	public JTextField getCampoNome() {
		return campoNome;
	}

	public JTextField getCampoLinkNumero() {
		return campoLinkNumero;
	}

	public JButton getButtonVoltar() {
		return buttonVoltar;
	}

	public JButton getButtonSalvar() {
		return buttonSalvar;
	}
}
