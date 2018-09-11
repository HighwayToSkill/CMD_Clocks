package CMD_Clocks;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Clock{
    Calendar cal;
    Date date;


    public static void main(String[] args){
        new Clock().start();
    }

    public void start(){
        String time;
        cal = Calendar.getInstance();
        //s




        while (true) {

            time = (new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));
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