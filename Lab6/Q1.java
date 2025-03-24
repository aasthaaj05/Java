/*
 * Write program to implement exception handling and multithreading use scenarios based application to implement same
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Meeting {
    String timeSlot;
    String user;

    public Meeting(String timeSlot, String user) {
        this.timeSlot = timeSlot;
        this.user = user;
    }
}

class MeetingScheduler {
    private final List<Meeting> schedule = new ArrayList<>();

    // Synchronized method to prevent race conditions
    public synchronized void bookMeeting(String timeSlot, String user) {
        try {
            Thread.sleep(100); // Simulate processing delay

            // Check if the time slot is already booked
            for (Meeting m : schedule) {
                if (m.timeSlot.equals(timeSlot)) {
                    System.out.println("❌ Error: Time slot " + timeSlot + " is already booked by " + m.user);
                    return;
                }
            }

            // If not booked, add the meeting
            schedule.add(new Meeting(timeSlot, user));
            System.out.println("✅ " + user + " successfully booked the meeting at " + timeSlot);

        } catch (InterruptedException e) {
            System.out.println("⚠️ Thread interrupted!");
        }
    }

    // Display all booked meetings
    public void showSchedule() {
        System.out.println("\n📅 Current Meeting Schedule:");
        if (schedule.isEmpty()) {
            System.out.println("No meetings scheduled.");
        } else {
            for (Meeting m : schedule) {
                System.out.println("⏰ " + m.timeSlot + " -> " + m.user);
            }
        }
    }
}

class MeetingThread extends Thread {
    private final MeetingScheduler scheduler;
    private final String timeSlot;
    private final String user;

    public MeetingThread(MeetingScheduler scheduler, String timeSlot, String user) {
        this.scheduler = scheduler;
        this.timeSlot = timeSlot;
        this.user = user;
    }

    @Override
    public void run() {
        scheduler.bookMeeting(timeSlot, user);
    }
}

public class Q1 {
    public static void main(String[] args) {
        MeetingScheduler scheduler = new MeetingScheduler();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of users booking meetings: ");
        int numUsers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<MeetingThread> threads = new ArrayList<>();

        for (int i = 0; i < numUsers; i++) {
            System.out.print("\nEnter user name: ");
            String user = scanner.nextLine();

            System.out.print("Enter meeting time in 24-hour format (HHMM, e.g., 1300 for 1:00 PM): ");
            String timeSlot = scanner.nextLine();

            MeetingThread thread = new MeetingThread(scheduler, timeSlot, user);
            threads.add(thread);
        }

        // Start all threads
        for (MeetingThread thread : threads) {
            thread.start();
        }

        // Wait for all threads to complete
        for (MeetingThread thread : threads) {
            try {
                thread.join(); // Ensure all meetings are booked before displaying schedule
            } catch (InterruptedException e) {
                System.out.println("⚠️ Thread interrupted while waiting.");
            }
        }

        // Display final schedule
        scheduler.showSchedule();
        scanner.close();
    }
}
