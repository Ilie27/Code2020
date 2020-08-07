import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class Generator {

	public static MazeCanvas mc;
	Maze m;
	public static Color generatePathColor= Color.BLUE;
	
	public Generator(MazeCanvas mc, Maze m) 
	{
		this.mc=mc;
		this.m=m;
	}
	
	public ArrayList<Side> shuffle(ArrayList<Side> sides) 
	{
		Collections.shuffle(sides);
		return sides;
	}
	
	public Side getOpposite(Side side)
	{
		if(side==Side.Left)
			return Side.Right;
		
		if(side==Side.Right)
			return Side.Left;
		
		if(side==Side.Top)
			return Side.Bottom;
		
		if(side==Side.Bottom)
			return Side.Top;
		
		return Side.Center;
		
	}

	public boolean run (Cell cell, Side side)
	{
		
		//mark cell as visited
		cell.setVisited(true);
		
		mc.drawPath(cell.getRow(), cell.getCol(), side, generatePathColor);
		mc.drawCenter(cell.getRow(), cell.getCol(),generatePathColor);
		cell.removeWall(side);
		
	//get and shuffle the cell’s list of walls
		ArrayList<Side> pereti ;
		pereti=shuffle(cell.getWalls());
		
		
		for (Side s:pereti)
{
			Cell neighbor = m.getNeighbor(cell, s);
					
			if(!neighbor.getVisited())
			{
				mc.drawPath(cell.getRow(), cell.getCol(), s, generatePathColor);
				cell.removeWall(s);
			
			run(neighbor,getOpposite(s));
			mc.erasePath(cell.getRow(), cell.getCol(), s);
			
			}
			
		
}
		
mc.eraseCenter(cell.getRow(), cell.getCol());
mc.erasePath(cell.getRow(), cell.getCol(), side);
//mc.pause();
		


		return false;
	}
	
	public boolean run ()
	{
		return run(m.getEntryCell(),Side.Center);
	}
}
