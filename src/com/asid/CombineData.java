package com.asid;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author sachithra
 */
public class CombineData {
	private int NICCount=0;
	private int DrivingLsnCount=0;
	private int VehicleCount=0;
    public JSONObject Combine(ResultSet NIC,ResultSet NICCount,ResultSet DrivingLsn,ResultSet DrivingLsnCount,ResultSet Vehicle, ResultSet VehicleCount/*,GovGui ui*/) throws JSONException{
        ResultSetMetaData rsmd,rsmd1,rsmd2;
        try {
        	 if(NICCount.next())
        	        this.setNICCounter(NICCount.getInt("niccount"));
        	        
        	        if(DrivingLsnCount.next())
        	            this.setDrivingLsnCounter(DrivingLsnCount.getInt("drivecount"));
        	        
        	        if(VehicleCount.next())
        	            this.setVehicleCounter(VehicleCount.getInt("vehiclecount"));
            rsmd = NIC.getMetaData();
            rsmd1=DrivingLsn.getMetaData();
            rsmd2=Vehicle.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            int columnsNumber1 = rsmd1.getColumnCount();
            int columnsNumber2 = rsmd2.getColumnCount();
            JSONObject[] obj = new JSONObject[/*this.getVehicleCounter()+this.getDrivingLsnCounter()+*/this.getNICCounter()];
            JSONObject[] NICObj = new JSONObject[this.getNICCounter()];
            JSONObject[] DrivingLsnObj = new JSONObject[this.getDrivingLsnCounter()];
            JSONObject[] VehicleObj = new JSONObject[this.getVehicleCounter()];
            JSONObject a=new JSONObject();
            
            
            
            
         String[] id=new String[/*this.getVehicleCounter()+this.getDrivingLsnCounter()+*/this.getNICCounter()];
         for(int i=0;i<this.getNICCounter();i++){
             id[i]="kkk";
             obj[i]=new JSONObject();
         }
         for(int i=0;i<this.getNICCounter();i++){
             NICObj[i]=new JSONObject();
         }
         for(int i=0;i<this.getDrivingLsnCounter();i++){
             DrivingLsnObj[i]=new JSONObject();
         }
         for(int i=0;i<this.getVehicleCounter();i++){
             VehicleObj[i]=new JSONObject();
            // obj[i]=null;
           // NICObj[i]=null;
            // DrivingLsnObj[i]=null;
            // VehicleObj[i]=null;
         }
         int counter=0;
   while (NIC.next()) {
        id[counter]="NYC data is, NIC="+NIC.getString("NIC")+" Name="+NIC.getString("name");
        
        NICObj[counter].put("Name", NIC.getString("name"));
        NICObj[counter].put("ID", NIC.getString("NIC"));
        NICObj[counter].put("FamilyName", NIC.getString("FamilyName"));
        NICObj[counter].put("Surname", NIC.getString("Surname"));
        NICObj[counter].put("Civil Status", NIC.getString("Civil_Status"));
        NICObj[counter].put("Profession", NIC.getString("Profession"));
        NICObj[counter].put("place of birth", NIC.getString("place_of_birth"));
        NICObj[counter].put("secretariat division", NIC.getString("secretariat_division_"));
        NICObj[counter].put("District", NIC.getString("district"));
        NICObj[counter].put("Number of the house", NIC.getString("Number_of_the_house"));
        NICObj[counter].put("street", NIC.getString("street"));
        NICObj[counter].put("village or city", NIC.getString("village_or_city"));
         NICObj[counter].put("place of birth", NIC.getString("place_of_birth"));
        NICObj[counter].put("postal code", NIC.getString("postal_code"));
        NICObj[counter].put("telephone", NIC.getString("telephone"));
        NICObj[counter].put("E-mail", NIC.getString("E-mail"));
        NICObj[counter].put("Date of birth", NIC.getString("date_of_birth"));
        NICObj[counter].put("picture", NIC.getString("Picture"));
       NICObj[counter].put("score",0);
        /*for(int i=0;i<columnsNumber;i++){
            String columnValue = NIC.getString(i);
        id[counter]=id[counter]+columnValue + " " + rsmd.getColumnName(i)+",";
                }*/
        while (DrivingLsn.next()) {
        	if(counter>=this.getDrivingLsnCounter()){
        		break;
        	}
            if(NIC.getString("NIC").equals(DrivingLsn.getString("NIC"))){
            id[counter]=id[counter]+"\r\n Driving license data is, Name="+DrivingLsn.getString("Name_With_Initials")+" License Number="+DrivingLsn.getString("Driving_License_Number");
            DrivingLsnObj[counter].put("Full Name", DrivingLsn.getString("Full_Name"));
            DrivingLsnObj[counter].put("Name with initials", DrivingLsn.getString("Name_With_Initials"));
            DrivingLsnObj[counter].put("sex", DrivingLsn.getString("sex"));
            DrivingLsnObj[counter].put("address", DrivingLsn.getString("Address"));
            DrivingLsnObj[counter].put("ID", DrivingLsn.getString("NIC"));
            DrivingLsnObj[counter].put("Date of birth", DrivingLsn.getString("date_of_birth"));
            DrivingLsnObj[counter].put("driving licence number", DrivingLsn.getString("Driving_License_Number"));
            DrivingLsnObj[counter].put("Blood Type", DrivingLsn.getString("Blood_type"));
        
            }
        }
        DrivingLsn.beforeFirst();
            while(Vehicle.next()){
            	if(counter>=this.getVehicleCounter()){
            		break;
            	}
                if(NIC.getString("NIC").equals(Vehicle.getString("NIC"))){
                id[counter]=id[counter]+"\r\n Vehicle data is, Name="+Vehicle.getString("Full_Name")+" Vehicle Number="+Vehicle.getString("Vehicle_Number");
                VehicleObj[counter].put("Full Name", Vehicle.getString("Full_Name"));
                VehicleObj[counter].put("Name with initials", Vehicle.getString("Name_With_Initials"));
                VehicleObj[counter].put("Address", Vehicle.getString("Address"));
                VehicleObj[counter].put("NIC", Vehicle.getString("NIC"));
                VehicleObj[counter].put("Date of birth", Vehicle.getString("Date_Of_Birth"));
                VehicleObj[counter].put("Engine Model", Vehicle.getString("Engine_Model"));
                VehicleObj[counter].put("Year of manufactured", Vehicle.getString("year_of_manufactured"));
                VehicleObj[counter].put("vehicle number", Vehicle.getString("vehicle_number"));
               // System.out.println(Vehicle.getString("Address"));
              //  System.out.println(VehicleObj[counter].get("Address"));
                }
               // for(int k=1; k<=columnsNumber2;k++){
                    
           // if (i > 1) System.out.print(",  ");
           // String columnValue = NIC.getString(i);
            //System.out.print(columnValue + " " + rsmd.getColumnName(i));
           // id[i]=NIC.getString("NIC");
      
    }
            Vehicle.beforeFirst();
            counter++;
        
    }
   System.out.println(this.getDrivingLsnCounter()+"fuck me");
    for(int i=0;i<this.getNICCounter();i++){
        if(NICObj[i]!=null){
            obj[i].put("NIC data", NICObj[i]);
        }
    }
    for(int i=0;i<this.getDrivingLsnCounter();i++){
        if(DrivingLsnObj[i]!=null){
            obj[i].put("Driving License data", DrivingLsnObj[i]);
        }
    }
    for(int i=0;i<this.getVehicleCounter();i++){
        if(VehicleObj[i]!=null){
            obj[i].put("Vehicle data", VehicleObj[i]);
            //System.out.println(obj[i].get("Vehicle data"));
        }
    }
    a.put("Everything", obj);
    /*for(int i=0;i<50;i++){
        if(id[i]!="kkk"){
    System.out.println(id[i]);
    System.out.println(" ");
    System.out.println(" ");
        }
    }*/
   
    for(int i=0;i<this.getVehicleCounter();i++){
    	JSONObject vehicle_data = (JSONObject) obj[i].get("Vehicle data");
    	
    	
    //	System.out.println(obj[i].get("Vehicle data"));
    	
    }
   /* ui.input(id);*
    */
   
    return a;
        } catch (SQLException ex) {
            Logger.getLogger(CombineData.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
     
    }
    public void setNICCounter(int counter){
    	NICCount=counter;
    }
    public int getNICCounter(){
    	return NICCount;
    }
    public void setDrivingLsnCounter(int counter){
    	DrivingLsnCount=counter;
    }
    public int getDrivingLsnCounter(){
    	return DrivingLsnCount;
    }
    public void setVehicleCounter(int counter){
    	VehicleCount=counter;
    }
    public int getVehicleCounter(){
    	return VehicleCount;
    }
   
}
