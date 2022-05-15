package com.matthewchiborak.wordlerhelper;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class WordleHelperView extends JFrame implements ActionListener {

	WordleHelperView(WordFinderProcessor processor) {
		setTitle("Wordle Helper");
		setBounds(300, 90, 900, 700);
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
		
		blackListLabel = new JLabel("Black List:");
		blackListLabel.setSize(420, 10);
		blackListLabel.setLocation(420, 10);
		c.add(blackListLabel);
		
		blackBox = new ConditionTextBox();
		blackBox.setLocation(420, 25);
		c.add(blackBox);
		
		whiteListLabel = new JLabel("Yellow List (Pos then letter):");
		whiteListLabel.setSize(420, 10);
		whiteListLabel.setLocation(420, 55);
		c.add(whiteListLabel);
		
		posBlackBox = new ConditionalPositionTextBox();
		posBlackBox.setLocation(420, 70);
		c.add(posBlackBox);
		
		optionsBox = new JTextArea();
		optionsBox.setSize(800, 500);
		optionsBox.setLocation(50, 120);
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
	private ConditionTextBox blackBox;
	private ConditionalPositionTextBox posBlackBox;
	private JLabel blackListLabel;
	private JLabel whiteListLabel;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			
			posBlackBox.process();
			
			processor.setBlackLists(
					blackBox.getList(), 
					posBlackBox.getList(0),
					posBlackBox.getList(1),
					posBlackBox.getList(2),
					posBlackBox.getList(3),
					posBlackBox.getList(4));
		
			optionsBox.setText(
					processor.getResults(
						letter1.getLetter(), 
						letter2.getLetter(), 
						letter3.getLetter(), 
						letter4.getLetter(), 
						letter5.getLetter()
						)
					);
		}catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
}
