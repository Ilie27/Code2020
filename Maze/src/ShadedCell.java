import java.awt.Color;

import graphics.MazeCanvas;

public class ShadedCell extends Cell
{
	public Color shadeColor;
	public ShadedCell(MazeCanvas mc, int row, int col, Color shadeColor)
	{
	super( mc,  row,  col);
	this.shadeColor=shadeColor;
	mc.drawShade(row, col, shadeColor);
	}

}
