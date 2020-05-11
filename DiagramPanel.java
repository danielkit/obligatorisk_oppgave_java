
import java.awt.*;

public class DiagramPanel extends Panel {

	public DiagramPanel(double[] v, String[] n, String t) {
		names = n;
		values = v;
		title = t;
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (values == null || values.length == 0) {
			return;
		}
		int i;
		double minVerdi = 0;
		double maksVerdi = 0;
		for (i = 0; i < values.length; i++) {
			if (minVerdi > values[i])
				minVerdi = values[i];
			if (maksVerdi < values[i])
				maksVerdi = values[i];
		}

		Dimension d = getSize();
		int klientBredde = d.width;
		int klientHoyde = d.height;
		int stolpeBredde = klientBredde / values.length;

		Font titleFont = new Font("SansSerif", Font.BOLD, 20);
		FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
		Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
		FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

		int titleWidth = titleFontMetrics.stringWidth(title);
		int y = titleFontMetrics.getAscent();
		int x = (klientBredde - titleWidth) / 2;
		g.setFont(titleFont);
		g.drawString(title, x, y);

		int toppTekst = titleFontMetrics.getHeight();
		int bunnTekst = labelFontMetrics.getHeight();
		if (maksVerdi == minVerdi) {
			return;
		}
		double skalaFaktor = (klientHoyde - toppTekst - bunnTekst) / (maksVerdi - minVerdi);
		y = klientHoyde - labelFontMetrics.getDescent();
		g.setFont(labelFont);

		for (i = 0; i < values.length; i++) {
			int x1 = i * stolpeBredde + 1;
			int y1 = toppTekst;
			int height = (int) (values[i] * skalaFaktor);
			if (values[i] >= 0)
				y1 += (int) ((maksVerdi - values[i]) * skalaFaktor);
			else {
				y1 += (int) (maksVerdi * skalaFaktor);
				height = -height;
			}
			g.setColor(Color.yellow);
			g.fillRect(x1, y1, stolpeBredde - 2, height);
			g.setColor(Color.black);
			g.drawRect(x1, y1, stolpeBredde - 2, height);
			int tekstbredde = labelFontMetrics.stringWidth(names[i]);
			x = i * stolpeBredde + (stolpeBredde - tekstbredde) / 2;
			g.drawString(names[i], x, y);
		}
	}

	private double[] values;
	private String[] names;
	private String title;

}
