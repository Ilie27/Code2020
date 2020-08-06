import java.awt.Color;
import java.awt.color.*;
import graphics.MazeCanvas.Side;
import graphics.MazeCanvas;


public class Maze {
	
	public static MazeCanvas mc;
	public Cell[][] gridOfCells;
	public Maze(MazeCanvas mc)
	{
		this.mc=mc;
		gridOfCells= new Cell[mc.getRows()][mc.getCols()];
		
	}
	public Cell getCell(int row,int col)
	{
		return gridOfCells[row][col];
	}
	private Cell EntryC,ExitC;
	
	public void initialize()
	{
		int perim=2*(mc.getRows()+mc.getCols()-2);
		int iEntry;
		int iExit;
		int EntrExCount=0;
		iEntry=(int)(Math.random()*perim);
		iExit=(int)(Math.random()*perim);
		while(iEntry==iExit)
		iExit=(int)(Math.random()*perim);
		
		
		int numberBlocks=(mc.getRows()-2)*(mc.getCols()-2)/20;
		for(int r=0;r<mc.getRows();r++)
			for(int c=0;c<mc.getCols();c++)
			{
				if(r==0||c==0||r==mc.getRows()-1||c==mc.getCols()-1)
					{
					if(EntrExCount==iEntry)
					{    EntryC= new EntryCell(mc,r,c);
						gridOfCells[r][c]=   EntryC;
					}
					else
					{
					if(EntrExCount==iExit)
					{	ExitC=new ExitCell(mc,r,c);
						gridOfCells[r][c]= ExitC;
					}

					else
					gridOfCells[r][c]= new EdgeCell(mc,r,c);
					
					}
					EntrExCount++;}
				
				else
				{	if(numberBlocks>0 && Math.random()<0.05)
						{
						gridOfCells[r][c]= new BlockCell(mc,r,c);
						numberBlocks--;
						}
					else
					gridOfCells[r][c]= new Cell(mc,r,c);
				}	
			}
	}
		
		public Cell getEntryCell()
		{
			return ExitC;
		}
		
		public Cell getExitCell()
		{
			return EntryC;
		}





public void genSnake()
	{
			
		Color dr= new Color (224,0,0);
		for(int row=0;row<mc.getRows();row++)
		{
		for(int col=0;col<mc.getCols();col++)
		{
			mc.drawCell(row, col);
			
			if(row==0)
			{
				mc.eraseWall(row, col, Side.Bottom);
				if(col%2==0)
				{	mc.drawCenter(row, col,dr);
				mc.drawPath(row, col, Side.Left, Color.RED);
				mc.drawPath(row, col, Side.Bottom, Color.RED);
				mc.drawPath(row, col, Side.Center, Color.RED);
				
					mc.eraseWall(row, col, Side.Left);
				}
		else
		{
			mc.drawCenter(row, col,dr);
			mc.drawPath(row, col, Side.Right, Color.RED);
			mc.drawPath(row, col, Side.Bottom, Color.RED);
			mc.drawPath(row, col, Side.Center, Color.RED);
					mc.eraseWall(row, col, Side.Right);
		}
					
				
			}	
			if(row==mc.getRows()-1)
				{
				mc.eraseWall(row, col, Side.Top);
					if(col%2==1)
					{
						mc.drawCenter(row, col,dr);
						mc.drawPath(row, col, Side.Left, Color.RED);
						mc.drawPath(row, col, Side.Top, Color.RED);
						mc.drawPath(row, col, Side.Center, Color.RED);
						
						mc.eraseWall(row, col, Side.Left);
					}
				
					else
					{
						mc.drawCenter(row, col,dr);
						mc.drawPath(row, col, Side.Right, Color.RED);
						mc.drawPath(row, col, Side.Top, Color.RED);
						mc.drawPath(row, col, Side.Center, Color.RED);
						mc.eraseWall(row, col, Side.Right);
					}
				}
			if(row>0 && row <mc.getRows()-1)
			{	mc.drawCenter(row, col, Color.RED);
			mc.drawPath(row, col, Side.Top, Color.RED);
			mc.drawPath(row, col, Side.Bottom, Color.RED);
				mc.eraseWall(row, col, Side.Bottom);
			mc.eraseWall(row, col, Side.Top);
			}
			
			
			
		}
		
	}

}
	
	
	
}
