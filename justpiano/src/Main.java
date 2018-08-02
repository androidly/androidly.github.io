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
				j.put("P","ly.pp.justpiano");
				j.put("V","4.3");
				j.put("N","netqaq");
				j.put("K","因你而在");
				j.put("C","");
				room.put("N","");
				room.put("P","");
				room.put("M",0);
				//for(byte b:result){System.out.println(b);}
			    int aaa=0;
				int post=0;
				int add=2287;//单次成绩
				
				//byte[] result=decodeHex("0500007B2253223A225C7530303166C28B5C625C75303030305C75303030305C75303030305C75303030305C75303030305C75303030305C7530303030C2A5C2935C75303030315C6E5C7530303030215C625C7530303034C287C3BEC3BFC3A85C7530303062C28EC2BBC394C392C392C2845C6E6C3559C2A6C396C2A2C380C38BC38C5C7530303137C3B9C280C2B15C7530303166C3A95C2F6EC28F26C2B65C7530303132C2AF64C291C3A75D445C7530303161C2B7C39BC2AFC2A5C29BC381705C7530303138C39D5C753030303653C2967C6BC2AF2A2952245C5CC390C2B3C3A05C7530303034C39DC2ABC2845C7530303133765C7530303163C2A629C393C39C55C29DC2BE5C75303030337C53275C7530303066615C75303031325C7530303138C3875C7530303034C28241C38FC3AFC3AF2A3E5948643CC3B0C2A95C75303031325C75303031656C5C75303030345C75303030305C7530303030227D");
			
				byte[] result=decodeHex("0500007B2253223A225C7530303166C28B5C625C75303030305C75303030305C75303030305C75303030305C75303030305C75303030305C75303030306362C2A23760C3805C2FC28021C28D55C288365C7530303030C2AB4574C2B3C29D7EC28061203DC38540C2A2C39DC2B8C295C3A3C2945C75303031395C753030316351C386C280445C75303030655C7530303031C380C280C381C28072C289C3B35C7530303031C395C3BCC289C3A1C28EC2815C7530303065415C22C3AD5C75303031666867525C75303031625C6635C3BFC280C39329C28D5C75303031634DC38FC2B05C753030313874C3A14EC2B5C3B25C7530303161C2BF5C7530303036C2865C7530303031C3B63A5C7530303030C38CC3B3C3AFC2945C6E5C745C75303030305C7530303030227D");
				byte[] ss2=new byte[]{0x06,0x04,0x00};
				byte[] json3=room.toString().getBytes();
				byte[] room2=addBytes3(ss2,json3);
				byte[] ss=new byte[]{0x05,0x00,0x00};
				byte[] json2=sorce.toString().getBytes();
				byte[] sss=addBytes2(ss,json2);
				byte[] json=j.toString().getBytes();
				byte[] t=new byte[]{0x0a,0x00,0x00};
				//String ss=t+json;
				byte[] login= addBytes(t,json);
				byte[] houxu=new byte[]{0x1c,0x00,0x00};
				byte[] dating=new byte[]{0x1d,0x00,0x04};
				byte[] next=new byte[]{0x15,0x07,0x04};
			
				byte[] next2=new byte[]{0x0f ,0x07,0x04 ,0x61, 0x2f ,0x64 ,0x2f ,0x77  ,0x69 ,0x6e ,0x64 ,0x6f ,0x77 ,0x73 ,0x6b ,0x61  ,
			0x69 ,0x6a ,0x69};
				byte[] next3=new byte[]{0x03,0x07,0x04};
				byte[] next4=new byte[]{0x17,0x00,0x00};
				/**byte[] next5=new byte[] {0x05 ,0x00 ,0x00 ,0x7b ,0x22 ,0x53 ,0x22 ,0x3a  ,0x22 ,0x5c ,0x75 ,0x30 ,0x30 ,0x31, 0x66,
				0xc2,0x8b,0x5c ,0x62 ,0x5c ,0x75 ,0x30 ,0x30 ,0x30 , 0x30 ,0x5c ,0x75 ,0x30 ,0x30 ,0x30 ,0x30 ,0x5c,
				0x75,0x30,0x30, 0x30 ,0x30,0x5c ,0x75, 0x30 ,0x30 ,0x30, 0x30 ,0x5c ,0x75 ,0x30, 0x30, 0x30 ,0x30 ,
				0x5c ,0x75 ,0x30 ,0x30 ,0x30 ,0x30 ,0x5c ,0x75 ,0x30 ,30 ,30 ,30 ,63 ,60 ,60 ,
				0xc2 ,0x82 ,0x5c ,0x75 ,0x30 ,0x30 ,0x30 ,0x31 , 0x5c ,0x75,0x30 ,0x30 ,0x30 ,0x30 ,0x5c ,0x75,
				0x30 ,0x30 ,0x31 ,0x65 ,0x62 ,0x76, 0xc3, 0x92 , 0x5c, 0x75 ,0x30 ,0x30 ,0x30 ,0x62 ,0x5c, 0x75,
				0x30, 0x30 ,0x30 ,0x30 ,0x5c, 0x75 ,0x30, 0x30 , 0x30 ,0x30, 0x5c ,0x75 ,0x30 ,0x30, 0x30 ,0x30  ,
				0x22, 0x7d
				};*/
		
			
			//当输入的数据是exit退出输入
				System.out.println("--1 登陆\n--2  进入大厅二\n--3  创建房间\n--4  模拟弹奏\n--5  提交成绩\n--其他 离线");
	
				
					//System.out.println(".....开始....");
					//dos.write(he);
					//System.out.println("已登陆");
					//sc.nextLine();
					//System.out.println("输入b继续");
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
						while(aaa<=4372){
							//td.sleep(300);
						dos.write(result);
						td.sleep(60);
						post=post+add;
						aaa++;
						
						
						}
						System.out.println("已提交成绩");
						System.out.println("提交成绩"+post);
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
						dos.write(next2);
						}else if(start==7){
						dos.write(next3);
						}else if(start==4){
						dos.write(next4);
						System.out.println("模拟弹奏中");
						}else{
						dos.flush(); 
						dos.close();
						s.close();
					}
				
			
				
			//dos.write(he);
			//Thread td=new Thread();
			//td.sleep(500);
			//dos.write(fj);
			
			//System.out.println(ss);

			}
			
		}
		catch (IOException e)
		{}//申请链接
		
	
	}

	private static byte[] addBytes3(byte[] ss2, byte[] json3)
	{
		byte[] data = new byte[ss2.length + json3.length];
        System.arraycopy(ss2, 0,data, 0, ss2.length);
        System.arraycopy(json3, 0, data, ss2.length, json3.length);
		
		// TODO: Implement this method
		return data;
	}

	private static byte[] addBytes2(byte[] ss, byte[] json2)
	{
		byte[] data2 = new byte[ss.length + json2.length];
        System.arraycopy(ss, 0,data2, 0, ss.length);
        System.arraycopy(json2, 0, data2, ss.length, json2.length);
		
		// TODO: Implement this method
		return data2;
	}

	private static byte[] addBytes(byte[] t, byte[] json)
	{
		byte[] data3 = new byte[t.length + json.length];
        System.arraycopy(t, 0,data3, 0, t.length);
        System.arraycopy(json, 0, data3, t.length, json.length);
        return data3;
		// TODO: Implement this method
		
	}
	
	/**
	 * 字符串转化成为16进制字符串
	 * @param s
	 * @return
	 */
	public static String strTo16(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
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
