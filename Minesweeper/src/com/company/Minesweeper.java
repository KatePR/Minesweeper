package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Minesweeper implements ActionListener{

    JFrame frame = new JFrame("Minesweeper");
    JButton reset = new JButton("Reset");
    JButton[][] buttons = new JButton[20][20];
    int[][] counts = new int[20][20];
    Container grid = new Container();
    final int mine = 10;

    //make constructor!
    public Minesweeper(){
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.add(reset, BorderLayout.NORTH); //adds reset button to top of the border.
        reset.addActionListener(this);

        //Button grid
        grid.setLayout(new GridLayout(20, 20));
        for(int a = 0; a < buttons.length; a++ ){
            for (int b = 0; b < buttons[0].length; b++ ){
                buttons[a][b] = new JButton();
                buttons[a][b].addActionListener(this);
                grid.add(buttons[a][b]);
            }
        }
        frame.add(grid, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void main(String args[]){
        new Minesweeper();

    }

    public void generateMines(){
        ArrayList<Integer> list = new ArrayList<Integer>(); //import: alt+ENTER
        for(int x = 0; x < counts.length; x++ ){
            for(int y = 0; y < counts[0].length; y++ ){
                list.add(x*100+y);
            }
        }
        counts = new int[20][20];
        for(int a = 0; a < 30; a++){
            int choice = (int)(Math.random() * list.size());
            counts[list.get(choice)/100][list.get(choice)%100] = mine;
            list.remove(choice);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
