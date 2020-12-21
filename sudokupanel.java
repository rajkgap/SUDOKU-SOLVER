/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudukoswing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author raj
 */
public class sudokupanel extends JPanel implements ActionListener  {
    private JButton solvebutton,clearbutton;
    private JTextField[][] sudokufields;
    private JTextField notificationfield;
    private solvesudoku solver;
    private int gridsize;
    
    
    public sudokupanel(int size) 
    {
        gridsize=size;
        sudokufields=new JTextField[gridsize][gridsize];
        for(int i=0;i<gridsize;i++)
        {
            for(int j=0;j<gridsize;j++)
            {
                sudokufields[i][j]=new JTextField(2);
                sudokufields[i][j].setDocument(new textlimit(1));
                sudokufields[i][j].setHorizontalAlignment(JTextField.CENTER);
                sudokufields[i][j].setFont(new Font("SansSerif", Font.ITALIC, 20));
                this.add(sudokufields[i][j]);
            }
        }
        notificationfield =new JTextField(25);
        notificationfield.setEditable(false);
        notificationfield.setHorizontalAlignment(JTextField.CENTER);
        notificationfield.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(notificationfield);
        solvebutton=new JButton("Solve");
        solvebutton.addActionListener(this);
        this.add(solvebutton);
        clearbutton=new JButton("Clear");
        clearbutton.addActionListener(this);
        this.add(clearbutton);
        
        solver=new solvesudoku(gridsize);   ///calling the solve function;;
        
    }
    
    

    
    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.draw(new Line2D.Double(0,122,500,122));///horizontal lines in grid;
        g2.draw(new Line2D.Double(0,242,500,242));
        g2.draw(new Line2D.Double(170,0,170,354));    // Vertical lines in grid
        g2.draw(new Line2D.Double(329,0,329,354));
    }
    
    private void evaluate(int[][] board)
    {
        if(!solver.validateboard(board))
        {
            notificationfield.setText("INVALID BOARD");
            notificationfield.setBackground(Color.red);
        }
        else
        {
            if(!solver.backtrack(board))
            {
                notificationfield.setText("NO POSSIBLE SOLUTION");
                notificationfield.setBackground(Color.red);
            }
            else
            {
                notificationfield.setText("SOLVED!!");
                notificationfield.setBackground(Color.green);
                //showing the solution...
                for(int i=0;i<gridsize;i++)
                {
                    for(int j=0;j<gridsize;j++)
                    {
                        sudokufields[i][j].setText(Integer.toString(board[i][j]));
                    }
                }
            }
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        if(source==solvebutton)
        {
            notificationfield.setText(null);
            int[][] temgrid=new int[gridsize][gridsize];
            for(int i=0;i<gridsize;i++)
            {
                for(int j=0;j<gridsize;j++)
                {
                    if(sudokufields[i][j].getText().compareTo("")!=0)
                    {
                        try{
                            temgrid[i][j]=Integer.parseInt(sudokufields[i][j].getText());
                        }
                        catch(NumberFormatException ed)
                        {
                            temgrid[i][j]=0;
                        }
                    }
                    else
                    {
                        temgrid[i][j]=0;
                    }
                }
            }
            evaluate(temgrid);

        }
        else
        {
            notificationfield.setText(null);
            if(source==clearbutton)
            {
                for(int i=0;i<gridsize;i++)
                {
                    for(int j=0;j<gridsize;j++)
                    {
                        sudokufields[i][j].setText(null);
                    }
                }
                notificationfield.setText(null);
                notificationfield.setBackground(Color.white);
                
                
            }

        }
        
    }
    
    
}
