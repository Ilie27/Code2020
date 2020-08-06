import java.util.ArrayList;
import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class Cell 
{
public int row;
public int col;
public MazeCanvas mc;
public ArrayList<Side> listOfWalls= new  ArrayList<Side>();

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

public void removeWall(Side side)
	{
	mc.eraseWall(row, col, side);
	listOfWalls.remove(side);
	
	}



}
