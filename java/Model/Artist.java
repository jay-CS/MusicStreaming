/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samantharain
 */
public class Artist {
    
	 private double terms_freq;
         private String terms;
	 private String name;
	 private double familiarity;
	 private double longitude;
         private String ID;
	 private String location;
	 private double latitude;
	 private String similar;
	 private double hotttnesss;
	 
	 public Artist(double terms_freq, String terms, String name, double familiarity, double longitude, String ID, String location, 
			 double latitude, String similar, double hotttnesss) {
             
		 this.terms_freq = terms_freq;
                 this.terms = terms;
		 this.name = name;
		 this.familiarity = familiarity;
		 this.longitude = longitude;
                 this.ID = ID;
		 this.location = location;
		 this.latitude = latitude;
		 this.similar = similar;
		 this.hotttnesss = hotttnesss;
	 }
	
	 public void setTerms_freq(double terms_freq) {
		 this.terms_freq = terms_freq;
	 }
         
         public void setTerms(String terms) {
             this.terms = terms;
         }
	 
	 public void setName(String name) {
		 this.name = name;
	 }
	 
	 public void setFamiliarity(double familiarity) {
		 this.familiarity = familiarity;
	 }
	 
	 public void setLongitute(double longitude) {
		 this.longitude = longitude;
	 }
         
         public void setID(String ID) {
             this.ID = ID;
         }
	 
	 public void setLocation(String location) {
		 this.location = location;
	 }
	 
	 public void setLatitude(double latitude) {
		 this.latitude = latitude;
	 }
	 
	 public void setSimilar(String similar) {
		 this.similar = similar;
	 }
	 
	 public void setHotttnesss(double hotttnesss) {
		 this.hotttnesss = hotttnesss;
	 }
	 
	 public double getTerms_freq() {
		 return terms_freq;
	 }
         
         public String getTerms() {
             return this.terms;
         }
	 
	 public String getName() {
		 return name;
	 }
	 
	 public double getFamiliarity() {
		 return familiarity;
	 }
	 
	 public double getLongitute(){
		 return longitude;
	 }
         
         public String getID() {
             return this.ID;
         }
	 
	 public String getLocation() {
		 return location;
	 }
	 
	 public double getLatitude() {
		 return latitude;
	 }
	 
	 public String getSimilar() {
		 return similar;
	 }
	 
	 public double getHotttnesss() {
		 return hotttnesss;
	 }
 }