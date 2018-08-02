import java.io.*;
import java.net.*;
import java.util.*;
import org.json.*;

public class json2byte
{
	public static void main(String a1[]) throws IOException{
		
		Socket s = new Socket("121.199.31.116", 8908);
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		Scanner sc=new Scanner(System.in);
		JSONObject jb=new JSONObject();
		System.out.println("输入内容：");
		String dl=sc.next().toString();
		byte[] b1=new byte[]{0x0a,0x00,0x00};
		//String t2=dl.toString().getBytes();
		byte[] j2b=dl.getBytes();
		//dos.write(b1+dl);
		System.out.println(b1+dl);
		
		
		
		}
}
