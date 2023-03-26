package com.iit.mp.dto;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BoardDto {
    private String pstgWrtId, pstgWrtTitle, pstgWrtCn;
    private int pstgNo, pstgInqCnt, pstgGroup, pstgDepth, pstgParent;
    private Date pstgWrtYmd, pstgMdfcnYmd;
    
    private List<AttachmentDto> attachments;

    
    //pstgWrtYmd String에서 Date로 변환
    public String getPstgWrtYmd() {
        if (pstgWrtYmd == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(pstgWrtYmd);
    }
    //조회수 증가
    public int getViewCount() {
        return pstgInqCnt;
    }

    public void setViewCount(int viewCount) {
        this.pstgInqCnt = viewCount;
    }
    
    //게시글 답변
    public String getPstgWrtTitle() {
        return pstgWrtTitle;
    }

    public void setPstgWrtTitle(String pstgWrtTitle) {
        this.pstgWrtTitle = pstgWrtTitle;
    }
    
}
