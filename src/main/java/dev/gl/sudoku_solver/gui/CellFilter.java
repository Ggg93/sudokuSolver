package dev.gl.sudoku_solver.gui;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author gl
 */
public class CellFilter extends DocumentFilter {

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        Document doc = fb.getDocument();
        String oldText = doc.getText(0, doc.getLength());
        
        if (!text.matches("\\d+")) {
            return;
        }
        
        if (oldText.length() == 1) {
            offset = 0;
            length = 1;
        }
        super.replace(fb, offset, length, text, attrs); 
    }

}
