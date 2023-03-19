package com.iit.mp.vo;

import java.util.List;

import com.iit.mp.dto.AttachmentDto;
import com.iit.mp.dto.BoardDto;
import com.iit.mp.dto.ReplyDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BoardDetailVO {
	private BoardDto boardDto;
	private List<ReplyDto> replyList;
	private List<AttachmentDto> atchList;
}
