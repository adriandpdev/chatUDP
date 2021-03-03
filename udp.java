public class udp {
	
	public static void main(String[] args) {
        

		udpcontrol c = new udpcontrol();		
        udphilo h1 = new udphilo(c);
        h1.start();
        udphilo2 h2 = new udphilo2(c);
        h2.start();
	}
}