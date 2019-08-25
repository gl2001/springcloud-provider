package cn.sz.gl.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.sz.gl.pojo.Emp;
import cn.sz.gl.service.IEmpService;

@RestController
@RequestMapping("/ec")
public class EmpController {
	
	@Autowired
	private IEmpService empService;

	@RequestMapping(value="findbyid/{id}")
	@HystrixCommand(fallbackMethod="findbyidCallback")
	public Emp findById(@PathVariable("id") Integer empno) {
		if(empno==null) {
			throw new RuntimeException("编号不能为空");
		}
		Emp emp = empService.findById(empno);
		System.out.println(emp.getEmpName()+"---"+emp.getEmpno()+"----"+emp.getSal());
		if(emp==null) {
			throw new RuntimeException("没找到数据");
		}
		return emp;
		
	}
	
	@RequestMapping(value="findall")
	public List<Emp> findall(){
		return empService.findall();
	}
	
	public Emp findbyidCallback(@PathVariable("id") Integer empno) {
		Emp emp = new Emp();
		emp.setEmpno(empno);
		emp.setEmpName("空");
		return emp;
	}
}
