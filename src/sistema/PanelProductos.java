package sistema;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PanelProductos extends JPanel {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    private void guardarProducto() {
        Connection conexion = null;
        try {
            conexion = ConexionBD.obtenerConexion(); 
            String query = "INSERT INTO productos (nombre, codigo, cantidad, descripcion, fecha_llegada) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setString(1, textField.getText());
                preparedStatement.setString(2, textField_1.getText());
                preparedStatement.setInt(3, Integer.parseInt(textField_2.getText()));
                preparedStatement.setString(4, textField_3.getText());
                preparedStatement.setDate(5, java.sql.Date.valueOf(textField_4.getText()));

                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Producto guardado exitosamente.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar el producto.");
        } finally {
            ConexionBD.cerrarConexion(conexion);
        }
    }
    
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
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese el nombre:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(28, 62, 120, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ingrese código:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(92, 99, 120, 14);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ingrese la cantidad:");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(134, 138, 120, 14);
		add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.DARK_GRAY);
		textField.setBounds(158, 62, 175, 16);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setCaretColor(Color.WHITE);
		textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		textField_1.setForeground(Color.WHITE);
		textField_1.setBackground(Color.DARK_GRAY);
		textField_1.setColumns(10);
		textField_1.setBounds(198, 99, 175, 16);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setCaretColor(Color.WHITE);
		textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		textField_2.setBackground(Color.DARK_GRAY);
		textField_2.setColumns(10);
		textField_2.setBounds(264, 136, 175, 16);
		add(textField_2);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(76, 281, 120, 23);
		add(btnNewButton);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(Color.LIGHT_GRAY);
		btnLimpiar.setBackground(Color.DARK_GRAY);
		btnLimpiar.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		btnLimpiar.setBounds(455, 281, 120, 23);
		add(btnLimpiar);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ingrese la descripción:");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(187, 175, 130, 14);
		add(lblNewLabel_1_2_1);
		
		textField_3 = new JTextField();
		textField_3.setCaretColor(Color.WHITE);
		textField_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		textField_3.setForeground(Color.WHITE);
		textField_3.setBackground(Color.DARK_GRAY);
		textField_3.setColumns(10);
		textField_3.setBounds(340, 176, 175, 16);
		add(textField_3);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Ingrese la fecha de llegada:");
		lblNewLabel_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(236, 214, 165, 14);
		add(lblNewLabel_1_2_1_1);
		
		textField_4 = new JTextField();
		textField_4.setCaretColor(Color.WHITE);
		textField_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		textField_4.setForeground(Color.WHITE);
		textField_4.setBackground(Color.DARK_GRAY);
		textField_4.setColumns(10);
		textField_4.setBounds(411, 215, 175, 16);
		add(textField_4);
		setVisible(true);
	}
	
}
