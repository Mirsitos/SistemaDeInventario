package sistema;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Metodos_SQL.ConexionBD;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelProductos extends JPanel {
    private JTextField textFieldNombre;
    private JTextField textFieldCodigo;
    private JTextField textFieldCantidad;
    private JTextField textFieldDescripcion;
    private JTextField textFieldFechaLlegada;
    private JButton btnGuardar;
    private JButton btnLimpiar;

    public PanelProductos() {
        setBorder(new LineBorder(Color.GRAY));
        setBackground(Color.DARK_GRAY);
        setBounds(0, 0, 630, 388);
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

        textFieldNombre = new JTextField();
        textFieldNombre.setCaretColor(Color.WHITE);
        textFieldNombre.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        textFieldNombre.setForeground(Color.WHITE);
        textFieldNombre.setBackground(Color.DARK_GRAY);
        textFieldNombre.setBounds(158, 62, 175, 16);
        add(textFieldNombre);
        textFieldNombre.setColumns(10);

        textFieldCodigo = new JTextField();
        textFieldCodigo.setCaretColor(Color.WHITE);
        textFieldCodigo.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        textFieldCodigo.setForeground(Color.WHITE);
        textFieldCodigo.setBackground(Color.DARK_GRAY);
        textFieldCodigo.setColumns(10);
        textFieldCodigo.setBounds(198, 99, 175, 16);
        add(textFieldCodigo);

        textFieldCantidad = new JTextField();
        textFieldCantidad.setForeground(Color.WHITE);
        textFieldCantidad.setCaretColor(Color.WHITE);
        textFieldCantidad.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        textFieldCantidad.setBackground(Color.DARK_GRAY);
        textFieldCantidad.setColumns(10);
        textFieldCantidad.setBounds(264, 136, 175, 16);
        add(textFieldCantidad);

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarProducto();
            }
        });
        btnGuardar.setBorder(new LineBorder(new Color(192, 192, 192), 3));
        btnGuardar.setForeground(Color.LIGHT_GRAY);
        btnGuardar.setBackground(Color.DARK_GRAY);
        btnGuardar.setBounds(76, 281, 120, 23);
        add(btnGuardar);
        btnGuardar.setBorder(new LineBorder(new Color(192, 192, 192), 3));
        btnGuardar.setForeground(Color.LIGHT_GRAY);
        btnGuardar.setBackground(Color.DARK_GRAY);
        btnGuardar.setBounds(76, 281, 120, 23);
        add(btnGuardar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
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

        textFieldDescripcion = new JTextField();
        textFieldDescripcion.setCaretColor(Color.WHITE);
        textFieldDescripcion.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        textFieldDescripcion.setForeground(Color.WHITE);
        textFieldDescripcion.setBackground(Color.DARK_GRAY);
        textFieldDescripcion.setColumns(10);
        textFieldDescripcion.setBounds(340, 176, 175, 16);
        add(textFieldDescripcion);

        JLabel lblNewLabel_1_2_1_1 = new JLabel("Ingrese la fecha de llegada:");
        lblNewLabel_1_2_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1_2_1_1.setBounds(236, 214, 165, 14);
        add(lblNewLabel_1_2_1_1);

        textFieldFechaLlegada = new JTextField();
        textFieldFechaLlegada.setCaretColor(Color.WHITE);
        textFieldFechaLlegada.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        textFieldFechaLlegada.setForeground(Color.WHITE);
        textFieldFechaLlegada.setBackground(Color.DARK_GRAY);
        textFieldFechaLlegada.setColumns(10);
        textFieldFechaLlegada.setBounds(411, 215, 175, 16);
        add(textFieldFechaLlegada);
        setVisible(true);
    }

    private void guardarProducto() {
        btnGuardar.setEnabled(false);

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try (Connection conexion = ConexionBD.conectar()) {
                    if (conexion != null) {
                        String query = "INSERT INTO productos (Nombre, CodigoProducto, cantidad, DescripcionProducto, FechaLlegada) VALUES (?, ?, ?, ?, ?)";
                        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                            preparedStatement.setString(1, textFieldNombre.getText());
                            preparedStatement.setString(2, textFieldCodigo.getText());
                            preparedStatement.setInt(3, Integer.parseInt(textFieldCantidad.getText()));
                            preparedStatement.setString(4, textFieldDescripcion.getText());

                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String fechaActual = sdf.format(new Date());

                            preparedStatement.setString(5, fechaActual);

                            preparedStatement.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Producto guardado exitosamente.");
                            System.out.println("Producto guardado correctamente");
                            limpiarCampos();
                           
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al guardar el producto: " + ex.getMessage());
                }
                return null;
            }

            @Override
            protected void done() {
                btnGuardar.setEnabled(true);
            }
        };

        worker.execute();
    }

    private void limpiarCampos() {
        textFieldNombre.setText("");
        textFieldCodigo.setText("");
        textFieldCantidad.setText("");
        textFieldDescripcion.setText("");
        textFieldFechaLlegada.setText("");
    }

   
    }

