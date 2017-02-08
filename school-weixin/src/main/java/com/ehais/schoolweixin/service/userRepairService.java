package com.ehais.schoolweixin.service;

import org.ehais.tools.ReturnObject;
import com.ehais.schoolweixin.model.wxRepair;

public interface userRepairService {

	ReturnObject<?> saveRepairList(wxRepair urmodel);

	ReturnObject<wxRepair> getRepairList(String wxid);

}