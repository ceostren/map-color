import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LineEntry implements ActionListener {
    JLabel lines, curves;
    JTextField lEntry, cEntry;
    JTextArea area;
    JButton draw;

    LineEntry(){
        JFrame f = new JFrame();
        lines = new JLabel("Lines:");
        lines.setBounds(50,25,75, 30);
        lEntry = new JTextField();
        lEntry.setBounds(130, 25,75,30);
        curves = new JLabel("Curves:");
        curves.setBounds(170,25,75, 30);
        cEntry = new JTextField();
        cEntry.setBounds(200, 25,75,30);
        area = new JTextArea();
        area.setBounds(20,75,250,200);
        draw = new JButton("Print Lines");
        draw.setBounds(100,300,120,30);
        draw.addActionListener(this);
        f.add(lines);f.add(curves);f.add(lEntry);f.add(cEntry);f.add(area);f.add(draw);
        f.setSize(450,450);
        f.setLayout(null);
        f.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int l = Integer.parseInt(lines.getText());
        int c = Integer.parseInt(curves.getText());


    }
}
