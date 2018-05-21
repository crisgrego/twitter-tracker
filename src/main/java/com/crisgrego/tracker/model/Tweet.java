package com.crisgrego.tracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

//@SuppressWarnings("unused")
@Entity
public class Tweet {

	@Id
	private long id;// private
	private String idStr;// private
	private String text;// private
	private Date createdAt; // private

	private String fromUser;
	private String profileImageUrl;
	private Long toUserId;
	private Long inReplyToStatusId;
	private Long inReplyToUserId;
	private String inReplyToScreenName;
	private long fromUserId;
	private String languageCode;
	private String source;
	private Integer retweetCount;
	private boolean retweeted;
	// private Tweet retweetedStatus;
	private boolean favorited;
	private Integer favoriteCount;
//	private Entities entities;

//	@JoinColumn(name = "twitter_user_id", nullable = false, updatable = false)
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private TwitterProfile user;

	public Tweet() {
	}

	public Tweet(org.springframework.social.twitter.api.Tweet otw) {
		id = otw.getId();
		idStr = otw.getIdStr();
		text = otw.getText();
		createdAt = otw.getCreatedAt();
		fromUser = otw.getFromUser();
		profileImageUrl = otw.getProfileImageUrl();
		toUserId = otw.getToUserId();
		inReplyToStatusId = otw.getInReplyToStatusId();
		inReplyToUserId = otw.getInReplyToUserId();
		inReplyToScreenName = otw.getInReplyToScreenName();
		fromUserId = otw.getFromUserId();
		languageCode = otw.getLanguageCode();
		source = otw.getSource();
		retweetCount = otw.getRetweetCount();
		retweeted = otw.isRetweeted();
		// private Tweet retweetedStatus;
		favorited = otw.isFavorited();
		favoriteCount = otw.getFavoriteCount();
//		entities = new Entities(otw.getEntities());
		user = new TwitterProfile(otw.getUser());
	}

	public String getIdStr() {
		return idStr;
	}

	public String getText() {
		return text;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getFromUser() {
		return fromUser;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public Long getToUserId() {
		return toUserId;
	}

	public Long getInReplyToStatusId() {
		return inReplyToStatusId;
	}

	public Long getInReplyToUserId() {
		return inReplyToUserId;
	}

	public String getInReplyToScreenName() {
		return inReplyToScreenName;
	}

	public long getFromUserId() {
		return fromUserId;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public String getSource() {
		return source;
	}

	public Integer getRetweetCount() {
		return retweetCount;
	}

	public boolean isRetweeted() {
		return retweeted;
	}

	public boolean isFavorited() {
		return favorited;
	}

	public Integer getFavoriteCount() {
		return favoriteCount;
	}

	public TwitterProfile getUser() {
		return user;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}

	public void setInReplyToStatusId(Long inReplyToStatusId) {
		this.inReplyToStatusId = inReplyToStatusId;
	}

	public void setInReplyToUserId(Long inReplyToUserId) {
		this.inReplyToUserId = inReplyToUserId;
	}

	public void setInReplyToScreenName(String inReplyToScreenName) {
		this.inReplyToScreenName = inReplyToScreenName;
	}

	public void setFromUserId(long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setRetweetCount(Integer retweetCount) {
		this.retweetCount = retweetCount;
	}

	public void setRetweeted(boolean retweeted) {
		this.retweeted = retweeted;
	}

	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}

	public void setFavoriteCount(Integer favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public void setUser(TwitterProfile user) {
		this.user = user;
	}

}
