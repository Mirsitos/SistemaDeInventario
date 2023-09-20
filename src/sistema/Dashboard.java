package sistema;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Dashboard extends JFrame {

    private JPanel contentPane;
    private JLabel lblIncioDeSesin;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Dashboard frame = new Dashboard();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Dashboard() {
        setBackground(new Color(105, 105, 105));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 641, 358);
        
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null); 
        setContentPane(contentPane);

       
        lblIncioDeSesin = new JLabel("Hola, soy un JLabel");
        lblIncioDeSesin.setForeground(Color.WHITE);
        lblIncioDeSesin.setBounds(24, 241, 154, 30);
        contentPane.add(lblIncioDeSesin); 

       
        lblIncioDeSesin.setText("Incio de sesión como");

       
        lblIncioDeSesin.setBackground(Color.DARK_GRAY);
        lblIncioDeSesin.setOpaque(true); 
        
        JLabel lblNombre = new JLabel((String) null);
        lblNombre.setOpaque(true);
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setBackground(Color.DARK_GRAY);
        lblNombre.setBounds(188, 241, 173, 30);
        contentPane.add(lblNombre);
    }
}
