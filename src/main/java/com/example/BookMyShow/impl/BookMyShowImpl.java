package com.example.BookMyShow.impl;

import java.awt.image.BufferedImage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.example.BookMyShow.dao.MoviesRepo;
import com.example.BookMyShow.model.Movie;
import com.example.BookMyShow.model.MovieReview;
import com.example.BookMyShow.model.Theatre;

@Component
public class BookMyShowImpl {
	 private List<MovieReview> movieReviews = new ArrayList<MovieReview>();
	 private Map<Integer, String> theatres = new HashMap();
	 static final String JDBC_DRIVER = "org.h2.Driver"; //org.h2.Driver
	 static final String DB_URL = "jdbc:h2:mem:danny";
	 static final String USER = "sa";
     static final String PASS = "";
	 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
     Statement stmt = conn.createStatement();
     
	
	@Autowired
	private MoviesRepo repo;                                                                                                                                                                                     
	
    ResourceLoader resourceLoader;

	public BookMyShowImpl() throws IOException, SQLException {
		super();
		this.storeMoviesIntoDB();
		this.storeReviewsIntoDB();
	}

	/**
	 * Initially loads DB with user defined data.
	 * @throws IOException
	 * @throws SQLException
	 */
	public void storeMoviesIntoDB() throws IOException, SQLException {
		
		// Loads avatar from resources and converts to blob.
		File file = ResourceUtils.getFile("classpath:actions.png");
		BufferedImage bImage = ImageIO.read(file);
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    ImageIO.write(bImage, "jpg", bos );
	    byte [] data = bos.toByteArray();
	    Blob blob = new javax.sql.rowset.serial.SerialBlob(data);
	    
	    //Inserts user defined data in DB.
	    String sqlQuery = " INSERT INTO MOVIE (movie_id, image, movie_description, movie_name)"
                + " VALUES(?, ?, ?, ?)";
	    PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);
	    prepStmt.setInt(1, 1234); 
	    prepStmt.setBlob(2, blob);
	    prepStmt.setString(3, "Awesome");
	    prepStmt.setString(4, "Sarkar");
	    prepStmt.executeUpdate();
	    prepStmt.close();
	
	}
	
	/**
	 * Loads reviews into DB initially.
	 * @throws SQLException
	 */
	public void storeReviewsIntoDB() throws SQLException {
		String sqlQuery = "INSERT INTO MOVIE_REVIEW (review_id,movie_id,reviewer_name,review,rating)"
				+ "VALUES(?,?,?,?,?)";
		PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);
	    prepStmt.setInt(1, 1234);
	    prepStmt.setInt(2, 1111);
	    prepStmt.setString(3, "deepak");
	    prepStmt.setString(4, "One time watchable");
	    prepStmt.setDouble(5, 3.5);
	    prepStmt.executeUpdate();
	    prepStmt.close();
	    
	    String sqlQuery1 = "INSERT INTO MOVIE_REVIEW (movie_id,reviewer_name,review,rating)"
				+ "VALUES(?,?,?,?)";
		PreparedStatement prepStmt1 = conn.prepareStatement(sqlQuery1);
	    prepStmt1.setInt(1, 1234); 
	    prepStmt1.setString(2, "joel");
	    prepStmt1.setString(3, "One time watchable");
	    prepStmt1.setDouble(4, 3.8);
	    prepStmt1.executeUpdate();
	    prepStmt1.close();
	}
		

	/**
	 * Returns the list of movie objects.
	 * @return
	 */
	public Iterable<Movie> getMovies() {
		Iterable<Movie> movies = repo.findAll();
		List<Movie> movie = new ArrayList<>();
		// movies.forEach(movies::add);
		return repo.findAll();
	}
	
	/**
	 * Returns avatar of the respective movie.
	 * @param movie
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public byte[] getMovieAvatar(String movie) throws SQLException, IOException {      
        Blob img = null;
        String sql = "select image from movie where (movie_name=?)";
        PreparedStatement prepStmt = conn.prepareStatement(sql);
        prepStmt.setString(1, movie);
        ResultSet result = prepStmt.executeQuery();
		while(result.next()) {
			img = result.getBlob("image");
		}
		InputStream in = img.getBinaryStream();
		byte[] Bytebuffer = new byte[(int)img.length()];
		in.read(Bytebuffer);
		return Bytebuffer;
	}
	
	/**
	 * Returns description of the respective movie.
	 * @param movie
	 * @return
	 * @throws SQLException
	 */
	public String getMovieDescription(String movie) throws SQLException {      
        
        String description = "";
        String sql = "select movie_description from movie where (movie_name=?)";
        PreparedStatement prepStmt = conn.prepareStatement(sql);
        prepStmt.setString(1, movie);
        ResultSet results = prepStmt.executeQuery();
        while(results.next()) {
            description = results.getString("movie_description");
        }
		return description;
	}
	
	/**
	 * Loads reviews for the specific movie.
	 * @param movieId
	 * @return
	 * @throws SQLException
	 */
	public List<MovieReview> getMovieReviews(Integer movieId) throws SQLException {
		String sql = "select * from movie_review where (movie_id=?)";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
        prepStmt.setInt(1, movieId);
        ResultSet results = prepStmt.executeQuery();
        while(results.next()) {
            MovieReview review = new MovieReview();
            review.setMovieId(results.getInt("movie_id"));
            review.setReviewerName(results.getString("reviewer_name"));
            review.setReview(results.getString("review"));
            System.out.println("review---"+review);
            this.movieReviews.add(review);
        }
		return this.movieReviews;
	}
	
	/**
	 * Returns theatres list.
	 * @return
	 * @throws SQLException
	 */
	public Map<Integer, String> getTheatres() throws SQLException {
		String sqlQuery = "select * from THEATRE_MOVIE_MODEL";
		PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);
		ResultSet theatres = prepStmt.executeQuery();
		while(theatres.next()) {
			Integer theatreId = theatres.getInt("theatre_id");
			String theatreName = theatres.getString("theatre");
			this.theatres.put(theatreId, theatreName);
		}
		System.out.println(this.theatres);
		return this.theatres;
	}
	
	
}
