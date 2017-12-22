package ohho.mytest2;

public class GetThread implements Runnable{
	private CellphoneUser c;
	private int x = 0;
	public GetThread(CellphoneUser c) {
		this.c = c;
	}
	@Override
	public void run() {
		while (x<1000){
			synchronized (c) {
//				long cellphone_long = Long.parseLong(c.cellphone);
//				c.cellphone = String.valueOf(cellphone_long);
				System.out.println(c.cellphone);
				x++;
			}
		}
		
	}

}
