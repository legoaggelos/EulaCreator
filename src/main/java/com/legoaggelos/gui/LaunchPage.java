package com.legoaggelos.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LaunchPage implements ActionListener {

    JFrame frame = new JFrame();
    List<JLabel> labels;
    JButton myButton = new JButton("OK");

    public LaunchPage(List<String> labelTexts) {
        labels = new ArrayList<>();
        for (int i = 0; i < labelTexts.size(); i++) {
            labels.add(i,new JLabel());
        }
        try{labels.forEach(v->{
            v.setText(labelTexts.get(labels.indexOf(v)));
            v.setBounds(0, 25 * labels.indexOf(v), 400, 100);
            v.setFont(new Font(null, Font.PLAIN, 25));
            frame.add(v);
        });}
        catch(IndexOutOfBoundsException ignored){
        }

        myButton.setBounds(100, 160, 200, 40);
        myButton.setFocusable(false);
        myButton.addActionListener(this);

        frame.add(myButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==myButton) {
            frame.dispose();
        }
    }
}