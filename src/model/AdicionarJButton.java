package model;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AdicionarJButton extends JButton {

	public JButton adicionarJButton(String nomeCampo, int x, int y, int z, int w) {

		JButton nome = new JButton(nomeCampo);
		nome.setBounds(x, y, z, w);
		nome.setFont(Util.font);
		nome.setOpaque(true);
		nome.setBackground(new Color(46, 139, 87));
		nome.setForeground(Color.WHITE);
		nome.addActionListener(actionListener);
		nome.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				nome.setBackground(new Color(46, 139, 87));
				nome.repaint();
				Cursor c = new Cursor(Cursor.DEFAULT_CURSOR);
				setCursor(c);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				nome.setBackground(Color.BLUE);
				nome.repaint();
				Cursor c = new Cursor(Cursor.HAND_CURSOR);
				setCursor(c);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
	
			}
		});
		return (JButton) add(nome);
	}

	public void addTema() {
		try {
			// AQUI VOCE SETA O NOME DA CLASSE REFERENTE A CADA TEMA !
			String tema = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";

			// AQUI VC SETA O LOOK AND FEEL
			UIManager.setLookAndFeel(tema);
		} catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException
				| ClassNotFoundException e) {
			System.out.println("Erro LAF : " + e.getMessage());
		}
	}
}
