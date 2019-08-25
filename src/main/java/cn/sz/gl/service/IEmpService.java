package cn.sz.gl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sz.gl.pojo.Emp;

public interface IEmpService {

	public List<Emp> findall();

	public Emp findById(Integer empno);

	public boolean insertEmp(Emp emp);

	public boolean deleteEmp(Integer empno);

	public boolean updateEmp(Emp emp);
}
