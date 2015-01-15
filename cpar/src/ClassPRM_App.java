/* -------------------------------------------------------------------------- */
/*                                                                            */
/*                 PRM (PREDICTIVE RULE MINING) APPLICATION                   */
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

javac ClassPRM_App.java

Run using javaARM.exe, Example:

java ClassPRM_App -FpimaIndians.D42.N768.C2.num -N2

(-F filename, -N number of classifiers).              */


public class ClassPRM_App {

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
	
	// Create training data set (method in ClassificationAprioriT class)
	// assuming a 50:50 split
        newClassification.createTrainingAndTestDataSets();
	
	// Mine data, produce T-tree and generate CRs
        double time1 = (double) System.currentTimeMillis();
	double accuracy = newClassification.startClassification();
	newClassification.outputDuration(time1,
				(double) System.currentTimeMillis());
	
	// Output
	System.out.println("Accuracy = " + accuracy);
	newClassification.getCurrentRuleListObject().outputNumRules();
	newClassification.getCurrentRuleListObject().outputRules();
	
	// End
	System.exit(0);
	}
    }
