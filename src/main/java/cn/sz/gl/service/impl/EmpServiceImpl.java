package cn.sz.gl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.gl.dao.IEmpDAO;
import cn.sz.gl.pojo.Emp;
import cn.sz.gl.service.IEmpService;
@Service
public class EmpServiceImpl implements IEmpService {

	@Autowired
	private IEmpDAO empdao;
	
	@Override
	public List<Emp> findall() {
		return empdao.findallemp();
	}

	@Override
	public Emp findById(Integer empno) {
		return empdao.findEmpByEmpno(empno);
	}

	@Override
	public boolean insertEmp(Emp emp) {
		int res = empdao.insertEmp(emp);
		return res>0;
	}

	@Override
	public boolean deleteEmp(Integer empno) {
		int res = empdao.deleteEmp(empno);
		return res>0;
	}

	@Override
	public boolean updateEmp(Emp emp) {
		int res = empdao.updateEmp(emp);
		return res>0;
	}

}
