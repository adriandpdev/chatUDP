public class udphilo extends Thread {
	private udpcontrol c;
	public udphilo(udpcontrol c) {
		this.c=c;
	}
	
	
    @Override
    public void run() {
        super.run();
        while(true){
            c.escuchaservidor();
        }
    }

}