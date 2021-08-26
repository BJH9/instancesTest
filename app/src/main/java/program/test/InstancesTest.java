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

import java.util.ArrayList;

public class InstancesTest {
	private String path;
	private Instances ins;
	private Instance in;
	
	private int column;
	private int row;
	
	private int[][] v; //������ instances
	private int[] b;//sliced instance
	private int[] ob;//original sliced instance
	private int[][] c; //��ġ���� ����
	private int[] violationNumber;//instance�� violation ����
	private int[] oViolationNumber;//original instance�� violation ����
	
	
	private int median;
	private int vMedian;
	private int k;
	private int[] kNumber;
	int p;
	
	public static void main(String[] args) {//main
		InstancesTest runner = new InstancesTest();
		runner.run(args);
	}
	
	public static Instances loadArff(String path){//instance ������ ����
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
		
		
		ins = loadArff(args[0]);//ins�� �Ҵ�
		
		in = ins.get(0);//ù �� instance �Ҵ�
		column = in.numAttributes();//���� ����
		row = ins.size();//���� ����
		
		violationNumber = new int[row];
		oViolationNumber = new int[row];
		
		for(int i = 0; i < row; i++) {
			violationNumber[i] = 0;
		}
		
		kNumber = new int[row / 2];
		
		System.out.println("");
		System.out.println("");
		System.out.println("a");		
		System.out.println("");
		System.out.println("");
		
		
		
		System.out.println("");
		System.out.println("");
		System.out.println(row);
		System.out.println("");
		System.out.println("");
		
		v = new int[column][row];// ��� �� ������ �迭 �� ���� ����
		b = new int[row];// ������ �迭, 1�� ���� ����
		
		for(int i = 0; i < column - 1; i++) {
			System.out.println("");
			for(int j = 0; j < row - 1; j++) {
				in = ins.get(j);
				v[i][j] = (int)in.valueSparse(i);
				
					System.out.print(v[i][j] + ",");//��� �� ������
				
		}
		}
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("b");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		for(int j = 0; j < column - 1; j++) {//violation�� ��ġ�� ���Ѵ�.
		
		System.out.println("***   "+ j +  "��° metric   ***");
		for(int i = 0; i < row - 1; i++) {
		b[i] = v[j][i];
		System.out.print(b[i] + ",");// ������ ù��° instance ����
		}
		
		System.out.println("");
		
		ob = new int[row];//�ʱ�ȭ
		k = 0;
		c = new int[column][row];
		
		for(int i = 0; i < row - 1; i++)
			ob[i] = b[i];//���ĵ��� ���� ������ �迭 ����
		
		Arrays.sort(b); //����
		
		System.out.println("���ĵ� metrices");
		for(int i = 0; i < row - 1; i++){
			System.out.print(b[i] + ",");
		}
		
		System.out.println("");
		
		median = b[row / 2]; //median
		System.out.println("median ��: " + median);
		
		for(int i = 0; i < row - 1; i++) {//violation ��ġ
			if(ob[i] > median) {
				c[j][k] = i;
				violationNumber[i]++;
				k++;//
			}
		}
		
		System.out.println(j + " ��° metric violation ��ġ");
		for(int i =0; i < k; i++) {
			System.out.print(c[j][i] + ",");
		}
		System.out.println("");
		System.out.println(j + " ��° metric violation�� ����: " + k);
		System.out.println("");
		System.out.println("");
		
		kNumber[p] = k;
		p++;
		
		}
		
		System.out.println("");
		System.out.println("������ metric�� violation ����");
		
		for(int i = 0; i < p; i++) {
			System.out.print(kNumber[i] + ",");
			violationNumber[kNumber[i]]++;
		}
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("instance�� violation����");//instance�� violation����
		for(int i = 0; i < row - 1; i++) {
			System.out.print(violationNumber[i] + ",");
		}
		
		for(int i = 0; i < row - 1; i++) {
			oViolationNumber[i] = violationNumber[i];
		}
		System.out.println("");
		
		Arrays.sort(violationNumber);
		System.out.println("");
		System.out.println("sort�� violationNumber");//sort�� violationNumber
		for(int i = 0; i < row; i++) {
			System.out.print(violationNumber[i] + ",");
		}
		System.out.println("");
		System.out.println("");
		
		System.out.println("violation median ��");
		vMedian = violationNumber[row/2];
		System.out.println(vMedian);
		
		for(int i = 0; i < row - 1; i++) {
			violationNumber[i]
		}
		
	}

}
