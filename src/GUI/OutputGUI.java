package GUI;

import java.awt.*;
import javax.swing.*;
import Objects.*;

public class OutputGUI extends JFrame
{
    private int width;
    private int height;
    public Graph graph;

    public OutputGUI()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.width = 30;
        this.height = 30;
        graph = new Graph();
    }

    public void paint(Graphics graphics)
    {
        FontMetrics f = graphics.getFontMetrics();
        int nodeHeight = Math.max(height, f.getHeight());

        graphics.setColor(Color.black);

        for (Vertex v : graph.vertices)
        {
            for (Vertex u : v.adjList) {
                graphics.drawLine(v.getX(), v.getY(),
                        u.getX(), u.getY());
            }
        }

        for (Vertex n : graph.vertices)
        {
            int nodeWidth = Math.max(width, f.stringWidth(n.getLabel()) + width / 2);
            graphics.setColor(Color.white);
            graphics.fillOval(n.getX() - nodeWidth / 2, n.getY() - nodeHeight / 2,
                    nodeWidth, nodeHeight);
            if (n.getColor().equals("RED"))
                graphics.setColor(Color.red);
            else
                graphics.setColor(Color.blue);

            graphics.drawOval(n.getX() - nodeWidth / 2, n.getY() - nodeHeight / 2,
                    nodeWidth, nodeHeight);

            graphics.drawString(n.getLabel(), n.getX() - f.stringWidth(n.getLabel()) / 2,
                    n.getY() + f.getHeight() / 2);
        }

    }

    public Vertex getVertex(String name)
    {
        for (int k=0;k<graph.vertices.size();k++)
        {
            if (graph.vertices.get(k).getLabel().equals(name))
                return graph.vertices.get(k);
        }
        return new Vertex("notFound",0,0);
    }

}
