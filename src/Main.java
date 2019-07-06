import javax.swing.JFrame;
import GUI.InputGUI;

import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame ("Bipartite Graph");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new InputGUI());
        frame.pack();
        frame.setVisible (true);

    }
}
