import java.util.ArrayList;
import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class Cell 
{
public int row;
public int col;
public MazeCanvas mc;
public ArrayList<Side> listOfWalls= new  ArrayList<Side>();
public boolean visited = false;

public Cell (MazeCanvas mc, int row, int col)
	{
	this.row=row;
	this.col=col;
	this.mc=mc;
	listOfWalls.add(Side.Top);
	listOfWalls.add(Side.Right);
	listOfWalls.add(Side.Bottom);
	listOfWalls.add(Side.Left);
	mc.drawCell(row, col);
	
	}




public ArrayList<Side> getWalls()
	{
	 ArrayList<Side> cloneListOfWalls= new ArrayList<Side>();
	cloneListOfWalls.addAll(listOfWalls);
	return cloneListOfWalls;
	}

public int getRow()
	{
	return row;
	}

public int getCol()
	{
	return col;
	}

public boolean getVisited()
{
	return visited;
}

public void setVisited(boolean n)
{
	visited=n;
}

public void removeWall(Side side)
	{
	mc.eraseWall(row, col, side);
	listOfWalls.remove(side);
	
	}

public ArrayList<Side> getPaths() 
{
	ArrayList<Side> listOfPaths= new ArrayList<Side>();
	listOfPaths.add(Side.Top);
	listOfPaths.add(Side.Right);
	listOfPaths.add(Side.Bottom);
	listOfPaths.add(Side.Left);
	listOfPaths.removeAll(listOfWalls);
	return listOfPaths;
}



}
