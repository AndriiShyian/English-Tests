import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Main extends JFrame {
	ImageIcon icon = new ImageIcon("C:\\Users\\Andriy\\Pictures\\download.png");
	private JButton button = new JButton("Закінчити тестування");
	private JRadioButton radio1 = new JRadioButton("watched");
	private JRadioButton radio2 = new JRadioButton("watch");
	private JRadioButton radio3 = new JRadioButton("has watched");
	private JRadioButton radio4 = new JRadioButton("been");
	private JRadioButton radio5 = new JRadioButton("was");
	private JRadioButton radio6 = new JRadioButton("were");
	private JRadioButton radio7 = new JRadioButton("bigger");
	private JRadioButton radio8 = new JRadioButton("tall");
	private JRadioButton radio9 = new JRadioButton("the tallest");
	private JRadioButton radio10 = new JRadioButton("studing");
	private JRadioButton radio11 = new JRadioButton("study");
	private JRadioButton radio12 = new JRadioButton("during study");
	private JRadioButton[] radio = { radio1, radio2, radio3, radio4, radio5, radio6, radio7, radio8, radio9, radio10,
			radio11, radio12 };
	private JLabel label1 = new JLabel("I didn't ... TV last night");
	private JLabel label2 = new JLabel(" I've never ... to England.");
	private JLabel label3 = new JLabel("Dubai has ... building in the world.");
	private JLabel label4 = new JLabel("How much time do you spend ... English?");

	public static void main(String[] args) {
		Main m = new Main();
		m.setVisible(true);

	}

	public Main() {
		super("English Test");
		getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		getRootPane().setBackground(Color.CYAN);
		this.setBounds(520, 550, 520, 520);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(icon.getImage());
		Container container = this.getContentPane();
		container.setBackground(Color.CYAN);
		container.setLayout(new GridLayout(18, 1, 1, 1));
		ButtonGroup group1 = new ButtonGroup();
		ButtonGroup group2 = new ButtonGroup();
		ButtonGroup group3 = new ButtonGroup();
		ButtonGroup group4 = new ButtonGroup();
		for (int i = 0; i < radio.length; i++) {
			radio[i].setBackground(Color.CYAN);
		}
		container.add(label1);
		group1.add(radio1);
		group1.add(radio2);
		group1.add(radio3);
		container.add(radio1);
		container.add(radio2);
		container.add(radio3);
		container.add(label2);
		group2.add(radio4);
		group2.add(radio5);
		group2.add(radio6);
		container.add(radio4);
		container.add(radio5);
		container.add(radio6);
		container.add(label3);
		group3.add(radio7);
		group3.add(radio8);
		group3.add(radio9);
		container.add(radio7);
		container.add(radio8);
		container.add(radio9);
		container.add(label4);
		group4.add(radio10);
		group4.add(radio11);
		group4.add(radio12);
		container.add(radio10);
		container.add(radio11);
		container.add(radio12);

		container.add(button);
		for (int i = 3; i < radio.length; i++) {
			radio[i].setEnabled(false);
		}
		button.setEnabled(false);
		for (int i = 0; i < 3; i++) {
			radio[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					radio4.setEnabled(true);
					radio5.setEnabled(true);
					radio6.setEnabled(true);

				}
			});
		}
		for (int i = 3; i < 6; i++) {
			radio[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					radio7.setEnabled(true);
					radio8.setEnabled(true);
					radio9.setEnabled(true);

				}
			});
		}
		for (int i = 6; i < 9; i++) {
			radio[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					radio10.setEnabled(true);
					radio11.setEnabled(true);
					radio12.setEnabled(true);

				}
			});
		}

		for (int i = 9; i < 12; i++) {
			radio[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					button.setEnabled(true);

				}
			});
		}

		button.addActionListener(new ButtonEventListener());
	}

	class ButtonEventListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String message = "";
			message += "Тестування закінчено\n";
			int zero = 0;
			if (radio2.isSelected()) {
				zero++;
			}
			if (radio4.isSelected()) {
				zero++;
			}
			if (radio9.isSelected()) {
				zero++;
			}
			if (radio10.isSelected()) {
				zero++;
			}

			message += "Your point: " + zero + "\n";
			if (zero == 0 || zero == 1 || zero == 2) {
				message += "Bad result";
			} else if (zero == 3) {
				message += "Not bad result";
			} else {
				message += "Great result";
			}

			JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
		}
	}

}