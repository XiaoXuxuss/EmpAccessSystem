package com.jiayidai.assess.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiayidai.assess.entity.Emp;
import com.jiayidai.assess.service.EmpService;
import com.jiayidai.assess.util.JsonResult;

@Controller
public class EmpCtr {

	@Autowired
	private EmpService empservice;

	@Autowired
	private ObjectMapper objectmapper;

	public void setEmpservice(EmpService empservice) {
		this.empservice = empservice;
	}

	public void setObjectmapper(ObjectMapper objectmapper) {
		this.objectmapper = objectmapper;
	}

	@RequestMapping(value = "test.action", method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws JsonGenerationException, JsonMappingException, IOException {
		response.setContentType("test/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Emp emp = new Emp();
		if (username != null && username != "") {
			emp.setUserId(Integer.parseInt(username));
			;
		}
		if (password != null && password != "") {
			emp.setPassword(password);
		}
		JsonResult result = new JsonResult();
		try {
			Emp oemp = empservice.login(emp);
			HttpSession session = request.getSession();
			if (oemp != null) {
				session.setAttribute("username", oemp.getUsername());
				session.setAttribute("roleId", oemp.getRoleId());
				System.out.println(oemp.getRoleId());
				result.setStatus(1);
				result.setResponseText("µ«¬Ω≥…π¶");
			} else {
				result.setStatus(0);
				result.setResponseText("µ«¬Ω ß∞‹");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setResponseText("«Î ‰»Î’Àªß√‹¬Î");
		}
		objectmapper.writeValue(response.getWriter(), result);
	}

	@RequestMapping(value = "loadEmp.action", method = RequestMethod.GET)
	public void loadEmp(HttpServletRequest request, HttpServletResponse response)
			throws JsonGenerationException, JsonMappingException, IOException {
		response.setContentType("test/html;charset=utf-8");
		String username = request.getParameter("username");
		String deptId = request.getParameter("deptId");
		Emp emp = new Emp();
		List<Emp> emplist = new ArrayList<Emp>();
		if (username != null && username != "") {
			emp.setUsername(username);
		}
		if (deptId != null && deptId != "") {
			emp.setDeptId(Integer.parseInt(deptId));
		}
		emplist = empservice.loadEmp(emp);
		String str = objectmapper.writeValueAsString(emplist);
		response.getWriter().write(str);
	}

}
