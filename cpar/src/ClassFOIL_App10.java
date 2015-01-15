/* -------------------------------------------------------------------------- */
/*                                                                            */
/*         FOIL (FIRST ORDER INDUCTIVE LEARNER) APPLICATION WITH TCV          */
/*                                                                            */
/*                             Frans Coenen                                   */
/*                                                                            */
/*                         Tuesday 3 February 2004                            */
/*                                                                            */
/*                      Department of Computer Science                        */
/*                        The University of Liverpool                         */
/*                                                                            */
/* -------------------------------------------------------------------------- */

import java.io.*;

/* Classification application the FOIL (First Order Inductive Learner) algorithm
first proposed by Ross Quinlan in 1993.

Compile using:

javac ClassFOIL_App10.java

Run using javaARM.exe, Example:

java ClassFOIL_App10 -FpimaIndians.D42.N768.C2.num -N2

(-F filename, -N number of classifiers).              */


public class ClassFOIL_App10 {

    // ------------------- FIELDS ------------------------

    // None

    // ---------------- CONSTRUCTORS ---------------------

    // None

    // ------------------ METHODS ------------------------

    public static void main(String[] args) throws IOException {

	// Create instance of class ClassificationFOIL	
	FOIL_CARgen newClassification = new FOIL_CARgen(args);
				
	// Read data to be mined from file (method in AssocRuleMining class)
	// and set numRowsInInputSet field.
	newClassification.inputDataSet();
	newClassification.outputDataArraySize();
	
	// Create tenths data sets (method in ClassificationAprioriT class)
	newClassification.createTenthsDataSets();
	
	// Mine data, produce T-tree and generate CRs
	double time1 = (double) System.currentTimeMillis();
	newClassification.commenceTCVwithOutput();
	newClassification.outputDuration(time1,
				(double) System.currentTimeMillis());
	
	// End
	System.exit(0);
	}
    }
