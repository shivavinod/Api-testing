package api.GoogleTest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import api.testing.google.AccessInfo;
import api.testing.google.Epub;
import api.testing.google.GoogleApiTest;
import api.testing.google.Item;
import api.testing.google.Pdf;
import api.testing.google.SaleInfo;
import api.testing.google.VolumeInfo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestConfiguration {
	@Test
	 public void configure() {
	        RestAssured.baseURI = "https://www.googleapis.com/books/v1/volumes";
	        //RestAssured.port = 8080;
	       // RestAssured.basePath = "/books";
	        RequestSpecification req=RestAssured.given().contentType(ContentType.JSON).param("q", "turing");
	        Response response=req.get();
	       response.then().log().all();
	       // System.out.println(response);
	      //Google google = response.as(Google.class, ObjectMapperType.GSON);
	     //  GoogleApiTest google=response.as(GoogleApiTest.class, ObjectMapperType.GSON);
	       GoogleApiTest g= response.as(GoogleApiTest.class, ObjectMapperType.GSON);
	        
	        //List<Item> items = google.getItems();
	  //     List<Item>items=google.getItems();
	    //    for (Item item : items) {
	      //  	int m=items.size();
	        //	System.out.println(m);
	          //  System.out.println(item.toString());
	         // String aa=item.getId();
	          
	         //   VolumeInfo volumeInfo = item.getVolumeInfo();
	       //  String a= volumeInfo.getTitle();
	         //System.out.println("/*/*////*/*/*//*/*/");
	         //System.out.println(a);
	        //}
	       
	       int totalitems=g.getTotalItems();
	       
	       System.out.println("the total number of items is  "+ totalitems);
	       List<Item>items=g.getItems();
	       for(Item item:items)
	       {
	    	   System.out.println("************");
	    	   System.out.println(item.toString());
	    	   AccessInfo accessInfo=item.getAccessInfo();
	    	   String Country= accessInfo.getCountry();
	    	   System.out.println("the Country is "+  Country);
	    	   Epub epub=  accessInfo.getEpub();
	    	   
	    	   
	    	   
	    	  Pdf p= accessInfo.getPdf();
	    	 //
	    	 String AcsTokenLink= p.getAcsTokenLink();
	    	 System.out.println("the AcsTokenLink is  " + AcsTokenLink);
	    	 
	    	Boolean b= p.getIsAvailable();
	    	 System.out.println("the IsAvailable is  " + b);
	    	
	    	  
	    	   
	    	   VolumeInfo volumeInfo = item.getVolumeInfo();
	    	   String volumeinformation=volumeInfo.getTitle();
	    	   System.out.println("volumeinformation  is ::  "   +volumeinformation);
	    	   
	    	   
	    	   List<String> s=volumeInfo.getAuthors();
	    	   for(int i = 0; i < s.size(); i++) {
		             
	    		   System.out.println("Authors is ::" + s.get(i));
		    	  }
	    	   
	    	   
	    	   
	    	   Double k=volumeInfo.getAverageRating();
	    	   System.out.println("AverageRating is ::   "+k);
	    	   
	    	   
	    	  String m= volumeInfo.getContentVersion();
//	    	  System.out.println("ContentVersion  >>  " +m);
	    	  
	    	  
	    	  List<String> l= volumeInfo.getCategories();
	    	  for(int i = 0; i < l.size(); i++) {
	              System.out.println("Categories is ::"  +l.get(i));
	    	  }
	    	  
	    	   
	    	 /*  public void setVolumeInfo(VolumeInfo volumeInfo) {
	    	        this.volumeInfo = volumeInfo;
	    	    }*/
	    	   SaleInfo saleInfo=item.getSaleInfo();
	    	   String sd=saleInfo.getCountry();
	    	   System.out.println(sd);
	    			   
	       }
	  
	        

	    }
/*
	    //public RequestSpecification getRequestSpecification() {
	        //return RestAssured.given().contentType(ContentType.JSON);
	   // }

	    public  Response getResponse(RequestSpecification requestSpecification,String endpoint, int
	                            status){
	        Response response = requestSpecification.get(endpoint);
	        Assert.assertEquals(response.getStatusCode(),status);
	        response.then().log().all();
	        
	        return response;
	    }*/
}
