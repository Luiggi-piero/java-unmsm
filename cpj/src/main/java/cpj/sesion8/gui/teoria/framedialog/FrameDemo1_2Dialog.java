package cpj.sesion8.gui.teoria.framedialog;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FrameDemo1_2Dialog {
	JFrame frame;

	FrameDemo1_2Dialog() {
		JDialog ayuda = new JDialog(frame, "FrameDemo5", true);
		Container panel = new JPanel();
		panel.add(new JLabel("FrameDemo5 Version 1.0"));
		ayuda.setContentPane(panel);
		ayuda.setSize(200, 100);
		ayuda.setVisible(true);

		String dato = JOptionPane.showInputDialog(null, "Ingrese un valor:", "Ingreso",
				JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "El valor ingresado es " + dato, "Aviso", JOptionPane.INFORMATION_MESSAGE);
		int opc = JOptionPane.showConfirmDialog(null, "Cerrar la aplicacion?");
		if (opc == JOptionPane.YES_OPTION) {
			System.out.println("Presionaste el botón  SI");
		}
	}

	/*
	public static void main(String[] args) {
		new FrameDemo1_2Dialog();
	}*/
}
