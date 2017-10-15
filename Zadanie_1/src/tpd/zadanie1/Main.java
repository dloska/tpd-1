package tpd.zadanie1;

import tpd.zadanie1.Criterions.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<DecisionModel> decisionsList;

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        decisionsList = fileReader.readDataFromFile();
        startProgram();
    }

    private static void startProgram() {
        boolean isProgramRunningFlag = true;
        while(isProgramRunningFlag) {
            System.out.println("Wybierz kryterium:\n1)Kryterium Walda\n2)Kryterium optymistyczne\n" +
                    "3)Kryterium Hurwicza\n4)Kryterium Bayes-Laplace'a\n5)Kryterium Savage'a\n0)Wyjście");

            int choosenCriterion = scanner.nextInt();
            AbstractCriterion criterion = null;
            switch(choosenCriterion) {
                case 1:
                    criterion = new WaldAbstractCriterion();
                    break;

                case 2:
                    criterion = new OptimisticAbstractCriterion();
                    break;

                case 3:
                    criterion = new HurwitzAbstractCriterion();
                    break;
                case 4:
                    criterion = new BayesLaplaceAbstractCriterion();
                    break;

                case 5:
                    criterion = new SavageAbstractCriterion();
                    break;

                case 0:
                    isProgramRunningFlag = false;
                    break;
            }

            criterion.makeDecision(decisionsList);
        }
    }
}
