/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Hamid Osooli
 */
public class cardgame {
    public static void main(String[] args) throws IOException, UnsupportedLookAndFeelException
    {
         try {
            // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }
        final JFrame game = new JFrame("Welcome");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setIconImage(getPic("game.png"));
        game.setSize(250, 250);
        Tools.setFormLocation(game);
        
        JLabel text = new JLabel("Please enter the number of cards");
        final JTextField tfnum = new JTextField();
        tfnum.setColumns(20);
        tfnum.setToolTipText("Maximum is 120");
        JButton start = new JButton(new ImageIcon(getPic("card.png")));
        
        JPanel northPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel southPanel = new JPanel();
        game.add(northPanel,BorderLayout.PAGE_START);
        game.add(centerPanel,BorderLayout.CENTER);
        game.add(southPanel,BorderLayout.PAGE_END);
        northPanel.add(text);
        centerPanel.add(tfnum);
        southPanel.add(start);
        game.setVisible(true);
        
        final JFrame board = new JFrame("card & dice");
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setIconImage(getPic("game.png"));
        GraphicsEnvironment env =
        GraphicsEnvironment.getLocalGraphicsEnvironment();
        board.setMaximizedBounds(env.getMaximumWindowBounds());
        board.setExtendedState(board.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        
        final JPanel northPanel2 = new JPanel();
        final JPanel southPanel2 = new JPanel();
        board.add(southPanel2,BorderLayout.PAGE_END);
        final JLabel cards[] = new JLabel[120];
        final JButton dice = new JButton(new ImageIcon(getPic("dice.png")));
        final int mul[] = new int[6];
        for(int i=0;i<6;i++)
            mul[i] = 1;
        final int encard[] = new int[120];
        for(int j =0;j<120;j++)
            encard[j]=-1;
        final int counter[]=new int[1];
        counter[0]=0;
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        int numcard = Integer.parseInt(tfnum.getText());
                        if(numcard>120)
                            tfnum.setText("Your number is greater than 120");
                        else{
                         for(int j=0;j<numcard;j++)
                            encard[j] = 1;
                        for(int i=0;i<numcard;i++)
                            {
                    try {
                        cards[i] = new JLabel(new ImageIcon(getPic("cards.png")));
                    } catch (IOException ex) {
                        Logger.getLogger(cardgame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                cards[i].setText(Integer.toString(1+i));
                                board.add(northPanel2,FlowLayout.LEFT);
                                northPanel2.add(cards[i]);
                            }
                        southPanel2.add(dice);
                        game.setVisible(false);
                        board.setVisible(true);
                throw new UnsupportedOperationException("Not supported yet.");   
                        }
            }
        });
        
        dice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int face = dice();
                switch(face)
                {
                    case 1:try {
                    dice.setIcon(new ImageIcon(getPic("1.png")));
                } catch (IOException ex) {
                    Logger.getLogger(cardgame.class.getName()).log(Level.SEVERE, null, ex);
                }
                        break;
                    case 2:try {
                    dice.setIcon(new ImageIcon(getPic("2.png")));
                } catch (IOException ex) {
                    Logger.getLogger(cardgame.class.getName()).log(Level.SEVERE, null, ex);
                }
                        break;
                    case 3:try {
                    dice.setIcon(new ImageIcon(getPic("3.png")));
                } catch (IOException ex) {
                    Logger.getLogger(cardgame.class.getName()).log(Level.SEVERE, null, ex);
                }
                        break;
                    case 4:try {
                    dice.setIcon(new ImageIcon(getPic("4.png")));
                } catch (IOException ex) {
                    Logger.getLogger(cardgame.class.getName()).log(Level.SEVERE, null, ex);
                }
                        break;
                    case 5:try {
                    dice.setIcon(new ImageIcon(getPic("5.png")));
                } catch (IOException ex) {
                    Logger.getLogger(cardgame.class.getName()).log(Level.SEVERE, null, ex);
                }
                        break;
                    case 6:try {
                    dice.setIcon(new ImageIcon(getPic("6.png")));
                } catch (IOException ex) {
                    Logger.getLogger(cardgame.class.getName()).log(Level.SEVERE, null, ex);
                }
                        break;
                }
               int number = mul[face-1]*face;
               while(encard[number-1]==0)
               {
                   mul[face-1]++;
                   number = mul[face-1]*face;
               }
               if(encard[number-1]==1)
               {
                   cards[number-1].setEnabled(false);
                   encard[number-1]=0;
                   counter[0]++;
               }
               if(counter[0]==Integer.parseInt(tfnum.getText()))
               {
                  final JFrame message = new JFrame("Finish");
                  message.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  message.setSize(400, 200);
                  Tools.setFormLocation(message);
                    try {
                        message.setIconImage(getPic("game.png"));
                    } catch (IOException ex) {
                        Logger.getLogger(cardgame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    JPanel northPanel3 = new JPanel();
                    JPanel southPanel3 = new JPanel();
                    message.add(northPanel3,BorderLayout.PAGE_START);
                    message.add(southPanel3,BorderLayout.PAGE_END);
                    
                    JLabel label = new JLabel("Your game finished!");
                    try {
                        JLabel pic = new JLabel(new ImageIcon(getPic("game.png")));
                        northPanel3.add(pic);
                    } catch (IOException ex) {
                        Logger.getLogger(cardgame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    JButton retry = new JButton("RETRY");
                    JButton done = new JButton("DONE");
                    JButton cancel = new JButton("CANCEL");
                    
                    northPanel3.add(label);
                    southPanel3.add(retry);
                    southPanel3.add(done);
                    southPanel3.add(cancel);
                    message.setVisible(true);
                    
                    retry.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            message.setVisible(false);
                            board.setVisible(false);
                            game.setVisible(true);
                            throw new UnsupportedOperationException("Not supported yet.");
                        }
                    });
                    
                    done.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            message.setVisible(false);
                            board.setVisible(false);
                            throw new UnsupportedOperationException("Not supported yet.");
                        }
                    });
                    
                    cancel.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            message.setVisible(false);
                            throw new UnsupportedOperationException("Not supported yet.");
                        }
                    });
               }
            }
        });
}
        public static Image getPic(String s) throws IOException
    {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(s);
        return ImageIO.read(input); 
    }
    public static int dice()
    {
        Random rand=new Random();
        return 1+rand.nextInt(6);
    }
    }
    
    
    
    


