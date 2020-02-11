package com.example.MoonPhases.dao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class MoonPhasesResponse {

	private List<Integer> newMoon;
	private List<Integer> firstQuarter;
	private List<Integer> fullMoon;
	private List<Integer> lastQuarter;
	
	public List<Integer> getNewMoon() {
		return newMoon;
	}
	public void setNewMoon(List<Integer> newMoon) {
		this.newMoon = newMoon;
	}
	public List<Integer> getFirstQuarter() {
		return firstQuarter;
	}
	public void setFirstQuarter(List<Integer> firstQuarter) {
		this.firstQuarter = firstQuarter;
	}
	public List<Integer> getFullMoon() {
		return fullMoon;
	}
	public void setFullMoon(List<Integer> fullMoon) {
		this.fullMoon = fullMoon;
	}
	public List<Integer> getLastQuarter() {
		return lastQuarter;
	}
	public void setLastQuarter(List<Integer> lastQuarter) {
		this.lastQuarter = lastQuarter;
	}
	
}