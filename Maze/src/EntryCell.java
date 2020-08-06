import java.awt.Color;

import graphics.MazeCanvas;
public class EntryCell extends EdgeCell
{
	public static final Color entryShadeColor= Color.YELLOW;
	public EntryCell(MazeCanvas mc, int row, int col)
			{
		super( mc,  row, col);
		mc.drawShade(row, col, entryShadeColor);
			}
}