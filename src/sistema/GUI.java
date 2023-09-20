package sistema;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Metodos_SQL.Metodos_sql;


public class GUI extends JFrame {
    private JPanel contentPane;

    private int mouseX, mouseY;
    private JPasswordField txtContraseña;
    
    int xx,xy;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI();
                    frame.setUndecorated(true);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    Metodos_sql metodos = new Metodos_sql();
    private TextField txtUsuario;
    private TextField txtEmail;
    
    public GUI() {
    	setTitle("Pantalla de registro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 933, 496);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
      
        
        Button button = new Button("Registrarse");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        						                    
        		int i = metodos.guardar(txtUsuario.getText(), txtEmail.getText(), txtContraseña.getText());
        		if (i>0) {
        			JOptionPane.showMessageDialog(null, "Datos Guardados Correctamente");
        			
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "No se pudieron guardar los datos ");
        		}
        	}
        });
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(241,57,83));
        button.setBounds(581, 403, 282, 33);
        contentPane.add(button);
        
        
        txtUsuario = new TextField();
        txtUsuario.setBounds(581, 58, 282, 23);
        contentPane.add(txtUsuario);
        
        
        JLabel lblNewLabel = new JLabel("USUARIO");
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(580, 29, 72, 23);
        contentPane.add(lblNewLabel);
        
        txtEmail = new TextField();
        txtEmail.setBounds(581, 136, 282, 23);
        contentPane.add(txtEmail);
        
        JLabel lblNewLabel_1 = new JLabel("CORREO ELECTRÓNICO");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBackground(Color.BLACK);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(581, 116, 167, 14);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("CONTRASEÑA");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setBackground(Color.BLACK);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(581, 196, 91, 14);
        contentPane.add(lblNewLabel_2);
        
        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(581, 221, 282, 23);
        contentPane.add(txtContraseña);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(581, 242, 282, 2);
        contentPane.add(separator_1);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(495, 165, 282, -6);
        contentPane.add(separator);
        
        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(495, 87, 282, -6);
        contentPane.add(separator_3);
        
        JLabel lbl_close = new JLabel("X");
        lbl_close.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		System.exit(ABORT);
        	}
        });
        lbl_close.setForeground(new Color(241,57,83));
        lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbl_close.setBounds(884, 11, 47, 23);
        contentPane.add(lbl_close);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xx = e.getX();
                 xy = e.getY();
             
            }
        });
  
        lblNewLabel_4.addMouseMotionListener(new MouseMotionAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent e) {
        		
        		int x = e.getXOnScreen();

		        int y = e.getYOnScreen();

		       GUI.this.setLocation(x - xx, y - xy);
        	}
        		
        });
        lblNewLabel_4.setIcon(new ImageIcon(GUI.class.getResource("/sistema/images/user_folder_20282.png")));
        lblNewLabel_4.setBounds(43, 0, 512, 425);
        contentPane.add(lblNewLabel_4);
        
        JCheckBox chkMostrarContrasenia1 = new JCheckBox("Mostrar Contraseña");
        chkMostrarContrasenia1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (chkMostrarContrasenia1.isSelected()) {
        			
       			 txtContraseña.setEchoChar((char)0);
       		}
       		else {
       			
       			txtContraseña.setEchoChar('*');
       		}
        	}
        });
        chkMostrarContrasenia1.setForeground(Color.WHITE);
        chkMostrarContrasenia1.setBackground(Color.DARK_GRAY);
        chkMostrarContrasenia1.setBounds(720, 251, 143, 23);
        contentPane.add(chkMostrarContrasenia1);
        
        JLabel lblNewLabel_5 = new JLabel("<<");
        lblNewLabel_5.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Login FRAME= new Login();
       		 	FRAME.setUndecorated(true);
                FRAME.setVisible(true);
                dispose();
        	}
        });
        lblNewLabel_5.setForeground(new Color(241,57,83));
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_5.setBounds(10, 11, 47, 23);
        contentPane.add(lblNewLabel_5);
    }
}