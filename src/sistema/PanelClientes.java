package sistema;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Metodos_SQL.ConexionBD;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PanelClientes extends JPanel {
    private JTextField textFieldNombre;
    private JTextField textFieldRUC;
    private JTextField textFieldCI;
    private JTextField textFieldDireccion;

    public PanelClientes() {
        setBorder(new LineBorder(Color.LIGHT_GRAY));
        setBackground(Color.DARK_GRAY);
        setLayout(null);

        JLabel lblNewLabel = new JLabel("AGREGAR CLIENTE");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(234, 11, 139, 14);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Ingrese el nombre:");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(28, 62, 120, 14);
        add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("RUC:");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1_1.setBounds(92, 99, 120, 14);
        add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("CI:");
        lblNewLabel_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1_2.setBounds(134, 138, 120, 14);
        add(lblNewLabel_1_2);

        JLabel lblDireccion = new JLabel("Direccion:");
        lblDireccion.setForeground(Color.WHITE);
        lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblDireccion.setBounds(92, 175, 120, 14);
        add(lblDireccion);

        textFieldNombre = new JTextField();
        textFieldNombre.setCaretColor(Color.WHITE);
        textFieldNombre.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
        textFieldNombre.setForeground(Color.WHITE);
        textFieldNombre.setBackground(Color.DARK_GRAY);
        textFieldNombre.setBounds(158, 62, 175, 16);
        add(textFieldNombre);
        textFieldNombre.setColumns(10);

        textFieldRUC = new JTextField();
        textFieldRUC.setCaretColor(Color.WHITE);
        textFieldRUC.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
        textFieldRUC.setForeground(Color.WHITE);
        textFieldRUC.setBackground(Color.DARK_GRAY);
        textFieldRUC.setColumns(10);
        textFieldRUC.setBounds(198, 99, 175, 16);
        add(textFieldRUC);

        textFieldCI = new JTextField();
        textFieldCI.setCaretColor(Color.WHITE);
        textFieldCI.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
        textFieldCI.setBackground(Color.DARK_GRAY);
        textFieldCI.setColumns(10);
        textFieldCI.setBounds(264, 136, 175, 16);
        add(textFieldCI);

        textFieldDireccion = new JTextField();
        textFieldDireccion.setCaretColor(Color.WHITE);
        textFieldDireccion.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
        textFieldDireccion.setForeground(Color.WHITE);
        textFieldDireccion.setBackground(Color.DARK_GRAY);
        textFieldDireccion.setColumns(10);
        textFieldDireccion.setBounds(198, 175, 175, 16);
        add(textFieldDireccion);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBorder(new LineBorder(new Color(192, 192, 192), 3));
        btnGuardar.setForeground(Color.LIGHT_GRAY);
        btnGuardar.setBackground(Color.DARK_GRAY);
        btnGuardar.setBounds(76, 281, 120, 23);
        add(btnGuardar);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setForeground(Color.LIGHT_GRAY);
        btnLimpiar.setBackground(Color.DARK_GRAY);
        btnLimpiar.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
        btnLimpiar.setBounds(455, 281, 120, 23);
        add(btnLimpiar);

       
        btnGuardar.addActionListener(e -> guardarCliente());

        setVisible(true);
    }

    private void guardarCliente() {
        Connection conexion = null;
        try {
            conexion = ConexionBD.obtenerConexion();
            String query = "INSERT INTO clientes (nombre, ruc, ci, direccion) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setString(1, textFieldNombre.getText());
                preparedStatement.setString(2, textFieldRUC.getText());
                preparedStatement.setString(3, textFieldCI.getText());
                preparedStatement.setString(4, textFieldDireccion.getText());
                preparedStatement.executeUpdate();
                System.out.println("Cliente guardado exitosamente.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al guardar el cliente.");
        } finally {
            ConexionBD.cerrarConexion(conexion);
        }
    }
}
