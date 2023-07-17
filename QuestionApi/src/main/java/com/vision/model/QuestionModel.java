package com.vision.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "question_answer")
public class QuestionModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	public QuestionModel() {
		super();
	}

	@Id
	private Integer id;
    private String answer;
    private String question;
    private Integer value;
    private Date airdate;
    private Date createdAt;
    private Date updatedAt;
    
    @Transient
    private Integer categoryId;
    private Integer gameId;
    private Integer invalidCount;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_Id")
    private Category category;

    
    public QuestionModel(@JsonProperty("id") int id,
            @JsonProperty("answer") String answer,
            @JsonProperty("question") String question,
            @JsonProperty("value") int value,
            @JsonProperty("airdate") Date airdate,
            @JsonProperty("created_at") Date createdAt,
            @JsonProperty("updated_at") Date updatedAt,
            @JsonProperty("category_id") Integer categoryId,
            @JsonProperty("game_id") Integer gameId,
            @JsonProperty("invalid_count") Integer invalidCount,
            @JsonProperty("category") Category category) {
										this.id = id;
										this.answer = answer;
										this.question = question;
										this.value = value;
										this.airdate = airdate;
										this.createdAt = createdAt;
										this.updatedAt = updatedAt;
										this.categoryId = categoryId;
										this.gameId = gameId;
										this.invalidCount = invalidCount;
										this.category = category;}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Date getAirdate() {
		return airdate;
	}

	public void setAirdate(Date airdate) {
		this.airdate = airdate;
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

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getInvalidCount() {
		return invalidCount;
	}

	public void setInvalidCount(Integer invalidCount) {
		this.invalidCount = invalidCount;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "QuetionModel [id=" + id + ", answer=" + answer + ", question=" + question + ", value=" + value
				+ ", airdate=" + airdate + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", categoryId="
				+ categoryId + ", gameId=" + gameId + ", invalidCount=" + invalidCount + ", category=" + category + "]";
	}
	
	

}
