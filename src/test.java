import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class test {

	public static void main(String[] args) {
		showlist sl=new showlist();
		sl.setloc(116.226926, 40.019403);//设置中心点经纬度
		sl.setlist();//查找机构列表
		HashMap<Double, institute> temp=sl.getData();//获取参数并排序
		Collection<institute> itemp=temp.values();
		for (institute institute : itemp) {
			System.out.println(institute.distext);
			System.out.println(institute.durtext);
		}
	}

}
