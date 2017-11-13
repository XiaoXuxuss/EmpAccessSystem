package com.jiayidai.assess.mapper;

import java.util.List;

import com.jiayidai.assess.entity.Emp;

public interface EmpMapper {

	public Emp login(Emp emp);
	
	public List<Emp> loadEmp(Emp emp);

}
