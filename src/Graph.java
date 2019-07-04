import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Graph
{
    private ArrayList<Vertex> vertices;
    private Map<Vertex, List<Vertex>> adjList;

    public void addVertex(String label)
    {
        vertices.add(new Vertex(label));
        adjList.putIfAbsent(new Vertex(label), new ArrayList<Vertex>());
    }

    public void addEdge(Vertex v1, Vertex v2)
    {
        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1);
    }

    public boolean isBipartite()
    {
        vertices.get(0).setColor("RED");

        for (int i = 0; i < vertices.size(); i++)
        {
            for (int j = 0; j < adjList.get(vertices.get(i)).size(); j++)
            {
                if (adjList.get(vertices.get(i)).get(j).getColor().equals(vertices.get(i).getColor()))
                {
                    return false;
                }

                else
                {
                    switch (vertices.get(i).getColor())
                    {
                        case "RED":
                        {
                            adjList.get(vertices.get(i)).get(j).setColor("BLUE");
                            break;
                        }
                        case "BLUE":
                        {
                            adjList.get(vertices.get(i)).get(j).setColor("RED");
                            break;
                        }
                    }
                }
            }
        }

        return true;
    }
}
