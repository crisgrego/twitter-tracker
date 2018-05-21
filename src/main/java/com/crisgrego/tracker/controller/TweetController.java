package com.crisgrego.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import com.crisgrego.tracker.exception.ResourceNotFoundException;
import com.crisgrego.tracker.model.Tweet;
import com.crisgrego.tracker.model.TwitterProfile;
import com.crisgrego.tracker.repository.TweetRepository;
import com.crisgrego.tracker.repository.TwitterUserRepository;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.GeoCode;
import org.springframework.social.twitter.api.SearchParameters;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class TweetController {
	@Autowired
	TweetRepository tweetRepository;

	private Twitter twitter;
	private ConnectionRepository connectionRepository;

	@Inject
	public TweetController(Twitter twitter, ConnectionRepository connectionRepository) {
		this.twitter = twitter;
		this.connectionRepository = connectionRepository;
	}

	@GetMapping("/tweets")
	public @ResponseBody List<Tweet> getAllTweets(@RequestParam String hashtag) {
		SearchResults results = twitter.searchOperations()
				.search(new SearchParameters("#" + hashtag)
				.resultType(SearchParameters.ResultType.RECENT)
				.count(100)
				.includeEntities(true));
		
		
		tweetRepository.save(adaptTweets(results.getTweets()));
		
		return tweetRepository.findAll();
	}
	
	/**
	 * Adapt the result of teh query to the twitter API to Entities of the App 
	 * @param tw
	 * @return
	 */
	private List<Tweet> adaptTweets(List<org.springframework.social.twitter.api.Tweet> tw) {
		List<Tweet> finalT = new ArrayList<Tweet>();
		
		for(org.springframework.social.twitter.api.Tweet otw : tw) {
			finalT.add(new Tweet(otw));
		}
		
		return finalT;
	}

}
