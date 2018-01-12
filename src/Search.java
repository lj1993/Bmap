import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import net.sf.json.*;

public class Search {
	public institute ins=new institute();//机构对象
	
	//初始化对象
	public void setInstitute(String name,double lng,double lat){
		ins.Iname=name;
		ins.lng=lng;
		ins.lat=lat;
	}

	//获取距离和时间
	public boolean getData(double lng,double lat){
		String inslo=ins.lat+","+ins.lng;
		String dislo=lat+","+lng;
		StringBuffer buffer=new StringBuffer();
		buffer.append("http://api.map.baidu.com/routematrix/v2/driving?output=json");
		buffer.append("&origins="+inslo);
		buffer.append("&destinations="+dislo);
		buffer.append("&tactics=11");
		buffer.append("&ak=2R7OAGrkAI0050YRTYBzF1wtxbWMFKFe");
		String url=buffer.toString();
		String json = loadJSON(url);
	    JSONObject obj = JSONObject.fromObject(json);
	    if(obj.get("status").toString().equals("0")){
	    	JSONArray jtarray=obj.getJSONArray("result");	    	
	    	ins.distance=jtarray.getJSONObject(0).getJSONObject("distance").getDouble("value");
	    	ins.duration=jtarray.getJSONObject(0).getJSONObject("duration").getDouble("value");
	    	ins.distext=jtarray.getJSONObject(0).getJSONObject("distance").getString("text");
	    	ins.durtext=jtarray.getJSONObject(0).getJSONObject("duration").getString("text");
	    	return true;
	    }
	    return false;
	}
	
	//访问baidu获取数据
	 public static String loadJSON (String url) {
	       StringBuilder json = new StringBuilder();
	       try {
	           URL baidu = new URL(url);
	           URLConnection yc = baidu.openConnection();
	           yc.setRequestProperty("Content-Type","application/json;charset=UTF-8");//字符编码
	           BufferedReader in = new BufferedReader(new InputStreamReader(
	                                       yc.getInputStream(),"utf-8"));
	           String inputLine = null;
	           while ( (inputLine = in.readLine()) != null) {
	               json.append(inputLine);
	           }
	           in.close();
	       } catch (MalformedURLException e) {
	    	   e.printStackTrace();
	       } catch (Exception e) {
	    	   e.printStackTrace();
	       }
	       return json.toString();
	   }
}
