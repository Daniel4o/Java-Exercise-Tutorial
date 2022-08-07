public class Player {

    // PROBLEM!!! Changing variables internally will make it so
    // you have to change the variables used from all the app
   // example : changing nam to fullName;
    public String name;
    public int health;
    public String weapon;

    public void loseHealth(int damage) {
        this.health -= damage;
        if(this.health <=0)
            System.out.println("Player knocked out");
    }

    public int healthReamining() {
        return this.health;
    }
}
