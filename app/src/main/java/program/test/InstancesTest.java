package program.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import weka.core.Instances;

public class InstancesTest {

	private String path;
	
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
		System.out.println(instances);
		return instances;
	}
	
	private void run(String[] args) {
	loadArff(args[0]);
	
	
	}

}
