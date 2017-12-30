package com.fuppino.spring.associations;

import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fuppino.spring.associations.entities.Programmer;
import com.fuppino.spring.associations.entities.Project;
import com.fuppino.spring.associations.repos.ProgrammerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AssociationsApplication.class)
public class AssociationsApplicationTests {

	@Autowired
	ProgrammerRepository programmerRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testmtomCreateProgrammer() {
		Programmer programmer = new Programmer();
		programmer.setName("Rohan");
		programmer.setSalary(10000);
		
		HashSet<Project> projects = new HashSet<Project>();
		Project project = new Project();
		project.setName("Sample Project");
		projects.add(project);
		
		programmer.setProjects(projects);
		
		programmerRepository.save(programmer);
	}
	
	@Test
	@Transactional
	public void testmtomFindProgrammer() {
		Programmer programmer = programmerRepository.findOne(1);
		System.out.println("Programmer : "+programmer);
		System.out.println("Projects : "+programmer.getProjects());
	}
	
}
