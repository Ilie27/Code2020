import java.awt.Color;
import java.util.ArrayList;
import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class EdgeCell extends ShadedCell
{
	public static final Color edgeColor= new Color (100,200,150);
	public ArrayList<Side> listOfEdges= new ArrayList<Side>();
public EdgeCell(MazeCanvas mc, int row, int col)
	{
	super( mc,  row,  col, edgeColor);
	if(row==0)
	{
		listOfEdges.add(Side.Top);
	}
	
	if(row==mc.getRows()-1)
	{
		listOfEdges.add(Side.Bottom);
	}
	
	if(col==0)
	{
		listOfEdges.add(Side.Left);
	}
	
	if(col==mc.getCols()-1)
	{
		listOfEdges.add(Side.Right);
	}
	}

public ArrayList<Side> getWalls()
{
	ArrayList<Side>walls=super.getWalls();
	walls.removeAll(listOfEdges);
	return walls;

}

public ArrayList<Side> getPaths() 
{
	
	ArrayList<Side> listOfPathsEdge=super.getPaths();
	listOfPathsEdge.removeAll(listOfEdges);
	return listOfPathsEdge;
}



	

}
