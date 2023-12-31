package sistema;
import Metodos_SQL.ConexionBD;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Metodos_SQL.ConexionBD;
import Metodos_SQL.ConexionBD;
import Metodos_SQL.ConexionBD;
import javax.swing.JTable;
import javax.swing.JSeparator;

public class PanelProveedores extends JPanel {

    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTable table;

    public PanelProveedores() {
        setBorder(new LineBorder(Color.LIGHT_GRAY));
        setBackground(Color.DARK_GRAY);
        setLayout(null);

        JLabel lblNewLabel = new JLabel("GESTION DE PRODUCTOS");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(234, 11, 188, 14);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Ingrese el nombre:");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(28, 62, 120, 14);
        add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Código:");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1_1.setBounds(92, 99, 120, 14);
        add(lblNewLabel_1_1);

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
        textField_1.setBounds(158, 100, 175, 16);
        add(textField_1);

        textField_2 = new JTextField();
        textField_2.setCaretColor(Color.WHITE);
        textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
        textField_2.setBackground(Color.DARK_GRAY);
        textField_2.setColumns(10);
        textField_2.setBounds(158, 139, 175, 16);
        add(textField_2);

        JButton btnNewButton = new JButton("Actualizar");
        btnNewButton.setBorder(new LineBorder(new Color(192, 192, 192), 3));
        btnNewButton.setForeground(Color.LIGHT_GRAY);
        btnNewButton.setBackground(Color.DARK_GRAY);
        btnNewButton.setBounds(441, 59, 120, 23);
        add(btnNewButton);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setForeground(Color.LIGHT_GRAY);
        btnLimpiar.setBackground(Color.DARK_GRAY);
        btnLimpiar.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
        btnLimpiar.setBounds(441, 135, 120, 23);
        add(btnLimpiar);
        
        table = new JTable();
        table.setBackground(Color.GRAY);
        table.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
        table.setBounds(30, 204, 605, 145);
        add(table);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setForeground(Color.LIGHT_GRAY);
        btnEliminar.setBorder(new LineBorder(new Color(192, 192, 192), 3));
        btnEliminar.setBackground(Color.DARK_GRAY);
        btnEliminar.setBounds(441, 96, 120, 23);
        add(btnEliminar);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Fecha:");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1_1_1.setBounds(92, 144, 59, 14);
        add(lblNewLabel_1_1_1);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(28, 21, 200, 14);
        add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(420, 21, 200, 14);
        add(separator_1);

      
        btnNewButton.addActionListener(e -> guardarProveedor());

        setVisible(true);
    }

    private void guardarProveedor() {
        Connection conexion = null;
        try {
            conexion = ConexionBD.conectar();
            String query = "INSERT INTO proveedores (nombre, xxxx, xxxxx) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setString(1, textField.getText());
                preparedStatement.setString(2, textField_1.getText());
                preparedStatement.setString(3, textField_2.getText());
                preparedStatement.executeUpdate();
                System.out.println("Proveedor guardado exitosamente.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al guardar el proveedor.");
        } finally {
            ConexionBD.cerrarConexion(conexion);
        }
    }
}