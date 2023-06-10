package whistleblower.service.impl;

import whistleblower.dao.WhistleblowerDao;
import whistleblower.dao.impl.WhistleblowerDaoImpl;
import whistleblower.model.Whistleblower;
import whistleblower.service.WhistleblowerService;

public class WhistleblowerServiceImpl implements WhistleblowerService {
	
	
	@Override
	public boolean addOneWhistleblower(Whistleblower whistleblower) {
		WhistleblowerDao dao = new WhistleblowerDaoImpl();
		int result = dao.insert(whistleblower);
		
		return result > 0;
	}

}
