package com.example.MoonPhases.methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.MoonPhases.dao.MoonPhasesResponse;

public class MoonPhasesMethods {

	public List<String> foundNewMoons(Long year) {
		
		int metonico;
		int epacta;
		int epactaConcreta = 0;
		int total;
		String month = null;
		String phase = null;
		List<String> newMoons = new ArrayList<String>();

		for (int j = 1; j <= 12; j++) {
			for (int x = 1; x <= 31; x++) {

				metonico = (int) ((year + 1) % 19);
				epacta = ((metonico - 1) * 11) % 30;

				if (j == 1 || j == 3) {
					epactaConcreta = x;
				}

				if (j == 2) {
					epactaConcreta = x + 1;
				}

				if (j == 4 || j == 5 || j == 6 || j == 7 || j == 8 || j == 9 || j == 10 || j == 11 || j == 12) {
					epactaConcreta = (j - 3) + x;
				}

				total = epacta + epactaConcreta;

				if (total >= 30) {
					total = total % 30;
				}

				if (total == 0) {
					if (j == 1) {
						month = "JAN";
					}
					if (j == 2) {
						month = "FEB";
					}
					if (j == 3) {
						month = "MAR";
					}
					if (j == 4) {
						month = "APR";
					}
					if (j == 5) {
						month = "MAY";
					}
					if (j == 6) {
						month = "JUN";
					}
					if (j == 7) {
						month = "JUL";
					}
					if (j == 8) {
						month = "AUG";
					}
					if (j == 9) {
						month = "SEP";
					}
					if (j == 10) {
						month = "OCT";
					}
					if (j == 11) {
						month = "NOV";
					}
					if (j == 12) {
						month = "DEC";
					}
					newMoons.add(month + "/" + String.valueOf(x));
				}
			}
		}

		return newMoons;
	}
	
	public HashMap<Integer, String> foundMoonPhases(Long year, Long month) {

		int metonico;
		int epacta;
		int epactaConcreta = 0;
		int total;
		String phase = null;
		HashMap<Integer, String> mapValues = new HashMap<Integer, String>();

		for (int x = 1; x <= 31; x++) {

			metonico = (int) ((year + 1) % 19);
			epacta = ((metonico - 1) * 11) % 30;

			if (month == 1 || month == 3) {
				epactaConcreta = x;
			}

			if (month == 2) {
				epactaConcreta = x + 1;
			}

			if (month == 4 || month == 5 || month == 6 || month == 7 || month == 8 || month == 9 || month == 10
					|| month == 11 || month == 12) {
				epactaConcreta = (int) ((month - 3) + x);
			}

			total = epacta + epactaConcreta;

			if (total >= 30) {
				total = total % 30;
			}

			if (total == 0) {
				phase = "newMoon";
				mapValues.put(x, phase);
			} else if (total == 7) {
				phase = "firstQuarter";
				mapValues.put(x, phase);
			} else if (total == 14) {
				phase = "fullMoon";
				mapValues.put(x, phase);
			} else if (total == 21) {
				phase = "lastQuarter";
				mapValues.put(x, phase);
			}
		}

		return mapValues;
	}

	public MoonPhasesResponse retriveMoonPhases(HashMap<Integer, String> mapValues) {

		MoonPhasesResponse moonPhases = new MoonPhasesResponse();
		List<Integer> newMoons = new ArrayList<Integer>();
		List<Integer> firstQuarters = new ArrayList<Integer>();
		List<Integer> lasttQuarters = new ArrayList<Integer>();
		List<Integer> fullMoons = new ArrayList<Integer>();
		Set set = mapValues.entrySet();
		Iterator it = set.iterator();

		while (it.hasNext()) {

			Map.Entry entry = (Map.Entry) it.next();

			if (entry.getValue().toString().equalsIgnoreCase("newMoon")) {
				newMoons.add(Integer.valueOf(entry.getKey().toString()));
			} else if (entry.getValue().toString().equalsIgnoreCase("firstQuarter")) {
				firstQuarters.add(Integer.valueOf(entry.getKey().toString()));
			} else if (entry.getValue().toString().equalsIgnoreCase("fullMoon")) {
				fullMoons.add(Integer.valueOf(entry.getKey().toString()));
			} else if (entry.getValue().toString().equalsIgnoreCase("lastQuarter")) {
				lasttQuarters.add(Integer.valueOf(entry.getKey().toString()));
			}
		}

		moonPhases.setFirstQuarter(firstQuarters);
		moonPhases.setFullMoon(fullMoons);
		moonPhases.setLastQuarter(lasttQuarters);
		moonPhases.setNewMoon(newMoons);

		return moonPhases;
	}
}
