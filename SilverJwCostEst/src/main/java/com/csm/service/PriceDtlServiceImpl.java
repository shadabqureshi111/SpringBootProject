package com.csm.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csm.dto.PriceSlab;
import com.csm.model.PriceDtl;
import com.csm.model.ProductDtl;
import com.csm.repo.PriceDtlRepo;
import com.csm.repo.ProdectRepo;

@Service
public class PriceDtlServiceImpl implements PriceDtlService {
	
	@Autowired
	ProdectRepo prodRepo;
	
	@Autowired
	PriceDtlRepo priceRepo;
	
	@PersistenceContext
	EntityManager em;
	
	public PriceDtl convertPriceSlabToPriceDtl(PriceSlab ps) {
		PriceDtl pd=new PriceDtl();
		ProductDtl product =prodRepo.findById(ps.getProductId()).get();
		pd.setProductDtl(product);
		pd.setCurrentDate(new Date());
	    
		double makingChargAfterDiscount=(ps.getMakingChargesPerGram()*product.getWeight())-(ps.getMakingChargesPerGram()*product.getWeight()*ps.getDiscountOnMakingCharges()/100);
	    pd.setMakingChargeAfterDiscount(makingChargAfterDiscount);
	    
	    pd.setCurrentRatePerGram(ps.getTodaySilverRate()/10);
	    
	    double grossAmount= (pd.getCurrentRatePerGram()*product.getWeight())+pd.getMakingChargeAfterDiscount();
	    pd.setGrossAmount(grossAmount);
	    
	    pd.setGstAmount(pd.getGrossAmount()*(ps.getGstPercent()/100));
	    pd.setNetPrice(pd.getGrossAmount()+pd.getGstAmount());
		return pd;
	}

	@Override
	@Transactional
	public List<PriceDtl> saveAllPriceDtls(List<PriceDtl> priceDtls) {
		//priceDtls.forEach(pd->priceRepo.save(pd));
		
		try {
		priceRepo.saveAll(priceDtls);
//			EntityTransaction tn = em.getTransaction();
//			tn.begin();
			
//			tn.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return priceRepo.findAll();
	}

	@Override
	public List<PriceDtl> getAllList() {
		// TODO Auto-generated method stub
		return priceRepo.findAll();
	};

}
