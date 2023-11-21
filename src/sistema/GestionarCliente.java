package sistema;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Metodos_SQL.ConexionBD;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class GestionarCliente extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

    public GestionarCliente() {
        setBorder(new LineBorder(Color.LIGHT_GRAY));
        setBackground(Color.DARK_GRAY);
        setLayout(null);

        JLabel lblNewLabel = new JLabel("GESTION DE CLIENTES");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(234, 11, 200, 14);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Ingrese el nombre:");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(28, 62, 120, 14);
        add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Ruc:");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1_1.setBounds(28, 99, 120, 14);
        add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("C.I:");
        lblNewLabel_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1_2.setBounds(28, 138, 120, 14);
        add(lblNewLabel_1_2);
        
        table = new JTable();
        table.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
        table.setBackground(Color.GRAY);
        table.setBounds(45, 182, 605, 145);
        add(table);
        
        textField = new JTextField();
        textField.setForeground(Color.WHITE);
        textField.setColumns(10);
        textField.setCaretColor(Color.WHITE);
        textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
        textField.setBackground(Color.DARK_GRAY);
        textField.setBounds(104, 97, 296, 16);
        add(textField);
        
        textField_1 = new JTextField();
        textField_1.setForeground(Color.WHITE);
        textField_1.setColumns(10);
        textField_1.setCaretColor(Color.WHITE);
        textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
        textField_1.setBackground(Color.DARK_GRAY);
        textField_1.setBounds(104, 136, 296, 16);
        add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setForeground(Color.WHITE);
        textField_2.setColumns(10);
        textField_2.setCaretColor(Color.WHITE);
        textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
        textField_2.setBackground(Color.DARK_GRAY);
        textField_2.setBounds(146, 60, 254, 16);
        add(textField_2);
        
        JButton btnNewButton = new JButton("Actualizar");
        btnNewButton.setForeground(Color.LIGHT_GRAY);
        btnNewButton.setBorder(new LineBorder(new Color(192, 192, 192), 3));
        btnNewButton.setBackground(Color.DARK_GRAY);
        btnNewButton.setBounds(479, 59, 120, 23);
        add(btnNewButton);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setForeground(Color.LIGHT_GRAY);
        btnEliminar.setBorder(new LineBorder(new Color(192, 192, 192), 3));
        btnEliminar.setBackground(Color.DARK_GRAY);
        btnEliminar.setBounds(479, 96, 120, 23);
        add(btnEliminar);
        
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setForeground(Color.LIGHT_GRAY);
        btnLimpiar.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
        btnLimpiar.setBackground(Color.DARK_GRAY);
        btnLimpiar.setBounds(479, 135, 120, 23);
        add(btnLimpiar);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(56, 23, 168, 2);
        add(separator_1);
        
        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setBounds(399, 23, 168, 2);
        add(separator_1_1);

        setVisible(true);
    }

    public void guardarClienteEnBD() {
        Connection conexion = null;
        try {
            conexion = ConexionBD.conectar();
            String query = "INSERT INTO clientes (nombre, campo1, campo2) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setString(1, "nombre_cliente");
                preparedStatement.setString(2, "valor_campo1");
                preparedStatement.setString(3, "valor_campo2");
                preparedStatement.executeUpdate();
                System.out.println("Cliente guardado en la base de datos.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al guardar el cliente en la base de datos.");
        } finally {
            ConexionBD.cerrarConexion(conexion);
        }
    }
}
