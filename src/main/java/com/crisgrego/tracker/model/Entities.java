//package com.crisgrego.tracker.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import org.hibernate.annotations.NotFound;
//import org.hibernate.annotations.NotFoundAction;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//import org.springframework.social.twitter.api.HashTagEntity;
//import org.springframework.social.twitter.api.MediaEntity;
//import org.springframework.social.twitter.api.MentionEntity;
//import org.springframework.social.twitter.api.TickerSymbolEntity;
//import org.springframework.social.twitter.api.UrlEntity;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.LinkedList;
//import java.util.List;
//
////@SuppressWarnings("unused")
//@Entity
//public class Entities {
//
//	@Id
//	private long id;
//
//	private List<UrlEntity> urls = new LinkedList<UrlEntity>();
//	
//	private List<HashTagEntity> tags = new LinkedList<HashTagEntity>();
//	
//	private List<MentionEntity> mentions = new LinkedList<MentionEntity>();
//	
//	private List<MediaEntity> media = new LinkedList<MediaEntity>();
//
//	private List<TickerSymbolEntity> tickerSymbols = new LinkedList<TickerSymbolEntity>();
//
//	public Entities() {
//	}
//
//	public Entities(org.springframework.social.twitter.api.Entities entities) {
//		urls.addAll(entities.getUrls());
//	}
//
//}
