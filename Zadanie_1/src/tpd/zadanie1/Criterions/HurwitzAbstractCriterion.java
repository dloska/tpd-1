package tpd.zadanie1.Criterions;

import tpd.zadanie1.DecisionModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Damian Deska on 2017-10-14.
 */
public class HurwitzAbstractCriterion extends AbstractCriterion {

    Scanner scanner = new Scanner(System.in);
    private float precautionaryFactor = 2.0f;

    public HurwitzAbstractCriterion() {
        criterionName = "Hurwicza";
    }

    @Override
    public void makeDecision(List<DecisionModel> decisionsList) {

        float currentMax, currentMin, averageWin = 0.0f;
        List<Float> hurwitzValuesList = new ArrayList<>();
        List<Integer> resultIndexList = new ArrayList<>();

        while(precautionaryFactor < 0 || precautionaryFactor > 1) {
            System.out.println("Podaj współczynnik ostrożności [0:1]: ");
            precautionaryFactor = scanner.nextFloat();
        }

        for(DecisionModel decision : decisionsList) {
            currentMin = Collections.min(decision.getDecisionStates());
            currentMax = Collections.max(decision.getDecisionStates());
            averageWin = (precautionaryFactor * currentMin) + ((1 - precautionaryFactor) * (currentMax));
            System.out.println(averageWin);
            hurwitzValuesList.add(averageWin);
        }

        displayResult(getIndexesListOfMaxValues(hurwitzValuesList), criterionName);
    }
}
