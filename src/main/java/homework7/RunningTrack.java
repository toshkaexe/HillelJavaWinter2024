package homework7;

public class RunningTrack implements Obstacle{
    private double length;

    public RunningTrack(double length) {
        this.length = length;
    }

    @Override
    public void overcome(Participant participant) {

        if (participant.run(length)) {
            System.out.println("Учасник " + participant.getName() + " пробіг бігову доріжку довжиною " + length + " метрів.");
        } else {
            System.out.println("Учасник " + participant.getName() + " не пробіг бігову доріжку довжиною " + length + " метрів.");
            participant.eliminate();
        }
    }


}
