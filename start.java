/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudukoswing;

import javax.swing.JFrame;

/**
 *
 * @author raj
 */
public class start {
    public start() {
        JFrame frame = new sudokuFrame(9);
    }
    public static void main(String[] args) {
        new start();
        
    }
    
}
