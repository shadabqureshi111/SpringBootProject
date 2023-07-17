package com.vision.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Category implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	 @Id
	 private Integer id;
     private String title;
     private Date createdAt;
     private Date updatedAt;
     private Integer cluesCount;

     
     public Category() {
     }

     public Category(@JsonProperty("id") int id,
                     @JsonProperty("title") String title,
                     @JsonProperty("created_at") Date createdAt,
                     @JsonProperty("updated_at") Date updatedAt,
                     @JsonProperty("clues_count") int cluesCount) {
         this.id = id;
         this.title = title;
         this.createdAt = createdAt;
         this.updatedAt = updatedAt;
         this.cluesCount = cluesCount;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getTitle() {
         return title;
     }

     public void setTitle(String title) {
         this.title = title;
     }

     public Date getCreatedAt() {
         return createdAt;
     }

     public void setCreatedAt(Date createdAt) {
         this.createdAt = createdAt;
     }

     public Date getUpdatedAt() {
         return updatedAt;
     }

     public void setUpdatedAt(Date updatedAt) {
         this.updatedAt = updatedAt;
     }

     public int getCluesCount() {
         return cluesCount;
     }

     public void setCluesCount(int cluesCount) {
         this.cluesCount = cluesCount;
     }
	

}
