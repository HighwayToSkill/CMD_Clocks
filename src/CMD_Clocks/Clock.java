package CMD_Clocks;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock {



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //frame.setVisible(true);
                frame.setVisible(true);
            }
        });
    }

}

class MainFrame extends JFrame{
    MainFrame(){
        setTitle("ASCII Clock");


        //ClockPanel clock = new ClockPanel();
        add(new ClockPanel());
        //pack();

        setSize(300,300);
    }
}

class ClockPanel extends JPanel{
    //private Calendar cal;
    private JTextArea textArea;
    //private JPanel panel;

    ClockPanel(){

        textArea = new JTextArea(8, 50);
        textArea.setText("hey" + " \n" + "you" + "\n" + "why" + "\n" + "the"+ "\n"+ "fuck" + "\n" + "you" + "\n" + "invisible");
        //textArea.setEditable(false);
        JPanel panel = new JPanel();
        //cal = Calendar.getInstance();
        //panel.add(textArea);

        //add(panel);
        add(textArea);
        start();

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