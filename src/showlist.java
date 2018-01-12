import java.util.*;

public class showlist {
	private double lng;
	private double lat;
	List<institute> insNear=new ArrayList<institute>();//符合条件的中心
	
	//初始化定位坐标
	public void setloc(double lng,double lat){
		this.lng=lng;
		this.lat=lat;
	}

	public void setlist(){
	//查找所有坐标在（lng-1,lng+1）和（lat-1,lat+1）的机构
	//并添加入集合中
		institute itest=new institute();
		itest.Iname="njxt";
		itest.lng=116.40515;
		itest.lat=39.907916;
		insNear.add(itest);
	}
	
	//获取每家机构的距离和时间，并按照距离排序
	public HashMap<Double, institute> getData(){
		HashMap<Double, institute> sortlist=new HashMap<Double, institute>();
		for (institute institute : insNear) {
			Search se=new Search();
			se.setInstitute(institute.Iname, institute.lng, institute.lat);
			if(se.getData(lng, lat)){
				sortlist.put(se.ins.distance, se.ins);
			}
		}
		return sortlist;
	}
}
