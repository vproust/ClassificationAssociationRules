import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
 
public class ReadCVS{
 
  public static void main(String[] args) {
 
	ReadCVS obj = new ReadCVS();
	obj.run();
 
  }
 
  public void run() {
 
	String csvFile = "./pineauCabernetPV.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ";";
	
	// Associative array to store the relation : moleculeName <-> number
	Map<String, String> relation = new HashMap<String, String>();
	Map<String, String> produitsRelation = new HashMap<String, String>();
 
	try {
		// On considère qu'il y a moins de 150 produits
		String[] produitsPourCBA = new String[1300];		
		br = new BufferedReader(new FileReader(csvFile));
		int numeroMolecule =1;
		String precProduit = new String();
		int numeroProduit = 70;
		PrintWriter writer = new PrintWriter("output.num", "UTF-8");
		
		String headerLine = br.readLine();
		String[] moleculesNames = headerLine.split(cvsSplitBy);
		
		// For each molecules in header, link molecule name to number.
		for(int i=0;i< moleculesNames.length;i++){
			relation.put(Integer.toString(i+1),moleculesNames[i]);
			//System.out.println(relation.get(Integer.toString(i+1)));
			//System.out.println(Integer.toString(i+1)+" "+moleculesNames[i]);
		}
		
		while ((line = br.readLine()) != null) {
		     // use comma as separator
			String[] molecules = line.split(cvsSplitBy);
			System.out.println(numeroMolecule);
			produitsPourCBA[numeroMolecule] = new String();
			
			for(int i=0;i< molecules.length;i++){
				if(molecules[i].equals("1")){
					produitsPourCBA[numeroMolecule] = produitsPourCBA[numeroMolecule] +(i+1)+" " ;
				}
				if(i==molecules.length-1){
					if(!molecules[i].equals(precProduit)){
						numeroProduit++;
						produitsRelation.put(Integer.toString(numeroProduit),molecules[i]);	
						//System.out.println(Integer.toString(numeroProduit) + "" +molecules[i]);
						precProduit=molecules[i];
					}
					produitsPourCBA[numeroMolecule] = produitsPourCBA[numeroMolecule]+numeroProduit;
					writer.println(produitsPourCBA[numeroMolecule]);
				}
			}
			numeroMolecule++;
		}
		writer.close();
		File file = new File("relation.txt");
        FileOutputStream f = new FileOutputStream(file);
        ObjectOutputStream s = new ObjectOutputStream(f);
        s.writeObject(relation);
        s.close();
        
        File file2 = new File("produitRelations.txt");
        FileOutputStream f2 = new FileOutputStream(file2);
        ObjectOutputStream s2 = new ObjectOutputStream(f2);
        s2.writeObject(produitsRelation);
        s2.close();
        
        File file3 = new File("produitRelations.txt");
        FileInputStream f3 = new FileInputStream(file3);
        ObjectInputStream s3 = new ObjectInputStream(f3);

        
        
        try {
			HashMap<String, Object> fileObj2 = (HashMap<String, Object>) s3.readObject();
			System.out.println("produit "+fileObj2.get("72"));			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
        s3.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	System.out.println("Done");
  }
 
}