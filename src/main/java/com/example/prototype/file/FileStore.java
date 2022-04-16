package com.example.prototype.file;

import com.example.prototype.item.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileStore {

    @Value("${file.dir}")
    private String fileDir;

    //파일명의 위치
    public String getFullPath(String filename){
        return fileDir + filename;
    }

    //이미지파일들 담는용
    public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<UploadFile> storeFileResult=new ArrayList<>();
        for(MultipartFile multipartFile:multipartFiles){
            if(!multipartFile.isEmpty()){
                UploadFile uploadFile = storeFile(multipartFile);
                storeFileResult.add(uploadFile);
            }
        }
        return storeFileResult;
    }

    //이건 이미지 파일 1개 담는용
    public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
        if(multipartFile.isEmpty()){
            return null;
        }
        //사용자가 올린 오리지널 파일명
        String originalFilename= multipartFile.getOriginalFilename();
        //서버 저장하는 파일명
        String storeFileName = createStoreFileName(originalFilename);
        multipartFile.transferTo(new File(getFullPath(storeFileName)));

        return new UploadFile(originalFilename,storeFileName);

    }

    //저장할 파일이름 잡아주기 ->getFullPath 만들기위함
    private String createStoreFileName(String originalFilename) {
        //대충 랜덤으로 만들어줌
        String uuid = UUID.randomUUID().toString();
        String ext = extracted(originalFilename);
        return uuid+"."+ext;
    }

    //확장자 빼오는용
    private String extracted(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos+1);
    }

}
