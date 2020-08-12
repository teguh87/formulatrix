package com.example.formulatrix.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

import java.util.Objects;

@Table(name = "content")
@Entity
public class ContentEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "item_name", length = 20, nullable = false)
    private String itemName;

    @Column(name = "item_type", nullable = false)
    private Integer itemType;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "register_id", nullable=false)
    private RegisterEntity itemContent;


    public ContentEntity() {
    }

    public ContentEntity(String itemName, RegisterEntity itemContent, Integer itemType) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemContent = itemContent;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemType() {
        return this.itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public RegisterEntity getItemContent() {
        return this.itemContent;
    }

    public void setItemContent(RegisterEntity itemContent) {
        this.itemContent = itemContent;
    }

    public ContentEntity id(Integer id) {
        this.id = id;
        return this;
    }

    public ContentEntity itemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public ContentEntity itemType(Integer itemType) {
        this.itemType = itemType;
        return this;
    }

    public ContentEntity itemContent(RegisterEntity itemContent) {
        this.itemContent = itemContent;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ContentEntity)) {
            return false;
        }
        ContentEntity contentEntity = (ContentEntity) o;
        return Objects.equals(id, contentEntity.id) && Objects.equals(itemName, contentEntity.itemName) && Objects.equals(itemType, contentEntity.itemType) && Objects.equals(itemContent, contentEntity.itemContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemName, itemType, itemContent);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", itemName='" + getItemName() + "'" +
            ", itemType='" + getItemType() + "'" +
            "}";
    }

}