import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LineEntry implements ActionListener {
    JLabel lines, curves;
    JTextField lEntry, cEntry;
    JTextArea area;
    JButton draw;
    private LineCreator lineCreator;

    LineEntry(){
        JFrame f = new JFrame();
        lines = new JLabel("Lines:");
        lines.setBounds(50,25,75, 30);
        lEntry = new JTextField();
        lEntry.setBounds(100, 25,75,30);
        curves = new JLabel("Curves:");
        curves.setBounds(200,25,75, 30);
        cEntry = new JTextField();
        cEntry.setBounds(250, 25,75,30);
        area = new JTextArea();
        area.setBounds(20,75,250,200);
        lineCreator = new LineCreator(500, 500);
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
        int l = Integer.parseInt(lEntry.getText());
        int c = Integer.parseInt(cEntry.getText());
        ArrayList<int[][]> lst = lineCreator.createLines(l,c);
        String res = "";
        for(int[][] arr: lst){
            for(int i = 0; i < arr.length; i++){
                res +="(" + arr[i][0] + "," + arr[i][1] + "---" + arr[i][2] + "," + arr[i][3] + ") ";
            }
            res += "\n";
        }
        area.setText(res);
        LineDraw ld = new LineDraw(lst);
        JFrame f=new JFrame();
        f.add(ld);
        f.setSize(600,600);
        f.setVisible(true);


    }
}
