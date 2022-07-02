package ouvinte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CentralDeInformacoes;
import model.Mensageiro;
import model.Persistencia;
import personalizedMessage.MensagemEmail;
import tela.TelaDeMenu;
import tela.TelaEnviarEmail;

public class OuvinteTelaDeEnviarEmail implements ActionListener {

    private TelaEnviarEmail telaEnviarEmail;

    Persistencia persistencia = new Persistencia();
    CentralDeInformacoes central = persistencia.recuperarCentral();

    public OuvinteTelaDeEnviarEmail(TelaEnviarEmail tela){
        this.telaEnviarEmail = tela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void actionPerformedEnviar(ActionEvent e, String enviar_email) {

    	try {
    		
            String emailCleinte = telaEnviarEmail.getEmail().getText();
            String assunto = telaEnviarEmail.getAssunto().getText();
            String mensagem = telaEnviarEmail.getAreaMensagem().getText();
            
            Mensageiro.enviarProgramacaoDeHoje(assunto, emailCleinte, mensagem + central.getTodasAsAgendas().toString());
            MensagemEmail.emailEnviadoUsuario();

    	} catch (Exception erro) {
		    MensagemEmail.emailErro();
		}
    }

    public void actionPerformedVoltar(ActionEvent e, String voltar) {
    	
            new TelaDeMenu(null);
            telaEnviarEmail.setVisible(false);
     
    }
}
