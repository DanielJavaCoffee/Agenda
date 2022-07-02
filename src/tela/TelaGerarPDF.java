package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import janelas.JanelaPadrao;
import ouvinte.OuvinteTelaGerarPDF;

public class TelaGerarPDF extends JanelaPadrao {

	OuvinteTelaGerarPDF ouvinte = new OuvinteTelaGerarPDF(this);

	private JButton buttonGerarPDF;
	private JButton buttonVoltar;

	public TelaGerarPDF(String titulo) {
		super(titulo);
		adicionarTitulo();
		adicionarJButtonPDF();
		adicionarJButtonVoltar();
		setVisible(true);
	}

	private void adicionarTitulo() {

		ImageIcon icon = new ImageIcon("src/Imagens/cats-removebg-preview.png");
		JLabel jLabel = new JLabel("TELA DE PDF", icon, JLabel.CENTER);
		jLabel.setBounds(0, 0, 700, 70);
		jLabel.setFont(new Font("Impact", Font.ITALIC, 30));
		jLabel.setOpaque(true);
		jLabel.setBackground(new Color(46, 139, 87));
		jLabel.setForeground(Color.WHITE);
		add(jLabel);

	}

	private void adicionarJButtonPDF() {

		buttonGerarPDF = new JButton("Gerar PDF De Todos Os Programas");
		buttonGerarPDF.setBounds(200, 200, 350, 30);
		buttonGerarPDF.addActionListener(gerarPDF());
		buttonGerarPDF.addActionListener(voltar());
		buttonGerarPDF.setBackground(new Color(46, 139, 87));
		buttonGerarPDF.setForeground(Color.WHITE);
		buttonGerarPDF.setFont(new Font("Arial Black", Font.ITALIC, 15));
		add(buttonGerarPDF);
	}

	public ActionListener gerarPDF() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedGerarPDF(e);
			}
		};
	}

	private void adicionarJButtonVoltar() {

		buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(30, 400, 100, 30);
		buttonVoltar.addActionListener(voltar());
		buttonVoltar.addActionListener(voltar());
		buttonVoltar.setBackground(new Color(46, 139, 87));
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

	public JButton getButtonGerarPDF() {
		return buttonGerarPDF;
	}
}
