import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class test {

	public static void main(String[] args) {
		showlist sl=new showlist();
		sl.setloc(116.226926, 40.019403);//�������ĵ㾭γ��
		sl.setlist();//���һ����б�
		HashMap<Double, institute> temp=sl.getData();//��ȡ����������
		Collection<institute> itemp=temp.values();
		for (institute institute : itemp) {
			System.out.println(institute.distext);
			System.out.println(institute.durtext);
		}
	}

}
