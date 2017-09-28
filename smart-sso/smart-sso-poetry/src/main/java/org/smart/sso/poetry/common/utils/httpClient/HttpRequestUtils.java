package org.smart.sso.poetry.common.utils.httpClient;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.smart.mvc.config.ConfigUtils;

/**
 * http请求
 * @author kangtiancheng
 * @date 2017年7月8日
 */
public class HttpRequestUtils {

	/**
	 * 比较新的浏览器内核，用于对内核有要求的请求
	 */
	public final static String NEW_USER_AGENT="Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36"; 
	public final static String FILE_SAVE_PATH = ConfigUtils.getProperty("upload_file_path");
	
	/**
	 * 远程获取文件
	 */
	public static String sendGetFile(String url, String path1, String fileName) {
		ByteArrayOutputStream outStream = null;
		FileOutputStream fileoutStream = null;
		String cd =  FILE_SAVE_PATH + path1 + "/" ;
		File newFile = new File(cd);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }
		String fileFullName = cd   +  fileName ;
		try {
			String urlNameString = url;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", NEW_USER_AGENT);
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			// 建立实际的连接
			connection.connect();
			outStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = connection.getInputStream().read(buffer)) != -1) {
				outStream.write(buffer, 0, len);
			}
			byte[] data = outStream.toByteArray();// 图片的二进制数据
			File file = new File(fileFullName);
			fileoutStream = new FileOutputStream(file);
			fileoutStream.write(data);

		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (fileoutStream != null) {
					fileoutStream.close();
				}
				if (outStream != null) {
					outStream.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return fileFullName;
	}
    
	
    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url ) {
    	return sendGet(url,null,null);
    }

    /**
     * GET扩充
     * @param url
     * @param paramMap
     * @return
     */
    public static String sendGet(String url, Map<String, Object> paramMap) {
        
        return sendGet(url,paramMap,null);
    }
    
    /**
     * 
     * @param url
     * @param paramMap
     * @return
     */
    public static String sendGet(String url, Map<String, Object> paramMap,Map<String, String> requestPro) {
        
        if (paramMap != null && paramMap.size() > 0) {
        	StringBuffer param = new StringBuffer();
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                if (null != entry.getKey() && !"".equals(entry.getKey())) {
                    param.append(entry.getKey());
                    param.append("=");
                    param.append(entry.getValue());
                    param.append("&");
                }
            }
            param = new StringBuffer(param.substring(0, param.length() - 1));
            url = url + param.toString();
        }
        
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            if(requestPro != null && requestPro.size() > 0) {
                for (Map.Entry<String, String> stringStringEntry : requestPro.entrySet()) {
                    connection.setRequestProperty(stringStringEntry.getKey(), stringStringEntry.getValue());
                }
            }
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
        
       
    }
    
    /**
     * post扩充
     * @param url
     * @param paramMap
     * @return
     */
    public static String sendPost(String url, Map<String, Object> paramMap, int post) {
        StringBuffer param = new StringBuffer();
        if (paramMap != null && paramMap.size() > 0) {
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                if (null != entry.getKey() && !"".equals(entry.getKey())) {
                    param.append(entry.getKey());
                    param.append("=");
                    param.append(entry.getValue());
                    param.append("&");
                }
            }
            param = new StringBuffer(param.substring(0, param.length() - 1));
        }
        return sendPost(url, param.toString());
    }

    /**
     * post扩充
     * @param url
     * @param paramMap
     * @return
     */
    public static String sendPost(String url, Map<String, String> paramMap) {
        StringBuffer param = new StringBuffer();
        if (paramMap != null && paramMap.size() > 0) {
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                if (null != entry.getKey() && !"".equals(entry.getKey())) {
                    param.append(entry.getKey());
                    param.append("=");
                    param.append(entry.getValue());
                    param.append("&");
                }
            }
            param = new StringBuffer(param.substring(0, param.length() - 1));
        }
        return sendPost(url, param.toString());
    }
    
    public static String sendPost2(String url, Map<String, Object> paramMap) {
        StringBuffer param = new StringBuffer();
        if (paramMap != null && paramMap.size() > 0) {
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                if (null != entry.getKey() && !"".equals(entry.getKey())) {
                    param.append(entry.getKey());
                    param.append("=");
                    param.append(entry.getValue());
                    param.append("&");
                }  
            }
            param = new StringBuffer(param.substring(0, param.length() - 1));
        }
        return sendPost(url, param.toString());
    }
    
    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param, Map<String, String> requestPro) {
        //PrintWriter out = null;
    	OutputStreamWriter  out =null;
    	
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            if(requestPro != null && requestPro.size() > 0) {
                for (Map.Entry<String, String> stringStringEntry : requestPro.entrySet()) {
                    connection.setRequestProperty(stringStringEntry.getKey(), stringStringEntry.getValue());
                }
            }
            // 发送POST请求必须设置如下两行
            connection.setDoOutput(true);
            connection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            //out = new PrintWriter(connection.getOutputStream());
            //201704 oycw 换成 OutputStreamWriter防止传入中文参数时对方乱码
            out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); 
            // 发送请求参数
            out.write(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    
    /** 
     * 发送xml数据 
     * @author oycw
     * @param path 请求地址 
     * @param xml xml数据 
     * @param encoding 编码 
     * @return 
     * @throws Exception 
     */  
    public static String postXml(String path, String xml, String encoding) throws Exception {  
        byte[] data = xml.getBytes(encoding);  
        URL url = new URL(path);  
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
        conn.setRequestMethod("POST");  
        conn.setDoOutput(true);  
        conn.setRequestProperty("Content-Type", "text/xml; charset="+ encoding);  
        conn.setRequestProperty("Content-Length", String.valueOf(data.length));  
        conn.setConnectTimeout(5 * 1000);  
        OutputStream outStream = conn.getOutputStream();  
        outStream.write(data);  
        outStream.flush();  
        outStream.close();  
        if(conn.getResponseCode()==200){  
        	byte[]  bytes = read2Byte(conn.getInputStream());
            return new String(bytes,encoding);  
        }  
        return null;  
    }  
    
    /** 
     * 发送json数据 
     * @author oycw
     * @param path 请求地址 
     * @param xml xml数据 
     * @param encoding 编码 
     * @return 
     * @throws Exception 
     * 接收方读取方式
     *  HttpServletRequest request...
     *  StringBuilder sb = new StringBuilder();
            BufferedReader in = request.getReader();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            String xml = sb.toString();
     */  
    public static String postJson(String path, String json, String encoding) throws Exception {  
        byte[] data = json.getBytes(encoding);  
        URL url = new URL(path);  
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
        conn.setRequestMethod("POST");  
        conn.setDoOutput(true);  
        conn.setRequestProperty("Content-Type", "application/json; charset="+ encoding);  
        conn.setRequestProperty("Content-Length", String.valueOf(data.length));  
        conn.setConnectTimeout(5 * 1000);  
        OutputStream outStream = conn.getOutputStream();  
        outStream.write(data);  
        outStream.flush();  
        outStream.close();  
        if(conn.getResponseCode()==200){  
        	byte[]  bytes = read2Byte(conn.getInputStream());
            return new String(bytes,encoding);  
        }  
        return null;  
    }  
    
    /** 
     * 将输入流转为字节数组 
     * @param inStream 
     * @return 
     * @throws Exception 
     */  
    public static byte[] read2Byte(InputStream inStream)throws Exception{  
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();  
        byte[] buffer = new byte[1024];  
        int len = 0;  
        while( (len = inStream.read(buffer)) !=-1 ){  
            outSteam.write(buffer, 0, len);  
        }  
        outSteam.close();  
        inStream.close();  
        return outSteam.toByteArray();  
    }  
    
    
    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        return sendPost(url, param, null);
    }

    public static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("http_client_ip");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        // 如果是多级代理，那么取第一个ip为客户ip
        if (ip != null && ip.indexOf(",") != -1) {
            ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
        }
        return ip;
    }

    public static String getUA(HttpServletRequest request) {
        String ua = request.getHeader("user-agent");
        return ua;
    }

    public static String getReferer(HttpServletRequest request) {
        String referer = request.getHeader("referer");
        return referer;
    }
}