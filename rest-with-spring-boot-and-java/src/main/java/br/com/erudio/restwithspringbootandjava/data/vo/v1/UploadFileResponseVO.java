package br.com.erudio.restwithspringbootandjava.data.vo.v1;

import java.io.Serializable;

public class UploadFileResponseVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fileName;
    private String fileDownloadUri;
    private String fieType;
    private long size;

    public UploadFileResponseVO() {}

    public UploadFileResponseVO(String fileName, String fileDownloadUri, String fieType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fieType = fieType;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFieType() {
        return fieType;
    }

    public void setFieType(String fieType) {
        this.fieType = fieType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
