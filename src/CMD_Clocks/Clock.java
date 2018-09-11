package CMD_Clocks;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Clock {



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
            }
        });
    }

}

class Time{
    private String time;
    private PropertyChangeSupport support= new PropertyChangeSupport(this);

    public void addListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public void removeListenere(PropertyChangeListener listener){
        support.removePropertyChangeListener(listener);
    }

    public void setVariable(String time){

    }
}

class MainFrame extends JFrame{
    Calendar cal;
    Date date;
    private String time;
    JTextArea textArea;


    MainFrame(){
        textArea = new JTextArea(8, 50);
        textArea.setEditable(false);
        cal = Calendar.getInstance();
        start();

    }

    public void start(){
        JPanel panel = new JPanel();
        panel.add(textArea);
        getContentPane().add(BorderLayout.CENTER,panel);




        while (true) {

            String theTime = (new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));

            char[] sign = time.toCharArray();
            for (int line = 0; line < 7; line ++) {
                for (int i = 0; i < 8; i++) {
                    String s = String.valueOf(sign[i]);
                    if (s.equals(":")) {
                        System.out.print(view[line][10]);
                    } else {
                        System.out.print(view[line][Integer.parseInt(s)]);
                    }
                }
                System.out.println("");
            }
            System.out.println("\n");
            try{
                Thread.sleep(950);
            }catch (Exception ex){ex.printStackTrace();}

        }
    }



    private static final String[][] view = {

            {"  ***  ", "   *   ", "  ***  ", "  ***  ", "    *  ", " ***** ", "  ***  ", " ***** ", "  ***  ", "  ***  ", "    "},
            {" *   * ", "  **   ", " *   * ", " *   * ", "   **  ", " *     ", " *   * ", "     * ", " *   * ", " *   * ", " ** "},
            {"*     *", " * *   ", " *   * ", "     * ", "  * *  ", " *     ", " *     ", "    *  ", " *   * ", " *   * ", " ** "},
            {"*     *", "   *   ", "    *  ", "  ***  ", " *  *  ", " ****  ", " ****  ", "   *   ", "  ***  ", "  **** ", "    "},
            {"*     *", "   *   ", "   *   ", "     * ", " ***** ", "     * ", " *   * ", "  *    ", " *   * ", "     * ", " ** "},
            {" *   * ", "   *   ", "  *    ", " *   * ", "    *  ", " *   * ", " *   * ", "  *    ", " *   * ", "     * ", " ** "},
            {"  ***  ", " ***** ", " ***** ", "  ***  ", "    *  ", "  ***  ", "  ***  ", "  *    ", "  ***  ", "  ***  ", "    "}};
}