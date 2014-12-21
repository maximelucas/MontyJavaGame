package ex4Improved;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class View extends JFrame {

	private ActionListener listener;
	private String value = "";
	private JLabel readout = new JLabel("");


	private final KeyButton key0 = new KeyButton("0");
	private final KeyButton key1 = new KeyButton("1");
	private final KeyButton key2 = new KeyButton("2");
	private final KeyButton key3 = new KeyButton("3");
	private final KeyButton key4 = new KeyButton("4");
	private final KeyButton key5 = new KeyButton("5");
	private final KeyButton key6 = new KeyButton("6");
	private final KeyButton key7 = new KeyButton("7");
	private final KeyButton key8 = new KeyButton("8");
	private final KeyButton key9 = new KeyButton("9");
	private final KeyButton keyBack = new KeyButton("Back");
	private final KeyButton keyClear = new KeyButton("Clear");
	private final KeyButton keyVerify = new KeyButton("Verify Code");
	private final KeyButton keyChange = new KeyButton("Change Code");

	public View(String title, ActionListener al) {
		super(title);
		this.setListener(al);
		setLayout(new BorderLayout());
		add(makeDisplayPanel(), BorderLayout.NORTH);
		add(makeKeyPad(), BorderLayout.CENTER);
		add(makeControlsPad(), BorderLayout.SOUTH);
		display(" ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	public void display(String value) {
		if (value.equals("")) {
			readout.setText(" ");
		} else {
			readout.setText(value);
		}
	}

	private JPanel makeDisplayPanel(){
		JPanel displayPanel = new JPanel();
		displayPanel.add(readout);
		displayPanel.setSize(100,1000);
		return displayPanel;
	}
	
	private JPanel makeKeyPad() {
		JPanel keyPad = new JPanel();
		keyPad.setLayout(new GridLayout(4, 3));
		// Add keys in correct order
		key7.addActionListener(listener);
		keyPad.add(key7);
		key8.addActionListener(listener);
		keyPad.add(key8);
		key9.addActionListener(listener);
		keyPad.add(key9);
		key4.addActionListener(listener);
		keyPad.add(key4);
		key5.addActionListener(listener);
		keyPad.add(key5);
		key6.addActionListener(listener);
		keyPad.add(key6);
		key1.addActionListener(listener);
		keyPad.add(key1);
		key2.addActionListener(listener);
		keyPad.add(key2);
		key3.addActionListener(listener);
		keyPad.add(key3);
		key0.addActionListener(listener);
		keyPad.add(key0);
		return keyPad;
	}

	public JPanel makeControlsPad() {
		JPanel controlsPad = new JPanel();
		controlsPad.setLayout(new GridLayout(2, 2));
		// Add keys in correct order
		keyBack.addActionListener(listener);
		controlsPad.add(keyBack);
		keyVerify.addActionListener(listener);
		controlsPad.add(keyVerify);
		keyClear.addActionListener(listener);
		controlsPad.add(keyClear);
		keyChange.addActionListener(listener);
		controlsPad.add(keyChange);
		return controlsPad;
	}

	public ActionListener getListener() {
		return listener;
	}

	public void setListener(ActionListener listener) {
		this.listener = listener;
	}

	public String getValue() {
		return readout.getText();
	}

	public void setValue(String value) {
		this.value = value;
	}
}
