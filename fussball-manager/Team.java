import java.util.ArrayList;

class Team {
  private String name;
  private Player goalkeeper;
  private ArrayList<Player> fieldplayers;
  private Trainer trainer;

  public Team(String name) {
    this.name = name;
  }

  public void validateForPlaying() throws Exception {
    if (this.goalkeeper == null) {
      throw new Exception("Team has no goalkeeper");
    }

    int playerCount = this.fieldplayers.size();

    if (playerCount != 10) {
      throw new Exception("Team has the invalid number of fieldplayers of " + playerCount);
    }

    if (this.trainer == null) {
      throw new Exception("Team has no trainer");
    }
  }

  public Double getSkilllevel() {
    Double accumulator = 0.0;

    for (Player player: this.fieldplayers) {
      accumulator += player.getSkillLevel();
    }

    accumulator += this.goalkeeper.getSkillLevel();
    accumulator *= this.trainer.getSkillMultiplier();

    return accumulator;
  }

  public Team addPlayer(Player player) {
    this.fieldplayers.add(player);
    return this;
  }

  public Team removeFieldplayer(Player player) {
    this.fieldplayers.remove(player);
    return this;
  }

  public ArrayList<Player> getFieldplayers() {
    return this.fieldplayers;
  }

  public String getName() {
    return this.name;
  }

  public Player getGoalkeeper() {
    return this.goalkeeper;
  }

  public Team setGoalkeeper(Player goalkeeper) {
    this.goalkeeper = goalkeeper;
    return this;
  }
}