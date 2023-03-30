package com.iit.mp.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class AttachmentDto {
	private int atchNo;
	private long atchFileSz;
	private String atchExtnNm, atchFileNm;
	private Date atchStrgYmd;
	
	public int getAtchNo(){
		return atchNo;
	}
	
	public void getAtchNo(int atchNo){
		this.atchNo = atchNo;
	}
	
	public long getAtchFileSz(){
		return atchFileSz;
	}
	
	public void getAtchFileSz(long atchFileSz){
		this.atchFileSz = atchFileSz;
	}

	public String getAtchFileNm() {
		return atchFileNm;
	}

	public String getAtchExtnNm() {
	    return atchExtnNm;
	}

}
