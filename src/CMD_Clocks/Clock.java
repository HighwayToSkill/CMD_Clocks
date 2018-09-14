package CMD_Clocks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock {



    public static void main(String[] args) {
        ClockFrame clock = new ClockFrame();
    }

}


class ClockFrame{
    private JTextArea textArea;
    JFrame mainFrame;
    JPanel panel;
    char newFont;
    static char oldFont = '*';
    static boolean start = false;

    //JButton buttonTwo;
    //JButton button;
    ClockFrame(){
        newFont = '*';

        mainFrame = new JFrame();
        mainFrame.setTitle("ASCII CLOCK");

        textArea = new JTextArea(8, 50);
        textArea.setEditable(false);
        //textArea.setEnabled(false);
        textArea.setFont(new Font("monospaced", Font.PLAIN, 24));

        panel = new JPanel();
        panel.add(textArea);
        mainFrame.getContentPane().add(panel);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem settingsMenu = new JMenuItem("settings");
        menu.add(settingsMenu);

        menuBar.add(menu);
        mainFrame.setJMenuBar(menuBar);
        settingsMenu.addActionListener(new MenuListener());


        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.pack();
        start();

    }

    public class MenuListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            Settings settings = new Settings();
            settings.buildGui();
        }
    }



    /*Кнопки для тестов
    public class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            //textArea.setFont(new Font("monospaced", Font.PLAIN, 48));
            //panel.removeAll();
            //panel.repaint();
            start = false;
            try{
                Thread.sleep(150);
            }catch (Exception ex){ex.printStackTrace();}
            //start('#');
            mainFrame.pack();

        }
    }
    public class ButtonTwoListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            textArea.setBackground(Color.ORANGE);
            textArea.setForeground(Color.RED);
            //Color color = new Color(Color.get)
        }
    }*/


    public void start(){
        start = true;
        String time = (new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));



        while (start) {

            String theTime = (new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));
            String text ="";
            if(!theTime.equals(time)){
                char[] sign = theTime.toCharArray();
                for (int line = 0; line < 7; line ++) {
                    for (int i = 0; i < 8; i++) {
                        String s = String.valueOf(sign[i]);
                        if (s.equals(":")) {
                            text = text.concat(view[line][10]);
                        } else {
                            text = text.concat(view[line][Integer.parseInt(s)]);

                        }
                    }
                    text =text.concat("\n");
                    System.out.println("");
                }
                System.out.println(text.replace(oldFont,newFont));

                textArea.setText(text.replace(oldFont,newFont));
                System.out.println("\n");

            }else{
                try{
                    Thread.sleep(100);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            time = theTime;
        }
        oldFont = newFont;
    }

    private static final String[][] view = {

            {"  ***  ", "   *   ", "  ***  ", "  ***  ", "    *  ", " ***** ", "  ***  ", " ***** ", "  ***  ", "  ***  ", "    "},
            {" *   * ", "  **   ", " *   * ", " *   * ", "   **  ", " *     ", " *   * ", "     * ", " *   * ", " *   * ", " ** "},
            {"*     *", " * *   ", " *   * ", "     * ", "  * *  ", " *     ", " *     ", "    *  ", " *   * ", " *   * ", " ** "},
            {"*     *", "   *   ", "    *  ", "  ***  ", " *  *  ", " ****  ", " ****  ", "   *   ", "  ***  ", "  **** ", "    "},
            {"*     *", "   *   ", "   *   ", "     * ", " ***** ", "     * ", " *   * ", "  *    ", " *   * ", "     * ", " ** "},
            {" *   * ", "   *   ", "  *    ", " *   * ", "    *  ", " *   * ", " *   * ", "  *    ", " *   * ", "     * ", " ** "},
            {"  ***  ", " ***** ", " ***** ", "  ***  ", "    *  ", "  ***  ", "  ***  ", "  *    ", "  ***  ", "  ***  ", "    "}};

    class Settings{
        JFrame frame;
        JPanel panel;
        //JTextArea charArea;
        JComboBox frontColor;
        JComboBox backColor;
        JTextArea fontSize;
        JTextArea charArea;
        Color[] colors = {Color.white, Color.black, Color.red, Color.green, Color.blue, Color.yellow, Color.MAGENTA, Color.cyan};
        String[] color = {"white","black","red","green","blue","yellow", "pink", "cyan"};


        public void buildGui(){
            frame = new JFrame();
            frame.setTitle("settings");

            panel = new JPanel();
            panel.setLayout(new GridLayout(4,2));

            JTextArea textOne = new JTextArea();
            textOne.setEditable(false);
            textOne.setText("размер шрифта:");

            JTextArea textTwo = new JTextArea();
            textTwo.setEditable(false);
            textTwo.setText("цвет фона: ");

            JTextArea textThree = new JTextArea();
            textThree.setEditable(false);
            textThree.setText("цвет шрифта");

            JTextArea textFour = new JTextArea();
            textFour.setEditable(false);
            textFour.setText("символ: ");

            frontColor = new JComboBox(color);//(colors);
            backColor = new JComboBox(color);

            charArea = new JTextArea(1,1);
            charArea.setText("*");
            fontSize = new JTextArea(1,2);
            fontSize.setText("24");

            panel.add(textOne);
            panel.add(fontSize);

            panel.add(textFour);
            panel.add(charArea);

            panel.add(textThree);
            panel.add(frontColor);

            panel.add(textTwo);
            panel.add(backColor);

            JPanel savePanel = new JPanel();

            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(new SaveButtonListener());
            savePanel.add(saveButton);

            frame.getContentPane().add(BorderLayout.CENTER, panel);
            frame.getContentPane().add(BorderLayout.SOUTH, saveButton);
            frame.setVisible(true);
            frame.pack();
        }

        class SaveButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent ev){
                setFont();
                setSymbol();
                setBackColor();
                setFrontColor();
            }
        }

        public void setFont(){
            String font = fontSize.getText();
            if(!font.isEmpty()){
                if(font.length() > 1){
                    font = font.substring(0,2);
                }

                try{
                    int fontSize = Integer.parseInt(font);
                    textArea.setFont(new Font("monospaced", Font.PLAIN, fontSize));
                }catch (Exception ex){
                    System.out.println("Неприемлемые данные");
                }
            }else{
                System.out.println("Строка размера шрифта пуста");
            }
            mainFrame.pack();
        }

        public void setSymbol(){

            if(!charArea.getText().isEmpty()){
                newFont = charArea.getText().substring(0,1).charAt(0);
            }else {
                System.out.println("Строка символа пуста");
            }
        }

        public void setBackColor(){
            Color color = getColor((String)backColor.getSelectedItem());//(Color) backColor.getSelectedItem();
            textArea.setBackground(color);

        }

        public void setFrontColor(){
            Color color = getColor((String)frontColor.getSelectedItem());//(Color) frontColor.getSelectedItem();
            textArea.setForeground(color);
        }

        public Color getColor(String color){
            Color color1 = Color.white;
            switch(color){
                case ("white"):
                    color1 = Color.white;
                    break;
                case ("black"):
                    color1 = Color.black;
                    break;
                case ("red"):
                    color1 = Color.red;
                    break;
                case ("green"):
                    color1 = Color.blue;
                    break;
                case ("blue"):
                    color1 = Color.blue;
                    break;
                case ("yellow"):
                    color1 = Color.yellow;
                    break;
                case("pink"):
                    color1 = Color.magenta;
                    break;
                case("cyan"):
                    color1 = Color.cyan;
                    break;
            }
            return color1;
        }


    }
}

