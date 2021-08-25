package program.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import weka.core.Instances;
import weka.core.Instance;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.Arrays;

public class InstancesTest {
	private Instances ins;
	private Instance in;
	
	private int column;
	private int row;
	
	private int[][] v;
	double int[] b;
	
	public static void main(String[] args) {
		InstancesTest runner = new InstancesTest();
		runner.run(args);
	}
	
	public static Instances loadArff(String path){
		Instances instances=null;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(path));
			instances = new Instances(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		instances.setClassIndex(instances.numAttributes()-1);
		System.out.println(instances);
		return instances;
	}
	
	private void run(String[] args) {
		
		ins = loadArff(args[0]);
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		in = ins.get(0);
		column = in.numAttributes();
		row = ins.size();
		System.out.println(row);
		
		v = new int[column][row];
		
		for(int i = 0; i < column-1; i++) {
			System.out.println("");
			for(int j = 0; j < row-1; j++) {
				in = ins.get(j);
				v[i][j] = (int)in.valueSparse(i);
				
					System.out.print(v[i][j] + ",");
					
				
		}
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		for(int i = 0; i < row; i++) {
			System.out.println("");
		for(int j = 0; j < column; j++) {
			Arrays.sort(v[i][j]);
			System.out.print(v[i][j] +",");
		}
		
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println(v);
		
	}

}
