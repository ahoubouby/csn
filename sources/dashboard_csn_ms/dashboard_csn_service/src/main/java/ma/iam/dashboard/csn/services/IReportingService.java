package ma.iam.dashboard.csn.services;

import java.util.List;

import ma.iam.dashboard.csn.dtos.ReportingDto;

/**
 * 
 * @author K.ELBAGUARI && O.SLAAOUITER && H.ELKHATEB
 *
 */
public interface IReportingService {

	List<ReportingDto> getListEquipementReportingByCriteres(String dr, String dc, String technologie, String infrastructure);
}
