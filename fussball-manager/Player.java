class Player extends Person {
  private int skillLevel;

  public Player(String name, int age) {
    super(name, age);
  }

  public int getSkillLevel() {
    return this.skillLevel;
  }
}