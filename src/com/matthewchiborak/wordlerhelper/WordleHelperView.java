package com.matthewchiborak.wordlerhelper;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class WordleHelperView extends JFrame implements ActionListener {

	WordleHelperView(WordFinderProcessor processor) {
		setTitle("Wordle Helper");
		setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        this.processor = processor;
        
        c = getContentPane();
        
		letter1 = new LetterBox();
		letter1.setLocation(10, 10);
		c.add(letter1);
		
		letter2 = new LetterBox();
		letter2.setLocation(70, 10);
		c.add(letter2);
		
		letter3 = new LetterBox();
		letter3.setLocation(130, 10);
		c.add(letter3);
		
		letter4 = new LetterBox();
		letter4.setLocation(190, 10);
		c.add(letter4);
		
		letter5 = new LetterBox();
		letter5.setLocation(250, 10);
		c.add(letter5);
		
		goButton = new JButton("GO");
		goButton.setSize(100, 50);
		goButton.setLocation(310, 10);
		goButton.addActionListener(this);
		c.add(goButton);
		
		whiteBox = new ConditionTextBox();
		whiteBox.setLocation(420, 15);
		c.add(whiteBox);
		
		blackBox = new ConditionTextBox();
		blackBox.setLocation(420, 50);
		c.add(blackBox);
		
		optionsBox = new JTextArea();
		optionsBox.setSize(800, 450);
		optionsBox.setLocation(50, 80);
		optionsBox.setLineWrap(true);
		c.add(optionsBox);
	}
	
	private WordFinderProcessor processor;
	private Container c;
	private LetterBox letter1;
	private LetterBox letter2;
	private LetterBox letter3;
	private LetterBox letter4;
	private LetterBox letter5;
	private JButton goButton;
	private JTextArea optionsBox;
	private ConditionTextBox whiteBox;
	private ConditionTextBox blackBox;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		optionsBox.setText(
				processor.getResults(
					letter1.getLetter(), 
					letter2.getLetter(), 
					letter3.getLetter(), 
					letter4.getLetter(), 
					letter5.getLetter(),
					whiteBox.getList(),
					blackBox.getList()
					)
				);
		}catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
}
