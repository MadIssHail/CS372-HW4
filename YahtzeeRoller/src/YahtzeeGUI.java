import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Random;

/** YahtzeeGUI, all the components necessary to create a user interface to roll 5 dice, just like the game Yahtzee
 * @author Madi Binyon
 * @version 1.0.0
 * Above constructor: All URLS, Images, and ImageIcons necessary to display 6 different dice images
 */
public class YahtzeeGUI implements Runnable{
  private JLabel _label;
  private URL Dice1;
  Image Dice1img;
  ImageIcon Dice1icon;

  private URL Dice2;
  Image Dice2img;
  ImageIcon Dice2icon;

  private URL Dice3;
  Image Dice3img;
  ImageIcon Dice3icon;

  private URL Dice4;
  Image Dice4img;
  ImageIcon Dice4icon;

  private URL Dice5;
  Image Dice5img;
  ImageIcon Dice5icon;

  private URL Dice6;
  Image Dice6img;
  ImageIcon Dice6icon;

  /** YahtzeeGUI Constructor
   *  Takes the URLs from the 6 dice face images and puts them into ImageIcons
   * @param label JLabel created for each thread the user wants to create
   */
  public YahtzeeGUI(JLabel label) {
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dice1 = getClass().getResource("/resources/die_face_1_T.png");
    Dice1img = tk.getImage(Dice1);
    Dice1img = Dice1img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
    Dice1icon = new ImageIcon(Dice1img);

    Dice2 = getClass().getResource("/resources/die_face_2_T.png");
    Dice2img = tk.getImage(Dice2);
    Dice2img = Dice2img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
    Dice2icon = new ImageIcon(Dice2img);

    Dice3 = getClass().getResource("/resources/die_face_3_T.png");
    Dice3img = tk.getImage(Dice3);
    Dice3img = Dice3img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
    Dice3icon = new ImageIcon(Dice3img);

    Dice4 = getClass().getResource("/resources/die_face_4_T.png");
    Dice4img = tk.getImage(Dice4);
    Dice4img = Dice4img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
    Dice4icon = new ImageIcon(Dice4img);

    Dice5 = getClass().getResource("/resources/die_face_5_T.png");
    Dice5img = tk.getImage(Dice5);
    Dice5img = Dice5img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
    Dice5icon = new ImageIcon(Dice5img);

    Dice6 = getClass().getResource("/resources/die_face_6_T.png");
    Dice6img = tk.getImage(Dice6);
    Dice6img = Dice6img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
    Dice6icon = new ImageIcon(Dice6img);
    _label = label;
    _label.setIcon(Dice5icon);
  }

  /** Run function for threads
   * Creates a random number from 1-6 and stores that value into an int.
   * ImageDisplay is called to change the image on the current label based on the random number
   */
  public void run() {
    for (int i = 50; i >= 0; i--) {
      Random rand1 = new Random();
      int int1 = (rand1.nextInt() % 6) + 1;
      ImageDisplay(int1, _label);
      try {
        Thread.sleep(100);
      }
      catch (InterruptedException ex) {;}
    }
  }

  /** ImageDisplay function
   * Based on the random number from the run function, a die is chosen to change the images
   * from the threads over and over again, making it look like the dice are rolling
   * @param rand Random number from run function stored into an int
   * @param _label Current label being changed in each thread
   */
  public void ImageDisplay(int rand, JLabel _label) {
    if (rand == 1)
      _label.setIcon(Dice1icon);
    else if (rand == 2)
      _label.setIcon(Dice2icon);
    else if (rand == 3)
      _label.setIcon(Dice3icon);
    else if (rand == 4)
      _label.setIcon(Dice4icon);
    else if (rand == 5)
      _label.setIcon(Dice5icon);
    else if (rand == 6)
      _label.setIcon(Dice6icon);
  }
}


