int myArraySize = 3;
int [] myArray = new int[myArraySize];
int xPosition, yPosition, rectWidth, rectHeight;

void setup(){
  size(600, 500);
  background(255,230,230);
  xPosition = 0;
  yPosition = height/2;
  rectWidth = width/myArraySize;
  rectHeight = 50;
  textSize(20);
  textAlign(CENTER, CENTER);
  setArray(myArray.length);
  drawMyRectangles(xPosition, yPosition, rectWidth, rectHeight);
  
}

void draw(){
  
  
}

void drawMyRectangles(int xPostion, int yPostion, int rectWidth, int rectHeight) {
    for(int count = 0; count < myArray.length; count++){
      rect(xPosition, yPosition, rectWidth, rectHeight);
      fill(0);
      text(str(myArray[count]), xPosition, yPosition, rectWidth, rectHeight);
      text(str(count), xPosition, yPosition+rectHeight, rectWidth, rectHeight);
      fill(255);
      xPosition+= rectWidth;
      print(myArray[count] + "\t");
  }
}

void setArray(int arrayLen){
  for(int count = 0; count < arrayLen; count++){
    myArray[count] = count * 10;
  } 
}
