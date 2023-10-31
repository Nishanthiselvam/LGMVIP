package Task_1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Currency_Main {
    public static void main(String[] args) {
        try{
            Currency_converter curr_conv = new Currency_converter();

            curr_conv.setTitle("Currency Converter"); 
            curr_conv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            curr_conv.setSize(500, 350);
            curr_conv.setLocationRelativeTo(null);
            curr_conv.setVisible(true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
