package sistema;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Metodos_SQL.Metodos_sql;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;


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
    private JTextField txtUsuario;
    private JTextField txtEmail;
    
    public GUI() {
    	setTitle("Pantalla de registro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 933, 496);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 2), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
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
        button.setBounds(581, 424, 282, 33);
        contentPane.add(button);
        
        
        JLabel lblNewLabel = new JLabel("USUARIO");
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(581, 40, 72, 23);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("CORREO ELECTRÓNICO");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBackground(Color.BLACK);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(581, 164, 167, 14);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("CONTRASEÑA");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setBackground(Color.BLACK);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(581, 284, 91, 14);
        contentPane.add(lblNewLabel_2);
        
        txtContraseña = new JPasswordField();
        txtContraseña.setCaretColor(Color.WHITE);
        txtContraseña.setSelectionColor(Color.WHITE);
        txtContraseña.setForeground(Color.WHITE);
        txtContraseña.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
        txtContraseña.setBackground(Color.DARK_GRAY);
        txtContraseña.setBounds(581, 309, 282, 23);
        contentPane.add(txtContraseña);
        
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
        lblNewLabel_4.setBounds(41, 0, 506, 425);
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
        chkMostrarContrasenia1.setBounds(720, 339, 143, 23);
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
        
        txtUsuario = new JTextField();
        txtUsuario.setForeground(Color.WHITE);
        txtUsuario.setDisabledTextColor(Color.WHITE);
        txtUsuario.setCaretColor(Color.WHITE);
        txtUsuario.setBackground(Color.DARK_GRAY);
        txtUsuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
        txtUsuario.setBounds(581, 74, 277, 20);
        contentPane.add(txtUsuario);
        txtUsuario.setColumns(10);
        
        txtEmail = new JTextField();
        txtEmail.setForeground(Color.WHITE);
        txtEmail.setCaretColor(Color.WHITE);
        txtEmail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
        txtEmail.setBackground(Color.DARK_GRAY);
        txtEmail.setBounds(581, 189, 282, 20);
        contentPane.add(txtEmail);
        txtEmail.setColumns(10);
    }
}