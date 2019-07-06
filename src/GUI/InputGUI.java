package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputGUI extends JPanel
{
    private int numOfNoses;
    private JButton insert;
    private JTextField nodesCount;
    private JLabel vertexDec;
    private JLabel edgesDec;
    private JTextField edges;
    private JButton add1;
    private JButton execute;
    private JLabel nodesNames;
    private JTextField nodes;
    private JButton add2;
    private JLabel nodesAdded;
    private JLabel edgesAdded;
    private int Nodes;
    private int Edges;
    private JLabel result;

    public InputGUI()
    {
        OutputGUI outputGUI = new OutputGUI();
        outputGUI.setSize(400,300);


        insert = new JButton ("Insert");
        nodesCount = new JTextField (5);
        vertexDec = new JLabel ("How many vertices your Graph have?");
        edgesDec = new JLabel ("Enter Edges in form of vertex1-vertex2  one by one.");
        edges = new JTextField (5);
        add1 = new JButton ("Add");
        execute = new JButton ("Execute");
        nodesNames = new JLabel ("Enter nodes name one by one an press add.");
        nodes = new JTextField (5);
        add2 = new JButton ("Add");
        nodesAdded = new JLabel ("");
        edgesAdded = new JLabel ("");
        result = new JLabel ("");

        nodesAdded.setVisible(false);
        edgesAdded.setVisible(false);
        result.setVisible(false);

        setPreferredSize (new Dimension (630, 168));
        setLayout (null);

        add (insert);
        add (nodesCount);
        add (vertexDec);
        add (edgesDec);
        add (edges);
        add (add1);
        add (execute);
        add (nodesNames);
        add (nodes);
        add (add2);
        add (nodesAdded);
        add (edgesAdded);
        add (result);

        insert.setBounds (445, 25, 75, 25);
        nodesCount.setBounds (320, 25, 100, 25);
        vertexDec.setBounds (10, 20, 280, 30);
        edgesDec.setBounds (10, 95, 355, 25);
        edges.setBounds (395, 95, 100, 25);
        add1.setBounds (520, 95, 100, 25);
        execute.setBounds (280, 130, 100, 25);
        nodesNames.setBounds (10, 60, 315, 25);
        nodes.setBounds (330, 60, 100, 25);
        add2.setBounds (460, 60, 100, 25);
        nodesAdded.setBounds (10, 130, 155, 25);
        edgesAdded.setBounds (125, 130, 155, 25);
        result.setBounds (380, 130, 250, 25);


        insert.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                numOfNoses=Integer.parseInt(nodesCount.getText());
                outputGUI.setSize(400,90+(numOfNoses-1)*50);
                outputGUI.repaint();

            }
        });

        add2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                outputGUI.graph.addVertex(nodes.getText(),100,100);
                System.out.println( "vertex " + nodes.getText());
                Nodes++;
                nodesAdded.setText("Nodes added : "+Nodes);
                nodesAdded.setVisible(true);
                nodes.setText("");
            }
        });

        add1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] temp = edges.getText().split("-");
                outputGUI.graph.addEdge(outputGUI.getVertex(temp[0]),outputGUI.getVertex(temp[1]));
                Edges++;
                edgesAdded.setText("Edges added : "+Edges);
                edgesAdded.setVisible(true);
                edges.setText("");
            }
        });

        execute.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (outputGUI.graph.isBipartite())
                {
                    outputGUI.graph.setLocation();
                    outputGUI.setVisible(true);

                    outputGUI.repaint();
                }
                else
                {
                    outputGUI.setVisible(false);
                    result.setText("given Graph is NOT Bipartite!");
                    result.setVisible(true);
                }
            }
        });
    }

}
