package com.sebastianwrobel.dto;

import java.util.HashMap;
import java.util.Map;


public class Channel {
	
 private String name;
 private Long channelId;
 private Map<Long, Message> chats = new HashMap<>();
 private Map<Long, User> users = new HashMap<>();
 public Channel() {}
 
 public Channel(String name, Long channelId, Map<Long, Message> chats, Map<Long, User> users) {
	 this.name = name;
	 this.channelId = channelId;
	 this.chats = chats;
	 this.users = users;
 }


public Map<Long, Message> getChats() {
	return chats;
}
public void setChats(Map<Long, Message> chats) {
	this.chats = chats;
}
 
 public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public Map<Long, User> getUsers() {
	return users;
}
public void setUsers(Map<Long, User> users) {
	this.users = users;
}
public Long getChannelId() {
	return channelId;
}
public void setChannelId(Long channelId) {
	this.channelId = channelId;
}
}
