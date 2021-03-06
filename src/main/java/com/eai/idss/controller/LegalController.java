package com.eai.idss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.eai.idss.util.IDSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eai.idss.dao.LegalDao;
import com.eai.idss.model.User;
import com.eai.idss.repository.UserRepository;
import com.eai.idss.vo.LegalDetailsRequest;
import com.eai.idss.vo.LegalFilter;
import com.eai.idss.vo.LegalPaginationResponseVo;
import com.eai.idss.vo.TileVo;


@RestController
@CrossOrigin(origins ={"http://localhost:4200", "http://10.10.10.32:8080"})
public class LegalController {

	@Autowired
	private LegalDao cd;
	
	
	
    @Autowired
    private UserRepository userRepository;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST, value = "/legal-details", produces = "application/json")
	public ResponseEntity<LegalPaginationResponseVo> getLegalDetailsData(@RequestBody LegalDetailsRequest cdr, Pageable pageable) throws IOException {
    	LegalPaginationResponseVo cl = null;
	    try {
	    	cl =  cd.getLegalPaginatedRecords(cdr,pageable);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Exception in /Legal-details", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<LegalPaginationResponseVo>(cl,HttpStatus.OK);
	}
    
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "/legal-dashboard/action-by-category-type", produces = "application/json")
	public ResponseEntity<Map<String,Map<String,Map<String,List<TileVo>>>>> getLegalActionByCategoryTypeData(@RequestHeader String userName) throws IOException {
    	Map<String,Map<String,Map<String,List<TileVo>>>> ct = new LinkedHashMap<String,Map<String, Map<String,List<TileVo>>>>();
	    try {
	    	User u = userRepository.findByUserName(userName);
	    	ct.put("actionByCategory",cd.getLegalActionsByIndustryScaleCategoryData(u.getRegion(),u.getSubRegion()));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Exception in /legal-dashboard/action-by-category-type", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<Map<String,Map<String,Map<String,List<TileVo>>>>>(ct,HttpStatus.OK);
	}
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST, value = "/legal-dashboard/action-by-industry", produces = "application/json")
	public ResponseEntity<Map<String,Map<String,List<TileVo>>>> getLegalActionByIndustryData(@RequestHeader String userName, @RequestBody LegalFilter cf) throws IOException {
    	Map<String,Map<String,List<TileVo>>> ct = new LinkedHashMap<String, Map<String,List<TileVo>>>();
	    try {
//	    	User u = userRepository.findByUserName(userName);
	    	ct.put("actionByIndustry",cd.getLegalActionsByIndustryData(cf,cf.getRegion(),cf.getSubRegion()));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Exception in /legal-dashboard/action-by-industry", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<Map<String,Map<String,List<TileVo>>>>(ct,HttpStatus.OK);
	}
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST, value = "/legal-dashboard/pending-legal-actions",  produces = "application/json")
	public ResponseEntity<Map<String,Map<String,List<TileVo>>>> getLegalDashboardPendingData(@RequestHeader String userName, @RequestBody LegalFilter cf) throws IOException {
    	Map<String,Map<String,List<TileVo>>> ct = new LinkedHashMap<String, Map<String,List<TileVo>>>();
	    try {
//	    	User u = userRepository.findByUserName(userName);
	    	ct.put("pendingRequest",cd.getPendingLegalActionsData(cf,cf.getRegion(),cf.getSubRegion()));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Exception in /legal-dashboard/pending-legal-actions", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<Map<String,Map<String,List<TileVo>>>>(ct,HttpStatus.OK);
	}
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST, value = "/legal-dashboard/request-by-sub-region",  produces = "application/json")
	public ResponseEntity<Map<String,Map<String,Map<String,List<TileVo>>>>> getLegalDataBySubRegionData(@RequestHeader String userName, @RequestBody LegalFilter cf) throws IOException {
    	Map<String,Map<String,Map<String,List<TileVo>>>> ct = new LinkedHashMap<String, Map<String,Map<String,List<TileVo>>>>();
	    try {
	    	User u = userRepository.findByUserName(userName);
			List<String> subRegions =new ArrayList<String>();
			if(u.getDesignation().equals("RO")){
				subRegions = IDSSUtil.getSubRegion(u.getRegion());
			}else{
				subRegions.add(u.getSubRegion());
			}
	    	ct.put("bySubRegionRequest",cd.getBySubRegionLegalData(subRegions, cf));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Exception in /legal-dashboard/request-by-sub-region", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<Map<String,Map<String,Map<String,List<TileVo>>>>>(ct,HttpStatus.OK);
	}
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST, value = "/legal-dashboard/pending-by-team",  produces = "application/json")
	public ResponseEntity<Map<String,Map<String,List<TileVo>>>> getLegalDataPendingByTeam(@RequestHeader String userName,@RequestBody LegalFilter cf) throws IOException {
    	Map<String,Map<String,List<TileVo>>> ct = new LinkedHashMap<String, Map<String,List<TileVo>>>();
	    try {
	    	User u = userRepository.findByUserName(userName);
	    	ct.put("pendingByTeamLegalData",cd.getByTeamLegalData(cf,u));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Exception in /legal-dashboard/pending-by-team", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<Map<String,Map<String,List<TileVo>>>>(ct,HttpStatus.OK);
	}
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST, value = "/legal-dashboard/by-region", produces = "application/json")
	public ResponseEntity<Map<String,Map<String,Map<String,List<TileVo>>>>> getLegalDataByRegion(@RequestBody LegalFilter cf) throws IOException {
    	Map<String,Map<String,Map<String,List<TileVo>>>> ct = new LinkedHashMap<String,Map<String, Map<String,List<TileVo>>>>();
	    try {
	    	ct.put("byRegion",cd.getByRegionLegalData(cf));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Exception in /legal-dashboard/by-region", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<Map<String,Map<String,Map<String,List<TileVo>>>>>(ct,HttpStatus.OK);
	}
    
}
