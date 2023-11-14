package sistema;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class GestionarCliente extends JPanel {

    public GestionarCliente() {
        setBorder(new LineBorder(Color.LIGHT_GRAY));
        setBackground(Color.DARK_GRAY);
        setLayout(null);

        JLabel lblNewLabel = new JLabel("GESTION DE CLIENTES");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(234, 11, 139, 14);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Ingrese el nombre:");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(28, 62, 120, 14);
        add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("xxxx:");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1_1.setBounds(92, 99, 120, 14);
        add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("xxxxx:");
        lblNewLabel_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1_2.setBounds(134, 138, 120, 14);
        add(lblNewLabel_1_2);

        setVisible(true);
    }

    public void guardarClienteEnBD() {
        Connection conexion = null;
        try {
            conexion = ConexionBD.obtenerConexion();
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