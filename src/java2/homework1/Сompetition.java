package java2.homework1;

import java2.homework1.competitor.*;

public class Сompetition {

    public static void main(String[] args) {

        Course c = new Course(190, 150, 0.3);

        Team team = new Team(
                "DreamTeam",
                new Cat("Persic", 120, 1.8),
                new Dog("Barbos", 700, 160, 0.4),
                new Human("Ivan", 200, 200, 0.7),
                new Cat("Bonya", 220, 1.4)
        );

        c.courseInfo();
        team.teamInfo();

        c.doIt(team);
        team.showResult();

    }

}
