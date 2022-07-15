package janelas;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JanelaTelaCadastroDePrograma extends JFrame {

	public JanelaTelaCadastroDePrograma(String titulo) {
		
		setTitle(titulo);
		setSize(900, 700); // L, A
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
	}
}
