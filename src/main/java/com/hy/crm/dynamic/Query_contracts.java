package com.hy.crm.dynamic;

import com.hy.crm.entity.Contracts;
import org.apache.ibatis.annotations.Param;

public class Query_contracts {


    public String query(@Param("contracts") Contracts contracts){

        StringBuffer sql=new StringBuffer(" select *,(select sum(re_monkey) from remittance r where r.ct_id=ct.ct_id )  re_monkey ,(select sum(ch_monkey) from checks ch where ch.ct_id=ct.ct_id)  ch_monkey  from  contracts ct ");

        return sql.toString();
    }


}
