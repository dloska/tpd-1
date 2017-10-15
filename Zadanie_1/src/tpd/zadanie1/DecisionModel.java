package tpd.zadanie1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damian Deska on 2017-10-14.
 */
public class DecisionModel {

    private List<Float> decisionStates = new ArrayList<>();
    private int investitionCost;

    public int getInvestitionCost() {
        return investitionCost;
    }

    public void setInvestitionCost(int investitionCost) {
        this.investitionCost = investitionCost;
    }

    public List<Float> getDecisionStates() {
        return decisionStates;
    }

    public void setDecisionStates(List<Float> decisionStates) {
        this.decisionStates = decisionStates;
    }
}
