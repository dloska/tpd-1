package tpd.zadanie1.Criterions;

import tpd.zadanie1.DecisionModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Damian Deska on 2017-10-14.
 */
public class WaldAbstractCriterion extends AbstractCriterion {

    public WaldAbstractCriterion() {
        criterionName = "Walda";
    }

    @Override
    public void makeDecision(List<DecisionModel> decisionsList) {
        List<Float> minValuesList = new ArrayList<>();
        decisionsList.stream().forEach(d -> minValuesList.add(Collections.min(d.getDecisionStates())));

        displayResult(getIndexesListOfMaxValues(minValuesList), criterionName);
    }
}
