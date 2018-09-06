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
			BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			String line;
			String res="";
			Thread td=new Thread();
			JSONObject j=new JSONObject();
			//String j2=new JSONObject().toString();
			JSONObject sorce=new JSONObject();
			JSONObject room=new JSONObject();
			JSONObject 房间=new JSONObject();
			
			System.out.println("输入账号：");
			String user=sc.next();
			//System.out.println("输入房间号：");
			//String fj = null ;
			sc.nextLine();
				j.put("P","ly.pp.justpiano");
				j.put("V","4.3");
				j.put("N",user.toString());
				j.put("K","昵称");
				j.put("C","");
				room.put("N","");
				room.put("P","");
				room.put("M",0);
				//房间.put("I",fj.toString());
				//房间.put("P","");
				//for(byte b:result){System.out.println(b);}
			    int aaa=0;
				int post=0;
				int add=3607;//单次经验
				//int add=2287;//单次经验
			
				//2287经验
				//byte[] result=decodeHex("0500007B2253223A225C7530303166C28B5C625C75303030305C75303030305C75303030305C75303030305C75303030305C75303030305C75303030306362C2A23760C3805C2FC28021C28D55C288365C7530303030C2AB4574C2B3C29D7EC28061203DC38540C2A2C39DC2B8C295C3A3C2945C75303031395C753030316351C386C280445C75303030655C7530303031C380C280C381C28072C289C3B35C7530303031C395C3BCC289C3A1C28EC2815C7530303065415C22C3AD5C75303031666867525C75303031625C6635C3BFC280C39329C28D5C75303031634DC38FC2B05C753030313874C3A14EC2B5C3B25C7530303161C2BF5C7530303036C2865C7530303031C3B63A5C7530303030C38CC3B3C3AFC2945C6E5C745C75303030305C7530303030227D");
				//3607经验
				byte[] result=decodeHex("0500007b2253223a225c7530303166c28b5c625c75303030305c75303030305c75303030305c75303030305c75303030305c75303030305c753030303063625c7530303161c2aac28061c3885c75303031613e425c75303030315c75303030335c7530303133c383c3805c7530303036c3ab5c75303030305b5c7530303066755c75303030325c7530303033c2bac380285c7530303138c2acc2805a71335c7530303161c387c3b45c7530303034c384c287c3b668c2bcc28cc282615c7530303037484cc394c283365c7530303066c2a0c397c294c2a35c75303030305c6e5c753030303663c2b05c75303030305c7530303030216a415c22475c665c75303030305c7530303030227D");
				byte[] ss2=new byte[]{0x06,0x04,0x00};
				byte[] json3=room.toString().getBytes();
				byte[] room2=addBytes(ss2,json3);
				byte[] ss=new byte[]{0x05,0x00,0x00};
				byte[] json2=sorce.toString().getBytes();
				byte[] sss=addBytes(ss,json2);
				byte[] json=j.toString().getBytes();
				byte[] 琴房=房间.toString().getBytes();
				
				
				byte[] t=new byte[]{0x0a,0x00,0x00};
				//String ss=t+json;
				byte[] login= addBytes(t,json);
				byte[] dating1=new byte[]{0x1d,0x00,0x03};
				byte[] dating2=new byte[]{0x1d,0x00,0x04};
				byte[] 房间头=new byte[]{0x07,0x15,0x00};
				byte[] 进入房间=addBytes(房间头,琴房);
			
				byte[] next2=new byte[]{0x28 ,0x00,0x00 ,0x7b, 0x22 ,0x54 ,0x22 ,0x3a  ,0x30 ,0x7d};
			
				//考级分数
				//byte[] next3=decodeHex("280000 7B2253223A225C7530303166C28B5C625C75303030305C75303030305C75303030305C75303030305C75303030305C75303030305C75303030306362C2A23760C3805C2FC28021C28D55C288365C7530303030C2AB4574C2B3C29D7EC28061203DC38540C2A2C39DC2B8C295C3A3C2945C75303031395C753030316351C386C280445C75303030655C7530303031C380C280C381C28072C289C3B35C7530303031C395C3BCC289C3A1C28EC2815C7530303065415C22C3AD5C75303031666867525C75303031625C6635C3BFC280C39329C28D5C75303031634DC38FC2B05C753030313874C3A14EC2B5C3B25C7530303161C2BF5C7530303036C2865C7530303031C3B63A5C7530303030C38CC3B3C3AFC2945C6E5C745C75303030305C7530303030 222C224E223A22E7919CE4B990E6989FE79A84E58FB3E6898BE8A1A8E78EB0E696B9E6B395E7A094E7A9B6202D20E7919CE4B990E6989F58222C2254223A327D");
				
				byte[] next3=decodeHex("2800007b2253223a225c7530303166c28b5c625c75303030305c75303030305c75303030305c75303030305c75303030305c75303030305c753030303063625c7530303161c2aac28061c3885c75303031613e425c75303030315c75303030335c7530303133c383c3805c7530303036c3ab5c75303030305b5c7530303066755c75303030325c7530303033c2bac380285c7530303138c2acc2805a71335c7530303161c387c3b45c7530303034c384c287c3b668c2bcc28cc282615c7530303037484cc394c283365c7530303066c2a0c397c294c2a35c75303030305c6e5c753030303663c2b05c75303030305c7530303030216a415c22475c665c75303030305c7530303030222C224E223A22E7919CE4B990E6989FE79A84E58FB3E6898BE8A1A8E78EB0E696B9E6B395E7A094E7A9B6202D20E7919CE4B990E6989F58222C2254223A327D");
				byte[] next4=new byte[]{0x17,0x00,0x00};
		
			
			
				System.out.println("--1  登陆\n--2  进入大厅二\n--3  创建房间\n--4  模拟弹奏\n--5  提交成绩\n--6  准备考级\n--7  提交考级分数\n--8  进入大厅一\n--9  进入房间\n--其他  离线");
	
				
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
						while(aaa<=120){
							//td.sleep(300);
						dos.write(result);
						td.sleep(60);
						post=post+add;
						aaa++;
						//System.out.println(post);
						
						}
						System.out.println("已提交弹奏成绩："+post);
						sc.nextLine();
						}else if(start==2){
						dos.write(dating2);
						System.out.println("进入大厅二");
						
						System.out.println(res);
						}else if (start==3){
						dos.write(room2);
						System.out.println("已创建房间");
						}else if(start==8){
						dos.write(dating1);
						System.out.println("进入大厅一");
						}else if(start==6){
						System.out.println("准备考级");
						dos.write(next2);
						}else if(start==7){
							System.out.println("开始提交考级分数");
							//循环40次至超神
							while(aaa<40){
								dos.write(next3);
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
