package com.example.MoonPhases.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.MoonPhases.dao.MoonPhasesResponse;
import com.example.MoonPhases.service.MoonPhasesService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnit4.class)
public class MoonPhasesControllerTest {

	@InjectMocks
	MoonPhasesController moonPhasesController;
	
	@Mock
	MoonPhasesService moonPhasesService;
	
	@Mock
	List<String> newMoons;
	
	@Mock
	MoonPhasesResponse moonPhasesResponse;
	
	@Test
	public void findAllNewMoons() {
		
		newMoons = new ArrayList<String>();
		newMoons.add("Dec/18");
		newMoons.add("FEB/12");
		newMoons.add("JAN/5");
		List<String> result;
		Long year = 2005l;
		
		when(moonPhasesService.newMoons(year)).thenReturn(newMoons);
		result = moonPhasesController.newMoons(year);
	}
	
	@Test
	public void findMoonPhases() {
		
		List<Integer> newMoons = new ArrayList<Integer>();
		List<Integer> firstQuarters = new ArrayList<Integer>();
		List<Integer> lasttQuarters = new ArrayList<Integer>();
		List<Integer> fullMoons = new ArrayList<Integer>();
		Long year = 2005l;
		Long month = 2l;
		MoonPhasesResponse result;
		
		newMoons.add(21);
		firstQuarters.add(23);
		lasttQuarters.add(5);
		fullMoons.add(12);
		
		moonPhasesResponse.setFirstQuarter(firstQuarters);
		moonPhasesResponse.setFullMoon(fullMoons);
		moonPhasesResponse.setLastQuarter(lasttQuarters);
		moonPhasesResponse.setNewMoon(newMoons);
		
		when(moonPhasesService.moonPhases(year, month)).thenReturn(moonPhasesResponse);
		result = moonPhasesController.moonPhases(year, month);
		
	}
}
