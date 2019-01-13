package java2.homework1.competitor;

/**
 * @author Stanislav Melekhin
 * Created on 13/01/2019
 */

public class Team {

    private String teamName;
    private Animal[] team;

    public Team(String teamName, Animal a1, Animal a2, Animal a3, Animal a4) {
        this.teamName = teamName;
        team = new Animal[]{a1, a2, a3, a4};
    }

    public void teamInfo() {
        System.out.println("Competitors team " + teamName + ":");
        for (Animal a : team) {
            System.out.println(a.toString());
        }
    }

    public Animal[] getTeam() {
        return team;
    }

    public void showResult() {
        for (Animal a : team) {
            if(a.getFinished()) {
                System.out.println(a.getClass().getSimpleName() + " " + a.name + " do it!");
            }
        }
    }
}