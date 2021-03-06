package uff.ic.swlab.dataset_ertd.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class MoviePropertyRelevanceScore extends HashMap<String, Double> {

    public static Config conf = Config.getInsatnce();

    public MoviePropertyRelevanceScore() {
        String linha;
        File f = new File(conf.rawDataRootDir() + "/movie_property_relevance_scores/properties.txt");
        try (InputStream in = new FileInputStream(f);) {
            Scanner sc = new Scanner(in);
            int count = 0;
            while (sc.hasNext()) {
                linha = sc.nextLine();
                linha = linha.replace('\u00A0', '\0').replace('\u00C2', '\0');
                linha = linha.replaceAll("  ", " ").replaceAll(" ", "\t").replaceAll("\t\t", "\t");
                count++;
                if (count > 1 && linha != null && !linha.equals("")) {
                    String[] cols = linha.split("\t");
                    if (cols.length == 2) {
                        cols[0] = cols[0].trim();
                        put(cols[0], Double.valueOf(cols[1]));
                    } else
                        System.out.println(String.format("Error: class -> %1s, line -> %1s.", "MoviePropertyRelevanceScore", linha));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MoviePropertyRelevanceScore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MoviePropertyRelevanceScore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double getScore(String label) {
        return get(label);
    }
}
