package com.example.prototype.item;

import lombok.Data;

@Data
public class UploadFile {

    //uploadFile은 사용자가 올리면서 설정한 파일이름
    //storeFile은 서버가 저장한 이상한 문자 파일이름
    private String uploadFileName;
    private String storeFileName;

    public UploadFile(String uploadFileName,String storeFileName){
        this.uploadFileName=uploadFileName;
        this.storeFileName=storeFileName;
    }
}
