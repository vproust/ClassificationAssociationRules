/* -------------------------------------------------------------------------- */
/*                                                                            */
/*             PRM (PREDICTIVE RULE MINING) APPLICATION WITH TCV              */
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

/* Classification application the PRM (First Order Inductive Learner) algorithm
proposed by Xiaoxin Yin and Jiawei Han.

Compile using:

javac ClassPRM_App10.java

Run using javaARM.exe, Example:

java ClassPRM_App10 -FpimaIndians.D42.N768.C2.num -N2

(-F filename, -N number of classifiers).              */


public class ClassPRM_App10 {

    // ------------------- FIELDS ------------------------

    // None

    // ---------------- CONSTRUCTORS ---------------------

    // None

    // ------------------ METHODS ------------------------

    public static void main(String[] args) throws IOException {

	// Create instance of class ClassificationPRM	
	PRM_CARgen newClassification = new PRM_CARgen(args);
				
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
