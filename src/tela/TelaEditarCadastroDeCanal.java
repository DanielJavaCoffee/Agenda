package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entity.Canal;
import janelas.JanelaPadrao;
import model.SorteioDeTelaImagens;
import ouvinte.OuvinteTelaEditarCadastroDeCanal;

public class TelaEditarCadastroDeCanal extends JanelaPadrao {

	OuvinteTelaEditarCadastroDeCanal ouvinte = new OuvinteTelaEditarCadastroDeCanal(this);

	private JTextField campoNome;
	private JTextField campoFormaDeAssistir;
	private JTextField campoNumeroOuLink;
	private JTextField campoid;
	private JButton buttonSalvar;
	private JButton buttonVoltar;
	private Canal canal;

	public TelaEditarCadastroDeCanal(String titulo, Canal canal) {
		super(titulo);
		this.canal = canal;
		setVisible(true);
		adicionarTitulo();
		adicionarJLabel();
		adicionarJTextFiled();
		adicionarJButtonsalvar();
		adicionarJButtonVoltar();
		adicionarImagem();
	}

	private void adicionarTitulo() {

		ImageIcon icon = new ImageIcon("src/Imagens/cats-removebg-preview.png");
		JLabel jLabel = new JLabel("CADASTRAMENTO DE CANAL", icon, JLabel.CENTER);
		jLabel.setBounds(0, 0, 700, 70);
		jLabel.setFont(new Font("Impact", Font.ITALIC, 30));
		jLabel.setOpaque(true);
		jLabel.setBackground(new Color(46, 139, 87));
		jLabel.setForeground(Color.WHITE);
		add(jLabel);
	}

	private void adicionarJLabel() {

		JLabel nomeDoCanal = new JLabel("Nome Do Canal:");
		nomeDoCanal.setBounds(30, 100, 170, 30);
		nomeDoCanal.setFont(new Font("Arial Black", Font.ITALIC, 17));
		nomeDoCanal.setOpaque(true);
		nomeDoCanal.setBackground(new Color(46, 139, 87));
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

	private void adicionarJTextFiled() {

		campoNome = new JTextField();
		campoNome.setBounds(300, 100, 200, 30);
		campoNome.setText(this.canal.getNome());
		add(campoNome);

		campoNumeroOuLink = new JTextField();
		campoNumeroOuLink.setBounds(300, 180, 200, 30);
		campoNumeroOuLink.setText(this.canal.getLinkOuCanal());
		add(campoNumeroOuLink);

		campoid = new JTextField();
		campoid.setText(String.valueOf(this.canal.getId()));
	}

	public void adicionarJButtonsalvar() {

		buttonSalvar = new JButton("Salvar");
		buttonSalvar.setBounds(540, 390, 100, 30);
		buttonSalvar.addActionListener(salvar());
		buttonSalvar.setBackground(new Color(46, 139, 87));
		buttonSalvar.setForeground(Color.WHITE);
		buttonSalvar.setFont(new Font("Arial Black", Font.ITALIC, 15));
		add(buttonSalvar);

	}

	public ActionListener salvar() {
		return new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}

	public void adicionarJButtonVoltar() {

		buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(30, 390, 100, 30);
		buttonVoltar.addActionListener(voltar());
		buttonVoltar.setBackground(new Color(46, 139, 87));
		buttonVoltar.setForeground(Color.WHITE);
		buttonVoltar.setFont(new Font("Arial Black", Font.ITALIC, 15));
		add(buttonVoltar);
	}

	public ActionListener voltar() {
		return new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedVoltar(e);
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

	public JTextField getCampoFormaDeAssistir() {
		return campoFormaDeAssistir;
	}

	public JTextField getCampoNumeroOuLink() {
		return campoNumeroOuLink;
	}

	public JButton getButtonSalvar() {
		return buttonSalvar;
	}

	public JButton getButtonVoltar() {
		return buttonVoltar;
	}

	public JTextField getCampoid() {
		return campoid;
	}

	public void setCampoid(JTextField campoid) {
		this.campoid = campoid;
	}
}
