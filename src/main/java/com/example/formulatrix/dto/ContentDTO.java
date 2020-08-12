package com.example.formulatrix.dto;

import java.util.Objects;

public class ContentDTO {
    private String itemName;
    private String itemContent;
    private Integer itemType;


    public ContentDTO() {
    }

    public ContentDTO(String itemName, String itemContent, Integer itemType) {
        this.itemName = itemName;
        this.itemContent = itemContent;
        this.itemType = itemType;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemContent() {
        return this.itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public Integer getItemType() {
        return this.itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public ContentDTO itemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public ContentDTO itemContent(String itemContent) {
        this.itemContent = itemContent;
        return this;
    }

    public ContentDTO itemType(Integer itemType) {
        this.itemType = itemType;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ContentDTO)) {
            return false;
        }
        ContentDTO contentDTO = (ContentDTO) o;
        return Objects.equals(itemName, contentDTO.itemName) && Objects.equals(itemContent, contentDTO.itemContent) && Objects.equals(itemType, contentDTO.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemContent, itemType);
    }

    @Override
    public String toString() {
        return "{" +
            " itemName='" + getItemName() + "'" +
            ", itemContent='" + getItemContent() + "'" +
            ", itemType='" + getItemType() + "'" +
            "}";
    }

}