package main;

import java.util.ArrayList;

public class Recurssion {
	ArrayList<Antenna>Antennas=new ArrayList<>();
	ArrayList<Building>Buildings=new ArrayList<>();
	int w,h,n,m,r,score_p=-1;
	
	
	ArrayList<ArrayList<Cella>>Citta=new ArrayList<>();
	ArrayList<ArrayList<Cella>>Soluzione=new ArrayList<>();
	ArrayList<Antenna>Antennas_soluzione=new ArrayList<>();

	int score_tot;
	boolean reward;
	public Recurssion(ArrayList<Antenna> antennas, ArrayList<Building> buildings, int w, int h, int n, int m, int r) {
		super();
		Antennas = antennas;
		Buildings = buildings;
		this.w = w;
		this.h = h;
		this.n = n;
		this.m = m;
		this.r = r;
		
		for(int i=0;i<h;i++) {
			ArrayList<Cella>tmp=new ArrayList<>();
			for(int j=0;j<w;j++) {
				Cella t=new Cella(i,j);
				tmp.add(t);
			}
			Citta.add(tmp);
		}
		
		for(Building x : Buildings)
			Citta.get(x.getY()).get(x.getX()).setB(x);
	}
	
	void print(ArrayList<ArrayList<Cella>> Citta) {
		for(ArrayList<Cella> x : Citta) {
			String s=new String();
			for(Cella i:x) {
				if(i.is_available())
					s+=" - ";
				if(i.is_Building()&&!i.is_Antenna())
					s+=" B ";
				if(i.is_Antenna()&&!i.is_Building())
					s+=" A ";
				if(i.is_Antenna()&&i.is_Building())
					s+=" Z ";
			}
			System.out.println(s);
		}
		System.out.println("\n\n");
	
	}
	
	void DO(int pos_a,int i_a) {
		if(pos_a>=Antennas.size() || i_a >= Buildings.size()) {
			ArrayList<ArrayList<Cella>> tmp=this.Soluzione();
			int score=this.calcolaScore(tmp);
			if(score>this.score_p) {
				Antennas_soluzione.removeAll(Antennas_soluzione);
				this.score_p=score;
				this.Soluzione=this.Soluzione();
				
				for(Antenna a : Antennas) {
					Antenna t=new Antenna(a.getRange(),a.getSpeed());
					t.setX(a.getX());t.setY(a.getY());
					Antennas_soluzione.add(t);
					}
			}
			return;
		}
		
		for(Antenna a :Antennas) {
			if(!a.isPreso()) {
				a.setPreso(true);
				for(Building b: Buildings) {
					if(!b.isPreso_b()) {
						b.setPreso_b(true);
						a.setPosition(b.getX()+a.getVarX(), b.getY()+a.getVarY());
						while(a.getNext()!=-1) {
							this.DO(pos_a+1,i_a+1);
							if(b.getX()+a.getVarX()<w&&b.getY()+a.getVarY()<h&&b.getX()+a.getVarX()>=0&&b.getY()+a.getVarY()>=0)
								a.setPosition(b.getX()+a.getVarX(), b.getY()+a.getVarY());
						}
						b.setPreso_b(false);
					}
				}
				a.setPreso(false);
			}
		}
		
		return;
	}
	
	public ArrayList<ArrayList<Cella>> copiaCitta() {
		ArrayList<ArrayList<Cella>>Citta2=new ArrayList<>();
		for(ArrayList<Cella> t:Citta) {
			ArrayList<Cella> pippo=new ArrayList<>();
			for(Cella c:t) {
				Cella tmp= new Cella(c.x,c.y);
				tmp.setA(c.getA());
				tmp.setB(c.getB());
				pippo.add(tmp);
			}
			Citta2.add(pippo);
		}
		return Citta2;
		
	}
	
	public void printSoluzione() {
		ArrayList<ArrayList<Cella>>Citta2=this.copiaCitta();
		for(Antenna x : Antennas) {
			Citta2.get(x.getY()).get(x.getX()).setA(x);
		}
		this.print(Citta2);
	}
	public ArrayList<ArrayList<Cella>> Soluzione() {
		ArrayList<ArrayList<Cella>>Citta2=this.copiaCitta();
		for(Antenna x : Antennas) {
			Citta2.get(x.getY()).get(x.getX()).setA(x);
		}
		return Citta2;
	}
	
	public int calcolaScore(ArrayList<ArrayList<Cella>> S) {
		int distanza,score_b=0;
		boolean flag=false;
		
		for(Building b: Buildings) {
			for(Antenna a: Antennas) {
				distanza=Math.abs(b.getX()-a.getX())+Math.abs(b.getY()-a.getY());
				if(distanza<b.getDistanza()) {
					if(a.getRange()>=distanza) {
						b.setDistanza(distanza);
						b.setA(a);
					}
				}
			}
			if(b.getDistanza()<100000)
				score_b+=((b.connection_speed*b.getA().speed)-b.latency_weight*b.getDistanza());
			else 
				flag=true;
		}
		if(!flag)
			score_b=score_b+r;
		
		return score_b;
	}
	
	public Antenna CopiaAntenna(Antenna b) {
		Antenna a=new Antenna(b.range,b.speed);
		a.setX(b.getX());
		a.setY(b.getY());
		return a;
	}
	
}

