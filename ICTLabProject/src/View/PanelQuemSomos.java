package View;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelQuemSomos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2627455081204803462L;
	private JLabel lblOl;
	private JLabel lblNewLabel;
	private JLabel lblOpa;
	private JLabel lblTeste;

	/**
	 * Create the panel.
	 */
	public PanelQuemSomos() {

		initialize();
	}
	private void initialize() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblOl());
		add(getLblOpa());
		add(getLblTeste());
	}

	private JLabel getLblOl() {
		if (lblOl == null) {
			lblOl = new JLabel("OL\u00E1");
			lblOl.setBounds(241, 5, 19, 14);
		}
		return lblOl;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Mundo");
			lblNewLabel.setBounds(224, 254, 46, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblOpa() {
		if (lblOpa == null) {
			lblOpa = new JLabel("Opa");
			lblOpa.setBounds(374, 137, 46, 14);
		}
		return lblOpa;
	}
	private JLabel getLblTeste() {
		if (lblTeste == null) {
			lblTeste = new JLabel("Teste");
			lblTeste.setBounds(10, 137, 46, 14);
		}
		return lblTeste;
	}
}
