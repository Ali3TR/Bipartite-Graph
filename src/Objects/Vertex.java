package Objects;

import java.util.ArrayList;

public class Vertex
{
    private String label;
    private String color = "NotSet";
    private int x;
    private int y;
    public ArrayList<Vertex> adjList;

    public Vertex(String label, int x, int y)
    {
        this.label = label;
        this.x = x;
        this.y = y;
        adjList = new ArrayList<>();
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public int getX() {return this.x;}

    public int getY() {return this.y;}

    public String getLabel() {return this.label;}

    public String getColor()
    {
        return this.color;
    }

    public void setX(int x)
    {
        this.x=x;
    }

    public void setY(int y)
    {
        this.y=y;
    }

}
