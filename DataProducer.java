import javax.swing.JTextField;

public class DataProducer {

	private String[] labels; 
	private double[] numbers; 

	public DataProducer(JTextField numberpanel) {
		labels = numberpanel.getText().trim().split(" ");
		numbers = new double[labels.length];
		int n = 0;
		String d = "";
		for (String s:labels) {			
			try {
				if ((d = s.trim()).isEmpty()) continue;
				numbers[n++] = Double.parseDouble(d.trim());
			} catch (NumberFormatException e) {
				System.out.println("FEIL:" + d + " " + e);			
			}
		}			
	}

	public String[] getLabels() {
		return labels;
	}

	public double[] getNumbers() {
		return numbers;
	}

}
