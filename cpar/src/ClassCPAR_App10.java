/* -------------------------------------------------------------------------- */
/*                                                                            */
/*  CPAR (CLASSIFICATION BASED ON PREDICTIVE ASSOCIATION RULES) APPLICATION   */
/*                                                                            */
/*                             Frans Coenen                                   */
/*                                                                            */
/*                        Wednesday 11 February 2004                          */
/*                                                                            */
/*                      Department of Computer Science                        */
/*                        The University of Liverpool                         */
/*                                                                            */
/* -------------------------------------------------------------------------- */

import java.io.*;

/* Classification application the CPAR (Classification based on Predictive 
Association Rules) algorithm proposed by Xiaoxin Yin and Jiawei Han.

Compile using:

javac ClassCPAR_App10.java

Run using javaARM.exe, Example:

java ClassCPAR_App10 -FpimaIndians.D42.N768.C2.num -N2

(-F filename, -N number of classifiers).              */

public class ClassCPAR_App10 {

    // ------------------- FIELDS ------------------------

    // None

    // ---------------- CONSTRUCTORS ---------------------

    // None

    // ------------------ METHODS ------------------------

    public static void main(String[] args) throws IOException {

	// Create instance of class ClassificationCPAR	
	CPAR_CARgen newClassification = new CPAR_CARgen(args);
				
	// Read data to be mined from file (method in AssocRuleMining class)
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
