package sample.zhong.yi.sheng.zhi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;
public class Dictionary{	
	public List<String> dic_list;
	public Map<String, String> dic_map;
	public List<String> txtToListName() throws IOException{
		List<String> TEMP_list = new ArrayList<>();
		TEMP_list.add("������Ů�Ƹ���-��-��ɽ.txt");
		TEMP_list.add("��Ӥ��Ҫ-��-Ѧ��.txt");
		TEMP_list.add("�����±�-��-¬����.txt");
		TEMP_list.add("���ױ���-��-����.txt");
		TEMP_list.add("�����;�--������.txt");
		TEMP_list.add("���ưٱ�-��-ׯ����.txt");
		TEMP_list.add("��������--.txt");
		TEMP_list.add("�������-��-�����.txt");
		TEMP_list.add("����������Ҫ-��-������.txt");
		TEMP_list.add("������Ů��-��-��ɽ.txt"); 
		TEMP_list.add("�������п��ر࿼��-��-��ɽ.txt"); 
		return TEMP_list;
	}
	
	public Map<String, String> listNameToMap(List<String> dic_list) throws IOException{
		Map<String, String> dic_map = new ConcurrentHashMap<String, String>();
		for(int i = 0; i < dic_list.size(); i++) {
			String para = "";
			String name = dic_list.get(i).toString();
			InputStream in = getClass().getResourceAsStream(name);
			BufferedReader cReader;
			if(name.equalsIgnoreCase("��Ӥ��Ҫ-��-Ѧ��.txt") || name.equalsIgnoreCase("���ױ���-��-����.txt")
					|| name.equalsIgnoreCase("������Ů�Ƹ���-��-��ɽ.txt")) {
				 cReader= new BufferedReader(new InputStreamReader(in, "UTF-16"));  
			}else {
				 cReader= new BufferedReader(new InputStreamReader(in, "GBK"));  
			}
			String ctempString= null; 
			int index= 0;
			while ((ctempString= cReader.readLine())!= null) {  
				if(!ctempString.replace(" ", "").equals("")) {
					para+= ctempString;
					if(ctempString.replace(" ", "").contains("^^")) {	
						dic_map.put(name+(index++), para.replace("\\s+", " "));
						para= "";
					}
				}
			}
			cReader.close();
		}
		return dic_map;
	}
}