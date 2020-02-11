package com.example.MoonPhases.dao;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnit4.class)
public class MoonPhasesResponseTest {

	@InjectMocks
	MoonPhasesResponse moonPhasesResponse;
	
	@Test
	public void testCreateMoonPhasesResponse() {
		List<Integer> newMoons = new ArrayList<Integer>();
		List<Integer> firstQuarters = new ArrayList<Integer>();
		List<Integer> lasttQuarters = new ArrayList<Integer>();
		List<Integer> fullMoons = new ArrayList<Integer>();
		
		newMoons.add(21);
		firstQuarters.add(23);
		lasttQuarters.add(5);
		fullMoons.add(12);
		
		moonPhasesResponse.setFirstQuarter(firstQuarters);
		moonPhasesResponse.setNewMoon(newMoons);
		moonPhasesResponse.setLastQuarter(lasttQuarters);
		moonPhasesResponse.setFullMoon(fullMoons);
		
		assertEquals(21, moonPhasesResponse.getNewMoon().get(0).intValue());
		assertEquals(23, moonPhasesResponse.getFirstQuarter().get(0).intValue());
		assertEquals(5, moonPhasesResponse.getLastQuarter().get(0).intValue());
		assertEquals(12, moonPhasesResponse.getFullMoon().get(0).intValue());
	}
}
