package homework7;

public class Wall implements Obstacle {
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public void overcome(Participant participant) {


        boolean status = participant.isActive();
        if (!status) {
            System.out.println("Учасник " + participant.getName() +
                    " далi не перестрибнув стіну висотою " + height + " метрів.");

        } else if (!participant.jump(height)) {
            System.out.println("Учасник " + participant.getName() + " не перестрибнув стіну висотою " + height + " метрів.");

            participant.eliminate();
        } else {
            System.out.println("Учасник " + participant.getName() + " перестрибнув стіну висотою " + height + " метрів. Пройдено "
                    + participant.getJumpHeight() + " метрів.");
        }

    }


}


