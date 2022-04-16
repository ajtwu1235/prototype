package com.example.prototype.controller;

import com.example.prototype.item.UploadFile;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ItemForm {
        private Long id;
        private String itemName;
        private int price;
        private String userName;
        private String tag;
        private String content;
        private MultipartFile attachFile;
        private List<MultipartFile> imageFiles;

}
