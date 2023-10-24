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

public class Dashboard extends JFrame {

    private JPanel contentPane;
    private PanelProductos panelProductos;
    private PanelProveedores panelProveedores;
    

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
        setBackground(new Color(105, 105, 105));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 833, 464);

        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new LineBorder(Color.GRAY, 1, true));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        panelProductos = new PanelProductos();
        panelProductos.setBackground(Color.DARK_GRAY);
        panelProveedores = new PanelProveedores();
       /*panelProductos.setBounds(310, 6, 10, 10);*/
        

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(10, 11, 784, 30);
        contentPane.add(panel);

        JPanel panel_productos = new JPanel();
        panel_productos.addMouseListener(new PanelButtonMouseAdapter(panel_productos) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		menuClicked(panelProductos);
        	}
        	
        });
        panel_productos.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
        panel_productos.setBackground(Color.DARK_GRAY);
        panel_productos.setBounds(10, 163, 137, 30);
        contentPane.add(panel_productos);
        
        JLabel lblNewLabel = new JLabel("PRODUCTOS");
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
        panel_proveedores.setBounds(10, 192, 137, 30);
        contentPane.add(panel_proveedores);
        
        JLabel lblNewLabel_1 = new JLabel("PROVEEDORES");
        lblNewLabel_1.setForeground(Color.WHITE);
        panel_proveedores.add(lblNewLabel_1);
        
        JPanel panel_clientes = new JPanel();
        panel_clientes.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
        panel_clientes.setBackground(Color.DARK_GRAY);
        panel_clientes.setBounds(10, 220, 137, 30);
        contentPane.add(panel_clientes);
        
        JLabel lblNewLabel_2 = new JLabel("CLIENTES");
        lblNewLabel_2.setForeground(Color.WHITE);
        panel_clientes.add(lblNewLabel_2);
        
        JPanel panel_inventario = new JPanel();
        panel_inventario.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
        panel_inventario.setBackground(Color.DARK_GRAY);
        panel_inventario.setBounds(10, 247, 137, 30);
        contentPane.add(panel_inventario);
        
        JLabel lblNewLabel_3 = new JLabel("INVENTARIO");
        lblNewLabel_3.setForeground(Color.WHITE);
        panel_inventario.add(lblNewLabel_3);
        
        JPanel panel_salidas = new JPanel();
        panel_salidas.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
        panel_salidas.setBackground(Color.DARK_GRAY);
        panel_salidas.setBounds(10, 276, 137, 30);
        contentPane.add(panel_salidas);
        
        JLabel lblNewLabel_4 = new JLabel("SALIDAS");
        lblNewLabel_4.setForeground(Color.WHITE);
        panel_salidas.add(lblNewLabel_4);
        
        JPanel panelMainContent = new JPanel();
        panelMainContent.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
        panelMainContent.setBackground(Color.DARK_GRAY);
        panelMainContent.setBounds(164, 59, 630, 388);
        contentPane.add(panelMainContent);
        panelMainContent.setLayout(null);
        
        panelMainContent.add(panelProductos);
        
        menuClicked(panelProductos);
        
        JLabel lblNewLabel_5 = new JLabel("X");
        lblNewLabel_5.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseExited(MouseEvent e) {
        		System.exit(ABORT);
        	}
        });
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_5.setForeground(Color.GRAY);
        lblNewLabel_5.setBounds(804, 11, 46, 30);
        contentPane.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("New label");
        lblNewLabel_6.setIcon(new ImageIcon(Dashboard.class.getResource("/sistema/images/User icon 2.png")));
        lblNewLabel_6.setBounds(10, 52, 127, 100);
        contentPane.add(lblNewLabel_6);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new LineBorder(Color.GRAY, 1, true));
        panel_3.setBackground(Color.DARK_GRAY);
        panel_3.setBounds(10, 305, 137, 142);
        contentPane.add(panel_3);
	
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
