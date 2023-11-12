package sistema;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.Toolkit;

public class Dashboard extends JFrame {

    private JPanel contentPane;
    private PanelProductos panelProductos;
    private PanelProveedores panelProveedores;/*El panel proveedores es en realidad el panel de agregar productos*/
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Dashboard frame = new Dashboard();
                    frame.setUndecorated(true);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Dashboard() {
    	setAlwaysOnTop(true);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/sistema/images/teemo_icon_by_bobbelebien_db0cqmg.png")));
        setBackground(new Color(105, 105, 105));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 838, 452);

        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new LineBorder(new Color(128, 128, 128)));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        panelProductos = new PanelProductos();
        panelProductos.setBounds(0, 0, 636, 369);
        panelProductos.setBackground(Color.DARK_GRAY);
        panelProveedores = new PanelProveedores();

        JPanel panel_productos = new JPanel();
        panel_productos.addMouseListener(new PanelButtonMouseAdapter(panel_productos) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		menuClicked(panelProductos);
        	}
        	
        });
        panel_productos.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
        panel_productos.setBackground(Color.DARK_GRAY);
        panel_productos.setBounds(10, 191, 163, 42);
        contentPane.add(panel_productos);
        
        JLabel lblNewLabel = new JLabel("AGREGAR PRODUCTOS");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/sistema/images/carrito-de-compras.png")));
        lblNewLabel.setForeground(Color.WHITE);
        panel_productos.add(lblNewLabel);
        
        JPanel panel_proveedores = new JPanel();
        panel_proveedores.addMouseListener(new PanelButtonMouseAdapter(panel_proveedores) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		menuClicked(panelProveedores);
        	}
        	
        });
        panel_proveedores.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
        panel_proveedores.setBackground(Color.DARK_GRAY);
        panel_proveedores.setBounds(10, 230, 163, 42);
        contentPane.add(panel_proveedores);
        
        JLabel lblNewLabel_1 = new JLabel("GESTIONAR PRODUCTOS");
        panel_proveedores.add(lblNewLabel_1);
        lblNewLabel_1.setIcon(new ImageIcon(Dashboard.class.getResource("/sistema/images/gestion-de-productos.png")));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_1.setForeground(Color.WHITE);
        
        JPanel panel_proveedores_1 = new JPanel();
        panel_proveedores_1.addMouseListener(new PanelButtonMouseAdapter(panel_proveedores_1));
        panel_proveedores_1.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
        panel_proveedores_1.setBackground(Color.DARK_GRAY);
        panel_proveedores_1.setBounds(10, 270, 163, 42);
        contentPane.add(panel_proveedores_1);
        
        JLabel lblNewLabel_2 = new JLabel("PROVEEDORES");
        panel_proveedores_1.add(lblNewLabel_2);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setIcon(new ImageIcon(Dashboard.class.getResource("/sistema/images/fabrica.png")));
        lblNewLabel_2.setForeground(Color.WHITE);
        
        JPanel panel_clientes = new JPanel();
        panel_clientes.addMouseListener(new PanelButtonMouseAdapter(panel_clientes));
        panel_clientes.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
        panel_clientes.setBackground(Color.DARK_GRAY);
        panel_clientes.setBounds(10, 309, 163, 42);
        contentPane.add(panel_clientes);
        
        JLabel lblNewLabel_4 = new JLabel("CLIENTES\r\n");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_4.setIcon(new ImageIcon(Dashboard.class.getResource("/sistema/images/personas (1).png")));
        lblNewLabel_4.setForeground(Color.WHITE);
        panel_clientes.add(lblNewLabel_4);
        
        JPanel panel_GestionarClientes = new JPanel();
        panel_GestionarClientes.addMouseListener(new PanelButtonMouseAdapter(panel_GestionarClientes));
        panel_GestionarClientes.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
        panel_GestionarClientes.setBackground(Color.DARK_GRAY);
        panel_GestionarClientes.setBounds(10, 346, 163, 42);
        contentPane.add(panel_GestionarClientes);
        
        JLabel lblNewLabel_7 = new JLabel("GESTIONAR CLIENTES\r\n");
        panel_GestionarClientes.add(lblNewLabel_7);
        lblNewLabel_7.setForeground(Color.WHITE);
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_7.setIcon(new ImageIcon(Dashboard.class.getResource("/sistema/images/servicios-sociales.png")));
        
        JPanel panelMainContent = new JPanel();
        panelMainContent.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
        panelMainContent.setBackground(Color.DARK_GRAY);
        panelMainContent.setBounds(186, 59, 636, 369);
        contentPane.add(panelMainContent);
        panelMainContent.setLayout(null);
        
        panelMainContent.add(panelProductos);
        
        menuClicked(panelProductos);
        
        JLabel lblNewLabel_6 = new JLabel("New label");
        lblNewLabel_6.setIcon(new ImageIcon(Dashboard.class.getResource("/sistema/images/gestionar.png")));
        lblNewLabel_6.setBounds(30, 52, 127, 128);
        contentPane.add(lblNewLabel_6);
        
        JPanel panel_CERRAR = new JPanel();
        panel_CERRAR.addMouseListener(new PanelButtonMouseAdapter(panel_CERRAR));
        panel_CERRAR.setBorder(new LineBorder(Color.GRAY, 1, true));
        panel_CERRAR.setBackground(Color.DARK_GRAY);
        panel_CERRAR.setBounds(10, 384, 163, 44);
        contentPane.add(panel_CERRAR);
        
        JLabel lblNewLabel_3 = new JLabel("CERRAR SESIÓN\r\n");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        panel_CERRAR.add(lblNewLabel_3);
        lblNewLabel_3.setIcon(new ImageIcon(Dashboard.class.getResource("/sistema/images/salida (2).png")));
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0, 0, 841, 41);
        contentPane.add(panel);
        
        JLabel lblNewLabel_8 = new JLabel("                                                         SISTEMA DE INVENTARIO - TEEMO");
        panel.add(lblNewLabel_8);
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_8.setForeground(Color.WHITE);
        
        JLabel lblNewLabel_5 = new JLabel("                                   X");
        panel.add(lblNewLabel_5);
        lblNewLabel_5.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseExited(MouseEvent e) {
        		System.exit(ABORT);
        	}
        });
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblNewLabel_5.setForeground(Color.GRAY);
	
    }
    
    
    
    public void menuClicked(JPanel panel) {
    	panelProductos.setVisible(false);
    	panelProveedores.setVisible(false);
    	
    	panel.setVisible(true);
    	
    }
    
    private class PanelButtonMouseAdapter extends MouseAdapter{
    	
    	JPanel panel;
    	public PanelButtonMouseAdapter(JPanel panel) {
    		this.panel = panel;
    	}
    	
    	@Override
    	public void mouseEntered(MouseEvent e) {
        	
        	panel.setBackground(new Color(112,128,144));
        	
        }
    	
    	@Override
    	public  void mouseExited(MouseEvent e) {
    		
    		panel.setBackground(Color.DARK_GRAY);
    		
    	}
    	
    	
    	@Override
    	public  void mousePressed(MouseEvent e) {
    		
    		panel.setBackground(new Color(60,179,113));
    		
    	}
    	
    	@Override
    	public  void mouseReleased(MouseEvent e) {
    		
    		panel.setBackground(new Color(112,128,144));
    		
    	}
    	
    }
    
    
    
   
    
    public void paint (Graphics grphcs) {
        Graphics2D g2=(Graphics2D)grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        g2.setColor(getBackground());
        Area area=new Area(new RoundRectangle2D.Double(0,0,getWidth(), getHeight(), 15, 15));
        g2.fill(area);
        g2.dispose();
        super.paint(grphcs);
    }
}
