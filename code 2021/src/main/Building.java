package main;

public class Building {
	int x,y;
	int latency_weight;
	int connection_speed;
	boolean preso_b=false;
	int distanza =100000;
	Antenna a;
	public Antenna getA() {
		return a;
	}

	public void setA(Antenna a) {
		this.a = a;
	}

	public int getDistanza() {
		return distanza;
	}

	public void setDistanza(int distanza) {
		this.distanza = distanza;
	}

	public Building(int x,int y, int latency_weight, int connection_speed) {
		super();
		this.x=x;
		this.y=y;
		this.latency_weight = latency_weight;
		this.connection_speed = connection_speed;
	}
	
	public int getLatency_weight() {
		return latency_weight;
	}
	public void setLatency_weight(int latency_weight) {
		this.latency_weight = latency_weight;
	}
	public int getConnection_speed() {
		return connection_speed;
	}
	public void setConnection_speed(int connection_speed) {
		this.connection_speed = connection_speed;
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
	
	public void print() {
		System.out.println("x: " +x+" y: "+y+ " latency: "+latency_weight+" c_speed: "+connection_speed);
	}

	public boolean isPreso_b() {
		return preso_b;
	}

	public void setPreso_b(boolean preso_b) {
		this.preso_b = preso_b;
	}
	
}
