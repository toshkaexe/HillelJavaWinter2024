package homework7;

public class Wall implements Obstacle {
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public void overcome(Participant participant) {
        if  (participant.isActive() && !participant.jump(height))  {
            System.out.println("Учасник " + participant.getName() + " перестрибнув стіну висотою " + height + " метрів.");
            participant.eliminate();
        } else {
            System.out.println("Учасник " + participant.getName() + " не перестрибнув стіну висотою " + height + " метрів. Пройдено "
                    + participant.getJumpHeight() + " метрів.");
            participant.eliminate();
        }
    }

}
