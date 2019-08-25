package cn.sz.gl.dao;

import java.util.List;

import cn.sz.gl.pojo.Emp;

public interface IEmpDAO {

	public List<Emp> findallemp();
	
	public Emp findEmpByEmpno(Integer empno);
	
	public int insertEmp(Emp emp);
	
	public int deleteEmp(Integer empno);
	
	public int updateEmp(Emp emp);
}
