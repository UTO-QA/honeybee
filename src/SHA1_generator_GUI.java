import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SHA1_generator_GUI extends JFrame {
	public SHA1_generator_GUI() {
		setVisible(true);
		setResizable(false);
		setSize(460, 250);
		setTitle("SHA1 Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(224, 39, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(224, 87, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblEnterKey = new JLabel("Enter Key");
		lblEnterKey.setBounds(117, 42, 54, 14);
		getContentPane().add(lblEnterKey);

		JLabel lblNewLabel = new JLabel("# of hashes");
		lblNewLabel.setBounds(117, 90, 72, 14);
		getContentPane().add(lblNewLabel);

		JButton btnGenerateHash = new JButton("Generate Hash!");
		btnGenerateHash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String baseKey = textField.getText();
				int numberOfHashes = Integer.parseInt(textField_1.getText());
				try {
					SHA1_generator.generateCsvFile("SHA1_generated.csv",
							baseKey, numberOfHashes);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGenerateHash.setBounds(134, 153, 134, 30);
		getContentPane().add(btnGenerateHash);
	}

	private static final long serialVersionUID = 5885748269104931022L;
	private JTextField textField;
	private JTextField textField_1;
}
