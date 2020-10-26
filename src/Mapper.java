/**
 * author: Carl Ostrenga <ceo8099@rit.edu>
 * prg: Mapper
 * desc: Program to create the window and canvas in Swing
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mapper {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JButton draw = new JButton("Draw");
        JTextField tf = new JTextField("#####");

        tf.setBounds(50,50,150,20);
        draw.setBounds(130,400,100,40);
        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tf.setText("Works");
            }
        });
        frame.add(draw);
        frame.add(tf);
        frame.setSize(400,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}