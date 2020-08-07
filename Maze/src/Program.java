import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class Program {
	
	public static void main(String[] args) 
	{ 
		MazeCanvas mc = new MazeCanvas(30,30,20);
		mc.open();
		Maze m = new Maze (mc);
		m.initialize();
		mc.drawCaption("LABIRITUL LUI ILIE");
		
		Generator g= new Generator( mc, m);
		
		g.run();
		
		Solver s= new Solver(mc,m);
		
		mc.pause();
		
		s.run();

		mc.pause();
		
		

//		m.genSnake();
//		mc.pause();
	mc.close();

	}

}


