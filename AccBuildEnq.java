package com.itss.buildenq;

import java.util.List;

import com.temenos.t24.api.complex.eb.enquiryhook.EnquiryContext;
import com.temenos.t24.api.complex.eb.enquiryhook.FilterCriteria;
import com.temenos.t24.api.hook.system.Enquiry;

/**
 * TODO: Document me!
 *
 * @author User1
 *
 */
public class AccBuildEnq extends Enquiry {

    @Override
    public List<FilterCriteria> setFilterCriteria(List<FilterCriteria> filterCriteria, EnquiryContext enquiryContext) {
        // TODO Auto-generated method stub
        
        FilterCriteria fc= new FilterCriteria();
        fc.setFieldname("CURRENCY");
        fc.setOperand("EQ");
        fc.setValue("USD");
        
        
        filterCriteria.add(fc);
        return filterCriteria;
        
       
    }

    
    
}
