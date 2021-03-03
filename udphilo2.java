import java.io.*;
public class udphilo2 extends Thread {
	private udpcontrol c;
	public udphilo2(udpcontrol c) {
		this.c=c;
	}
	
	
    @Override
    public void run() {
        super.run();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try{
                String resp=br.readLine();
                if(resp.equals("1")){
                    c.enviar();   
                }
            } catch (Exception e) {
                e.printStackTrace();
              }
        }
    }

}