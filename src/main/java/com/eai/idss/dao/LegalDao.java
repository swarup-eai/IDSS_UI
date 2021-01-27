package com.eai.idss.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.eai.idss.model.Legal;
import com.eai.idss.model.User;
import com.eai.idss.vo.LegalDetailsRequest;
import com.eai.idss.vo.LegalFilter;
import com.eai.idss.vo.TileVo;

public interface LegalDao {

	public Map<String,List<TileVo>> getPendingLegalActionsData(LegalFilter cf,String region,String subRegion);
	
	public Map<String,Map<String,List<TileVo>>> getLegalActionsByIndustryScaleCategoryData(String region,String subRegion);
	
	public Map<String,Map<String,List<TileVo>>> getByRegionLegalData(LegalFilter cf);
	
	public Map<String,Map<String,List<TileVo>>> getBySubRegionLegalData(String region,LegalFilter cf);
	
	public Map<String,List<TileVo>> getByTeamLegalData(LegalFilter cf,User u);
	
	public List<Legal> getLegalPaginatedRecords(LegalDetailsRequest cdr, Pageable pageable);
}
