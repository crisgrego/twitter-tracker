package com.crisgrego.tracker.repository;

import java.util.List;
import com.crisgrego.tracker.model.Tweet;
import com.crisgrego.tracker.model.TwitterProfile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TwitterUserRepository extends JpaRepository<TwitterProfile, Long> {

}
