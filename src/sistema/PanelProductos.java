package sistema;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class PanelProductos extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelProductos() {
		setBorder(new LineBorder(Color.GRAY));
		setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 630,388);
		setLayout(null);
		setVisible(true);
	}

}
