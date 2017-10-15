package tpd.zadanie1.Criterions;

import tpd.zadanie1.DecisionModel;
import tpd.zadanie1.Fraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Damian Deska on 2017-10-14.
 */
public class BayesLaplaceAbstractCriterion extends AbstractCriterion {

    private static Scanner scanner = new Scanner(System.in);
    private int choosenFactorType;
    private int fractionsNumber = 1;
    private List<Fraction> fractionsList = new ArrayList<>();

    public BayesLaplaceAbstractCriterion() {
        criterionName = "Bayesa-Laplace'a";
    }

    @Override
    public void makeDecision(List<DecisionModel> decisionsList) {

        float averageWin = 0.0f;
        List<Float> averageWinsList = new ArrayList<>();
        fractionsNumber = decisionsList.get(0).getDecisionStates().size();
        boolean correctChoosenFactorTypeFlag = false;

        while(!correctChoosenFactorTypeFlag) {
            System.out.println("Wybierz rodzaj prawdopodobieństwa:\n1)Wszystkie stany jednakowo prawdopodobne" +
                    "\n2)Określone stany prawdopodobieństwa\n");
            choosenFactorType = scanner.nextInt();

            if (choosenFactorType == 1) {
                correctChoosenFactorTypeFlag = true;
                averageWinsList.clear();
                averageWin = 0.0f;
                for (DecisionModel decision : decisionsList) {
                    averageWin = (countDecisionStatesSum(decision.getDecisionStates()) / (decision.getDecisionStates().size()));
                    averageWinsList.add(averageWin);
                    System.out.println(averageWin);
                }
            } else if (choosenFactorType == 2) {
                correctChoosenFactorTypeFlag = true;
                averageWinsList.clear();
                averageWin = 0.0f;

                getAllFactors();

                for(DecisionModel decision : decisionsList){
                    for(int i = 0; i < decision.getDecisionStates().size(); i++) {
                        averageWin += ((decision.getDecisionStates().get(i))
                                * ((fractionsList.get(i).getNumerator()) / (fractionsList.get(i).getDenominator())));
                    }
                    averageWinsList.add(averageWin);
                }
            }
        }
        displayResult(getIndexesListOfMaxValues(averageWinsList), criterionName);
    }

    private float countDecisionStatesSum(List<Float> decisionStates) {
        float sum = 0.0f;

        for(Float state : decisionStates) {
            sum += state;
        }

        return sum;
    }

    private void getAllFactors() {
        boolean fractionsCorrectFlag = false;
        while(!fractionsCorrectFlag) {
            Fraction fraction = new Fraction();
            for(int i = 0; i < fractionsNumber; i++) {
                System.out.println("Podaj licznik dla " + (i + 1) + ". współczynnika: ");
                fraction.setNumerator(scanner.nextInt());
                System.out.println("Podaj mianownik dla " + (i + 1) + ". współczynnika: ");
                fraction.setDenominator(scanner.nextInt());
                fractionsList.add(fraction);
            }

            if(countFractionsSum()) {
                fractionsCorrectFlag = true;
            } else {
                System.out.println("Niepoprawne wartości współczynników - ich suma musi wynosić 1. Spróbuj jeszcze raz.\n");
            }
        }
    }

    private boolean countFractionsSum() {
        float fractionsSum = 0.0f;
        for(Fraction fraction : fractionsList) {
            fractionsSum += (fraction.getNumerator() / fraction.getDenominator());
        }

        return fractionsSum == 1.0f;
    }

}
