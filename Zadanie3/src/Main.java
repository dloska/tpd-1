import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int EXPECTED_TIME = 48;

    private static List<Action> actionsList = new ArrayList<>();

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        actionsList = fileReader.getActionsList();
        Pert pert = new Pert();
        pert.computeActionFactor(actionsList);

        Graph graph = new Graph(8, 11);
        CriticalPath criticalPath = graph.getCriticalPath();

        List<Action> criticalPathActionsList = getCriticalPathActions(criticalPath.getNodesNumbers());

        double s_squareSum = getS_squareSum(criticalPathActionsList);
        double s = Math.sqrt(s_squareSum);

        double z = ((EXPECTED_TIME - criticalPath.getLength()) / s);
        System.out.println(s_squareSum + ", " + s + ", " + z);
    }

    private static List<Action> getCriticalPathActions(List<Integer> nodesNumbers) {
        List<Action> criticalPathActionsList = new ArrayList<>();
        for(int i = 0; i < nodesNumbers.size(); i++) {
            for(Action action : actionsList) {
                if(action.getI() == nodesNumbers.get(i) && action.getJ() == nodesNumbers.get(i + 1)) {
                    criticalPathActionsList.add(action);
                }
            }
        }
        return criticalPathActionsList;
    }

    private static double getS_squareSum(List<Action> actionsList) {
        double sum = 0;
        for(Action action : actionsList) {
            sum += action.getS_square();
        }
        return sum;
    }

}
