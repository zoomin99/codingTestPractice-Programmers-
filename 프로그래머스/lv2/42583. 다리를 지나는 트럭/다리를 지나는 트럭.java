import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    class Truck {
        int weight;
        int remainDistance;

        public Truck(int weight, int remainDistance) {
            this.weight = weight;
            this.remainDistance = remainDistance;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int passTruckCount = 0;
        Queue<Truck> waitingQueue = new LinkedList<>();
        List<Truck> movingList = new LinkedList<>();

        for (int truckWeight : truck_weights) {
            waitingQueue.add(new Truck(truckWeight, bridge_length));
        }

        while (passTruckCount != truck_weights.length) {
            //트럭을 다리에 올리는 로직
            if (!waitingQueue.isEmpty()) {
                if (weight - waitingQueue.element().weight >= 0) {
                    weight -= waitingQueue.element().weight;
                    movingList.add(waitingQueue.remove());
                }
            }

            //트럭이 이동하는 로직
            if (!movingList.isEmpty()) {
                for (Truck truck : movingList) {
                    truck.remainDistance--;
                }
            }

            //지나간 트럭이 생겼을때
            if (movingList.get(0).remainDistance == 0) {
                weight += movingList.get(0).weight;
                movingList.remove(0);
                passTruckCount++;
            }
            answer++;
        }

        return answer + 1;
    }
}