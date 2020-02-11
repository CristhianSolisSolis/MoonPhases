package com.example.MoonPhases.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.MoonPhases.dao.MoonPhasesResponse;
import com.example.MoonPhases.methods.MoonPhasesMethods;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnit4.class)
public class MoonPhasesServiceTest {

	@InjectMocks
	MoonPhasesService moonPhasesService;
	
	@Mock
	MoonPhasesMethods moonPhasesMethods;
	
	@Test
	public void testNewMoons() {
		
		List<String>newMoons = new ArrayList<String>();
		newMoons.add("Dec/18");
		newMoons.add("FEB/12");
		newMoons.add("JAN/5");
		List<String> result;
		Long year = 2005l;
		
		when(moonPhasesMethods.foundNewMoons(year)).thenReturn(newMoons);
		result = moonPhasesService.newMoons(year);
	}
	
	@Test
	public void testMoonPhases() {
		
		List<Integer> newMoons = new ArrayList<Integer>();
		List<Integer> firstQuarters = new ArrayList<Integer>();
		List<Integer> lasttQuarters = new ArrayList<Integer>();
		List<Integer> fullMoons = new ArrayList<Integer>();
		Long year = 2005l;
		Long month = 2l;

		MoonPhasesResponse result;
		HashMap<Integer, String> values =  new HashMap<Integer, String>();
		values.put(2, "newMoon");
		values.put(12, "firstQuarter");
		values.put(22, "lasttQuarter");
		values.put(30, "fullMoon");
		
		newMoons.add(21);
		firstQuarters.add(23);
		lasttQuarters.add(5);
		fullMoons.add(12);
		
		
		when(moonPhasesMethods.foundMoonPhases(year, month)).thenReturn(values);
		result = moonPhasesService.moonPhases(year, month);
		
	}
}
