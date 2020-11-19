import java.awt.*;

public class Monster implements IFeatures{
	static int totalNumberOfMonsters;

	Monster(float xPosition, float yPosition, float size){
		this.size = size;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this._colorSetter();
		this._eyeSetter();
		this._mouthSetter();
		this._nameSetter();
		
		totalNumberOfMonsters++;
	}
	
	public void create(){
		return;
	}

	public void draw(Graphics g){
		g.setColor(monsterColor);
		g.fillOval((int) xPosition,(int) yPosition, (int)size, (int)size);
	}

	private void _colorSetter(){
		int red = (int) (Math.random()*256);
		int green = (int) (Math.random()*256);
		int blue = (int) (Math.random()*256);
		monsterColor = new Color(red, green, blue);
	}

	private void _eyeSetter(){
		eyes = new Eyes(size/6, xPosition, yPosition-size/8);
	}

	private void _mouthSetter(){
		mouth = new Mouth(size/4, xPosition, yPosition+size/8);
	}

	private void _nameSetter(){
		name = new Name(size, xPosition, yPosition+size*5/8);
	}
	
	float size;
	float xPosition, yPosition;
	private Eyes eyes;
	private Mouth mouth;
	private Name name;
	private Color monsterColor;
}

//creates and draws eyes
class Eyes extends Features{

	/**
	 * 
	 * @param size
	 * @param xPosition
	 * @param yPosition
	 */
	Eyes(float size, float xPosition, float yPosition){
		super(size, xPosition, yPosition);
	}

	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.drawOval();
	}

	public void create(){
		return;
	}
}

//creates and draws mouth
class Mouth extends Features{

	/**
	 * 
	 * @param size
	 * @param xPosition
	 * @param yPosition
	 */
	Mouth(float size, float xPosition, float yPosition){
		super(size, xPosition, yPosition);
	}

	public void draw(Graphics g){
		return;
	}

	public void create(){
		return;
	}
}



//creates and draws name
class Name extends Features{
	static final char[] vowels = {'A','E','I','O','U'};
	static final char[] consonants =  {'K', 'T', 'Z', 'R', 'P', 'B', 'L', 'M', 'X', 'Y'};

	/**
	 * Creates a name object
	 * @param size size of name
	 * @param xPosition x position of name
	 * @param yPosition y position of name 
	 */
	Name(float size, float xPosition, float yPosition){
		super(size, xPosition, yPosition);
	}

	/**
	 * Draws name to the screen 
	 * @param g the Graphics object from java.awt.Graphics
	 */
	public void draw(Graphics g){
		return;
	}

	public void create(){
		return;
	}
	String name;
}