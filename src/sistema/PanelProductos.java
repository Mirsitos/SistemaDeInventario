package sistema;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelProductos extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelProductos() {
		setBorder(new LineBorder(Color.GRAY));
		setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 630,388);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NUEVO PRODUCTO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(234, 11, 139, 14);
		add(lblNewLabel);
		setVisible(true);
	}

}
