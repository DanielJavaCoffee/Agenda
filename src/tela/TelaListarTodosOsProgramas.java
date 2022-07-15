package tela;

import java.awt.Color;
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

import entity.Programa;
import entity.ProgramaContinuo;
import entity.ProgramaDeRealityShows;
import entity.ProgramaSeriesRegulares;
import janelas.JanelaListarProgramas;
import model.CentralDeInformacoes;
import model.Persistencia;
import model.Util;
import ouvinte.OuvinteTelaListarTodosOsProgramas;

public class TelaListarTodosOsProgramas extends JanelaListarProgramas {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	OuvinteTelaListarTodosOsProgramas ouvinte = new OuvinteTelaListarTodosOsProgramas(this);

	private JButton buttonVoltar;
	private JButton buttonExcluir;
	private JButton buttonAtualizar;
	private JButton buttonDetalhar;
	private JButton buttonAdicionarNaAgenda;
	private JButton buttonFiltrar;
	private JTextField campoBusca;

	public TelaListarTodosOsProgramas(String titulo) {
		super(titulo);

		adicionarJButtonVoltar();
		adicionarJButtonAtualizar();
		adicionarJButtonExcluir();
		adicionarJButtonDetalhar();
		adicionarJButtonAdcionar();
		adicionarJButtonFiltrar();
		listarCanal();
		imagen();
		setVisible(true);
	}

	private void adicionarJButtonVoltar() {

		buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(80, 600, 100, 30);
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

	private void adicionarJButtonAtualizar() {

		buttonAtualizar = new JButton("Atualizar");
		buttonAtualizar.setBounds(850, 600, 100, 30);
		buttonAtualizar.addActionListener(atualizar());
		buttonAtualizar.setBackground(new Color(46,139,87));
		buttonAtualizar.setForeground(Color.WHITE);
		buttonAtualizar.setFont(Util.font);
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
		buttonExcluir.setBounds(980, 600, 100, 30);
		buttonExcluir.addActionListener(excluir());
		buttonExcluir.setBackground(new Color(46,139,87));
		buttonExcluir.setForeground(Color.WHITE);
		buttonExcluir.setFont(Util.font);
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
		buttonDetalhar.setBounds(700, 600, 130, 30);
		buttonDetalhar.addActionListener(detalhar());
		buttonDetalhar.setBackground(new Color(46,139,87));
		buttonDetalhar.setForeground(Color.WHITE);
		buttonDetalhar.setFont(Util.font);
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
	
	public void adicionarJButtonAdcionar(){
		
		buttonAdicionarNaAgenda = new JButton("Adicionar na minha Agenda");
		buttonAdicionarNaAgenda.setBounds(430, 600, 250, 30);
		buttonAdicionarNaAgenda.addActionListener(adicionar());
		buttonAdicionarNaAgenda.setBackground(new Color(46,139,87));
		buttonAdicionarNaAgenda.setForeground(Color.WHITE);
		buttonAdicionarNaAgenda.setFont(Util.font);
		add(buttonAdicionarNaAgenda);
	}
	
	public ActionListener adicionar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedAdicionarNaAgenda(e);
			}
		};
	}
	
	public void adicionarJButtonFiltrar() {
		
		buttonFiltrar = new JButton("Filtrar Agenda");
		buttonFiltrar.setBounds(220, 600, 180, 30);
		buttonFiltrar.addActionListener(filtrar());
		buttonFiltrar.setBackground(new Color(46,139,87));
		buttonFiltrar.setForeground(Color.WHITE);
		buttonFiltrar.setFont(Util.font);
		add(buttonFiltrar);
		
	}
	
	public ActionListener filtrar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedFiltrar(e);
			}
		};
	}

	private void listarCanal() {

		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("Tipo De Programa");
		modelo.addColumn("Nome");
		modelo.addColumn("Apresentador");
		modelo.addColumn("Status De Exebição");
		modelo.addColumn("Canal");
		modelo.addColumn("Dia Da Semana");
		modelo.addColumn("Horario");
		modelo.addColumn("Data");
		modelo.addColumn("Temporada");
		modelo.addColumn("Genero");
		modelo.addColumn("Estilo");
		modelo.addColumn("ID");
		
		List<Programa> programa = centralDeInformacoes.getTodosOsProgramas();

		Collections.sort(programa);

		Object[] linhas = new Object[programa.size()];

		for (Programa p : programa) {

			if (p instanceof ProgramaContinuo) {
				ProgramaContinuo pc = (ProgramaContinuo) p;

				Object[] linha = new Object[12];
				linha[0] = pc.getTipoDePrograma();
				linha[1] = pc.getNome();
				linha[2] = pc.getNomeDosApresentadores();
				linha[3] = pc.getStatusDeExebicao();
				linha[4] = pc.getCanal();
				for(String d: pc.getDiasDaSemana()) {
					System.out.println(d);
				}
				linha[5] = pc.getDiasDaSemana();
				linha[6] = pc.getHorario();
				linha[7] = pc.getDataHiato();
				linha[11] = pc.getId();

				modelo.addRow(linha);
			}
			
			if (p instanceof ProgramaSeriesRegulares) {
				ProgramaSeriesRegulares ps = (ProgramaSeriesRegulares) p;

				Object[] linha = new Object[12];
				linha[0] = ps.getTipoDePrograma();
				linha[1] = ps.getNome();
				linha[3] = ps.getStatusDeExebicao();
				linha[4] = ps.getCanal();
				linha[5] = ps.getDiasDaSemana();
				linha[6] = ps.getHorario();
				linha[7] = ps.getDataHiato();
				linha[8] = ps.getTemparada();
				linha[9] = ps.getGenero();
				linha[10] = ps.getEstilo();
				linha[11] = ps.getId();

				modelo.addRow(linha);
			}
			
			if (p instanceof ProgramaDeRealityShows) {
				ProgramaDeRealityShows pr = (ProgramaDeRealityShows) p;

				Object[] linha = new Object[12];
				linha[0] = pr.getTipoDePrograma();
				linha[1] = pr.getNome();
				linha[3] = pr.getStatusDeExebicao();
				linha[4] = pr.getCanal();
				linha[5] = pr.getDiasDaSemana().toString();
				linha[6] = pr.getHorario();
				linha[7] = pr.getDataHiato();
				linha[8] = pr.getTemporada();
				linha[11] = pr.getId();
				modelo.addRow(linha);
			}
		}
		JTable tabela = new JTable(modelo);
		tabela.setBackground(Color.green);
		JScrollPane painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(80, 120, 1000, 400);
		add(painelTabela);
	}
	
	public void imagen() {
		
		JLabel imagem = new JLabel();
        imagem.setIcon(new ImageIcon("src/Imagens/pipocaFilme.jpeg"));
        imagem.setBounds(0, 30, 1200, 700);
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
	
	public JButton getButtonAdicionarNaAgenda() {
		return buttonAdicionarNaAgenda;
	}

	public JButton getButtonFiltrar() {
		return buttonFiltrar;
	}

}
