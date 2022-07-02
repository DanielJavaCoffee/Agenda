package tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entity.Canal;
import janelas.JanelaPadrao;
import model.CentralDeInformacoes;
import model.Persistencia;
import model.SorteioDeTelaImagens;
import ouvinte.OuvinteTelaDeListarCanal;

public class TelaListarTodosOsCanal extends JanelaPadrao {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	OuvinteTelaDeListarCanal ouvinte = new OuvinteTelaDeListarCanal(this);

	private JButton buttonVoltar;
	private JButton buttonExcluir;
	private JButton buttonAtualizar;
	private JButton buttonDetalhar;
	private JTextField campoBusca;

	public TelaListarTodosOsCanal(String titulo) {
		super(titulo);
		adicionarJLabel();
		adicionarJButtonVoltar();
		adicionarJButtonAtualizar();
		adicionarJButtonExcluir();
		adicionarJButtonDetalhar();
		listarCanal();
		adicionarImagem();
		setVisible(true);
	}

	private void adicionarJLabel() {

		ImageIcon icon = new ImageIcon("src/Imagens/cats-removebg-preview.png");
		JLabel jLabel = new JLabel("TELA DE LISTAR CANAL", icon, JLabel.CENTER);
		jLabel.setBounds(0, 0, 700, 70);
		jLabel.setFont(new Font("Impact", Font.ITALIC, 30));
		jLabel.setOpaque(true);
		jLabel.setBackground(new Color(46, 139, 87));
		jLabel.setForeground(Color.WHITE);
		add(jLabel);
	}

	private void adicionarJButtonVoltar() {

		buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(30, 400, 100, 30);
		buttonVoltar.addActionListener(voltar());
		buttonVoltar.setBackground(new Color(46, 139, 87));
		buttonVoltar.setForeground(Color.WHITE);
		buttonVoltar.setFont(new Font("Arial Black", Font.ITALIC, 15));
		add(buttonVoltar);
	}

	public ActionListener voltar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}

	private void adicionarJButtonAtualizar() {

		buttonAtualizar = new JButton("Atualizar");
		buttonAtualizar.setBounds(450, 400, 100, 30);
		buttonAtualizar.addActionListener(atualizar());
		buttonAtualizar.setBackground(new Color(46, 139, 87));
		buttonAtualizar.setForeground(Color.WHITE);
		buttonAtualizar.setFont(new Font("Arial Black", Font.ITALIC, 15));
		add(buttonAtualizar);
	}

	public ActionListener atualizar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedAtualizar(e);
			}
		};
	}

	private void adicionarJButtonExcluir() {

		buttonExcluir = new JButton("Excluir");
		buttonExcluir.setBounds(570, 400, 100, 30);
		buttonExcluir.addActionListener(excluir());
		buttonExcluir.setBackground(new Color(46, 139, 87));
		buttonExcluir.setForeground(Color.WHITE);
		buttonExcluir.setFont(new Font("Arial Black", Font.ITALIC, 15));
		add(buttonExcluir);
	}

	public ActionListener excluir() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedExcluir(e);
			}
		};
	}

	private void adicionarJButtonDetalhar() {

		buttonDetalhar = new JButton("Detalhar");
		buttonDetalhar.setBounds(320, 400, 100, 30);
		buttonDetalhar.addActionListener(detalhar());
		buttonDetalhar.setBackground(new Color(46, 139, 87));
		buttonDetalhar.setForeground(Color.WHITE);
		buttonDetalhar.setFont(new Font("Arial Black", Font.ITALIC, 15));
		add(buttonDetalhar);
	}

	public ActionListener detalhar() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedDetalhar(e);
			}
		};
	}

	private void listarCanal() {

		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("Nome");
		modelo.addColumn("Forma De Assistir");
		modelo.addColumn("Link Do Canal Ou Número");

		List<Canal> canais = centralDeInformacoes.getTodosOsCanais();

		Collections.sort(canais);

		Object[] linhas = new Object[canais.size()];
		for (Canal canal : canais) {
			Object[] linha = new Object[3];
			linha[0] = canal.getNome();
			linha[1] = canal.getTipoDoCanal();
			linha[2] = canal.getLinkOuCanal();
			modelo.addRow(linha);
		}

		JTable tabela = new JTable(modelo);

		tabela.setBackground(Color.green);

		JScrollPane painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(20, 100, 650, 190);
		add(painelTabela);
		linhas.clone();
	}
	
	public void adicionarImagem() {
		
		SorteioDeTelaImagens sorteioDeTelaImagens = new SorteioDeTelaImagens();
		
		JLabel imagem = new JLabel();
        imagem.setIcon(new ImageIcon(sorteioDeTelaImagens.sorteioDeTela()));
        imagem.setBounds(0, 30, 700, 450);
        add(imagem);
	}

	public JButton getButtonVoltar() {
		return buttonVoltar;
	}

	public JButton getButtonExcluir() {
		return buttonExcluir;
	}

	public JButton getButtonAtualizar() {
		return buttonAtualizar;
	}

	public JTextField getCampoBusca() {
		return campoBusca;
	}

	public JButton getButtonDetalhar() {
		return buttonDetalhar;
	}
}

/*
 * for (int i = 0; i < centralDeInformacoes.getTodosOsCanais().size(); i++) {
 * 
 * if (centralDeInformacoes.getTodosOsCanais().get(i)
 * .equals(TipoDeCanal.CANAL_ABERTO_DE_TELEVISAO)) {
 * tabela.setBackground(Color.yellow); }
 * 
 * if (centralDeInformacoes.getTodosOsCanais().get(i)
 * .equals(TipoDeCanal.BROADCASTING_ABERTO_NA_INTERNET)) {
 * tabela.setBackground(Color.pink); }
 * 
 * if (centralDeInformacoes.getTodosOsCanais().get(i)
 * .equals(TipoDeCanal.PACOTE_DE_ASSINATURA)) {
 * tabela.setBackground(Color.blue); }
 * 
 * if (centralDeInformacoes.getTodosOsCanais().get(i)
 * .equals(TipoDeCanal.ASSINATURA_INDIVIDUAL_DE_TELEVISAO)) {
 * tabela.setBackground(Color.orange); }
 * 
 * if (centralDeInformacoes.getTodosOsCanais().get(i)
 * .equals(TipoDeCanal.ASSINATURA_INDIVIDUAL_DE_BROADCASTING)) {
 * tabela.setBackground(Color.white); } }
 */
