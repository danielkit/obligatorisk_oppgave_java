import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TableauPanel extends JPanel {

	public ControlPanel cp = new ControlPanel(this);
	public DiagramPanel dp = new DiagramPanel(null, null, null);

	public TableauPanel() {
		setLayout(new BorderLayout());
		add(cp, "North");
		add(dp);
		add(new Exit(), "South");
	}

	public void nyeTall (DataProducer d) {
		remove(dp);
		add(dp = new DiagramPanel(d.getNumbers(), d.getLabels(), "Oversikt over alle tallene du skrev inn:"));
		updateUI();
	}

	class Exit extends JButton implements ActionListener {

		public Exit() {
			setText("Lukk");
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	}

}