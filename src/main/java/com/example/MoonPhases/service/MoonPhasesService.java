package com.example.MoonPhases.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MoonPhases.dao.MoonPhasesResponse;
import com.example.MoonPhases.methods.MoonPhasesMethods;

@Service
public class MoonPhasesService {
	
	@Autowired
	MoonPhasesMethods moonPhasesMethods;
	
	public List<String> newMoons(Long year) {
		List<String> newMoons = new ArrayList<String>();
		newMoons = moonPhasesMethods.foundNewMoons(year);
		return newMoons;
	}
	
	public MoonPhasesResponse moonPhases(Long year, Long month) {
		MoonPhasesResponse moonPhases;
		HashMap<Integer, String> foundMoonPhases = moonPhasesMethods.foundMoonPhases(year, month);
		moonPhases = moonPhasesMethods.retriveMoonPhases(foundMoonPhases);
		return moonPhases;
	}
}
