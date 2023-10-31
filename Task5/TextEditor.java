package Task_5;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;
class editor extends JFrame implements ActionListener {

    JTextArea t;
 

    JFrame frame;
 
    editor()
    {
        // Create a frame
        frame = new JFrame("editor");
 
        try {
            
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
 
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        }
        catch (Exception e) {
        }
 
        t = new JTextArea();
 

        JMenuBar mb = new JMenuBar();
 

        JMenu m1 = new JMenu("File");
 
        JMenuItem mi1 = new JMenuItem("New");
        JMenuItem mi2 = new JMenuItem("Open");
        JMenuItem mi3 = new JMenuItem("Save");
        JMenuItem mi9 = new JMenuItem("Print");
 
        // Add action listener
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi9.addActionListener(this);
 
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(mi9);
 
        JMenu m2 = new JMenu("Edit");
 

        JMenuItem mi4 = new JMenuItem("cut");
        JMenuItem mi5 = new JMenuItem("copy");
        JMenuItem mi6 = new JMenuItem("paste");
 
        mi4.addActionListener(this);
        mi5.addActionListener(this);
        mi6.addActionListener(this);
 
        m2.add(mi4);
        m2.add(mi5);
        m2.add(mi6);
 
        JMenuItem mc = new JMenuItem("close");
 
        mc.addActionListener(this);
 
        mb.add(m1);
        mb.add(m2);
        mb.add(mc);
 
        frame.setJMenuBar(mb);
        frame.add(t);
        frame.setSize(500, 500);
        frame.show();
    }
 
    // If a button is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
 
        if (s.equals("cut")) {
            t.cut();
        }
        else if (s.equals("copy")) {
            t.copy();
        }
        else if (s.equals("paste")) {
            t.paste();
        }
        else if (s.equals("Save")) {
            JFileChooser j = new JFileChooser("f:");
 
            int r = j.showSaveDialog(null);
 
            if (r == JFileChooser.APPROVE_OPTION) {
 
                File fi = new File(j.getSelectedFile().getAbsolutePath());
 
                try {
                    FileWriter wr = new FileWriter(fi, false);
 
                    BufferedWriter w = new BufferedWriter(wr);
 
                    // Write
                    w.write(t.getText());
 
                    w.flush();
                    w.close();
                }
                catch (Exception evt) {
                    JOptionPane.showMessageDialog(f, evt.getMessage());
                }
            }
      
            else
                JOptionPane.showMessageDialog(f, "the user cancelled the operation");
        }
        else if (s.equals("Print")) {
            try {
               
                t.print();
            }
            catch (Exception evt) {
                JOptionPane.showMessageDialog(frame, evt.getMessage());
            }
        }
        else if (s.equals("Open")) {
          
            JFileChooser j = new JFileChooser("f:");
            int r = j.showOpenDialog(null);
 
            if (r == JFileChooser.APPROVE_OPTION) {
                File fi = new File(j.getSelectedFile().getAbsolutePath());
 
                try {
                    
                    String s1 = "", sl = "";
                    FileReader fr = new FileReader(fi);
                    BufferedReader br = new BufferedReader(fr);
 
                    sl = br.readLine();
 
                    while ((s1 = br.readLine()) != null) {
                        sl = sl + "\n" + s1;
                    }
                    t.setText(sl);
                }
                catch (Exception evt) {
                    JOptionPane.showMessageDialog(frame, evt.getMessage());
                }
            }
            else
                JOptionPane.showMessageDialog(f, "the user cancelled the operation");
        }
        else if (s.equals("New")) {
            t.setText("");
        }
        else if (s.equals("close")) {
            frame.setVisible(false);
        }
    }
    public static void main(String args[])
    {
        editor e = new editor();
    }
}

