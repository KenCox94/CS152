abstract class Features implements IFeatures{

	public Features(int size, int xPosition, int yPosition){
		this.size = size;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	

	public int size;
	public int xPosition, yPosition;
}