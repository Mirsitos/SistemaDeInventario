package sistema;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Metodos_SQL.ConexionBD;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PanelDeProveedores extends JPanel {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_4;

    public PanelDeProveedores() {
        setBackground(Color.DARK_GRAY);
        setBorder(new LineBorder(Color.LIGHT_GRAY));
        setLayout(null);

        JLabel lblNewLabel = new JLabel("PROVEEDORES");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(234, 11, 139, 14);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Empresa:");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(28, 62, 120, 14);
        add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("CI:");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1_1.setBounds(92, 99, 120, 14);
        add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("RUC:");
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
        btnNewButton.addActionListener(e -> guardarProveedor());
        add(btnNewButton);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setForeground(Color.LIGHT_GRAY);
        btnLimpiar.setBackground(Color.DARK_GRAY);
        btnLimpiar.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
        btnLimpiar.setBounds(455, 281, 120, 23);
        add(btnLimpiar);

        textField_4 = new JTextField();
        textField_4.setCaretColor(Color.WHITE);
        textField_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
        textField_4.setForeground(Color.WHITE);
        textField_4.setBackground(Color.DARK_GRAY);
        textField_4.setColumns(10);
        textField_4.setBounds(411, 215, 175, 16);
        add(textField_4);
    }

    private void guardarProveedor() {
        try (
            Connection conexion = ConexionBD.conectar();
            PreparedStatement preparedStatement = conexion.prepareStatement("INSERT INTO Proveedores (NombreEmpresa, CI, RUC) VALUES (?, ?, ?)")
        ) {
            preparedStatement.setString(1, textField.getText());
            preparedStatement.setString(2, textField_1.getText());
            preparedStatement.setString(3, textField_2.getText());
            preparedStatement.executeUpdate();
            System.out.println("Proveedor guardado exitosamente.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al guardar el proveedor.");
            // Puedes mostrar un mensaje de error en un cuadro de diálogo o en otro componente de la interfaz.
        }
    }
}

