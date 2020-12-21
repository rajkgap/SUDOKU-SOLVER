/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudukoswing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author raj
 */
public class sudokumenu extends JMenuBar implements ActionListener 
{
    private JMenu help;
    private JMenuItem guide,about;
    private JFrame masterframe;
    public sudokumenu(JFrame aframe)
    {
        super();
        help=new JMenu("Help");
        guide=new JMenuItem("Guide");
        about=new JMenuItem("About");
        guide.addActionListener(this);
        about.addActionListener(this);
        help.add(guide);
        help.add(about);
        this.add(help);
        
        
        masterframe=aframe;  //The JFrame that will be containing this was passed in as an argument
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object click=e.getSource();
        
        if(click==guide)
        {
            // JOptionPane is a simple popup box..
            JOptionPane.showMessageDialog(masterframe, "Fill in any of the textfields, representing the Sudoku board, with 1-9.\n" +
                            "0 and empty spaces will represent the empty spaces on the board.\n\n" +
                            "Press the Solve button to get the solution, Clear to clear the board.",
                    "Guide", JOptionPane.PLAIN_MESSAGE);
            
        }
        else
        {
            if(click==about)
            {
                // Used HTML injection to center this message
                    JOptionPane.showMessageDialog(masterframe,
                    "<html><body><div width='200px' align='center'>Author: RAJ GAUR<br/>" +
                            "Created: 2020</div></body></html>", 
                    "About",
                    JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    
    
}
