package com.iit.mp.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BoardAttachDto {
	private int atchNo, atchFileSz;
	private String atchFileNm, atchExtnNm;
	private Date atchStrgYmd;
}
