class Monster {
  Eyes eyes;
  Mouth mouth;
  Name name;
  float xPosition, yPosition;
  float size;
  color monsterColor;
  
  Monster(float sizeIn, float xPositionIn, float yPositionIn) {
  }
  
  void drawMonster() { 
  }
}

/**************************************************/
/**************************************************/
/**************************************************/
class Eyes {
  float xPosition, yPosition;
  float size;

  Eyes (float sizeIn, float xPositionIn, float yPositionIn) {
  }
  
  void drawEyes()
  {
    //draw eyes
    //draw eyebrows
  }
}

/**************************************************/
/**************************************************/
/**************************************************/
class Mouth {
  float xPosition, yPosition;
  float size;
  
  Mouth (float sizeIn, float xPositionIn, float yPositionIn) {
  }
  
  void drawMouth() {
  }
}

/**************************************************/
/**************************************************/
/**************************************************/
class Name {
  String name;
  final char[] vowels = {'A', 'E', 'I', 'O', 'U' };
  final char[] consonants = { 'K', 'T', 'Z', 'R', 'P', 'B', 'L', 'M' };
 
  Name () {
  }
  
  void drawName() {
  }

}
