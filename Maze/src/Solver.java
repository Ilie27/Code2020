import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class Solver {
	public static MazeCanvas mc;
	Maze m;
	public static Color fwdPathColor=Color.BLACK  ,  bktPathColor = Color.CYAN;
	
	public Solver (MazeCanvas mc, Maze m) 
	{
		this.mc=mc;
		this.m=m;
	}
	public boolean run(Cell cell, Side side)
	{
//		mark cell as visited
		cell.setVisited(true);
//		 draw fwdPath fromSide and Side.Center  
		mc.drawPath(cell.getRow(), cell.getCol(), side, fwdPathColor);
		mc.drawCenter(cell.getRow(), cell.getCol(),fwdPathColor);

//		  if cell is the exit then  return true
		if(m.getExitCell()==cell)
			return true;

//		  get and shuffle the cell’s list of paths
		ArrayList<Side> pereti ;
		pereti=shuffle(cell.getPaths());
		
		
		
//		  foreach side in list of paths do
		for (Side s:pereti)
		{
					Cell neighbor = m.getNeighbor(cell, s);
							
					if(!neighbor.getVisited())
					{
						mc.drawPath(cell.getRow(), cell.getCol(), s, fwdPathColor);
						
					if(run(neighbor,getOpposite(s)))
					return true;
					
					mc.drawPath(cell.getRow(), cell.getCol(), s,  bktPathColor);
					}			
					
					
}
					

//		  draw bktPath for Side.Center and fromSide
		mc.drawPath(cell.getRow(), cell.getCol(), side, bktPathColor);
		mc.drawCenter(cell.getRow(), cell.getCol(),bktPathColor);
	

		return false;
	}
	
	public boolean run()
	{
		for(int r=0;r<mc.getRows();r++)
			for(int c=0;c<mc.getCols();c++)
				m.getCell(r, c).setVisited(false);
				
				
				
		return run(m.getEntryCell(), Side.Center);
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

	
}
