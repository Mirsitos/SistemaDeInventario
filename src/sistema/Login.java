package sistema;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import Metodos_SQL.Metodos_sql;

import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;

public class Login extends JFrame {

    private JPanel contentPane;
    private JLabel lblInicioDeSesin;
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private JCheckBox chkMostrarContrasenia;
    private JLabel lbl_close;
    
    int xx,xy; 

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setUndecorated(true);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    Metodos_sql metodos = new Metodos_sql();
    public Login() {
        setBackground(new Color(105, 105, 105));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 801, 597);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null); 
        setContentPane(contentPane);
        
        lblInicioDeSesin = new JLabel("Hola, soy un JLabel");
        lblInicioDeSesin.setForeground(Color.WHITE);
        lblInicioDeSesin.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblInicioDeSesin.setBounds(333, 129, 112, 30); 
        contentPane.add(lblInicioDeSesin); 

      
        lblInicioDeSesin.setText("Inicio de Sesión");

     
        lblInicioDeSesin.setBackground(Color.DARK_GRAY);
        lblInicioDeSesin.setOpaque(true); 
        
        JLabel lblNewLabel = new JLabel("USUARIO");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel.setBounds(139, 203, 66, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("CONTRASEÑA");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(140, 276, 77, 14);
        contentPane.add(lblNewLabel_1);
        
    
        
        txtUsuario = new JTextField();
        txtUsuario.setForeground(Color.WHITE);
        txtUsuario.setCaretColor(Color.WHITE);
        txtUsuario.setBackground(Color.DARK_GRAY);
        txtUsuario.setBounds(140, 228, 512, 20);
        contentPane.add(txtUsuario);
        txtUsuario.setColumns(10);
        
        txtUsuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
        
        txtContraseña = new JPasswordField();
        txtContraseña.setCaretColor(Color.WHITE);
        txtContraseña.setForeground(Color.WHITE);
        txtContraseña.setBackground(Color.DARK_GRAY);
        txtContraseña.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
        txtContraseña.setBounds(140, 301, 512, 20);
        contentPane.add(txtContraseña);
        
        chkMostrarContrasenia = new JCheckBox("Mostrar Contraseña");
        chkMostrarContrasenia.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (chkMostrarContrasenia.isSelected()) {
        			
        			 txtContraseña.setEchoChar((char)0);
        		}
        		else {
        			
        			txtContraseña.setEchoChar('*');
        		}
        	}
        });
        chkMostrarContrasenia.setForeground(Color.WHITE);
        chkMostrarContrasenia.setBackground(Color.DARK_GRAY);
        chkMostrarContrasenia.setBounds(516, 328, 187, 23);
        contentPane.add(chkMostrarContrasenia);
        
        Button button = new Button("Registarse");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		GUI FRAME= new GUI();
        		 FRAME.setUndecorated(true);
                 FRAME.setVisible(true);
                dispose();
        	}
        });
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(241, 57, 83));
        button.setBounds(450, 426, 118, 33);
        contentPane.add(button);
        
        
        Button button1 = new Button("Ingresar");
        button1.addActionListener(new ActionListener() {
    

			@Override
			public void actionPerformed(ActionEvent e) {
			    String nombreUsuario = txtUsuario.getText();
			    String contraseña = txtContraseña.getText();

			    if (nombreUsuario.equals("root") && contraseña.equals("T0NGA1M37456789")) {
			        JOptionPane.showMessageDialog(null, "Bienvenido, iniciaste sesión como administrador");
			        Dashboard frame = new Dashboard(); 
			        JLabel lblNombre = new JLabel("Administrador"); 
			        frame.setVisible(true);
			        dispose();
			    } else {
			        String busqueda_usuario = metodos.buscarUsuarioRegistrado(nombreUsuario, contraseña);
			        
			        if (busqueda_usuario.equals("usuario encontrado")) {
			            String busqueda_nombre = metodos.buscarNombre(nombreUsuario);
			            JOptionPane.showMessageDialog(null, "Bienvenido(a)\n" + busqueda_nombre);
			            Dashboard frame = new Dashboard();
			            JLabel lblNombre = new JLabel(busqueda_nombre);
			            frame.setVisible(true);
			            dispose();
			        } else {
			            JOptionPane.showMessageDialog(null, "Usuario no encontrado, por favor regístrese");
			        }
			    }
			}

        });
        button1.setForeground(Color.WHITE);
        button1.setBackground(new Color(241, 57, 83));
        button1.setBounds(191, 429, 118, 30);
        contentPane.add(button1);
        
        lbl_close = new JLabel("X");
        lbl_close.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		System.exit(ABORT);
        	}
        });
        lbl_close.setForeground(new Color(241,57,83));
        lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbl_close.setBounds(769, 11, 46, 14);
        contentPane.add(lbl_close);
        
        JSeparator separator = new JSeparator();
        separator.setForeground(Color.GRAY);
        separator.setBounds(128, 144, 181, 2);
        contentPane.add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(471, 144, 181, 2);
        contentPane.add(separator_1);
        
        JLabel lblNewLabel_3 = new JLabel("");
        
        lblNewLabel_3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		
        		 xx = e.getX();
        		 xy = e.getY();
        	}
        });
        lblNewLabel_3.addMouseMotionListener(new MouseMotionAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent e) {
        		
        		int x = e.getXOnScreen();

		        int y = e.getYOnScreen();
        		
		        Login.this.setLocation(x - xx, y - xy);  
        	}
        });
        lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/sistema/images/User icon 2.png")));
        lblNewLabel_3.setBounds(322, 11, 128, 107);
        contentPane.add(lblNewLabel_3);
        setForeground(new Color(241, 57, 83));
        
        
    }
}
