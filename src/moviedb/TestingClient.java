package moviedb;

public class TestingClient {
	public static void main(String[] args) {
	MoviesDB movies = new MoviesDB("movie_metadata.csv");
	movies.addFieldIndex("movie_title");
	}
}
