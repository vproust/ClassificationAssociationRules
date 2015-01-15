/* -------------------------------------------------------------------------- */
/*                                                                            */
/*             FOIL (FIRST ORDER INDUCTIVE LEARNER) APPLICATION               */
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

javac ClassFOIL_App.java

Run using javaARM.exe, Example:

java ClassFOIL_App -FpimaIndians.D42.N768.C2.num -N2

(-F filename, -N number of classifiers).              */


public class ClassFOIL_App {

    // ------------------- FIELDS ------------------------

    // None

    // ---------------- CONSTRUCTORS ---------------------

    // None

    // ------------------ METHODS ------------------------

    public static void main(String[] args) throws IOException {

	// Create instance of class ClassificationFOIL	
	FOIL_CARgen newClassification = new FOIL_CARgen(args);
				
	// Read data to be mined from file (method in AssocRuleMining class)
	newClassification.inputDataSet();
	newClassification.outputDataArraySize();
	
	// Create training and test data sets (method in ClassificationAprioriT class)
	// assuming a 50:50 split
        newClassification.createTrainingAndTestDataSets();
	
	// Mine data and generate CARs
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
