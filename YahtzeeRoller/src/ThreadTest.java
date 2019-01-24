import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/** ThreadTest class
 * Creates JFrame to display Yahtzee game and adds labels/roll button to the display
 */
public class ThreadTest extends JFrame implements ActionListener {
  private JButton Roll;
  private YahtzeeGUI[] cs;
  public ThreadTest() {
    setSize(400,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    Roll = new JButton("Roll");
    Roll.addActionListener(this);
    this.add(Roll);

    cs = new YahtzeeGUI[5];
    for (int i = 0; i < cs.length; i++) {
      JLabel l = new JLabel();
      cs[i] = new YahtzeeGUI(l);
      this.add(l);
    }
    this.setVisible(true);
  }

  /** ActionPerformed
   * @param e Action event listener. If an action is committed (e) and it is the Roll button, the thread starts
   */
  public void actionPerformed(ActionEvent e) {
      if (e.getSource() == Roll) {
        for (int i = 0; i < cs.length; i++) {
          Thread t = new Thread(cs[i]);
          t.start();
          try {
            Thread.sleep(100);
          }
          catch (InterruptedException ex) {;}
        }
      }
  }

  /**
   * Creates test case
   */
  public static void main(String[] args) {
    ThreadTest t = new ThreadTest();
  }
}
