package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import entity.Canal;
import janelas.JanelaTelaCadastroDePrograma;
import model.CentralDeInformacoes;
import model.Persistencia;
import model.Util;
import ouvinte.OuvinteTelaDeCadastroDeProgramaContinuo;

public class TelaCadastroDeProgramaContinuo extends JanelaTelaCadastroDePrograma {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	OuvinteTelaDeCadastroDeProgramaContinuo ouvinte = new OuvinteTelaDeCadastroDeProgramaContinuo(this);

	private JTextField campoNomeDoPrograma;
	private JTextField campoIDCanal;
	private JTextField campoDiasDaSemana;
	private JTextField campoApresentador;
	private JFormattedTextField campoHorario;
	private JButton buttonVoltar;
	private JButton buttonSalvar;

	public TelaCadastroDeProgramaContinuo(String titulo) {
		super(titulo);
		adicionarTitulo();
		listarPrograma();
		adicionarJLabel();
		adicionarJTextFild();
		adicionarButtonVoltar();
		adicionarButtonSalvar();
		setVisible(true);
	}

	private void adicionarTitulo() {
		
		ImageIcon icon = new ImageIcon("src/Imagens/cats-removebg-preview.png");
		JLabel jLabel = new JLabel("CADASTRO DE PROGRAMA", icon, JLabel.CENTER);
		jLabel.setBounds(0, 0, 900, 70);
		jLabel.setFont(Util.fontTitulo);
		jLabel.setOpaque(true);
		jLabel.setBackground(new Color(46,139,87));
		jLabel.setForeground(Color.WHITE);
		add(jLabel);
	}

	private void listarPrograma() {

		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("ID");
		modelo.addColumn("Nome");
		modelo.addColumn("Tipo De Canal");
		modelo.addColumn("Link Ou Número Do Canal");

		List<Canal> canais = centralDeInformacoes.getTodosOsCanais();

		Collections.sort(canais);

		Object[] linhas = new Object[canais.size()];
		for (Canal canal : canais) {
			Object[] linha = new Object[4];
			linha[0] = canal.getId();
			linha[1] = canal.getNome();
			linha[2] = canal.getTipoDoCanal();
			linha[3] = canal.getLinkOuCanal();
			modelo.addRow(linha);
		}

		JTable tabela = new JTable(modelo);
		tabela.setBackground(Color.green);
		JScrollPane painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(40, 100, 800, 190);
		add(painelTabela);

	}

	private void adicionarJLabel() {

		JLabel nome = new JLabel("Nome Do Programa: ");
		nome.setBounds(40, 300, 240, 30);
		nome.setFont(Util.font);
	    nome.setOpaque(true);
		nome.setBackground(new Color(46,139,87));
		nome.setForeground(Color.WHITE);
		add(nome);

		JLabel id = new JLabel("ID Do Canal: ");
		id.setBounds(40, 350, 240, 30);
		id.setFont(Util.font);
	    id.setOpaque(true);
		id.setBackground(new Color(46,139,87));
		id.setForeground(Color.WHITE);
		add(id);

		JLabel data = new JLabel("Dia/s Do Programa: ");
		data.setBounds(40, 400, 240, 30);
		data.setFont(Util.font);
	    data.setOpaque(true);
		data.setBackground(new Color(46,139,87));
		data.setForeground(Color.WHITE);
		add(data);

		JLabel horario = new JLabel("Horario Do Programa: ");
		horario.setBounds(40, 450, 240, 30);
		horario.setFont(Util.font);
	    horario.setOpaque(true);
		horario.setBackground(new Color(46,139,87));
		horario.setForeground(Color.WHITE);
		add(horario);
		
		JLabel apresentador = new JLabel("Nome Do Apresentador:");
		apresentador.setBounds(40, 500, 240, 30);
		apresentador.setFont(Util.font);
	    apresentador.setOpaque(true);
		apresentador.setBackground(new Color(46,139,87));
		apresentador.setForeground(Color.WHITE);
		add(apresentador);
		
	}

	private void adicionarJTextFild() {

		campoNomeDoPrograma = new JTextField();
		campoNomeDoPrograma.setBounds(300, 300, 200, 30);
		add(campoNomeDoPrograma);

		campoIDCanal = new JTextField();
		campoIDCanal.setBounds(300, 350, 200, 30);
		add(campoIDCanal);

		campoDiasDaSemana = new JTextField();
		campoDiasDaSemana.setBounds(300, 400, 200, 30);
		add(campoDiasDaSemana);
		
		try {
			campoHorario = new JFormattedTextField(new MaskFormatter("##:##"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		campoHorario.setBounds(300, 450, 70, 30);
		add(campoHorario);
		
		campoApresentador = new JTextField();
		campoApresentador.setBounds(300, 500, 200, 30);
		add(campoApresentador);
		
	}

	private void adicionarButtonVoltar() {

		buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(40, 600, 100, 30);
		buttonVoltar.addActionListener(voltar());
		buttonVoltar.setBackground(new Color(46,139,87));
		buttonVoltar.setForeground(Color.WHITE);
		buttonVoltar.setFont(Util.font);
		add(buttonVoltar);

	}

	public ActionListener voltar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}

	private void adicionarButtonSalvar() {

		buttonSalvar = new JButton("Salvar");
		buttonSalvar.setBounds(720, 600, 100, 30);
		buttonSalvar.addActionListener(salvar());
		buttonSalvar.setBackground(new Color(46,139,87));
		buttonSalvar.setForeground(Color.WHITE);
		buttonSalvar.setFont(Util.font);
		add(buttonSalvar);
	}
	

	public ActionListener salvar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ouvinte.actionPerformedSalvar(e);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		};
	}

	public JTextField getCampoNomeDoPrograma() {
		return campoNomeDoPrograma;
	}

	public JTextField getCampoIDCanal() {
		return campoIDCanal;
	}


	public JTextField getCampoDiasDaSemana() {
		return campoDiasDaSemana;
	}

	public JFormattedTextField getCampoHorario() {
		return campoHorario;
	}

	public JButton getButtonVoltar() {
		return buttonVoltar;
	}

	public JButton getButtonSalvar() {
		return buttonSalvar;
	}

	public JTextField getCampoApresentador() {
		return campoApresentador;
	}
}
