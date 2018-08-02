import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.charset.*;

public class socket
 {
    private static final String HOST = "10.100.0.100";//主机地址
    private static final int PORT = 9000;//端口号

	//public static void main(String[] args){requestServer();}
    //TCP向服务端发送数据
    public static void requestServer(String json, CallListener callListener) {

        byte[] bytes1 = hexStringToByteArray("8EEEEEEE");//将自定义的16进制魔数转变为二进制的流
        byte[] bytes2 = intToBytes(json.length(), ByteOrder.BIG_ENDIAN);//将协议头的LENGHT转变为二进制的byte，第二个参数是大端
        byte[] byte3 = json.getBytes();  //将json数据转换为二进制的流
        byte[] bys = addBytes(bytes1, bytes2);//合并byte数组
        final byte[] bytes = addBytes(bys, byte3);//将3个byte数组合并为一个

        Socket socket = null;
        OutputStream output = null;
        InputStream input = null;
        StringBuffer sb = null;
        try {
            socket = new Socket(HOST, PORT);
            //--------向服务端的写入信息-------------
            output = socket.getOutputStream();
            output.write(bytes);// 把msg信息写入输出流中
            //--------接收服务端的返回信息-------------
            socket.shutdownOutput(); // 一定要加上这句，否则收不到来自服务器端的消息返回 ，意思就是结束msg信息的写入
            input = socket.getInputStream();
            byte[] b = new byte[1024];
            int len = -1;
            sb = new StringBuffer();
            while ((len = input.read(b)) != -1) {
                sb.append(new String(b, 0, len, Charset.forName("UTF-8")));// 得到返回信息
            }
        } catch (Exception e) {
            callListener.onError();//请求失败的回调
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    output.flush();
					String jsonResult = sb.substring(8);//截取服务器返回的数据
					callListener.onResult(jsonResult);//请求成功的回调
                    socket.close();// 释放资源，关闭这个Socket
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	

	
	public static byte[] addBytes(byte[] data1, byte[] data2) {
        byte[] data3 = new byte[data1.length + data2.length];
        System.arraycopy(data1, 0, data3, 0, data1.length);
        System.arraycopy(data2, 0, data3, data1.length, data2.length);
        return data3;
    }

    /**
     * int转byte{}
     */
    public static byte[] intToBytes(int value, ByteOrder mode) {
        byte[] src = new byte[4];
        if (mode == ByteOrder.LITTLE_ENDIAN) {
            src[3] = (byte) ((value >> 24) & 0xFF);
            src[2] = (byte) ((value >> 16) & 0xFF);
            src[1] = (byte) ((value >> 8) & 0xFF);
            src[0] = (byte) (value & 0xFF);
        } else {
            src[0] = (byte) ((value >> 24) & 0xFF);
            src[1] = (byte) ((value >> 16) & 0xFF);
            src[2] = (byte) ((value >> 8) & 0xFF);
            src[3] = (byte) (value & 0xFF);
        }
        return src;
    }


    /**
     * 16进制表示的字符串转换为字节数组
     *
     * @param s 16进制表示的字符串
     * @return byte[] 字节数组
     */
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] b = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个字节
            b[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
				.digit(s.charAt(i + 1), 16));
        }
        return b;
    }
	
	public interface CallListener {
		void onResult(String jsonresult);
		void onError();
	}
	
}
