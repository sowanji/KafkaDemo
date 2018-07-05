package com.doit.kafka.KafkaDemo;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

public class FrameTest {

	public static void main(String[] args) {
		Frame f = new Frame("测试窗口");
		
		Panel p = new Panel();
		p.add(new TextField(20));
		p.add(new Button("button"));
		f.add(p);
		f.setBounds(20, 30, 250, 200);
		f.setVisible(true);

	}
}
