package com.itss.enquiry;

import java.util.List;

import com.temenos.api.TDate;
import com.temenos.api.TStructure;
import com.temenos.t24.api.arrangement.accounting.Contract;
import com.temenos.t24.api.complex.eb.enquiryhook.EnquiryContext;
import com.temenos.t24.api.complex.eb.enquiryhook.FilterCriteria;
import com.temenos.t24.api.hook.system.Enquiry;
import com.temenos.t24.api.records.aaarrtermamount.AaArrTermAmountRecord;
import com.temenos.t24.api.system.Session;
/**
 * TODO: Document me!
 *
 * @author santh
 *
 */
public class ConversionAmount extends Enquiry {

    @Override
    public String setValue(String value, String currentId, TStructure currentRecord,
            List<FilterCriteria> filterCriteria, EnquiryContext enquiryContext) {
        // TODO Auto-generated method stub
       
       
        Session session = new Session(this);
        Contract ct=new Contract(this);
        ct.setContractId(currentId);
        String today = session.getCurrentVariable("!TODAY");
        TDate TodayDate = new TDate(today);
        String TermAmount=ct.getPropertyIdsForPropertyClass("TERM.AMOUNT").get(0);
        AaArrTermAmountRecord ta = new AaArrTermAmountRecord(ct.getConditionForPropertyEffectiveDate(TermAmount, TodayDate));
        
        String amt = ta.getAmount().toString();

        return amt;
    }
    
    

}
