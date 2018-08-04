import java.io.*;
import java.net.*;
import java.util.*;
import org.json.*;
import java.nio.*;

public class Main
{
	public static void main(String[] args) throws IOException, JSONException, InterruptedException
	{

		//"P":"ly.jp.piano","V":"4.3","N":"Yinnierzai","K":"因你而在°","C":""}
		//{"P":"ly.jp.piano","V":"4.3","N":"Yinnierzai","K":"因你而在°","C":""}

		try
		{
			Scanner sc=new Scanner(System.in);
			Socket s = new Socket("121.199.31.116", 8908);
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			Thread td=new Thread();
			JSONObject j=new JSONObject();
			//String j2=new JSONObject().toString();
			JSONObject sorce=new JSONObject();
			JSONObject room=new JSONObject();
			
			System.out.println("输入账号：");
			String user=sc.next();
			sc.nextLine();
				j.put("P","ly.pp.justpiano");
				j.put("V","4.3");
				j.put("N",user.toString());
				j.put("K","因你而在");
				j.put("C","");
				room.put("N","");
				room.put("P","");
				room.put("M",0);
				//for(byte b:result){System.out.println(b);}
			    int aaa=0;
				int post=0;
				int bbb=10;
				int add=2287;//单次经验
			
				//2287经验
				byte[] result=decodeHex("0500007B2253223A225C7530303166C28B5C625C75303030305C75303030305C75303030305C75303030305C75303030305C75303030305C75303030306362C2A23760C3805C2FC28021C28D55C288365C7530303030C2AB4574C2B3C29D7EC28061203DC38540C2A2C39DC2B8C295C3A3C2945C75303031395C753030316351C386C280445C75303030655C7530303031C380C280C381C28072C289C3B35C7530303031C395C3BCC289C3A1C28EC2815C7530303065415C22C3AD5C75303031666867525C75303031625C6635C3BFC280C39329C28D5C75303031634DC38FC2B05C753030313874C3A14EC2B5C3B25C7530303161C2BF5C7530303036C2865C7530303031C3B63A5C7530303030C38CC3B3C3AFC2945C6E5C745C75303030305C7530303030227D");
				byte[] ss2=new byte[]{0x06,0x04,0x00};
				byte[] json3=room.toString().getBytes();
				byte[] room2=addBytes(ss2,json3);
				byte[] ss=new byte[]{0x05,0x00,0x00};
				byte[] json2=sorce.toString().getBytes();
				byte[] sss=addBytes(ss,json2);
				byte[] json=j.toString().getBytes();
				byte[] t=new byte[]{0x0a,0x00,0x00};
				//String ss=t+json;
				byte[] login= addBytes(t,json);
				byte[] houxu=new byte[]{0x1c,0x00,0x00};
				byte[] dating=new byte[]{0x1d,0x00,0x04};
				byte[] next=new byte[]{0x15,0x07,0x04};
			
				byte[] next2=new byte[]{0x28 ,0x00,0x00 ,0x7b, 0x22 ,0x54 ,0x22 ,0x3a  ,0x30 ,0x7d};
			
				//考级分数
				byte[] next3=decodeHex("2800007B2253223A225C7530303166C28B5C625C75303030305C75303030305C75303030305C75303030305C75303030305C75303030305C75303030306362C2A23760C3805C2FC28021C28D55C288365C7530303030C2AB4574C2B3C29D7EC28061203DC38540C2A2C39DC2B8C295C3A3C2945C75303031395C753030316351C386C280445C75303030655C7530303031C380C280C381C28072C289C3B35C7530303031C395C3BCC289C3A1C28EC2815C7530303065415C22C3AD5C75303031666867525C75303031625C6635C3BFC280C39329C28D5C75303031634DC38FC2B05C753030313874C3A14EC2B5C3B25C7530303161C2BF5C7530303036C2865C7530303031C3B63A5C7530303030C38CC3B3C3AFC2945C6E5C745C75303030305C7530303030222C224E223A22E7919CE4B990E6989FE79A84E58FB3E6898BE8A1A8E78EB0E696B9E6B395E7A094E7A9B6202D20E7919CE4B990E6989F58222C2254223A327D");
				byte[] next4=new byte[]{0x17,0x00,0x00};
		
			
			
				System.out.println("--1 登陆\n--2  进入大厅二\n--3  创建房间\n--4  模拟弹奏\n--5  提交成绩\n--6  准备考级\n--7  提交考级分数\n--其他 离线");
	
				
					while(true){
						int start=sc.nextInt();
					if(start>=0&&start==100){
						
						break;
						
					}
					if(start==1){
						dos.write(login);
						System.out.println("已登陆");
					}else if(start==5){
						//dos.write(sss);
						while(aaa<=10){
							//td.sleep(300);
						dos.write(result);
						td.sleep(60);
						post=post+add;
						aaa++;
						System.out.println(post);
						
						}
						System.out.println("已提交弹奏成绩："+post);
						sc.nextLine();
						}else if(start==2){
						dos.write(dating);
						System.out.println("进入大厅");
						}else if (start==3){
						dos.write(room2);
						System.out.println("已创建房间");
						}else if(start==8){
						dos.write(next);
						}else if(start==6){
						System.out.println("准备考级");
						dos.write(next2);
						}else if(start==7){
							System.out.println("提交考级分数");
							//循环40次
							while(aaa<=39){
								//dos.write(next3);
								td.sleep(100);
								//post+=bbb;
								//System.out.println(post);
								aaa++;
							}
						System.out.println("考级结束");
						}else if(start==4){
						dos.write(next4);
						System.out.println("模拟弹奏中");
						}else{
						dos.flush(); 
						dos.close();
						s.close();
						System.out.println("已离线");
					}
			}
			
		}
		catch (IOException e)
		{}
		
	
	}


	private static byte[] addBytes(byte[] d1, byte[] d2)
	{
		byte[] data3 = new byte[d1.length + d2.length];
        System.arraycopy(d1, 0,data3, 0, d1.length);
        System.arraycopy(d2, 0, data3, d1.length, d2.length);
        return data3;
		// TODO: Implement this method
		
	}
	
	
	public static byte[] decodeHex(String nm) {
		int len = nm.length();
		byte[] result = new byte[len/2];
		for(int i = 0; i<len; i++) {
			char c = nm.charAt(i);
			byte b = Byte.decode("0x" + c);
			c = nm.charAt(++i);
			result[i/2] = (byte) (b << 4 | Byte.decode("0x" + c));
		}
		return result;
		
	}
}
