package com.sebastianwrobel.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.sebastianwrobel.dto.Channel;
import com.sebastianwrobel.service.ChannelService;
import com.sebastianwrobel.service.UserService;

@Controller
public class ChatController {
	@Autowired
	public UserService userService;
	@Autowired
	public ChannelService channelService;

	

	@GetMapping("/welcome")
	public String getWelcome(ModelMap model) {
		List<Channel> channels = channelService.getChannelNames();
		model.put("channels", channels);
		return "welcome";
	}

	@GetMapping("/channel/{channelId}")
	public String getChannel( ModelMap model, @PathVariable Long channelId) {
		return "/channel";
	}
}
	

	

