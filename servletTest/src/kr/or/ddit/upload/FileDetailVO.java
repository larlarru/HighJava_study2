package kr.or.ddit.upload;

import java.io.Serializable;

// 업로드된 파일 정보를 저장할 클래스
public class FileDetailVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String fileName;
	private long fileSize;
	private String uploadStatus;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getUploadStatus() {
		return uploadStatus;
	}
	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
	
	
	
	

}
