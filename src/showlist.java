import java.util.*;

public class showlist {
	private double lng;
	private double lat;
	List<institute> insNear=new ArrayList<institute>();//��������������
	
	//��ʼ����λ����
	public void setloc(double lng,double lat){
		this.lng=lng;
		this.lat=lat;
	}

	public void setlist(){
	//�������������ڣ�lng-1,lng+1���ͣ�lat-1,lat+1���Ļ���
	//������뼯����
		institute itest=new institute();
		itest.Iname="njxt";
		itest.lng=116.40515;
		itest.lat=39.907916;
		insNear.add(itest);
	}
	
	//��ȡÿ�һ����ľ����ʱ�䣬�����վ�������
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
