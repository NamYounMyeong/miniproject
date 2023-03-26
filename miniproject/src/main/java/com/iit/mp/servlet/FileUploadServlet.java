/*package com.iit.mp.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.velocity.tools.config.Data;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;

import com.iit.mp.dao.AttachmentDao;
import com.iit.mp.dao.BoardDao;
import com.iit.mp.dto.AttachmentDto;
import com.iit.mp.dto.BoardDto;

@WebServlet("/insert")
@MultipartConfig(location = "C:/attach", maxFileSize = 1024 * 1024 * 10)
public class FileUploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);

    private BoardDao boardDao = new BoardDao();
    private AttachmentDao attachmentDao = new AttachmentDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pstgWrtTitle = request.getParameter("pstgWrtTitle");
        String pstgWrtId = request.getParameter("pstgWrtId");
        String pstgWrtCn = request.getParameter("pstgWrtCn");

        // 파일 업로드
        Part filePart = request.getPart("attach");
        AttachmentDto attachmentDto = null;
        if (filePart != null && filePart.getSize() > 0) {
            String atchExtnNm = StringUtils.substringAfterLast(filePart.getSubmittedFileName(), ".");
            String atchFileNm = UUID.randomUUID().toString() + "." + atchExtnNm;
            int atchFileSz = (int) filePart.getSize();
            Date atchStrgYmd = new Date(System.currentTimeMillis());

            attachmentDto = AttachmentDto.builder().atchExtnNm(atchExtnNm).atchFileNm(atchFileNm)
                    .atchFileSz(atchFileSz).atchStrgYmd(atchStrgYmd).build();

            try (InputStream is = filePart.getInputStream();
                    FileOutputStream fos = new FileOutputStream("C:/attach/" + atchFileNm)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, length);
                }
            } catch (Exception e) {
                logger.error("Error occurred while saving attachment file.", e);
                throw new ServletException("Error occurred while saving attachment file.", e);
            }
        }

        BoardDto boardDto = BoardDto.builder().pstgWrtTitle(pstgWrtTitle).pstgWrtId(pstgWrtId).pstgWrtCn(pstgWrtCn)
                .build();

        // 게시글 등록
        int pstgNo = BoardDao.writeBoard(boardDto);

        // 첨부파일 정보 등록
        if (attachmentDto != null) {
            attachmentDto.setAtchNo(pstgNo);
            attachmentDao.insertAttachment(attachmentDto);
        }

        response.sendRedirect("board");
    }

}

}
*/