import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class Program {
	
	public static void main(String[] args) 
	{ 
		MazeCanvas mc = new MazeCanvas();
		mc.open();
		Maze m = new Maze (mc);
		m.initialize();
		
//		mc.pause();
//		m.genSnake();
//	
		mc.pause();
		mc.close();
		

	}

}


