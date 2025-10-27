package com.neoteric;

public class Student {
    private String hallTicket;
    private String name;
    private int marks;

        public Student(String hallTicket, String name, int marks) {
            this.hallTicket = hallTicket;
            this.name = name;
            this.marks = marks;
        }

        public String getHallTicket() { return hallTicket; }
        public String getName() { return name; }
        public int getMarks() { return marks; }

        public String getResult() {
            return marks >= 35 ? "Pass" : "Fail";
        }
    }

