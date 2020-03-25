class Trainer extends Person {
  private double skillMultiplier;

  public Trainer(String name, int age, double skillMultiplier) {
    super(name, age);
    this.skillMultiplier = skillMultiplier;
  }

  public Trainer setSkillMultiplikator(double value) {
    this.skillMultiplier = value;
    return this;
  }

  public double getSkillMultiplier() {
    return this.skillMultiplier;
  }
}