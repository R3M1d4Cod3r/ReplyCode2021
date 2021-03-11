package main;

public class Antenna {
	int range;
	int speed;
	boolean preso=false;
	int x=-1,y=-1;
	int var1=0,var2=0;
	int var_p=0,var_p1=0;
	int i_var=0;
	public Antenna(int range, int speed) {
		super();
		this.range = range;
		this.speed = speed;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void print() {
		System.out.println("range: "+range+" speed: "+speed);
	}
	public boolean isPreso() {
		return preso;
	}
	public void setPreso(boolean preso) {
		this.preso = preso;
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
	
	public void setPosition(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public int getVarX() {
		return var1;
	}
	public void setVarX(int var1) {
		this.var1 = var1;
	}
	public int getVarY() {
		return var2;
	}
	public void setVarY(int var2) {
		this.var2 = var2;
	}
	public int getNext() {
		
		if(var1==0&&var2==0) {
			var1+=-1;
			i_var++;
			return 1;
		}
		if(var2==-1&&var1<=0) {
			if(i_var<range) {
				var1-=2;var2+=1;
				i_var++;
				return 1;
			}
			var1=0;var2=0;
			return-1;
		}
		if(var2>=0&&var1<0) {
			var1+=1;var2+=1;
			return 1;
		}
		if(var2>0&&var1>=0) {
			var1+=1;var2-=1;
			return 1;
		}
		if(var2<=0&&var1>0) {
			var1-=1;var2-=1;
			return 1;
		}
		if(var2<0&&var1<=0) {
			var1-=1;var2+=1;
			return 1;
		}
		return 0;
		
	}
	
	
}

