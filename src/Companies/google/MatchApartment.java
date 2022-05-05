package Companies.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

enum RoomPreference {
    SINGLE, SHARED
}

class Applicant {
    String name;
    RoomPreference pref;

    Applicant(String name, RoomPreference pref) {
        this.name = name;
        this.pref = pref;
    }
}

class Apartment {
    int id;
    int rooms;
    List<String> applicantsList;

    Apartment(int id, int rooms) {
        this.id = id;
        this.rooms = rooms;
        applicantsList = new ArrayList<>();
    }
}

public class MatchApartment {
    public Map<String, Integer> mapApplicantToApartment(List<Applicant> applicants, List<Apartment> apartments) {
        Map<String, Integer> applicantMap = new HashMap<>();
        Map<Integer, Apartment> apartmentMap = new HashMap<>(); // [id, [rooms, applicants]]
        Queue<String> shared = new LinkedList<>();
        Queue<String> single = new LinkedList<>();

        Collections.sort(apartments, (a1, a2) -> a2.rooms - a1.rooms);

        for (Apartment apartment : apartments) {
            apartmentMap.put(apartment.id, apartment);
        }

        for (Applicant applicant : applicants) {
            if (applicant.pref == RoomPreference.SINGLE) {
                single.add(applicant.name);
            } else {
                shared.add(applicant.name);
            }
        }

        // fill shared
        if (shared.size() > 0) {
            for (Apartment apartment : apartments) {
                int size = Math.min(shared.size(), apartmentMap.get(apartment.id).rooms);
                for (int i = 0; i < size; i++) {
                    String name = shared.poll();

                    applicantMap.put(name, apartment.id);
                    apartmentMap.get(apartment.id).rooms--;
                    apartmentMap.get(apartment.id).applicantsList.add(name);
                    size = Math.min(shared.size(), apartmentMap.get(apartment.id).rooms);
                }

            }
        }

        // fill single
        if (single.size() > 0) {
            int i = 0;
            for (Apartment apartment : apartments) {
                if (apartmentMap.get(apartment.id).applicantsList.isEmpty() && !single.isEmpty()) {
                    String name = shared.poll();

                    applicantMap.put(name, apartment.id);
                    apartmentMap.get(apartment.id).rooms--;
                    apartmentMap.get(apartment.id).applicantsList.add(name);
                }

                if (single.isEmpty()) {
                    break;
                }
            }
        }

        return applicantMap;
    }

    public static void main(String[] args) {
        List<Applicant> applicants = new ArrayList<>();
        applicants.add(new Applicant("A", RoomPreference.SINGLE));
        applicants.add(new Applicant("B", RoomPreference.SINGLE));
        applicants.add(new Applicant("C", RoomPreference.SHARED));
        applicants.add(new Applicant("D", RoomPreference.SHARED));
        applicants.add(new Applicant("E", RoomPreference.SINGLE));
        applicants.add(new Applicant("F", RoomPreference.SHARED));
        applicants.add(new Applicant("G", RoomPreference.SINGLE));
        applicants.add(new Applicant("H", RoomPreference.SHARED));

        List<Apartment> apartments = new ArrayList<>();
        apartments.add(new Apartment(1, 2));
        apartments.add(new Apartment(2, 2));
        apartments.add(new Apartment(3, 2));
        apartments.add(new Apartment(4, 3));
        apartments.add(new Apartment(5, 1));

        MatchApartment matchApartment = new MatchApartment();
        Map<String, Integer> map = matchApartment.mapApplicantToApartment(applicants, apartments);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
