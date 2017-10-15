package tpd.zadanie1.Criterions;

import tpd.zadanie1.DecisionModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damian Deska on 2017-10-14.
 */
public abstract class AbstractCriterion {

    public String criterionName;

    public void makeDecision(List<DecisionModel> decisionsList){

    }

    void displayResult(List<Integer> indexesList, String criterionName){
        if(indexesList.size() == 1) {
            System.out.println("Zgodnie z kryterium " + criterionName + " najlepszym wyborem będzie decyzja numer: " + indexesList.get(0) + "\n");
        } else {
            String indexStringValues = "";
            for(int i = 0; i < indexesList.size() - 1; i++) {
                indexStringValues += indexesList.get(i).toString() + ", ";
            }
            System.out.println("Zgodnie z kryterium " + criterionName + " najkorzystniejsze będą decyzje: " + indexStringValues + "\n");
        }
    }

    public List<Integer> getIndexesListOfMaxValues(List<Float> minValuesList) {
        List<Integer> maxValuesIndexList = new ArrayList<>();
        maxValuesIndexList.add(1);
        float maxValue = minValuesList.get(0);

        for(int i = 1; i < minValuesList.size(); i++) {
            if(minValuesList.get(i) > maxValue) {
                maxValue = minValuesList.get(i);
                maxValuesIndexList.clear();
                maxValuesIndexList.add(minValuesList.indexOf(minValuesList.get(i)) + 1);
            } else if (minValuesList.get(i) == maxValue) {
                maxValuesIndexList.add(minValuesList.indexOf(minValuesList.get(i)) + 1);
            }
        }

        return maxValuesIndexList;
    }

}
