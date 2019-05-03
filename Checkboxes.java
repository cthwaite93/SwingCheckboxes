import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;


public class Checkboxes extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static int width = 640;
	private static int height = 360;
	private static String text = "We play with Checkboxes...";
	
	private JLabel jlText;
	private JPanel labelPanel;
	
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setVisible(true);
	}
	
	private JPanel labelPanel() {
		this.labelPanel = new JPanel();
		this.labelPanel.setLayout(new BorderLayout());
		this.labelPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
		
		jlText = new JLabel(text);
		
		this.labelPanel.add(jlText, BorderLayout.CENTER);
		//this.labelPanel.setBackground(Color.PINK);
		
		return this.labelPanel;
	}
	
	private JPanel checkboxPanel() {
		JPanel checkboxPanel = new JPanel();
		checkboxPanel.setLayout(new GridLayout(4, 1));
		checkboxPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		
		JCheckBox ck1 = new JCheckBox("Colour");
		JCheckBox ck2 = new JCheckBox("Bold");
		JCheckBox ck3 = new JCheckBox("Italic");
		JCheckBox ck4 = new JCheckBox("Big");
		
		checkboxPanel.add(ck1);
		checkboxPanel.add(ck2);
		checkboxPanel.add(ck3);
		checkboxPanel.add(ck4);
		
		return checkboxPanel;
	}
	
	private void constructLayout() {
		Container c = getContentPane();
		c.add(labelPanel(), BorderLayout.CENTER);
		c.add(checkboxPanel(), BorderLayout.EAST);
	}
	
	public Checkboxes() {
		super("Checkboxes");
		setLookAndFeel();
		constructLayout();
		initialize();
	}
	
	
	public static void main(String[] args) {
		new Checkboxes();
	}
}
