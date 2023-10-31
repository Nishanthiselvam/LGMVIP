package Task_1;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

class Currency_converter extends JFrame implements ActionListener {

    private JLabel amountLabel, fromLabel, toLabel, resultLabel;
    private JTextField amountTextField, resultTextField;
    private JComboBox<String> fromComboBox, toComboBox;
    private JButton jButton;
    private final String[] CURRENCIES = {"INR", "USD", "EUR", "CAD", "AUD", "JPY", "CHF", "CNY", "HKD", "KRW"};
    private final double[] EXCHANGE_RATES = {1, 84.24, 89.57, 62.45, 56.33, 0.523, 90.53, 13.52, 12.21, 0.07};

    Border blackLine = BorderFactory.createLineBorder(Color.blue);
    public Currency_converter() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 40, 40));
        panel.setBorder(blackLine);
        panel.setBackground(new Color(189,205,215));

        fromLabel = new JLabel("From:");
        toLabel = new JLabel("To:");
        amountLabel = new JLabel("Enter amount:");
        resultLabel = new JLabel("Result:");
        amountTextField = new JTextField();
        resultTextField = new JTextField();
        resultTextField.setEditable(false);
        fromComboBox = new JComboBox<>(CURRENCIES);
        toComboBox = new JComboBox<>(CURRENCIES);
        jButton = new JButton("Convert Currency");
        jButton.addActionListener(this);

        panel.add(amountLabel,BorderLayout.CENTER);
        panel.add(amountTextField,BorderLayout.CENTER);
        panel.add(fromLabel,BorderLayout.CENTER);
        panel.add(fromComboBox,BorderLayout.CENTER);
        panel.add(toLabel,BorderLayout.CENTER);
        panel.add(toComboBox,BorderLayout.CENTER);
        panel.add(resultLabel,BorderLayout.CENTER);
        panel.add(resultTextField,BorderLayout.CENTER);
        add(panel, BorderLayout.NORTH);
        add(jButton, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jButton) {
            try {
                double amount = Double.parseDouble(amountTextField.getText());
                int fromIndex = fromComboBox.getSelectedIndex();
                int toIndex = toComboBox.getSelectedIndex();

                double result = amount * EXCHANGE_RATES[fromIndex] / EXCHANGE_RATES[toIndex];
                DecimalFormat df = new DecimalFormat("#.##");

                resultTextField.setText(df.format(result));
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please Enter Valid Amount");
            }
        }
    }
}