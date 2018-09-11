package CMD_Clocks;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock {



    public static void main(String[] args) {
        ClockFrame clock = new ClockFrame();
        clock.start();
    }

}


class ClockFrame{
    private JTextArea textArea;

    ClockFrame(){
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("ASCII CLOCK");

        textArea = new JTextArea(8, 50);
        textArea.setEditable(false);
        textArea.setFont(new Font("monospaced", Font.PLAIN, 24));

        JPanel panel = new JPanel();
        panel.add(textArea);
        mainFrame.getContentPane().add(panel);


        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.pack();

    }

    public void start(){


        String time = (new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));



        while (true) {

            String theTime = (new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));
            String text ="";
            if(!theTime.equals(time)){
                char[] sign = theTime.toCharArray();
                for (int line = 0; line < 7; line ++) {
                    for (int i = 0; i < 8; i++) {
                        String s = String.valueOf(sign[i]);
                        if (s.equals(":")) {
                            System.out.print(view[line][10]);
                            text += view[line][10];
                        } else {
                            System.out.print(view[line][Integer.parseInt(s)]);
                            text += view[line][Integer.parseInt(s)];
                        }
                    }
                    text += "\n";
                    System.out.println("");
                }
                textArea.setText(text);
                System.out.println("\n");
                System.out.println(text +"\n"+"\n");
                /*try{
                    Thread.sleep(500);
                }catch (Exception ex){ex.printStackTrace();}
                */
            }else{
                try{
                    Thread.sleep(500);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            time = theTime;
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