package com.example.MoonPhases.methods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.MoonPhases.dao.MoonPhasesResponse;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnit4.class)
public class MoonPhasesMethodsTest {
	
	@InjectMocks
	MoonPhasesMethods moonPhasesMethods;
	
	@Test
	public void testFoundNewMoons() {
		
		Long year = 2001l;
		List<String> result = new ArrayList<String>();
	
		result = moonPhasesMethods.foundNewMoons(year);
		
		assertTrue(result.size() > 0);
		assertFalse(result.isEmpty());
		
	}
	
	@Test
	public void testFoundMoonPhases() {
		
		Long year = 2001l;
		Long month = 2l; 
		HashMap<Integer, String> result = new HashMap<Integer, String>();
	
		result = moonPhasesMethods.foundMoonPhases(year, month);
		
		assertTrue(result.size() > 0);
		assertFalse(result.isEmpty());
		
	}
	
	@Test
	public void testretriveMoonPhases() {
		
		Long year = 2001l;
		Long month = 2l; 
		HashMap<Integer, String> result = new HashMap<Integer, String>();
		MoonPhasesResponse moonPhasesResponse;
		
		result = moonPhasesMethods.foundMoonPhases(year, month);
		moonPhasesResponse =  moonPhasesMethods.retriveMoonPhases(result);
		
		assertFalse(moonPhasesResponse.toString().isEmpty());
		
	}
	

}
