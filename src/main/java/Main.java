public class Main {

    public static void main(String [] args)
    {
       GCIDatasetHandler gci = new GCIDatasetHandler("/Users/Patrick/Dropbox/Science/midas/20/datasets/GCI/GCI_Dataset_2007-2017_woh.csv");
       gci.transformToMachineReadability();
    }

}
