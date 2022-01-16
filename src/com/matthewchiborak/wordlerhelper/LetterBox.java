package com.matthewchiborak.wordlerhelper;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class LetterBox extends JTextField {

	LetterBox() {
		super();
		
		this.limit = 1;
		
		setSize(50, 50);
		setHorizontalAlignment(JTextField.CENTER);
	}
	
	private int limit;
	
	public char getLetter() {
		return (this.getText().length() > 0 ? this.getText().charAt(0) : ' ');
	}
	
    @Override
    protected Document createDefaultModel() {
        return new LimitDocument();
    }

    private class LimitDocument extends PlainDocument {

        @Override
        public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
            if (str == null) return;

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }       

    }
}
