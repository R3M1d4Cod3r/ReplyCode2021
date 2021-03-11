package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = null;
		try {
			reader= new BufferedReader(new FileReader("data_scenarios_a_example.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found 404");
			System.exit(-1);
		}
		String[] values_map=reader.readLine().split(" ");
		int w= Integer.parseInt(values_map[0]);
		int h= Integer.parseInt(values_map[1]);
		
		String[] values_map1=reader.readLine().split(" ");
		int n= Integer.parseInt(values_map1[0]);
		int m= Integer.parseInt(values_map1[1]);
		int r= Integer.parseInt(values_map1[2]);
		
		//Building
		ArrayList<Building>Buildings=new ArrayList<>();
		for(int i=0;i<n;i++) {
			String[] values_Buildings=reader.readLine().split(" ");
			int x= Integer.parseInt(values_Buildings[0]);
			int y= Integer.parseInt(values_Buildings[1]);
			int l= Integer.parseInt(values_Buildings[2]);
			int c= Integer.parseInt(values_Buildings[3]);
			Building tmp =new Building(x,y,l,c);
			Buildings.add(tmp);
		}
		Buildings.stream().forEach(e->e.print());
		
		//Antenne
		ArrayList<Antenna>Antennas=new ArrayList<>();
		for(int i=0;i<m;i++) {
			String[] values_Antennas=reader.readLine().split(" ");
			int r1= Integer.parseInt(values_Antennas[0]);
			int c= Integer.parseInt(values_Antennas[1]);
			Antenna tmp =new Antenna(r1,c);
			Antennas.add(tmp);
		}
		Antennas.stream().forEach(e->e.print());
		
		Recurssion test= new Recurssion(Antennas,Buildings,w,h,n,m,r);
		test.print(test.Citta);
		test.DO(0, 0);
		System.out.println(test.score_p);
		test.print(test.Soluzione);
		test.Antennas_soluzione.stream().forEach(e->System.out.println(e.getX()+" "+e.getY()+" - "+e.getRange()));
		

		

	}
}