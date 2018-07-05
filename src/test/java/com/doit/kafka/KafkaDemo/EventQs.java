package com.doit.kafka.KafkaDemo;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventQs {
	
	private Frame frame = new Frame("Event");
	private Button button = new Button("OK");
	private TextField textField = new TextField(30);
	
	public void init() {
		button.addActionListener(new OkListener());
		frame.add(textField);
		frame.add(button,BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
	
	class OkListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("click");
			textField.setText("Hello world");
		}
		
	}

	public static void main(String[] args) {
		
		new EventQs().init();
	}

}
