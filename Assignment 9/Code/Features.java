abstract class Features implements IFeatures{

	public Features(float size, float xPosition, float yPosition){
		this.size = size;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	

	public float size;
	public float xPosition, yPosition;
}