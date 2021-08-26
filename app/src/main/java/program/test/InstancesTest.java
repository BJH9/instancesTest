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
	
	private int[][] v; //뒤집힌 instances
	private int[] b;//sliced instance
	private int[] ob;//original sliced instance
	private int[][] c; //위치정보 저장
	private int[] violationNumber;//instance별 violation 개수
	private int[] oViolationNumber;//original instance별 violation 개수
	
	
	private int median;
	private int vMedian;
	private int k;
	private int[] kNumber;
	int p;
	
	public static void main(String[] args) {//main
		InstancesTest runner = new InstancesTest();
		runner.run(args);
	}
	
	public static Instances loadArff(String path){//instance 데이터 수집
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
		
		
		ins = loadArff(args[0]);//ins에 할당
		
		in = ins.get(0);//첫 줄 instance 할당
		column = in.numAttributes();//열의 개수
		row = ins.size();//행의 개수
		
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
		
		v = new int[column][row];// 행과 열 뒤집은 배열 거 여기 저장
		b = new int[row];// 뒤집힌 배열, 1행 여기 저장
		
		for(int i = 0; i < column - 1; i++) {
			System.out.println("");
			for(int j = 0; j < row - 1; j++) {
				in = ins.get(j);
				v[i][j] = (int)in.valueSparse(i);
				
					System.out.print(v[i][j] + ",");//행과 열 뒤집음
				
		}
		}
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("b");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		for(int j = 0; j < column - 1; j++) {//violation의 위치를 구한다.
		
		System.out.println("***   "+ j +  "번째 metric   ***");
		for(int i = 0; i < row - 1; i++) {
		b[i] = v[j][i];
		System.out.print(b[i] + ",");// 뒤집힌 첫번째 instance 저장
		}
		
		System.out.println("");
		
		ob = new int[row];//초기화
		k = 0;
		c = new int[column][row];
		
		for(int i = 0; i < row - 1; i++)
			ob[i] = b[i];//정렬되지 않은 기존의 배열 저장
		
		Arrays.sort(b); //정렬
		
		System.out.println("정렬된 metrices");
		for(int i = 0; i < row - 1; i++){
			System.out.print(b[i] + ",");
		}
		
		System.out.println("");
		
		median = b[row / 2]; //median
		System.out.println("median 값: " + median);
		
		for(int i = 0; i < row - 1; i++) {//violation 위치
			if(ob[i] > median) {
				c[j][k] = i;
				violationNumber[i]++;
				k++;//
			}
		}
		
		System.out.println(j + " 번째 metric violation 위치");
		for(int i =0; i < k; i++) {
			System.out.print(c[j][i] + ",");
		}
		System.out.println("");
		System.out.println(j + " 번째 metric violation의 개수: " + k);
		System.out.println("");
		System.out.println("");
		
		kNumber[p] = k;
		p++;
		
		}
		
		System.out.println("");
		System.out.println("각각의 metric의 violation 개수");
		
		for(int i = 0; i < p; i++) {
			System.out.print(kNumber[i] + ",");
			violationNumber[kNumber[i]]++;
		}
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("instance별 violation개수");//instance별 violation개수
		for(int i = 0; i < row - 1; i++) {
			System.out.print(violationNumber[i] + ",");
		}
		
		for(int i = 0; i < row - 1; i++) {
			oViolationNumber[i] = violationNumber[i];
		}
		System.out.println("");
		
		Arrays.sort(violationNumber);
		System.out.println("");
		System.out.println("sort된 violationNumber");//sort된 violationNumber
		for(int i = 0; i < row; i++) {
			System.out.print(violationNumber[i] + ",");
		}
		System.out.println("");
		System.out.println("");
		
		System.out.println("violation median 값");
		vMedian = violationNumber[row/2];
		System.out.println(vMedian);
		
		for(int i = 0; i < row - 1; i++) {
			violationNumber[i]
		}
		
	}

}
