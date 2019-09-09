package troubleShootSearch.driver;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.Results;
import troubleShootSearch.visitorPattern.DSeGate;
import troubleShootSearch.visitorPattern.ExactMatch;
import troubleShootSearch.visitorPattern.NaiveStemmingMatch;
import troubleShootSearch.visitorPattern.SemanticMatch;

/*
 * @author Munjal Shah
 */
public class Driver {

    public static void main(String[] args) {

        if (args.length <= 0 || args[0] == null || args[1] == null || args[2] == null || args[3] == null || args[4] == null || args[5] == null || args[6] == null || args[7] == null) {
            System.out.println("Please give input file, output file, debug value, synonyms & technical sentences");
            System.exit(0);
        }

        try {
            MyLogger.writeMessage("Setting debug level to " + args[7], MyLogger.DebugLevel.Driver);
            MyLogger.debugValue(Integer.parseInt(args[7]));
        } catch (Exception e) {
            MyLogger.debugValue(555);
        }

        String outputFile = args[6];
        //String outputFile = "output.txt";

        String productA = args[1];
        String productB = args[2];
        String productC = args[3];
        String productD = args[4];
        //String productA = "product A.txt";
        //String productB = "product B.txt";
        //String productC = "product C.txt";
        //String productD = "product D.txt";

        String meanings = args[5];
        //String meanings = "synnonyms.txt";

        String userInputs = args[0];
        //String userInputs = "userInputs.txt"; 

        FileProcessor.checkFileIsEmpty(outputFile);

        DSeGate dSeGate = new DSeGate();
        Results results = new Results();
        results.outputFile = outputFile;

        List<String> products = new LinkedList<>();
        products.add(productA);
        products.add(productB);
        products.add(productC);
        products.add(productD);

        List<String> keywords = FileProcessor.readFile(userInputs);
        List<String> synonyms = FileProcessor.readFile(meanings);
        Map<String, String> synonym = new HashMap<>();

        for (String str : synonyms) {
            String meaning[] = str.split(":");
            synonym.put(meaning[0], meaning[1]);
        }

        for (String product : products) {
            List<String> technicalSentences = FileProcessor.readFile(product);
            MyLogger.writeMessage("Calculating for " + product, MyLogger.DebugLevel.Driver);
            results.writeToFile("For " + product);
            results.writeToStdout("For " + product);

            for (String keyword : keywords) {
                ExactMatch exactMatch = new ExactMatch(keyword, technicalSentences);
                NaiveStemmingMatch naiveStemmingMatch = new NaiveStemmingMatch(keyword, technicalSentences);
                SemanticMatch semanticMatch = new SemanticMatch(keyword, technicalSentences, synonym);

                results.writeToFile("keyword: " + keyword);
                results.writeToStdout("keyword: " + keyword);
                if (!exactMatch.accept(dSeGate).isEmpty()) {
                    MyLogger.writeMessage("Found Excat Match in " + product, MyLogger.DebugLevel.Driver);
                    results.writeToFile("Excat Match: " + exactMatch.accept(dSeGate));
                    results.writeToStdout("Excat Match: " + exactMatch.accept(dSeGate));
                }

                if (!naiveStemmingMatch.accept(dSeGate).isEmpty()) {
                    MyLogger.writeMessage("Found Naive Stemming Match in " + product, MyLogger.DebugLevel.Driver);
                    results.writeToFile("Naive Stemming Match: " + naiveStemmingMatch.accept(dSeGate));
                    results.writeToStdout("Naive Stemming Match: " + naiveStemmingMatch.accept(dSeGate));
                }

                if (!semanticMatch.accept(dSeGate).isEmpty()) {
                    MyLogger.writeMessage("Found Semantic Match in " + product, MyLogger.DebugLevel.Driver);
                    results.writeToFile("Semantic Match: " + semanticMatch.accept(dSeGate));
                    results.writeToStdout("Semantic Match: " + semanticMatch.accept(dSeGate));
                }
            }
            results.writeToFile("\n");
            results.writeToStdout("\n");
        }
    }
}
