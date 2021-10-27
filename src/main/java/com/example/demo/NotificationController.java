package com.example.demo;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import Bean.NotificationForm;
@RestController
public class NotificationController {
	NotificationForm notificationForm;

	@PostMapping("/notifications")
	public void sendMessage(@RequestBody String message) {
		Map<String, SseEmitter> temp = notificationForm.getEmitters();
		for (Entry<String, SseEmitter> kullanıcı : temp.entrySet()) {
			try {
				kullanıcı.getValue().send(message, MediaType.APPLICATION_JSON);
			} catch (IOException e) {
				kullanıcı.getValue().complete();
				temp.remove(kullanıcı.getKey());
				e.printStackTrace();
			}
		}

	}
}
