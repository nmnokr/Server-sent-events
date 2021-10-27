package Bean;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
 
public class NotificationForm {

	Map<String, SseEmitter> emitters = new HashMap();

	public Map<String, SseEmitter> getEmitters() {
		return emitters;
	}

	public void setEmitters(Map<String, SseEmitter> emitters) {
		this.emitters = emitters;
	}

}
