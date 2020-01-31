
public class Song {
    double key;  
    double mode_confidence;  
    double artist_mbtags_count;  
    double key_confidence;  
    double tatums_start;  
    double year;  
    double duration;  
    double hotttnesss;  
    double beats_start;  
    double time_signature_confidence;  
    String title;  
    double bars_confidence;  
    String id;  
    double bars_start;  
    String artist_mbtags;  
    double start_of_fade_out;  
    double tempo;  
    double end_of_fade_in;  
    double beats_confidence;   
    double tatums_confidence;  
    int mode;  
    double time_signature;  
    double loudness;  
    
    public Song(double key, double mode_confidence, double artist_mbtags_count, double key_confidence,
    		double tatums_start, double year, double duration, double hotttnesss, double beats_start,
    		double time_signature_confidence, String title, double bars_confidence, String id, double bars_start,
    		String artist_mbtags, double start_of_fade_out, double tempo, double end_of_fade_in, 
    		double beats_confidence, double tatums_confidence, int mode, double time_signature, 
    		double loudness) {
    	this.key = key; 
    	this.mode_confidence = mode_confidence;
        this.artist_mbtags_count = artist_mbtags_count;
        this.key_confidence = key_confidence;
        this.tatums_start = tatums_start;
        this.year = year;
        this.duration = duration;
        this.hotttnesss = hotttnesss; 
        this.beats_start = beats_start;
        this.time_signature_confidence = time_signature_confidence;
        this.title = title;
        this.bars_confidence = bars_confidence; 
        this.id = id; 
        this.bars_start = bars_start;
        this.artist_mbtags = artist_mbtags;
        this.start_of_fade_out = start_of_fade_out; 
        this.tempo = tempo;
        this.end_of_fade_in = end_of_fade_in;
        this.beats_confidence = beats_confidence;  
        this.tatums_confidence = tatums_confidence;
        this.mode = mode; 
        this.time_signature = time_signature;
        this.loudness = loudness;
    }
}