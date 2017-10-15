package tpd.zadanie1.Criterions;

import tpd.zadanie1.DecisionModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Damian Deska on 2017-10-14.
 */
public class OptimisticAbstractCriterion extends AbstractCriterion {

    public OptimisticAbstractCriterion() {
        criterionName = "optymistycznym";
    }

    @Override
    public void makeDecision(List<DecisionModel> decisionsList) {
        List<Float> maxValuesList = new ArrayList<>();
        decisionsList.stream().forEach(d -> maxValuesList.add(Collections.max(d.getDecisionStates())));

        displayResult(getIndexesListOfMaxValues(maxValuesList), criterionName);
    }

}
