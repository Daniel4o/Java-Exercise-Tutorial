public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        player.name = "Daniel";
        //PROBLEM forgot to initialize all together
        // unlike a constructor
        player.health = 20;
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.healthReamining());

        damage = 11;
        // PROBLEM!!! Accessing fields in wats that you
        // didn't want it to do
        player.health = 200;
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.healthReamining());
    }
}
