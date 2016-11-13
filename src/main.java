import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * Created by Somide Olaoye Anthony on 11/12/2016.
 */

public class main {

    public static void main(String[] arg) throws Exception {
        // Define the path to the text file containing the DNA string
        String path = "D:/gene_sample.txt";
        //Calls the findgene method
        findgene(readfile(path));
    }

    private static void findgene(String dna) {
        //start codon is "ATG"
        String startcodon = "ATG";
        // stop codon can either start with "TAA" or "TGA" or "TAG"
        String[] stopcodon = {"TAA", "TAG", "TGA"};
        // Declare an empty array of genes
        ArrayList genes = new ArrayList();
        // Loops trough all the elements of the stopcondon array
        for (String temp : stopcodon) {
            String result = findstopcodon(dna, startcodon, temp);
            System.out.println(result);
            genes.add(result);
        }
        int count = genes.size();
        System.out.println("Total number of Genes found: " + count);
    }

    private static String findstopcodon(String dna, String startcodon, String stopcodon) {
        //Get index position of the start codon
        int startIndex = dna.indexOf(startcodon);
        //Find TAA starting from startIndex + 3 and call it currIndex
        int currIndex = dna.indexOf(stopcodon, startIndex+3);
        //return dna.substring(startIndex, currIndex+3);
        while (currIndex != -1) {
            if ((currIndex - startIndex) % 3 == 0) {
                String gene = dna.substring(startIndex, currIndex+3);
                return gene;
            }else{
                currIndex = dna.indexOf(stopcodon, currIndex + 1);
            }
        }
        return "";
    }

    public static String readfile(String path) throws Exception{
        FileReader file =  new FileReader(path);
        BufferedReader reader = new BufferedReader(file);
        String text = "";
        String line = reader.readLine();
        while (line != null) {
            text += line;
            line = reader.readLine();
        }
        return text;
    }
}
