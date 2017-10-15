package tpd.zadanie1.Criterions;

import tpd.zadanie1.DecisionModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damian Deska on 2017-10-14.
 */
public class SavageCriterion extends AbstractCriterion {

    List<Float> maxRelativeLoseFactorsList = new ArrayList<>();
    List<DecisionModel> decisionsList = new ArrayList<>();
    List<Float> maxLosesList = new ArrayList<>();
    List<Integer> minLoseIndexList = new ArrayList<>();

    public SavageCriterion() {
        criterionName = "Savage'a";
    }

    @Override
    public void makeDecision(List<DecisionModel> _decisionsList) {

        decisionsList = _decisionsList;

        getMaxRelativeLoseFactorsList();

        computeRelativeLose();

        computeMaxLose();

        makeMinLoseIndexList();

        displayResult(minLoseIndexList, criterionName);
    }

    private void getMaxRelativeLoseFactorsList() {
        float currentMax = 0.0f;

        for (int i = 0; i < decisionsList.get(0).getDecisionStates().size(); i++) {
            currentMax = decisionsList.get(0).getDecisionStates().get(i);
            for (DecisionModel decision : decisionsList) {
                if (decision.getDecisionStates().get(i) > currentMax) {
                    currentMax = decision.getDecisionStates().get(i);
                }
            }
            maxRelativeLoseFactorsList.add(currentMax);
        }
    }

    private void computeRelativeLose() {
        for (int i = 0; i < decisionsList.get(0).getDecisionStates().size(); i++) {
            for (DecisionModel decision : decisionsList) {
                decision.getDecisionStates().set(i, maxRelativeLoseFactorsList.get(i) - decision.getDecisionStates().get(i));
            }
        }
    }

    private void computeMaxLose() {
        float maxLose = 0.0f;
        for (DecisionModel decision : decisionsList) {
            maxLose = decision.getDecisionStates().get(0);
            for (int i = 1; i < decision.getDecisionStates().size(); i++) {
                if (decision.getDecisionStates().get(i) > maxLose) {
                    maxLose = decision.getDecisionStates().get(i);
                }
            }
            maxLosesList.add(maxLose);
        }
    }

    private void makeMinLoseIndexList() {
        float minLose = maxLosesList.get(0);
        minLoseIndexList.add(1);

        for(int i = 1; i < maxLosesList.size(); i++) {
            if(maxLosesList.get(i) < minLose) {
                minLoseIndexList.clear();
                minLoseIndexList.add(maxLosesList.indexOf(maxLosesList.get(i)) + 1);
                minLose = maxLosesList.get(i);
            } else if(maxLosesList.get(i) == minLose) {
                minLoseIndexList.add(maxLosesList.indexOf(maxLosesList.get(i)) + 1);
            }
        }
    }
}
