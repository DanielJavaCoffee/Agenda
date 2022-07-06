package ouvinte;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Canal;
import entity.ProgramaContinuo;
import enuns.StatusDeExebicao;
import model.CentralDeInformacoes;
import model.Persistencia;
import personalizedMessage.MensagemCanal;
import personalizedMessage.MensagemException;
import personalizedMessage.MensagemPrograma;
import personalizedMessage.MensagemUsuario;
import tela.TelaCadastroDeProgramaContinuo;
import tela.TelaCadastroDeProgramaSeriesRegulares;
import tela.TelaDeMenu;

public class OuvinteTelaDeCadastroDeProgramaContinuo implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	private TelaCadastroDeProgramaContinuo telaCadastroDePrograma;

	public TelaCadastroDeProgramaContinuo getTelaCadastroDePrograma() {
		return telaCadastroDePrograma;
	}

	public OuvinteTelaDeCadastroDeProgramaContinuo(TelaCadastroDeProgramaContinuo tela) {
		this.telaCadastroDePrograma = tela;
	}

	public void actionPerformed(ActionEvent e) {
		new TelaDeMenu(null);
		telaCadastroDePrograma.setVisible(false);
	} // end action

	public void actionPerformedSalvar(ActionEvent e) {

		try {

			SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
			Date data = null;
			String nome = telaCadastroDePrograma.getCampoNomeDoPrograma().getText();
			long id = Long.parseLong(telaCadastroDePrograma.getCampoIDCanal().getText());
			String horario = telaCadastroDePrograma.getCampoHorario().getText();
			String dia[] = telaCadastroDePrograma.getCampoDiasDaSemana().getText().split(", ");
			String apresentador = telaCadastroDePrograma.getCampoApresentador().getText();

			if (nome.isBlank() || horario.isBlank()) {
				MensagemUsuario.usuarioCampoVazio();
			} else {

				Canal canal = centralDeInformacoes.recuperarCanalId(id);

				if (canal != null) {

					String[] status = { "Exibi��o", "Hiato", "Finalizado", "Cancelado" };
					String entradaStatus = (String) JOptionPane.showInputDialog(null, "Status De Exebi��o: ", "",
							JOptionPane.WARNING_MESSAGE, null, status, status[0]);

					StatusDeExebicao exebicao = null;

					if (status[0] == entradaStatus) {
						exebicao = StatusDeExebicao.EXIBICAO;
					} else if (status[1] == entradaStatus) {
						exebicao = StatusDeExebicao.HIATO;
						data = formatar.parse(JOptionPane.showInputDialog("Data de exebi��o: Separe por barras /. "));
					} else if (status[2] == entradaStatus) {
						exebicao = StatusDeExebicao.FINALIZADO;
					} else {
						exebicao = StatusDeExebicao.CANCELADO;
					} // end else

					ProgramaContinuo programa = new ProgramaContinuo(nome, apresentador, exebicao, canal, null,
							horario, data);
					canal.conta(1);
					centralDeInformacoes.adicionarProgramaDeTV(programa);
					persistencia.salvarCentral(centralDeInformacoes);
					MensagemPrograma.programaSalvo();
					new TelaCadastroDeProgramaSeriesRegulares(null);
					telaCadastroDePrograma.setVisible(false);

				} else {
					MensagemCanal.canalNaoEncontardo();
				} // end else
			} // end if
		} catch (NumberFormatException number) {
			MensagemException.numberFormatException(number);
		} catch (HeadlessException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // end catch
	} // end action
} // end class
