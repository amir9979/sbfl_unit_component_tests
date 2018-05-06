package charm;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import charm.AlgoEclat;
import charm.TransactionDatabase;


/**
 * Example of how to use dECLAT algorithm from the source code.
 * @author Philippe Fournier-Viger - 2009
 */
public class MainTestDEclat_saveToMemory {

	public static void main(String [] arg) throws IOException{
		// Loading the transaction database
		TransactionDatabase database = new TransactionDatabase();
		try {
			database.loadFile(fileToPath("contextPasquier99.txt"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		context.printContext();
		
		// Applying the dECLAT algorithm
		AlgoEclat algo = new AlgoEclat();
		charm.itemset_array_integers_with_tids.Itemsets patterns = algo.runAlgorithm(null, database, 0.4, true);
		// NOTE 0: We use "null" as output file path, because in this
		// example, we want to save the result to memory instead of
		// saving to a file
		
		// NOTE 1: if you  use "true" in the line above, CHARM will use
		// a triangular matrix  for counting support of itemsets of size 2.
		// For some datasets it should make the algorithm faster.
		
		patterns.printItemsets(database.size());
		algo.printStats();

	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestDEclat_saveToMemory.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
