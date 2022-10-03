//some imports that we need to add them
import java.awt.*;
import java.awt.event.*;//ActionListener
import java.util.*;//Random
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;//JFrame , JPanel , JLabel , JButton ...

public class TicTacToe implements ActionListener {
 //---------------------------------------------------
    Random random = new Random();
    JFrame frame  = new JFrame();
    JPanel titlePanel  = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textfield   = new JLabel();
    JButton[] buttons  = new JButton[9];
    boolean Player_1_Turn;        
 //---------------------------------------------------
    //constructor
    TicTacToe(){
        // start with frame 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 600);
        frame.getContentPane().setBackground(new Color (127,255,200));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        //------------------------------------------------------------
        // Here we will type the textfield
        textfield.setBackground(Color.red);
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);
        //------------------------------------------------------------
        // Here we will type the titlePanel
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);
        //------------------------------------------------------------
        // Here we will type the buttonPanel
        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));
        
            for (int i = 0; i < 9; i++) {
                buttons[i] = new JButton();
                buttonPanel.add(buttons[i]);
                buttons[i].setFont(new Font ("Mv Boli",Font.BOLD,120));
                buttons[i].setFocusable(false);
                buttons[i].addActionListener(this);
        }
        //------------------------------------------------------------
             titlePanel.add(textfield);
             frame.add(titlePanel,BorderLayout.NORTH);
             frame.add(buttonPanel);
        //------------------------------------------------------------
        firstTurn();
        //_____________________________________________________________
        //END OF CONSTRUCTOR
    }
 //___________________________  
    // @override the implemnts method in ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource()==buttons[i]){
                if (Player_1_Turn){
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(Color.red);
                        buttons[i].setText("X");
                        Player_1_Turn = false;
                        textfield.setText("O turn");
                        check();
                    }
                    
                }
                else{
                   if(buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(Color.blue);
                        buttons[i].setText("O");
                        Player_1_Turn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }
    }
 //___________________________ 
    // method to know who is statrt first (method to choose one first randomly )    
    public void firstTurn(){
        try {
            Thread.sleep(0500);
        } catch (InterruptedException ex) {
            Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
        }
    // random 2 numbers  0 or 1
    if ( random.nextInt(2)==0){Player_1_Turn=true; textfield.setText("X turn");}
    else {Player_1_Turn=false; textfield.setText("O turn");}
    }
 //___________________________ 
    // Method to check who is win the game 
    public void check(){
        // X wins 
        if ((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&(buttons[2].getText()=="X")){xWins(0,1,2);}
        else if ((buttons[3].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[5].getText()=="X")){xWins(3,4,5);}
        else if ((buttons[6].getText()=="X")&&(buttons[7].getText()=="X")&&(buttons[8].getText()=="X")){xWins(6,7,8);}
        else if ((buttons[0].getText()=="X")&&(buttons[3].getText()=="X")&&(buttons[6].getText()=="X")){xWins(0,3,6);}
        else if ((buttons[1].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[7].getText()=="X")){xWins(1,4,7);}
        else if ((buttons[2].getText()=="X")&&(buttons[5].getText()=="X")&&(buttons[8].getText()=="X")){xWins(2,5,8);}
        else if ((buttons[0].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[8].getText()=="X")){xWins(0,4,8);}
        else if ((buttons[2].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[6].getText()=="X")){xWins(2,4,6);}
        // O wins
        else if ((buttons[0].getText()=="O")&&(buttons[1].getText()=="O")&&(buttons[2].getText()=="O")){oWins(0,1,2);}
        else if ((buttons[3].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[5].getText()=="O")){oWins(3,4,5);}
        else if ((buttons[6].getText()=="O")&&(buttons[7].getText()=="O")&&(buttons[8].getText()=="O")){oWins(6,7,8);}
        else if ((buttons[0].getText()=="O")&&(buttons[3].getText()=="O")&&(buttons[6].getText()=="O")){oWins(0,3,6);}
        else if ((buttons[1].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[7].getText()=="O")){oWins(1,4,7);}
        else if ((buttons[2].getText()=="O")&&(buttons[5].getText()=="O")&&(buttons[8].getText()=="O")){oWins(2,5,8);}
        else if ((buttons[0].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[8].getText()=="O")){oWins(0,4,8);}
        else if ((buttons[2].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[6].getText()=="O")){oWins(2,4,6);}
    }
 //___________________________ 
    // Two methods to receive three int  and  check if anyone wins
    //1-
    public void xWins(int a,int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        for (int i = 0; i < 9; i++) {
             buttons[i].setEnabled(false);   }
        textfield.setText("X Wins");
    }
    //2-
    public void oWins(int a,int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        for (int i = 0; i < 9; i++) {
             buttons[i].setEnabled(false);   }
        textfield.setText("O Wins");
    }
    
}
