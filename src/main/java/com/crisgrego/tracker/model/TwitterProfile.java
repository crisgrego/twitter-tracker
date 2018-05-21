package com.crisgrego.tracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class TwitterProfile  {

	@Id
	private long id;
	private String screenName;
	private String name;
	private String url;
	private String profileImageUrl;
	private String description;
	private String location;
	private Date createdDate;

	private String language;
	private int statusesCount;
	private int friendsCount;
	private int followersCount;
	private int favoritesCount;
	private int listedCount;
	private boolean following;
	private boolean followRequestSent;
	private boolean isProtected;
	private boolean notificationsEnabled;
	private boolean verified;
	private boolean geoEnabled;
	private boolean contributorsEnabled;
	private boolean translator;
	private String timeZone;
	private int utcOffset;
	private String sidebarBorderColor;
	private String sidebarFillColor;
	private String backgroundColor;
	private boolean useBackgroundImage;
	private String backgroundImageUrl;
	private boolean backgroundImageTiled;
	private String textColor;
	private String linkColor;
	private boolean showAllInlineMedia;
	private String profileBannerUrl;

//	@OneToMany(mappedBy = "user")
//	private List<Tweet> tweets;

	public TwitterProfile() {
	}

	public TwitterProfile(org.springframework.social.twitter.api.TwitterProfile user) {
		id = user.getId();
		screenName = user.getScreenName();
		name = user.getName();
		url = user.getUrl();
		profileImageUrl = user.getProfileImageUrl();
		description = user.getDescription();
		location = user.getLocation();
		createdDate = user.getCreatedDate();

		language = user.getLanguage();
		statusesCount = user.getStatusesCount();
		friendsCount = user.getFriendsCount();
		followersCount = user.getFollowersCount();
		favoritesCount = user.getFavoritesCount();
		listedCount = user.getListedCount();
		following = user.isFollowing();
		followRequestSent = user.isFollowRequestSent();
		isProtected = user.isProtected();
		notificationsEnabled = user.isNotificationsEnabled();
		verified = user.isVerified();
		geoEnabled = user.isGeoEnabled();
		contributorsEnabled = user.isContributorsEnabled();
		translator = user.isTranslator();
		timeZone = user.getTimeZone();
		utcOffset = user.getUtcOffset();
		sidebarBorderColor = user.getSidebarBorderColor();
		sidebarFillColor = user.getSidebarFillColor();
		backgroundColor = user.getBackgroundColor();
		useBackgroundImage = user.useBackgroundImage();
		backgroundImageUrl = user.getBackgroundImageUrl();
		backgroundImageTiled = user.isBackgroundImageTiled();
		textColor = user.getTextColor();
		linkColor = user.getLinkColor();
		showAllInlineMedia = user.showAllInlineMedia();
		profileBannerUrl = user.getProfileBannerUrl();
	}

	public String getScreenName() {
		return screenName;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public String getDescription() {
		return description;
	}

	public String getLocation() {
		return location;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public String getLanguage() {
		return language;
	}

	public int getStatusesCount() {
		return statusesCount;
	}

	public int getFriendsCount() {
		return friendsCount;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public int getFavoritesCount() {
		return favoritesCount;
	}

	public int getListedCount() {
		return listedCount;
	}

	public boolean isFollowing() {
		return following;
	}

	public boolean isFollowRequestSent() {
		return followRequestSent;
	}

	public boolean isProtected() {
		return isProtected;
	}

	public boolean isNotificationsEnabled() {
		return notificationsEnabled;
	}

	public boolean isVerified() {
		return verified;
	}

	public boolean isGeoEnabled() {
		return geoEnabled;
	}

	public boolean isContributorsEnabled() {
		return contributorsEnabled;
	}

	public boolean isTranslator() {
		return translator;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public int getUtcOffset() {
		return utcOffset;
	}

	public String getSidebarBorderColor() {
		return sidebarBorderColor;
	}

	public String getSidebarFillColor() {
		return sidebarFillColor;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public boolean isUseBackgroundImage() {
		return useBackgroundImage;
	}

	public String getBackgroundImageUrl() {
		return backgroundImageUrl;
	}

	public boolean isBackgroundImageTiled() {
		return backgroundImageTiled;
	}

	public String getTextColor() {
		return textColor;
	}

	public String getLinkColor() {
		return linkColor;
	}

	public boolean isShowAllInlineMedia() {
		return showAllInlineMedia;
	}

	public String getProfileBannerUrl() {
		return profileBannerUrl;
	}

//	public List<Tweet> getTweets() {
//		return tweets;
//	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setStatusesCount(int statusesCount) {
		this.statusesCount = statusesCount;
	}

	public void setFriendsCount(int friendsCount) {
		this.friendsCount = friendsCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public void setFavoritesCount(int favoritesCount) {
		this.favoritesCount = favoritesCount;
	}

	public void setListedCount(int listedCount) {
		this.listedCount = listedCount;
	}

	public void setFollowing(boolean following) {
		this.following = following;
	}

	public void setFollowRequestSent(boolean followRequestSent) {
		this.followRequestSent = followRequestSent;
	}

	public void setProtected(boolean isProtected) {
		this.isProtected = isProtected;
	}

	public void setNotificationsEnabled(boolean notificationsEnabled) {
		this.notificationsEnabled = notificationsEnabled;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public void setGeoEnabled(boolean geoEnabled) {
		this.geoEnabled = geoEnabled;
	}

	public void setContributorsEnabled(boolean contributorsEnabled) {
		this.contributorsEnabled = contributorsEnabled;
	}

	public void setTranslator(boolean translator) {
		this.translator = translator;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public void setUtcOffset(int utcOffset) {
		this.utcOffset = utcOffset;
	}

	public void setSidebarBorderColor(String sidebarBorderColor) {
		this.sidebarBorderColor = sidebarBorderColor;
	}

	public void setSidebarFillColor(String sidebarFillColor) {
		this.sidebarFillColor = sidebarFillColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public void setUseBackgroundImage(boolean useBackgroundImage) {
		this.useBackgroundImage = useBackgroundImage;
	}

	public void setBackgroundImageUrl(String backgroundImageUrl) {
		this.backgroundImageUrl = backgroundImageUrl;
	}

	public void setBackgroundImageTiled(boolean backgroundImageTiled) {
		this.backgroundImageTiled = backgroundImageTiled;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	public void setLinkColor(String linkColor) {
		this.linkColor = linkColor;
	}

	public void setShowAllInlineMedia(boolean showAllInlineMedia) {
		this.showAllInlineMedia = showAllInlineMedia;
	}

	public void setProfileBannerUrl(String profileBannerUrl) {
		this.profileBannerUrl = profileBannerUrl;
	}
//
//	public void setTweets(List<Tweet> tweets) {
//		this.tweets = tweets;
//	}
}
