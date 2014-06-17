
package cmeans;

import jminhep.cluster.*;

/**
 *
 * @author DanishM
 */
public class Clusters {
    public static void main(String argv[]) {

		DataHolder data = new DataHolder("Example");

		double[] a = new double[3];
		a[0] = 27.;
		a[1] = 14.;
		a[2] = 1.;
		data.add(new DataPoint(a));
		a[0] = 30.;
		a[1] = 15.;
		a[2] = 0.;
		data.add(new DataPoint(a));
		a[0] = 30.;
		a[1] = 13.;
		a[2] = 2.;
		data.add(new DataPoint(a));
		a[0] = 29.;
		a[1] = 17.;
		a[2] = 3.;
		data.add(new DataPoint(a));
		a[0] = 26.;
		a[1] = 21.;
		a[2] = 2.;
		data.add(new DataPoint(a));
		a[0] = 90.;
		a[1] = 50.;
		a[2] = 37.;
		data.add(new DataPoint(a));
		a[0] = 92.;
		a[1] = 61.;
		a[2] = 40.;
		data.add(new DataPoint(a));
		a[0] = 85.;
		a[1] = 62.;
		a[2] = 27.;
		data.add(new DataPoint(a));
		a[0] = 87.;
		a[1] = 64.;
		a[2] = 34.;
		data.add(new DataPoint(a));
		a[0] = 30.;
		a[1] = 190.;
		a[2] = 83.;
		data.add(new DataPoint(a));
		a[0] = 25.;
		a[1] = 187.;
		a[2] = 90.;
		data.add(new DataPoint(a));
		a[0] = 19.;
		a[1] = 201;
		a[2] = 89.;
		data.add(new DataPoint(a));
		a[0] = 21.;
		a[1] = 192.;
		a[2] = 97.;
		data.add(new DataPoint(a));

		System.out.println("Dimension=" + data.getDimention());
		System.out.println("No rows=" + data.getSize());

// check loaded data (print!)
		data.print();

		Partition pat = new Partition(data);

// set No clusters, precision, fuzziness (dummy if non-applicable),
// max number of iterations
		pat.set(3, 0.001, 1.7, 1000);

// probability for membership (only for Fuzzy algorithm)
                pat.setProbab(0.68);

// define types of cluster analysis
		int[] mode = new int[8];
		mode[0] = 111;
		mode[1] = 112;
		mode[2] = 113;
		mode[3] = 114;
		mode[4] = 121;
		mode[5] = 122;
		mode[6] = 131;
		mode[7] = 132;
// run over all clustering modes 
		for (int i = 0; i < mode.length; i++) {
			pat.run(mode[i]);
			System.out.println("\nalgorithm: " + pat.getName());
			System.out.println("Compactness: " + pat.getCompactness());
			System.out.println("No of final clusters: " + pat.getNclusters());
			DataHolder Centers = pat.getCenters();
			System.out.println("Positions of centers: ");
			Centers.print();
			
// show cluster association
		    	for (int m = 0; m < data.getSize(); m++) {
				 DataPoint dp = data.getRaw(m);
			    	int k = dp.getClusterNumber();
			    	System.out.println("point="+m+" associated with="+k);
		    	}
		    	
		    	
			// applicable for not every clustering
			// dataHolder Seeds = pat.getSeeds();
			// System.out.println("Positions of seeds: ");
			// Seeds.Print();
		}

	} 
}
