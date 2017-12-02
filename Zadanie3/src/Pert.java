import java.util.List;

/**
 * Created by Damian Deska on 2017-12-02.
 */
public class Pert {

    public void computeActionFactor(List<Action> actionsList) {
        for(Action action : actionsList) {
            action.setT(computeT(action));
            action.setS_square(computeS_square(action));
        }
    }

    private double computeT(Action action) {
        return ((action.getA() + (4* action.getM()) + action.getB()) / 6);
    }

    private double computeS_square(Action action) {
        double subtract = action.getB() - action.getA();
        double divide = subtract / 6;
        double s_square = Math.round(Math.pow(divide, 2) * 100);
        s_square = s_square/100;
        return s_square;
    }

}
