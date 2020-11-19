abstract class Features implements IFeatures{

	public Features(float xPosition, float yPosition, float size){
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.size = size;
	}
	

	public float size;
	public float xPosition, yPosition;
}