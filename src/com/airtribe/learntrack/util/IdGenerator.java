package com.airtribe.learntrack.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Thread-safe utility class for generating unique IDs for entities.
 * Using AtomicInteger ensures safe ID generation in multi-threaded environments.
 */
public final class IdGenerator {
    // AtomicInteger ensures thread-safe increment operations without explicit synchronization
    private static final AtomicInteger studentIdCounter = new AtomicInteger(1);
    private static final AtomicInteger courseIdCounter = new AtomicInteger(1);
    private static final AtomicInteger enrollmentIdCounter = new AtomicInteger(1);

    // Private constructor to prevent instantiation
    private IdGenerator() {
    }

    public static int getNextStudentId() {
        return studentIdCounter.getAndIncrement();
    }

    public static int getNextCourseId() {
        return courseIdCounter.getAndIncrement();
    }

    public static int getNextEnrollmentId() {
        return enrollmentIdCounter.getAndIncrement();
    }

}
