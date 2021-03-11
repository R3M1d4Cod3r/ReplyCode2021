package main;

public class Posizionebho {
	int x,y,w,h,index;
	public Posizionebho(int w,int h) {
		super();
		x=0;
		y=0;
		index=0;
		this.w=w;
		this.h=h;			
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		this.refreshindex();
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		this.refreshindex();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
		this.refreshXY();
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public int convertToIndex(int x,int y) {
		return y*w + x;
	}
	public int[] convertToXY(int index) {
		int riga=index/this.w;
		int colonna=index - riga*this.w;
		int[] ris= new int[2];
		ris[0]=riga;
		ris[1]=colonna;
		return ris;
	}
	private void refreshindex() {
		this.index=this.y*this.w + this.x;
	}
	private void refreshXY() {
		this.y=this.index/this.w;
		this.x=this.index-this.y*this.w;
	}
	public void goToNext() {
		if(this.index==this.w*this.h-1) {
			this.index =-1;
			this.x=-1;
			this.y=-1;
			return;
		}
		if(this.x<this.w-1)
			this.x++;
		else {
			this.y++;
			this.x=0;
		}
		this.index++;
	}

}
