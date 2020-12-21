/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudukoswing;

import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author raj
 */
public class textlimit extends PlainDocument {
    private int mx;

    public textlimit(int limit) {
        super();
        mx=limit;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if(str==null)
        {
            return;
        }
        if((this.getLength()+str.length())<=mx)
        {
            try{
                Integer.parseInt(str);
                super.insertString(offs, str, a);  // Only entered into the textfield if the string is an integer
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Invalid Input. Enter a number (0-9, with 0 for empty)", "Error",
                        JOptionPane.ERROR_MESSAGE);
  
            }

        }
    }
    
    
    
}
