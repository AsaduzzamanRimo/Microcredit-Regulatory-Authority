package com.doer.mraims.core.util;

import com.doer.mraims.core.util.model.Address;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.text.ParseException;


public class AddressUtil {
	
 public static Address jsonStringToObjectConvert(String jsonAddress) throws ParseException {
		
		Object obj= JSONValue.parse(jsonAddress);
        JSONObject jsonObject = (JSONObject) obj;

        Address address = new Address();
        address.setCareOf((String) jsonObject.get("careOf"));
        address.setHouseNo((String) jsonObject.get("houseNo"));
        address.setRoadNo((String) jsonObject.get("roadNo"));
        address.setVillageOrWord((String) jsonObject.get("villageOrWord"));
        address.setPostOffice((String) jsonObject.get("postOffice"));
        address.setPostcode((String) jsonObject.get("postcode"));
        address.setThana((String) jsonObject.get("thana"));
        address.setThanaOid((String) jsonObject.get("thanaOid"));
        address.setDistrict((String) jsonObject.get("district"));
        address.setDistrictOid((String) jsonObject.get("districtOid"));
		
		return address;
	}
}
