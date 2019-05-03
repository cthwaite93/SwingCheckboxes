import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;


public class Checkboxes extends JFrame implements ItemListener{
	
	private static final long serialVersionUID = 1L;
	private static int width = 640;
	private static int height = 360;
	private static float minSize = 24;
	private static float maxSize = 32;
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
		setResizable(false);
		setVisible(true);
	}
	
	private JPanel labelPanel() {
		this.labelPanel = new JPanel();
		this.labelPanel.setLayout(new BorderLayout());
		this.labelPanel.setBackground(Color.WHITE);
		this.labelPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
		
		this.jlText = new JLabel(text);
		Font f = this.jlText.getFont();
		this.jlText.setFont(this.jlText.getFont().deriveFont(f.getStyle(), minSize));
		this.jlText.setHorizontalAlignment(JLabel.CENTER);
		
		this.labelPanel.add(this.jlText, BorderLayout.CENTER);
		
		return this.labelPanel;
	}
	
	private JPanel checkboxPanel() {
		JPanel checkboxPanel = new JPanel();
		checkboxPanel.setLayout(new GridLayout(4, 1));
		checkboxPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		checkboxPanel.setBackground(Color.WHITE);
		
		JCheckBox ck1 = new JCheckBox("Colour");
		JCheckBox ck2 = new JCheckBox("Bold");
		JCheckBox ck3 = new JCheckBox("Italic");
		JCheckBox ck4 = new JCheckBox("Big");
		
		ck1.addItemListener(this);
		ck2.addItemListener(this);
		ck3.addItemListener(this);
		ck4.addItemListener(this);
		
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

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		JCheckBox c = (JCheckBox) source;
		switch(c.getText().toString()) {
			case "Colour":
				if (e.getStateChange() == 1) {
					this.labelPanel.setBackground(Color.PINK);
				} else if (e.getStateChange() == 2) {
					this.labelPanel.setBackground(Color.WHITE);
				}
				
				break;
			case "Bold":
				if (e.getStateChange() == 1) {
					if (this.jlText.getFont().isItalic()) {
						this.jlText.setFont(this.jlText.getFont().deriveFont(Font.BOLD+Font.ITALIC));
					} else {
						this.jlText.setFont(this.jlText.getFont().deriveFont(Font.BOLD));
					}
				} else if (e.getStateChange() == 2) {
					if (this.jlText.getFont().isItalic()) {
						this.jlText.setFont(this.jlText.getFont().deriveFont(Font.ITALIC));
					} else {
						this.jlText.setFont(this.jlText.getFont().deriveFont(Font.PLAIN));
					}
				}
				
				break;
			case "Italic":
				if (e.getStateChange() == 1) {
					if (this.jlText.getFont().isBold()) {
						this.jlText.setFont(this.jlText.getFont().deriveFont(Font.BOLD+Font.ITALIC));
					} else {
						this.jlText.setFont(this.jlText.getFont().deriveFont(Font.ITALIC));
					}
				} else if (e.getStateChange() == 2) {
					if (this.jlText.getFont().isBold()) {
						this.jlText.setFont(this.jlText.getFont().deriveFont(Font.BOLD));
					} else {
						this.jlText.setFont(this.jlText.getFont().deriveFont(Font.PLAIN));
					}
				}
				
				break;
			case "Big":
				Font f = this.jlText.getFont();
				if (e.getStateChange() == 1) {
					this.jlText.setFont(this.getFont().deriveFont(f.getStyle(), maxSize));
				} else if (e.getStateChange() == 2) {
					this.jlText.setFont(this.getFont().deriveFont(f.getStyle(), minSize));
				}
				break;
		}
	}
}
