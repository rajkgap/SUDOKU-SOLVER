/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudukoswing;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author raj
 */
public class sudokuFrame extends JFrame {
    
    sudokuFrame(int size)
    {
        this.setTitle("SUDOKU");
        this.setSize(500, 500);
        this.setLocation(0,0);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e); //To change body of generated methods, choose Tools | Templates.
            }
        });
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        Container contentPane=getContentPane();//we get the layer and then we can add aur object into that layer;
        sudokumenu m;
        m = new sudokumenu(this);
        this.setJMenuBar(m);
        sudokupanel sk=new sudokupanel(size);
        contentPane.add(sk);
        ////
        this.setVisible(true);
    }  
}
