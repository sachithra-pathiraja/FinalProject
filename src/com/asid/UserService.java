package com.asid;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/UserService")
public class UserService {

  // UserDao userDao = new UserDao();
	FYPAsid asid=new FYPAsid();
	NICData ex=new NICData();
    DrivingLsnData ex1= new DrivingLsnData();
    VehicleData ex2= new VehicleData();
    CombineData ex3=new CombineData();
    FYPAsid ex4=new FYPAsid();

   @GET
   @Path("/user")
   @Produces(MediaType.APPLICATION_JSON)
   public String getGov(@QueryParam("name")String name) throws JSONException{
	   System.out.println("sachithra");
     return asid.doJob(ex, ex1, ex2, ex3, name).toString();
	   //return "sachithra";
   }
   @POST
   @Path("/suggestion")
   @Produces(MediaType.APPLICATION_JSON)
   public String getUsers(String aggregated) throws JSONException{
	   
	   
	   //@QueryParam("name")String name, @QueryParam("town")String town,@QueryParam("job")String prof, @QueryParam("choice")String choice,@QueryParam("school")String school )
	   
	   
	   String city;//"balangoda";
	   String choice="s";
	   String name;//="asela";
	   String school;//="royal";
	   String prof;//="vega";
	   String role;//="PUBLIC";
	   String k="fuck";
	   String district="fuck";
	   String[] ch=new String[3];
	   
	   ch[0]="s";
	   ch[1]="g";
	   /*if(ch[1].equalsIgnoreCase(choice)){
		   return asid.doJob(ex, ex1, ex2, ex3, name).toString();
	   }
	   else */
	   if(ch[0].equalsIgnoreCase(choice)){
	  
	 
		  
		  // String aggregated = "{\"profiles\":[{\"socialMedia\":{\"linkedIn\":{\"skills\":[\"Java\",\"C++\",\"C\",\"Software Engineering\",\"Programming\",\"Computer Hardware\",\"MySQL\",\"Electronics\",\"Object Oriented Software\",\"Embedded Systems\",\"Microcontrollers\",\"Teamwork\",\"Algorithms\",\"C#\",\"HTML\",\"Matlab\",\"Object Oriented Design\",\"Data Structures\",\"Microsoft Office\",\"Visual C++\",\"PHP\",\"NodeJs\",\"Symfony\",\"Raspberry Pi\",\"JavaScript\",\"Amazon Web Services (AWS)\",\"PCB Design\",\"Arduino\",\"Atmel AVR\",\"ASP.NET\",\".NET\",\"Cross-platform Mobile app development\"],\"projects\":[{\"project\":\"Rhino Mark III Robot Arm Recreation\"},{\"project\":\"Object Oriented Software Development\"},{\"project\":\"Smart Personal Digital Assistant\"},{\"project\":\"SkyLyzer\"},{\"project\":\"Smart Personal Digital Assistant\"}],\"languages\":[\"English\",\"Sinhalese\"],\"matched\":true,\"_id\":{\"$oid\":\"57a5eb11fe6fb203d4cbb130\"},\"linkedin\":\"https://www.linkedin.com/in/aselapriyadarshana\",\"name\":\"Asela Priyadarshana\",\"education\":[{\"course\":\"Bachelor of Science (BSc), Computer Engineering\",\"school\":\"University of Moratuwa\"},{\"course\":\", Mathematics\",\"school\":\"Royal College - Colombo 07\"}]},\"facebook\":{\"work\":[{\"work\":\"Siplo\",\"details\":\"Co-founder · 2015 to present · Moratuwa, Sri Lanka\"},{\"work\":\"VEGA\",\"details\":\"Engineering Intern · 19 October 2015 to 2 April 2016 · Maradana\"}],\"social links\":\"https://lk.linkedin.com/in/aselapriyadarshana(LinkedIn)\",\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-1/c164.104.323.323/s160x160/1558597_719877614747952_5267274024535570642_n.jpg?oh=47fd5335a79afbf51f5b6f41a9a45a2b&oe=58EBE85B\",\"friends\":[],\"_id\":{\"$oid\":\"57a5be4afe6fb226a8cb1424\"},\"name\":\"Asela Priyadarshana\",\"facebook\":\"http://facebook.com/asela.darshan\",\"gender\":\"Male\",\"places\":[{\"status\":\"Current city\",\"city\":\"Katubedda, Sri Lanka\"}],\"education\":[{\"school\":\"University of Moratuwa - Faculty of Engineering\",\"details\":\"Class of 2017 · BSc Engineering Honours · Integrated Computer Engineering · Moratuwa, Sri Lanka\"},{\"school\":\"University of Moratuwa - Faculty of Engineering\",\"details\":\"Moratuwa, Sri Lanka\"},{\"school\":\"Royal College (Colombo)\",\"details\":\"Physical science · Colombo, Sri Lanka\"}]}},\"Aggregated Work\":[[\"Siplo\",\"VEGA\"],[\"Co-founder · 2015 to present · Moratuwa, Sri Lanka\",\"Engineering Intern · 19 October 2015 to 2 April 2016 · Maradana\"]],\"government\":{\"Vehicle data\":{},\"NIC data\":{\"Number of the house\":\"1F\",\"Profession\":\"Undergraduate\",\"E-mail\":\"asela.12@cse.mrt.ac.lk\",\"Civil Status\":\"Single\",\"Name\":\"Asela Darshan Buddhika\",\"picture\":\"http://localhost:3000/images/asela.jpg\",\"village or city\":\"Balangoda\",\"Date of birth\":\"12/30/1992 12:00:00 AM\",\"District\":\"Rathnapura\",\"place of birth\":\"Rathnapura\",\"ID\":\"923651824V\",\"secretariat division\":\"Balangoda\",\"FamilyName\":\"\",\"Surname\":\"Priyadarshana\",\"telephone\":\"+94774592258\",\"postal code\":\"70100\"},\"Driving License data\":{}},\"Aggregated Education\":[[\"University of Moratuwa - Faculty of Engineering\",\"Royal College - Colombo 07 (Colombo)\"],[\"class of 2017 ,  bsc engineering honours ,  integrated computer engineering ,  moratuwa,  sri lanka, bachelor of science (bsc), \",\"physical science ,  colombo,  sri lanka,  mathematics, \"]],\"Aggregated Names\":[\"Asela Darshan Buddhika Priyadarshana\"]}]}";
//String aggregated="{\"profiles\":[{\"socialMedia\":{\"linkedIn\":{\"skills\":[\"Java\",\"C++\",\"C\",\"Software Engineering\",\"Programming\",\"Computer Hardware\",\"MySQL\",\"Electronics\",\"Object Oriented Software\",\"Embedded Systems\",\"Microcontrollers\",\"Teamwork\",\"Algorithms\",\"C#\",\"HTML\",\"Matlab\",\"Object Oriented Design\",\"Data Structures\",\"Microsoft Office\",\"Visual C++\",\"PHP\",\"NodeJs\",\"Symfony\",\"Raspberry Pi\",\"JavaScript\",\"Amazon Web Services (AWS)\",\"PCB Design\",\"Arduino\",\"Atmel AVR\",\"ASP.NET\",\".NET\",\"Cross-platform Mobile app development\"],\"projects\":[{\"project\":\"Rhino Mark III Robot Arm Recreation\"},{\"project\":\"Object Oriented Software Development\"},{\"project\":\"Smart Personal Digital Assistant\"},{\"project\":\"SkyLyzer\"},{\"project\":\"Smart Personal Digital Assistant\"}],\"languages\":[\"English\",\"Sinhalese\"],\"matched\":true,\"_id\":{\"$oid\":\"57a5eb11fe6fb203d4cbb130\"},\"linkedin\":\"https://www.linkedin.com/in/aselapriyadarshana\",\"name\":\"Asela Priyadarshana\",\"education\":[{\"course\":\"Bachelor of Science (BSc), Computer Engineering\",\"school\":\"University of Moratuwa\"},{\"course\":\", Mathematics\",\"school\":\"Royal College - Colombo 07\"}]},\"facebook\":{\"work\":[{\"work\":\"Siplo\",\"details\":\"Co-founder · 2015 to present · Moratuwa, Sri Lanka\"},{\"work\":\"VEGA\",\"details\":\"Engineering Intern · 19 October 2015 to 2 April 2016 · Maradana\"}],\"social links\":\"https://lk.linkedin.com/in/aselapriyadarshana(LinkedIn)\",\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-1/c164.104.323.323/s160x160/1558597_719877614747952_5267274024535570642_n.jpg?oh=47fd5335a79afbf51f5b6f41a9a45a2b&oe=58EBE85B\",\"friends\":[],\"_id\":{\"$oid\":\"57a5be4afe6fb226a8cb1424\"},\"name\":\"Asela Priyadarshana\",\"facebook\":\"http://facebook.com/asela.darshan\",\"gender\":\"Male\",\"places\":[{\"status\":\"Current city\",\"city\":\"Katubedda, Sri Lanka\"}],\"education\":[{\"school\":\"University of Moratuwa - Faculty of Engineering\",\"details\":\"Class of 2017 · BSc Engineering Honours · Integrated Computer Engineering · Moratuwa, Sri Lanka\"},{\"school\":\"University of Moratuwa - Faculty of Engineering\",\"details\":\"Moratuwa, Sri Lanka\"},{\"school\":\"Royal College (Colombo)\",\"details\":\"Physical science · Colombo, Sri Lanka\"}]}},\"Aggregated Work\":[[\"Siplo\",\"VEGA\"],[\"Co-founder · 2015 to present · Moratuwa, Sri Lanka\",\"Engineering Intern · 19 October 2015 to 2 April 2016 · Maradana\"]],\"government\":{\"Vehicle data\":{},\"NIC data\":{\"Number of the house\":\"1F\",\"Profession\":\"Undergraduate\",\"E-mail\":\"asela.12@cse.mrt.ac.lk\",\"Civil Status\":\"Single\",\"Name\":\"Asela Darshan Buddhika\",\"picture\":\"http://localhost:3000/images/asela.jpg\",\"village or city\":\"Balangoda\",\"Date of birth\":\"12/30/1992 12:00:00 AM\",\"District\":\"Rathnapura\",\"place of birth\":\"Rathnapura\",\"ID\":\"923651824V\",\"secretariat division\":\"Balangoda\",\"FamilyName\":\"\",\"Surname\":\"Priyadarshana\",\"telephone\":\"+94774592258\",\"postal code\":\"70100\"},\"Driving License data\":{}},\"Aggregated Education\":[[\"University of Moratuwa - Faculty of Engineering\",\"Royal College - Colombo 07 (Colombo)\"],[\"class of 2017 ,  bsc engineering honours ,  integrated computer engineering ,  moratuwa,  sri lanka, bachelor of science (bsc), \",\"physical science ,  colombo,  sri lanka,  mathematics, \"]],\"Aggregated Names\":[\"Asela Darshan Buddhika Priyadarshana\"]}]}";

		   

		 JSONObject everything=new JSONObject(aggregated);
		 JSONArray profiles;
		 name=(String)everything.get("name");
		 school=(String)everything.get("school");
		 prof=(String)everything.get("workPlace");
		 city=(String)everything.get("city");
		 role=(String)everything.get("role");
		 profiles=everything.getJSONArray("profiles");
	   int counter=0;
	   int[] score=new int[profiles.length()];
	   
	   for(int i=0;i<profiles.length();i++){
		   int points=0;
	 // System.out.println(obj[i]);
		   if(profiles.getJSONObject(i).has("government")){
		   JSONObject government=(JSONObject)profiles.getJSONObject(i).get("government");
	   JSONObject NIC_data=(JSONObject)government.get("NIC data");
	 //  System.out.println((String)NIC_data.get("village or city"));
	    k=(String)NIC_data.get("village or city");
	    district=(String)NIC_data.get("District");
		   }
	   JSONObject socialMedia=(JSONObject)profiles.getJSONObject(i).get("socialMedia");
	   if(socialMedia.has("facebook")){
	   JSONObject facebook=(JSONObject)socialMedia.get("facebook");
	//   JSONObject[] places=(JSONObject[])facebook.get("places");
	   if(facebook.has("places")){
	   JSONArray places=facebook.getJSONArray("places");
	   String[] m=new String[places.length()];
	   if(city!=null && city!=""){
	   if(k.toLowerCase().equalsIgnoreCase(city.toLowerCase())){
		  points++; 
	   }
	   if(district.toLowerCase().equalsIgnoreCase(city.toLowerCase())){
			  points++; 
		   }
	   }
	   if(points==0 && city!=null && city!=""){
		   CharSequence seq=(CharSequence)city.toLowerCase();
	   for(int j=0;j<places.length();j++){
		   if(m[j]!=null){    
		   m[j]=(String)places.getJSONObject(j).get("city");
		   if(m[j].toLowerCase().contains(seq) ){
			   points++;
		   }
	   }
	   }
	   }
	   }
	   }
	   if(profiles.getJSONObject(i).has("Aggregated Education")){
	   JSONArray agreEdu=profiles.getJSONObject(i).getJSONArray("Aggregated Education");
	   /*for(int t=0;t<agreEdu[0].length;t++){
		   for(int u=0;u<agreEdu[1].length;u++){
			   if(agreEdu[t][u].toLowerCase().contains((CharSequence)school.toLowerCase())){
				   points++;
			   }
		   }
	   }*/
	 String[] eduDetails=new String[agreEdu.length()];
	 String[] institute=new String[agreEdu.length()];
	 if(school!=null && !school.equals("")){
		 CharSequence seqEdu=(CharSequence)school.toLowerCase();
	 
	   for(int j=0;j<eduDetails.length;j++){
		   eduDetails[j]=(String)agreEdu.getJSONObject(j).get("Details");
		   institute[j]=(String)agreEdu.getJSONObject(j).get("Institute");
		   if(eduDetails[j].toLowerCase().contains(seqEdu) ){
			   points++;
		   }
		   if(institute[j].toLowerCase().contains(seqEdu) ){
			   points++;
		   }
	   }
	   }
	   }
	   if(profiles.getJSONObject(i).has("Aggregated Education")){  
	 JSONArray agreWork=profiles.getJSONObject(i).getJSONArray("Aggregated Work");
	   /*for(int t=0;t<agreEdu[0].length;t++){
		   for(int u=0;u<agreEdu[1].length;u++){
			   if(agreEdu[t][u].toLowerCase().contains((CharSequence)school.toLowerCase())){
				   points++;
			   }
		   }
	   }*/
	 String[] workDetails=new String[agreWork.length()];
	 String[] company=new String[agreWork.length()];
	 if(prof!=null && !prof.equals("")){
		 CharSequence seqWork=(CharSequence)prof.toLowerCase();
	 
	   for(int j=0;j<workDetails.length;j++){
		   workDetails[j]=(String)agreWork.getJSONObject(j).get("Details");
		   company[j]=(String)agreWork.getJSONObject(j).get("Company");
		   if(workDetails[j].toLowerCase().contains(seqWork) ){
			   points++;
		   }
		   if(company[j].toLowerCase().contains(seqWork) ){
			   points++;
		   }
	   }
	   }
	   }
	   
	   profiles.getJSONObject(i).put("score", points);
	   score[i]=points;
	   String prop="government";
	   if(role.equalsIgnoreCase("PUBLIC")){
		   profiles.getJSONObject(i).remove(prop);
	   }
	   else if(role.equalsIgnoreCase("NIC")){
		   profiles.getJSONObject(i).getJSONObject(prop).remove("Vehicle data");
		   profiles.getJSONObject(i).getJSONObject(prop).remove("Driving License data");
	   }
	   else if(role.equalsIgnoreCase("MOTOR")) {
		 profiles.getJSONObject(i).getJSONObject(prop).remove("NIC data");
		 profiles.getJSONObject(i).getJSONObject(prop).remove("Driving Licence data");
	   }
	   else if(role.equalsIgnoreCase("LICENCE")) {
			 profiles.getJSONObject(i).getJSONObject(prop).remove("NIC data");
			 profiles.getJSONObject(i).getJSONObject(prop).remove("Vehicle data");
		   }
	  
	   }
	   int j;
	     boolean flag = true;   // set flag to true to begin first pass
	     int temp;   //holding variable

	     while ( flag )
	     {
	            flag= false;    //set flag to false awaiting a possible swap
	            for( j=0;  j < score.length -1;  j++ )
	            {
	                   if ( score[ j ] < score[j+1] )   // change to > for ascending sort
	                   {
	                           temp = score[ j ];                //swap elements
	                           score[ j ] = score[ j+1 ];
	                           score[ j+1 ] = temp;
	                          flag = true;              //shows a swap occurred 
	                  }
	            }
	      } 
	     
	 //  System.out.println(counter);
	   JSONObject[] Filtered= new JSONObject[profiles.length()];
	   
	   int count=0;
	 /*  for(int i=0;i<ex3.getNICCounter();i++){
		 //  System.out.println(obj[i]);
		   JSONObject NIC_data=(JSONObject)obj[i].get("NIC data");
		   String l=(String)NIC_data.get("village or city");
		   String o=(String)NIC_data.get("Profession");
		    if(l.equals(city)){
		     // Filtered[count]= new JSONObject();
			   //Filtered[count].put("everything", obj[i]);
			   //count++;
		    	points=(int)NIC_data.getInt("score");
		    	points++;
		    	NIC_data.remove("score");
		    	NIC_data.put("score", points);
		    	obj[i].remove("NIC data");
		    	obj[i].put("NIC data", NIC_data);
		    	
		   }
		    if(o.equals(prof)){
			     //  Filtered[count]= new JSONObject();
				  // Filtered[count].put("everything", obj[i]);
				  // count++;
			    	points=(int)NIC_data.getInt("score");
			    	points++;
			    	NIC_data.remove("score");
			    	NIC_data.put("score", points);
			    	obj[i].remove("NIC data");
			    	obj[i].put("NIC data", NIC_data);
			    	
			   }
		   }*/
	  /* int[] array=new int[ex3.getNICCounter()];
	   for(int i=0;i<ex3.getNICCounter();i++){
		   JSONObject NIC_data1=(JSONObject)obj[i].get("NIC data");
		   array[i]=(int)NIC_data1.getInt("score");
	   }*/
	    
	     int count2=0;
	     for(int i=0;i<profiles.length();i++){
	    	 for(int t=0;t<profiles.length();t++){
	    		 JSONObject NIC_data1=(JSONObject)profiles.getJSONObject(t);
	    		 if(i!=0){
	    		 if(score[i]==(int)NIC_data1.getInt("score") && score[i]!=score[i-1]){
	    			 Filtered[count2]=new JSONObject();
	    			 Filtered[count2].put("everything", profiles.getJSONObject(t));
	    			 count2++;
	    		 }
	    		 }
	    		 else{
	    			 if(score[i]==(int)NIC_data1.getInt("score") ){
		    			 Filtered[count2]=new JSONObject();
		    			 Filtered[count2].put("everything", profiles.getJSONObject(t));
		    			 count2++;
		    		 }
	    		 }
	    	 }
	     }
	   JSONObject finalObj=new JSONObject();
	   finalObj.put("final", Filtered);
     return finalObj.toString();
	   //return "sachithra";
   }
	   else{
		   //String aggOut =a.GetJson(null);
		   return null;
	   }
   }
   
   @POST
   @Path("/user/aggregation")
   @Produces(MediaType.APPLICATION_JSON)
   public String aggregate(String notAggregated) throws JSONException{
       Aggregation a= new Aggregation();
       String output=a.GetJson(notAggregated).toString();
       return output;
   
   }

  
}