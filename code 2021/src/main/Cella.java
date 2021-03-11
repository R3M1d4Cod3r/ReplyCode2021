package main;

public class Cella {
	public Building b;
	public Antenna a;
	int x;
	int y;
	public Cella(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Cella(Building b, int x, int y) {
		super();
		this.b = b;
		this.x = x;
		this.y = y;
	}
	public Cella(Antenna a, int x, int y) {
		super();
		this.a = a;
		this.x = x;
		this.y = y;
	}
	public Building getB() {
		return b;
	}
	public void setB(Building b) {
		this.b = b;
	}
	public Antenna getA() {
		return a;
	}
	public void setA(Antenna a) {
		this.a = a;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean is_available() {
		if(a==null && b==null)
			return true;
		return false;
	}
	public boolean is_Antenna() {
		if(a!=null)
			return true;
		return false;
	}
	public boolean is_Building() {
		if(b!=null)
			return true;
		return false;
	}
}
