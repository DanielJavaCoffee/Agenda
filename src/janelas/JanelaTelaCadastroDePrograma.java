package janelas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Util;

@SuppressWarnings("serial")
public class JanelaTelaCadastroDePrograma extends JFrame {

	public JanelaTelaCadastroDePrograma(String titulo) {
		
		setTitle(titulo);
		setSize(900, 700); // L, A
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tituloDaTela();
		setResizable(false);
	}
	
	public void tituloDaTela() {
		
		ImageIcon icon = new ImageIcon("src/Imagens/cats-removebg-preview.png");
		JLabel jLabel = new JLabel("CADASTRO DE PROGRAMA", icon, JLabel.CENTER);
		jLabel.setBounds(0, 0, 900, 70);
		jLabel.setFont(Util.fontTitulo);
		jLabel.setOpaque(true);
		jLabel.setBackground(new Color(46, 139, 87));
		jLabel.setForeground(Color.WHITE);
		jLabel.addMouseListener(new MouseListener() {
			
		public void mouseReleased(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {

		}

		public void mouseExited(MouseEvent e) {
				jLabel.setBackground(new Color(46, 139, 87));
				jLabel.repaint();
				Cursor c = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(c);
		}

		public void mouseEntered(MouseEvent e) {
				jLabel.setBackground(Color.RED);
				jLabel.repaint();
				Cursor c = new Cursor(Cursor.HAND_CURSOR);
				setCursor(c);
		}

		public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Isso não é um site");
			}
		});
		add(jLabel);
	}	
}
