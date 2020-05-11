import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControlPanel extends JPanel implements ActionListener {

	private TableauPanel tableaup;
	private JTextField tf = new JTextField();
	private JButton b = new JButton("Vis graf");
	
	
	public ControlPanel(TableauPanel tp) {

		tableaup = tp;
		setLayout(new GridLayout(0, 1, 5, 5));
		add(tf);
		add(b);
		b.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		tableaup.nyeTall(new DataProducer(tf));
	}
}
