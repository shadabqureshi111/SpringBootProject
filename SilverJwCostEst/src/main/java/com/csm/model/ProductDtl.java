package com.csm.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the product_dtls database table.
 * 
 */
@Entity
@Table(name="product_dtls")
@Getter
@Setter
@ToString
public class ProductDtl implements Serializable {


	@Id
	@Column(name="product_id")
	private Integer productId;

	@Column(name="product_type")
	private String productType;

	private Double weight;

	

	

}