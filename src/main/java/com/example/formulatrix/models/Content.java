package com.example.formulatrix.models;

import java.util.Objects;

public class Content {
    private String itemName;
    private Register itemContent;
    private Integer itemType;


    public Content() {
    }

    public Content(String itemName, Register itemContent, Integer itemType) {
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

    public Register getItemContent() {
        return this.itemContent;
    }

    public void setItemContent(Register itemContent) {
        this.itemContent = itemContent;
    }

    public Integer getItemType() {
        return this.itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public Content itemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public Content itemContent(Register itemContent) {
        this.itemContent = itemContent;
        return this;
    }

    public Content itemType(Integer itemType) {
        this.itemType = itemType;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Content)) {
            return false;
        }
        Content content = (Content) o;
        return Objects.equals(itemName, content.itemName) && Objects.equals(itemContent, content.itemContent) && Objects.equals(itemType, content.itemType);
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