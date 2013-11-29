package com.eshop.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

/**
 * 获取mac地址
 * @author chenas
 *
 */
@Component
public class GetMacAddrUtil {


	private String sRemoteAddr;
	
	private int iRemotePort = 137;
	
	private byte[] buffer = new byte[1024];
	
	private DatagramSocket ds = null;
	
	/**
	 * 获取服务端mac地址
	 * @return
	 */
	public static String getMac() {
		try {
			Process pro = Runtime.getRuntime().exec("ipconfig /all");
			InputStreamReader bi = new InputStreamReader(pro.getInputStream(),
					"GBK");
			LineNumberReader lineNumberReader = new LineNumberReader(bi);
			String str = "";
			while (lineNumberReader.readLine() != null) {
				str = lineNumberReader.readLine();
				if (str.indexOf("物理地址") > 0) {
					System.out.println(str + " " + str.length());
					return str.substring(str.indexOf("物理地址") + 32);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public GetMacAddrUtil() throws Exception {
		ds = new DatagramSocket();
	}

	/**
	 * 获取客户端ip地址
	 * @param request
	 * @return
	 */
	public String getClientIp(HttpServletRequest request){
		String sip = request.getHeader("x-forwarded-for");   
		if(sip == null || sip.length() == 0 || "unknown".equalsIgnoreCase(sip)) {   
		    sip = request.getHeader("Proxy-Client-IP");   
		}   
		if(sip == null || sip.length() == 0 || "unknown".equalsIgnoreCase(sip)) {   
		    sip = request.getHeader("WL-Proxy-Client-IP");   
		}   
		if(sip == null || sip.length() == 0 || "unknown".equalsIgnoreCase(sip)) {   
		    sip = request.getRemoteAddr();
		}
		return sip;
	}
	
	protected final DatagramPacket send(final byte[] bytes) throws IOException {
		DatagramPacket dp = new DatagramPacket(bytes, bytes.length,
				InetAddress.getByName(sRemoteAddr), iRemotePort);
		ds.send(dp);
		return dp;
	}

	protected final DatagramPacket receive() throws Exception {
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
		ds.receive(dp);
		return dp;
	}

	protected byte[] GetQueryCmd() throws Exception {
		byte[] t_ns = new byte[50];
		t_ns[0] = 0x00;
		t_ns[1] = 0x00;
		t_ns[2] = 0x00;
		t_ns[3] = 0x10;
		t_ns[4] = 0x00;
		t_ns[5] = 0x01;
		t_ns[6] = 0x00;
		t_ns[7] = 0x00;
		t_ns[8] = 0x00;
		t_ns[9] = 0x00;
		t_ns[10] = 0x00;
		t_ns[11] = 0x00;
		t_ns[12] = 0x20;
		t_ns[13] = 0x43;
		t_ns[14] = 0x4B;

		for (int i = 15; i < 45; i++) {
			t_ns[i] = 0x41;
		}

		t_ns[45] = 0x00;
		t_ns[46] = 0x00;
		t_ns[47] = 0x21;
		t_ns[48] = 0x00;
		t_ns[49] = 0x01;
		return t_ns;
	}

	protected final String GetMacAddr(byte[] brevdata) throws Exception {

		int i = brevdata[56] * 18 + 56;
		String sAddr = "";
		StringBuffer sb = new StringBuffer(17);

		for (int j = 1; j < 7; j++) {
			sAddr = Integer.toHexString(0xFF & brevdata[i + j]);
			if (sAddr.length() < 2) {
				sb.append(0);
			}
			sb.append(sAddr.toUpperCase());
			if (j < 6)
				sb.append(':');
		}
		return sb.toString();
	}

	public final void close() {
		try {
			ds.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 获取客户端mac地址
	 * @return
	 * @throws Exception
	 */
	public final String GetRemoteMacAddr() throws Exception {
		byte[] bqcmd = GetQueryCmd();
		send(bqcmd);
		DatagramPacket dp = receive();
		String smac = GetMacAddr(dp.getData());
		close();
		return smac;
	}

}
