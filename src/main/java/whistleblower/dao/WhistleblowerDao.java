package whistleblower.dao;

import java.util.List;

import whistleblower.model.Whistleblower;

//Dao寫JDBC 跟資料庫存取資料的內容 
public interface WhistleblowerDao {
	
	//新增檢舉表單
	int insert(Whistleblower whistleblower);
	
	//表單狀態更新
	int update(Whistleblower whistleblower);
	
	List<Whistleblower> selectAll();
	
	Whistleblower selectByID(Integer id);
	
}
