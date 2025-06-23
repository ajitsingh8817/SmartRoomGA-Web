package com.example.smartroomga.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.smartroomga.model.Room;
import com.example.smartroomga.model.Student;




@Controller
public class RoomGAController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/run")
    public String runGA(@RequestParam List<String> preference,
                        @RequestParam List<Integer> year,
                        @RequestParam List<String> roomType,
                        @RequestParam List<Boolean> roomAc,
                        Model model) {

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < preference.size(); i++) {
            students.add(new Student(preference.get(i), year.get(i)));
        }

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < roomType.size(); i++) {
            rooms.add(new Room(roomType.get(i), roomAc.get(i)));
        }

        int[] best = allocateRoomsGA(students, rooms);

        List<String> allocation = new ArrayList<>();
        for (int i = 0; i < best.length; i++) {
            allocation.add("Student " + i + " -> Room " + best[i]);
        }

        model.addAttribute("allocation", allocation);
        return "result";
    }

    public int[] allocateRoomsGA(List<Student> students, List<Room> rooms) {
        Random rand = new Random();
        int popSize = 6, gen = 10, n = students.size();
        int[] best = null;
        int bestScore = -1;

        List<int[]> population = new ArrayList<>();
        for (int i = 0; i < popSize; i++) {
            int[] genes = new int[n];
            for (int j = 0; j < n; j++) {
                genes[j] = rand.nextInt(rooms.size());
            }
            population.add(genes);
        }

        for (int g = 0; g < gen; g++) {
            for (int[] ind : population) {
                int score = fitness(ind, students, rooms);
                if (score > bestScore) {
                    bestScore = score;
                    best = ind.clone();
                }
            }
        }
        return best;
    }

    public int fitness(int[] ind, List<Student> students, List<Room> rooms) {
        int score = 0;
        for (int i = 0; i < ind.length; i++) {
            Student s = students.get(i);
            Room r = rooms.get(ind[i]);
            if (s.getPreference().equalsIgnoreCase(r.getType())) score += 2;
            if (r.isAc() && s.getYear() >= 3) score += 1;
        }
        return score;
    }
}
