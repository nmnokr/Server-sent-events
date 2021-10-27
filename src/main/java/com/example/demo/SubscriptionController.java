package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import Bean.NotificationForm;

public class SubscriptionController {
	NotificationForm notificationForm;

	@GetMapping(path = "/subscriptionse/{email}")
	public String subscriptions(@PathVariable("email") String email) {

		SseEmitter emitter = new SseEmitter();
		notificationForm.getEmitters().put(email, emitter);
		return "Subscribed";
	}

}
