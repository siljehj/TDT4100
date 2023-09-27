package oving4;

public class StopWatch {
    

    // internal state
    private boolean started = false;
    private int stopCount = 0;
    private int totalTickCount = 0;
    private int tickCount = 0;
    private int lapTickCount = 0;
    private int lastLapTickCount = 0;

    // constructor
    public StopWatch() {
    }

    // methods to get the internal state
    public boolean isStarted() {
        if (started || stopCount > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isStopped() {
        if (stopCount > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getTicks() {
        return totalTickCount;
    }

    public int getTime() {
        if (started || stopCount > 0) {
            return tickCount;
        }

        else {
            return -1;
        }
    }

    public int getLapTime() {
        if (!started && stopCount == 0) {
            return -1;
        } else {
            return lapTickCount;
        }
    }

    public int getLastLapTime() {
        if (lastLapTickCount == 0) {
            return -1;
        } else {
            return lastLapTickCount;
        }
    }

    // methods to change the internal state
    public void tick(int ticks) {
        if (ticks < 0) {
            throw new IllegalArgumentException("Time should not go backwards");
        }
        if (started) {
            tickCount += ticks;
            lapTickCount += ticks;
        }
        totalTickCount += ticks;
    }

    public void start() {
        if (started) {
            throw new IllegalStateException("Cannot start already running stopwatch");
        }
        started = true;
    }

    public void lap() {
        checkClockIsStarted();
        /*if (!started) {
            throw new IllegalStateException("Cannot lap when clock is not started");
        }*/
        if (lapTickCount > 0) {
            lastLapTickCount = lapTickCount;
        }
        lapTickCount = 0;
    }

    public void stop() {
        checkClockIsStarted();
        /*if (!started) {

            throw new IllegalStateException("Cannot stop stopped stopwatch");
        }*/
        started = false;
        lastLapTickCount = lapTickCount;
        lapTickCount = 0;
        stopCount += 1;
    }

    // validation-method
    private void checkClockIsStarted() {
        if (!started) {
            throw new IllegalStateException(""); // denne feilmeldingen er ikke spesifikk
        }
    }

    public String toString() {
        return "Total time: " + totalTickCount + "\tTime: " + tickCount + "\tLap time: " + lapTickCount
                + "\tLast lap time: " + lastLapTickCount;
    }

    public static void main(String[] args) {
        StopWatch time1 = new StopWatch();
        time1.tick(2);
        time1.start();
        time1.tick(4);
        System.out.println(time1);
        time1.lap();
        time1.tick(9);
        System.out.println(time1);
        time1.lap();
        time1.tick(5);
        System.out.println(time1);
        time1.stop();
        time1.tick(3);
        System.out.println(time1);

    }

}
