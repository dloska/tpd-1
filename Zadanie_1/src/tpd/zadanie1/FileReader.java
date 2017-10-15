package tpd.zadanie1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Damian Deska on 2017-10-14.
 */
public class FileReader {

    private static String FILE_NAME = "src/tpd/zadanie1/data/tabela.txt";

    public List<DecisionModel> readDataFromFile() {
        List<DecisionModel> decisionsList = new ArrayList<>();
        int investitionCost = 50;
        try {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            while ((line = br.readLine()) != null) {
                decisionsList.add(fillDecisionModel(line, investitionCost));
                investitionCost += 50;
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return decisionsList;
    }

    private DecisionModel fillDecisionModel(String line, int investitionCost) {
        DecisionModel decision = new DecisionModel();
        decision.setInvestitionCost(investitionCost);
        Arrays.stream(line.split(" ")).forEach(s -> decision.getDecisionStates().add(Float.parseFloat(s) * decision.getInvestitionCost()));

        return decision;
    }
}
