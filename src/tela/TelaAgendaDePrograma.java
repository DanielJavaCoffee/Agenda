package tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entity.Programa;
import entity.ProgramaContinuo;
import entity.ProgramaDeRealityShows;
import entity.ProgramaSeriesRegulares;
import entity.Usuario;
import janelas.JanelaListarProgramas;
import model.CentralDeInformacoes;
import model.Persistencia;
import ouvinte.OuvinteTelaAgendaDePrograma;

public class TelaAgendaDePrograma extends JanelaListarProgramas {
	
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	OuvinteTelaAgendaDePrograma ouvinte = new OuvinteTelaAgendaDePrograma(this);

	private JButton buttonVoltar;
	private JButton buttonExcluir;
	private JButton buttonDetalhar;
	private JTextField campoBusca;
	
	public TelaAgendaDePrograma(String titulo) {
		super(titulo);
		adicionarJButtonVoltar();
		adicionarJButtonExcluir();
		adicionarJButtonDetalhar();
		listarCanal();
		setVisible(true);
	}

	private void adicionarJButtonVoltar() {

		buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(80, 600, 100, 30);
		buttonVoltar.addActionListener(voltar());
		add(buttonVoltar);
	}

	public ActionListener voltar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}

	private void adicionarJButtonExcluir() {

		buttonExcluir = new JButton("Remover");
		buttonExcluir.setBounds(980, 600, 100, 30);
		buttonExcluir.addActionListener(excluir());
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
		buttonDetalhar.setBounds(850, 600, 100, 30);
		buttonDetalhar.addActionListener(detalhar());
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

		modelo.addColumn("Tipo De Programa");
		modelo.addColumn("Nome");
		modelo.addColumn("Apresentador");
		modelo.addColumn("Status De Exebi??o");
		modelo.addColumn("Canal");
		modelo.addColumn("Dia Da Semana");
		modelo.addColumn("Horario");
		modelo.addColumn("Data");
		modelo.addColumn("Temporada");
		modelo.addColumn("Genero");
		modelo.addColumn("Estilo");
		modelo.addColumn("ID");
		
		Usuario usuario = centralDeInformacoes.recuperarUsuario(centralDeInformacoes.getTodosOsUsuarios().get(0).getNome());
		
		List<Programa> programa = usuario.getMinhaAgenda();

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
				linha[5] = pr.getDiasDaSemana();
				linha[6] = pr.getHorario();
				linha[7] = pr.getDataHiato();
				linha[8] = pr.getTemporada();
				linha[11] = pr.getId();

				modelo.addRow(linha);
			}

		}
		JTable tabela = new JTable(modelo);
		JScrollPane painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(80, 120, 1000, 400);
		add(painelTabela);
	}

	public JButton getButtonVoltar() {
		return buttonVoltar;
	}

	public JButton getButtonExcluir() {
		return buttonExcluir;
	}

	public JTextField getCampoBusca() {
		return campoBusca;
	}

	public JButton getButtonDetalhar() {
		return buttonDetalhar;
	}
	
}



