package com.crisgrego.tracker.repository;

import java.util.List;
import com.crisgrego.tracker.model.Tweet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}