package com.jiayidai.assess.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiayidai.assess.entity.Emp;
import com.jiayidai.assess.mapper.EmpMapper;

@Service
public class EmpService {
	@Autowired
	private EmpMapper empmapper;

	public void setEmpmapper(EmpMapper empmapper) {
		this.empmapper = empmapper;
	}

	public Emp login(Emp emp) {
		Emp oemp = empmapper.login(emp);
		if (oemp.getUsername() != null){
			return oemp;			
		}else{
			return null;
		}
	}
	
	public List<Emp> loadEmp(Emp emp){
		List<Emp> emplist = empmapper.loadEmp(emp);
		return emplist;
	}
}
