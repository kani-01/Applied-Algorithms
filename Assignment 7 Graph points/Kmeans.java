import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Nischal
 *
 */
public class Kmeans {

	/**
	 * @param args
	 */
	private static int k=2; // number of clusters given in the question
	private static double mean[][]= new double [k][k];
	private static double last[][]=new double[k][k];
	private static double[][] input = {{0,1}, {1,0}, {0.5,0.5}, {5,6}, {6,5}, {5.5,5.5}};// input given in the question
	private static ArrayList<Integer> dataSet = new ArrayList<Integer>();
	private static ArrayList<Integer> centroids  = new ArrayList<Integer>();
	private static int num_1,num_2,status;
	
	public int sampleNumber() {
		int sample=(int) (Math.random()*6);
		return sample;
	}
	public static double[][] kMeanCluster(){// Method to get the mean
		double totalX = 0,totalY = 0,totalZ = 0,totalA = 0; 
		double num, numX, numY, numZ;

		for (int i=0; i< dataSet.size(); i++){
			int element = dataSet.get(i);
			totalX += input[element][0];
			totalY += input[element][1];
		}
		numZ = totalX / (dataSet.size());
		numX = totalY / (dataSet.size());
		mean[0][0] = numZ;
		mean[0][1] = numX;
		for (int j=0; j< centroids.size(); j++) {// Calculating new centroids
			int element_1 = centroids.get(j);
			totalZ += input[element_1][0];
			totalA += input[element_1][1];
		}
		numY = totalZ / (centroids.size());
		numZ = totalA / (centroids.size());
		mean[1][0] = numY;
		mean[1][1] = numZ;
		return mean;
	}
	public double euclideanDistance(double[] temp,double[] element_2){ // Calculating Euclidean distance.
		double distance;
		double x1, y1, x2, y2;

		x1 = temp[0];
		y1 = temp[1];
		x2 = element_2[0];
		y2 = element_2[1];
		distance = Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1,2));
		return distance;
	}
	public int mean(double[] element_2){
		kMeanCluster();
		double minimumMean = euclideanDistance(mean[0],element_2);
		int array=0;
		for(int j=0;j<mean[0].length;j++){
			double temp = euclideanDistance(mean[j],element_2);
			if (temp<minimumMean){
				minimumMean = temp;
				array = j;
			}                         
		}
		return array;
	}
	public void addData(){// method to add new data,one at a time
		for (int i=0; i<input.length ; i++){       
			int array = mean(input[i]);
			if(array==0 && i!=num_1 && i!=num_2){
				dataSet.add(i);
			}
			else if(array==1 && i!=num_1 && i!=num_2){
				centroids.add(i);
			}
		}
	}
	public void centroidsShift(){// method to keep shifting centroids until equilibrium occurs.
		for (int i=0; i< input.length; i++){
			int arr = mean(input[i]);
			if(arr==0){
				if(dataSet.contains(i)){
					dataSet.remove(dataSet.indexOf(i));
				}
				if(centroids.contains(i)){
					centroids.remove(centroids.indexOf(i));
				}
				dataSet.add(i);
			}
			else if(arr==1){
				if(dataSet.contains(i)){
					dataSet.remove(dataSet.indexOf(i));
				}
				if(centroids.contains(i)){
					centroids.remove(centroids.indexOf(i));
				}
				centroids.add(i);
			}
		}
	}
	public static int status(double[][] last){
		mean=kMeanCluster();
		for(int i=0;i<mean.length;i++){
			for(int j=0;j<mean[0].length;j++){
				if(mean[i][j]!=last[i][j]){
					return status=0;
				}
			}
		}
		status=1;
		return status;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Kmeans k = new Kmeans();
		num_1 = k.sampleNumber();
		dataSet.add(num_1);
		System.out.print("1st Array is: ");
		for(int i=0;i<input[num_1].length;i++){
			System.out.print(input[num_1][i] + " ");
		}
		System.out.println();
		num_2 = k.sampleNumber();
		while(num_2==num_1)
		{
			num_2 = k.sampleNumber();
		}
		centroids.add(num_2);
		System.out.print("2nd Array is: ");
		for(int i=0;i<input[num_2].length;i++){
			System.out.print(input[num_2][i] + " ");
		}
		System.out.println();
		kMeanCluster();
		System.out.println();
		k.addData();
		while(status!=1){
			last = kMeanCluster();
			k.centroidsShift();
			status = status(last);
			System.out.println("1st Array is "+dataSet);
			System.out.println("2nd Array is "+centroids);
			System.out.println();
		}
		System.out.println("1st cluster is: "+dataSet);
		System.out.println("Points displayed in 1st cluster: ");
		for(int i=0;i<dataSet.size();i++){
			int x = dataSet.get(i);
			System.out.print(input[x][0] + " ");
			System.out.print(input[x][1] + " ");
			System.out.println();
		}
		System.out.println("2nd cluster is: "+centroids);   
		System.out.println("Points displayed in 2nd cluster: ");
		for(int i=0;i<centroids.size();i++){
			int y = centroids.get(i);
			System.out.print(input[y][0] + " ");
			System.out.print(input[y][1] + " ");
			System.out.println();
		}
	}

}
