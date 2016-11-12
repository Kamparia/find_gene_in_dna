/**
 * Created by Somide Olaoye Anthony on 11/12/2016.
 */

public class main {
    public static void main(String[] arg) {
        String dna = "ATGATCGCTAATGCTTAAGCTATG";
        findgene(dna);
    }

    private static void findgene(String dna) {
        System.out.println("DNA strand is: " + dna);
        int count = 1;
        String valid = "False";

        //start codon is "ATG"
        // stop codon can either start with "TAA" or "TGA" or "TAG"

        String startcodon = "ATG";
        String[] stopcodon = {"TAA", "TAG", "TGA"};

        for (String temp : stopcodon) {
            findstopcodon(dna, count, valid, startcodon, temp);
        }
    }

    private static void findstopcodon(String dna, int count, String valid, String startcodon, String stopcodon) {
        //Get index position of the start codon
        int startIndex = dna.indexOf(startcodon);
        //Find TAA starting from startIndex + 3 and call it currIndex
        int currIndex = dna.indexOf(stopcodon, startIndex+3);
        //Get index position of the stop codon after the start codon

        while (valid == "False") {
            if ((currIndex - startIndex) % 3 == 0) {
                count = count + 1;
                String gene = dna.substring(startIndex, currIndex+3);
                System.out.println("Gene is: "+ gene);
                System.out.println("Valid stop codon is " + stopcodon);
                System.out.println("The Gene was a valid gene and stop codon was found at the " + count + " ocurence.");
                valid = "True";
            }else{
                currIndex = dna.indexOf(stopcodon, currIndex + 1);

                valid = "False";
            }
        }
    }


}
