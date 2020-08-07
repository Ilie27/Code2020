import java.awt.Color;

import graphics.MazeCanvas;

public class BlockCell extends ShadedCell 
{
 public static final Color blockShadeColor= Color.LIGHT_GRAY;
 public BlockCell(MazeCanvas mc, int row, int col)
 {
	 super( mc,  row,  col,blockShadeColor);
 }
 
 @Override
 public boolean getVisited()
 {
 	return true;
 }
 
}
