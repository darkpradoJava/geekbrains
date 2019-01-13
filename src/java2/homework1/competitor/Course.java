package java2.homework1.competitor;

public class Course {

    private double[] course;

    public Course(double distanceRun, double distanceSwim, double heightJump) {
        course = new double[3];
        course[0] = distanceRun;
        course[1] = distanceSwim;
        course[2] = heightJump;
    }

    public void courseInfo() {
        System.out.println("Course: run - " + course[0] + ", swim - " + course[1] + ", jump - " + course[2] + ".");
    }

    public void doIt(Team team) {
        for (Animal a : team.getTeam()) {
            if (a.run(course[0]) && a.swim(course[1]) && a.jump(course[2])) {
                a.setFinished(true);
            }
        }
    }

}
