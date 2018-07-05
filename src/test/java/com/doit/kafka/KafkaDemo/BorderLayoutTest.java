package com.doit.kafka.KafkaDemo;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderLayoutTest {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setLayout(new BorderLayout(30,5));
		
		frame.add(new Button("北"), BorderLayout.NORTH);
		frame.add(new Button("南"), BorderLayout.SOUTH);
		frame.add(new Button("西"),BorderLayout.WEST);
		frame.add(new Button("东"), BorderLayout.EAST);
		frame.add(new Button("中"), BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}

}
