package com.example.prototype.item;

import lombok.Data;

import java.util.List;

@Data
public class Item {

private Long id;
private String itemName;
private int price;
private String userName;
private String tag;
private String content;
private UploadFile attachFile;
private boolean HotDeal;
private List<UploadFile> imageFiles;
}
