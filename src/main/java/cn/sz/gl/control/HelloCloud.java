package cn.sz.gl.control;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCloud {

	@RequestMapping(value="/sayhello/{msg}")
	public String sayhello(@PathVariable("msg")String msg) {
		return "hello,"+msg;
	}
}
