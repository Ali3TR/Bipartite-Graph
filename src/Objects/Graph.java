package Objects;

import java.util.*;

public class Graph
{
    public ArrayList<Vertex> vertices;
    public Graph()
    {
        vertices = new ArrayList<Vertex>();
    }

    public void addVertex(String label, int x, int y)
    {
        vertices.add(new Vertex(label, x, y));
    }

    public void addEdge(Vertex v1, Vertex v2)
    {
        v1.adjList.add(v2);
        v2.adjList.add(v1);
    }

    public boolean isBipartite()
    {
        for (int i = 0; i < vertices.size(); i++)
        {
            if (vertices.get(i).getColor().equals("NotSet"))
                vertices.get(i).setColor("RED");
            for (int j = 0; j < vertices.get(i).adjList.size(); j++)
            {
                if (vertices.get(i).adjList.get(j).getColor().equals(vertices.get(i).getColor()))
                {
                    return false;
                }

                else
                {
                    switch (vertices.get(i).getColor())
                    {
                        case "RED":
                        {
                            vertices.get(i).adjList.get(j).setColor("BLUE");
                            break;
                        }
                        case "BLUE":
                        {
                            vertices.get(i).adjList.get(j).setColor("RED");
                            break;
                        }
                    }
                }
            }
        }
        return true;
    }
    public void setLocation()
    {
        for (int k =0;k<vertices.size();k++)
        {
            if (vertices.get(k).getColor().equals("RED"))
            {
                vertices.get(k).setX(100);
                vertices.get(k).setY(60 + k*50);

            }
            else
            {
                vertices.get(k).setX(300);
                vertices.get(k).setY(60 + k*50);
            }
        }
    }
}
