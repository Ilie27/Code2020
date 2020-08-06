import java.awt.Color;

import graphics.MazeCanvas;
public class ExitCell extends EdgeCell
{
	public static final Color exitShadeColor= Color.GREEN;
	public ExitCell(MazeCanvas mc, int row, int col)
			{
		super( mc,  row,  col);
		mc.drawShade(row, col, exitShadeColor);
			}
}