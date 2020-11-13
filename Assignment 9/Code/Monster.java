import java.awt.*;

public class Monster{
	int size;
	Color monsterColor;
	float xPosition, yPosition;
	Eyes eyes;
	Mouth mouth;
	Name name;
}

//creates and draws eyes
class Eyes extends Features{

	Eyes(int size, int xPosition, int yPosition){
		super(size, xPosition, yPosition);
	}

	public void draw(){
		return;
	}

	public void create(){
		return;
	}
}

//creates and draws mouth
class Mouth extends Features{

	Mouth(int size, int xPosition, int yPosition){
		super(size, xPosition, yPosition);
	}

	public void draw(){
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

	Name(int size, int xPosition, int yPosition){
		super(size, xPosition, yPosition);
	}

	public void draw(){
		return;
	}

	public void create(){
		return;
	}

}