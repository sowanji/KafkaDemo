package com.doit.kafka.KafkaDemo;

import java.awt.Button;
import java.awt.Frame;
import java.awt.ScrollPane;
import java.awt.TextField;

public class ScrollPaneTest {

	public static void main(String[] args) {
		Frame frame = new Frame("ScrollPane");

		ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		sp.add(new TextField(20));
		sp.add(new Button("button"));
		frame.add(sp);
		frame.setBounds(20, 30, 250, 300);
		frame.setVisible(true);
	}

}
