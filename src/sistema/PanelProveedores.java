

/*ESTE PANEL ES DE GESTIONAR PRODUCTOS
 * NO CAMBIO LOS NOMBRES PORQUE TENDRÍA QUE CAMBIAR MUCHAS COSAS*/


package sistema;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class PanelProveedores extends JPanel {

	
	public PanelProveedores() {
		setBorder(new LineBorder(Color.GRAY));
		setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 630,388);
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(245, 180, 89, 23);
		add(btnNewButton);
		setVisible(true);
	}

}
