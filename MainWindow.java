import javax.swing.*;

public class MainWindow extends JFrame {

	public MainWindow() {
		add(new TableauPanel());

		setSize(600, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}