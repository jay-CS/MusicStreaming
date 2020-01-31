
 public class Artist {
	 double terms_freq;
	 String name;
	 double familiarity;
	 double longitude;
	 String location;
	 double latitude;
	 String similar;
	 double hotttnesss;
	 
	 public Artist(double terms_freq, String name, double familiarity, double longitude, String location, 
			 double latitude, String similar, double hotttnesss) {
		 this.terms_freq = terms_freq;
		 this.name = name;
		 this.familiarity = familiarity;
		 this.longitude = longitude;
		 this.location = location;
		 this.latitude = latitude;
		 this.similar = similar;
		 this.hotttnesss = hotttnesss;
	 }
	
	 public void setTerms_freq(double terms_freq) {
		 this.terms_freq = terms_freq;
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
	 
	 public String getName() {
		 return name;
	 }
	 
	 public double getFamiliarity() {
		 return familiarity;
	 }
	 
	 public double getLongitute(){
		 return longitude;
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