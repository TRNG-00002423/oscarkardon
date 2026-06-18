package com.rev.partner_b;


import java.util.PriorityQueue;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Partner B — drain PriorityQueue in priority order. */
public class TaskQueueApp {
    private static final Logger logger =LoggerFactory.getLogger(TaskQueueApp.class);
    public static void main(String[] args) {
        logger.info("Partner B program is running");
        Queue<Task> q = new PriorityQueue<>();
        logger.info("Tasks are offered to queue");
        // TODO: offer tasks out of order, poll and print, peek demo
        q.offer(new Task(5, "Watch WC"));
        q.offer(new Task(2, "Study"));
        q.offer(new Task(3, "Exercises"));
        q.offer(new Task(4, "Work"));

        logger.info("Peek queue method used");
        System.out.println(q.peek());


         while (!q.isEmpty()) {
            Task task = q.poll();
            System.out.println(task);
            logger.debug(task + " polled");

        }

    }
}