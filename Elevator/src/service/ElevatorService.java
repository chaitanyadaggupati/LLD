package service;

import model.Request;
import model.enums.Direction;
import model.enums.Location;

import java.util.PriorityQueue;

public class ElevatorService {
    public Integer currentFloor;
    Direction direction;
    PriorityQueue<Request> upQueue;
    PriorityQueue<Request> downQueue;

    public ElevatorService(Integer currentFloor) {
        this.currentFloor = currentFloor;
        this.direction = Direction.IDLE;
        this.upQueue = new PriorityQueue<>((a,b) -> (a.desiredFloor - b.desiredFloor));
        this.downQueue = new PriorityQueue<>((a,b) -> (b.desiredFloor - a.desiredFloor));
    }

    public void sendUpRequest(Request upRequest) {
        if (upRequest.location== Location.OUTSIDE) {
            upQueue.offer(new Request(
                    upRequest.currentFloor, upRequest.currentFloor, Direction.UP, Location.OUTSIDE
            ));
            System.out.println("Append up request going to floor " + upRequest.currentFloor + ".");
        }
        upQueue.offer(upRequest);
        System.out.println("Append up request going to floor " + upRequest.desiredFloor + ".");
    }

    public void sendDownRequest(Request downRequest) {
        if (downRequest.location== Location.OUTSIDE) {
            downQueue.offer(new Request(
                    downRequest.currentFloor, downRequest.currentFloor, Direction.DOWN, Location.OUTSIDE
            ));
            System.out.println("Append down request going to floor " + downRequest.currentFloor + ".");
        }
        downQueue.offer(downRequest);
        System.out.println("Append down request going to floor " + downRequest.desiredFloor + ".");

    }

    public void run() {
        while (!upQueue.isEmpty() || !downQueue.isEmpty()) {
            processRequests();
        }
        System.out.println("All the requests have been processed");
        this.direction= Direction.IDLE;
    }

    public void processRequests() {
        if (this.direction== Direction.UP || this.direction== Direction.IDLE) {
            processUpRequest();
            processDownRequest();
        } else {
            processDownRequest();
            processUpRequest();
        }
    }

    public void processUpRequest() {
        while (!upQueue.isEmpty()) {
            Request request = upQueue.poll();
            this.currentFloor = request.desiredFloor;
            System.out.println("Processing up requests. Elevator stopped at floor " + this.currentFloor + ".");
        }
        if (!downQueue.isEmpty()) {
            this.direction= Direction.DOWN;
        } else {
            this.direction= Direction.IDLE;
        }

    }

    public void processDownRequest() {
        while (!downQueue.isEmpty()) {
            Request request = downQueue.poll();
            this.currentFloor = request.desiredFloor;
            System.out.println("Processing down requests. Elevator stopped at floor " + this.currentFloor + ".");
        }
        if (!upQueue.isEmpty()) {
            this.direction= Direction.UP;
        } else {
            this.direction= Direction.IDLE;
        }
    }

}
