package ma.iam.dashboard.csn.job.services.implementations;

import ma.iam.dashboard.csn.job.job.services.interfaces.IDashboardCsnLoadDataService;
import ma.iam.dashboard.csn.job.job.services.interfaces.IDashboardCsnService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardCsnServiceImpl implements IDashboardCsnService{
	@Autowired
	private IDashboardCsnLoadDataService service;
	@Override
	public void loadData() {
		service.loadReq1();
		service.loadReq2();
		service.loadReq3();
		service.loadReq4();
		service.loadReq5();
		service.loadReq6();
		service.loadData();		
	}

}
