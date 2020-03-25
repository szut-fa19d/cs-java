class Match {
  private Team teamA;
  private Team teamB;
  private int scoreA;
  private int scoreB;
  private boolean wasPlayed = false;
  private final int maxNumberOfGoals = 50;

  public Team getWinner() throws NoWinnerException {
    

    if (this.scoreA > this.scoreB) {
      return this.teamA;
    }

    if (this.scoreB > this.scoreA) {
      return this.teamB;
    }

    throw new NoWinnerException();
  }

  public Match(Team teamA, Team teamB) {
    this.teamA = teamA;
    this.teamB = teamB;
  }

  public Match play() throws Exception {
    this.teamA.validateForPlaying();
    this.teamB.validateForPlaying();

    double skillA = this.teamA.getSkilllevel();
    double skillB = this.teamB.getSkilllevel();

    double maxSkill = Math.max(skillA, skillB);
    double skillANormalized = skillA / maxSkill;
    double skillBNormalized = skillB / maxSkill;

    double smallerNormalized = Math.min(skillANormalized, skillBNormalized);

    double goalFactor = 1 - smallerNormalized;

    int averageGoals = (int) goalFactor * this.maxNumberOfGoals;
    
    int scoreA = (int) (averageGoals * skillANormalized * this.getRandomFactor());
    int scoreB = (int) (averageGoals * skillBNormalized * this.getRandomFactor());
    
    this.scoreA = scoreA;
    this.scoreB = scoreB;

    this.wasPlayed = true;

    return this;
  }

  private Double getRandomFactor() {
    Double base = 0.9;
    Double variance = Math.random() * 0.2;
    return base + variance;
  }

  public Match setTeamA(Team value) {
    this.teamA = value;
    return this;
  }

  public Team getTeamA() {
    return this.teamA;
  }

  public Match setTeamB(Team value) {
    this.teamB = value;
    return this;
  }

  public Team getTeamB() {
    return this.teamB;
  }

  public int getScoreA() {
    return this.scoreA;
  }

  public Match setScoreA(int scoreA) {
    this.scoreA = scoreA;
    return this;
  }

  public int getScoreB() {
    return this.scoreB;
  }

  public Match setScoreB(int scoreB) {
    this.scoreB = scoreB;
    return this;
  }

  public boolean getWasPlayed() {
    return this.wasPlayed;
  }

  public boolean wasPlayed() {
    return this.wasPlayed;
  }
}