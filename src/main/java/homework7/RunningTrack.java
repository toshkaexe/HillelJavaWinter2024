package homework7;

public class RunningTrack implements Obstacle {
    private double length;

    public RunningTrack(double length) {
        this.length = length;
    }

    @Override
    public void overcome(Participant participant) {

        boolean status = participant.isActive();
        if (!status) {
            System.out.println("Учасник " + participant.getName() +
                    " далi не пройшов бігову доріжку довжиною " +
                    length + " метрів. Пройдено " + participant.getRunDistance() + " метрів.");

        } else if (!participant.run(length)) {
            System.out.println("Учасник " + participant.getName() +
                    " не пройшов бігову доріжку довжиною " +
                    length + " метрів. Пройдено " + participant.getRunDistance() + " метрів.");
            participant.eliminate();
        } else {
            System.out.println("Учасник " + participant.getName() +
                    " пройшов бігову доріжку довжиною " + length + " метрів.");
        }
    }


}
