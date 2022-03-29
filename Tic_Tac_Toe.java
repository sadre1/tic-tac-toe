package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class mytakto implements ActionListener {

   Random r = new Random();
   JFrame jr=new JFrame();
   JPanel tital_penal=new JPanel();
   JPanel button_panel=new JPanel();
   JLabel lb=new JLabel();
   JButton []br=new JButton[9];

   boolean player1turn=true;
    mytakto()
    {
        jr.setSize(800,800);
        jr.setVisible(true);
        jr.setLocationRelativeTo(null);
        jr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jr.getContentPane().setBackground(new Color(50,50,50));
        jr.setLayout(new BorderLayout());
        lb.setBackground(new Color(246,61,252));
        lb.setForeground(new Color(0,0,0 ));
        lb.setFont(new Font("Ink Free",Font.BOLD,75));
        lb.setHorizontalAlignment(JLabel.CENTER);
        lb.setText("Tik tac toe");
        lb.setOpaque(true);
        tital_penal.setLayout(new BorderLayout());
        tital_penal.setBounds(0,0,800,100);
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(91,214,245));
        jr.add(button_panel);

        for(int i=0;i<9;i++)
        {
            br[i]=new JButton();
            button_panel.add(br[i]);
            br[i].setFont(new Font("MV Boli",Font.BOLD,120));
            br[i].setFocusable(false);
            br[i].addActionListener(this);
        }

        tital_penal.add(lb);
        jr.add(tital_penal,BorderLayout.NORTH);
        firstTurn();
    }

    public void firstTurn(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(r.nextInt(2)==0) {
            player1turn = true;
            lb.setText("Rafia Turns");
        }
        else
        {
            player1turn = false;
            lb.setText("Sadrealam Turns");

        }

    }

    public void check(){

        if((br[0].getText()=="X")&&(br[1].getText()=="X")&&(br[2].getText()=="X"))
        {
            xwins(0,1,2);
        }
        if((br[3].getText()=="X")&&(br[4].getText()=="X")&&(br[5].getText()=="X"))
        {
            xwins(3,4,5);
        }
        if((br[6].getText()=="X")&&(br[7].getText()=="X")&&(br[8].getText()=="X"))
        {
            xwins(6,7,8);
        }
        if((br[0].getText()=="X")&&(br[3].getText()=="X")&&(br[6].getText()=="X"))
        {
            xwins(0,3,6);
        }
        if((br[2].getText()=="X")&&(br[5].getText()=="X")&&(br[8].getText()=="X"))
        {
            xwins(2,5,8);
        }
        if((br[1].getText()=="X")&&(br[4].getText()=="X")&&(br[7].getText()=="X"))
        {
            xwins(1,4,7);
        }
        if((br[0].getText()=="X")&&(br[4].getText()=="X")&&(br[8].getText()=="X"))
        {
            xwins(0,4,8);
        }
        if((br[2].getText()=="X")&&(br[4].getText()=="X")&&(br[6].getText()=="X"))
        {
            xwins(2,4,6);
        }
// y is winning combination
        if((br[0].getText()=="O")&&(br[1].getText()=="O")&&(br[2].getText()=="O"))
        {
            xwins(0,1,2);
        }
        if((br[3].getText()=="O")&&(br[4].getText()=="O")&&(br[5].getText()=="O"))
        {
            xwins(3,4,5);
        }
        if((br[6].getText()=="O")&&(br[7].getText()=="O")&&(br[8].getText()=="O"))
        {
            xwins(6,7,8);
        }
        if((br[0].getText()=="O")&&(br[3].getText()=="O")&&(br[6].getText()=="O"))
        {
            xwins(0,3,6);
        }
        if((br[2].getText()=="O")&&(br[5].getText()=="O")&&(br[8].getText()=="O"))
        {
            xwins(2,5,8);
        }
        if((br[1].getText()=="O")&&(br[4].getText()=="O")&&(br[7].getText()=="O"))
        {
            xwins(1,4,7);
        }
        if((br[0].getText()=="O")&&(br[4].getText()=="O")&&(br[8].getText()=="O"))
        {
            xwins(0,4,8);
        }
        if((br[2].getText()=="O")&&(br[4].getText()=="O")&&(br[6].getText()=="O"))
        {
            xwins(2,4,6);
        }

    }
    public void xwins(int a,int b,int c)
    {
        br[a].setBackground(Color.green);
        br[b].setBackground(Color.green);
        br[c].setBackground(Color.green);

        for(int i=0;i<9;i++)
        {
            br[i].setEnabled(false);
        }

        lb.setText("Rafia WINS");
    }

    public void ywins(int a,int b,int c)
    {
        br[a].setBackground(Color.red);
        br[b].setBackground(Color.red);
        br[c].setBackground(Color.red);

        for(int i=0;i<9;i++)
        {
            br[i].setEnabled(false);
        }
        lb.setText("Sadrealam WINS");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<9;i++)
        {
            if(e.getSource()==br[i]){
                if(player1turn)
                {
                    if(br[i].getText()=="")
                    {
                        br[i].setForeground(new Color(255,0,0));
                        br[i].setText("X");
                        player1turn=false;
                        lb.setText("Sadrealam turns");
                        check();
                    }
                }
                else
                {
                    br[i].setForeground(new Color(0,0,255));
                    br[i].setText("O");
                    player1turn=true;
                    lb.setText("Rafia turns");
                    check();
                }
            }
        }

    }
}
public class Tik_Tak_To {

    public static void main(String ...args){
        mytakto tk=new mytakto();
    }
}
