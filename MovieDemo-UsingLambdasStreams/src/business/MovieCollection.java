package business;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MovieCollection {
	
	private List<Movie> movies;

	public MovieCollection() {
		movies = new ArrayList<>();
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	public void add(Movie m) {
		movies.add(m);
	}
	public List<Movie> filterMovies(Predicate<Movie> condition){
		List<Movie> filteredMovies = new ArrayList<>();
		
		for (Movie m: movies) {
			if (condition.test(m))
			filteredMovies.add(m);
		}
		return filteredMovies;
	}
	public double getLowestRating() {
//		double lr = 5.00;  // this copy is replaced with the copy below with lambdas
//		
//		return lr;
//		
//		for (Movie m: movies) {
//			lr = Math.min(lr, m.getRating());
//		}
//		return lr;
		
		double lr = movies.stream()
				.map(r-> r.getRating())
				.reduce(5.0, (a,b) -> Math.min(a,b));
		
		return lr;
	}
	public double getHighestRating() {
		
		double hr = movies.stream()
				.map(r-> r.getRating())
				.reduce(1.0, (a,b) -> Math.max(a,b));
		
		return hr;
	}
	public String getAverageRating() {
		
		double sum = movies.stream()
				.map(r -> r.getRating())
				.reduce(0.0, (a,b) -> (a+b));
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
			
		return nf.format(sum/movies.size());
	}

	public int getSize() {
		return movies.size();
	}
}

