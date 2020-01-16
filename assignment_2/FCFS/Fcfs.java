package FCFS;

import java.util.*;

/**
 * This class holds the attributes related to First Come First Serve of the provided Processes or Jobs.
 * It uses ArrayList to store the values also all operations are performed using that.
 * 
 * Abbriviations used in comments :
 * CT = Completion Time;
 * BT = Burst Time;
 * AT = Arrival Time;
 * WT = Waiting Time;
 * TAT = Turn Around Time;
 * @author Martand
 *
 */

public class Fcfs {

	public int getTotalProcesses() {
		return totalProcesses;
	}

	public void setTotalProcesses(int totalProcesses) {
		this.totalProcesses = totalProcesses;
	}

	public ArrayList<Integer> getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(ArrayList<Integer> arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public ArrayList<Integer> getBurstTime() {
		return burstTime;
	}

	public void setBurstTime(ArrayList<Integer> burstTime) {
		this.burstTime = burstTime;
	}

	public ArrayList<Integer> getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(ArrayList<Integer> waitingTime) {
		this.waitingTime = waitingTime;
	}

	public ArrayList<Integer> getTurnAroundTime() {
		return turnAroundTime;
	}

	public void setTurnAroundTime(ArrayList<Integer> turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
	}

	public ArrayList<Integer> getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(ArrayList<Integer> completionTime) {
		this.completionTime = completionTime;
	}

	int totalProcesses;
	ArrayList<Integer> arrivalTime = new ArrayList<Integer>();
	ArrayList<Integer> burstTime = new ArrayList<Integer>();
	ArrayList<Integer> waitingTime = new ArrayList<Integer>();
	ArrayList<Integer> turnAroundTime = new ArrayList<Integer>();
	ArrayList<Integer> completionTime = new ArrayList<Integer>();

	/**
	 * This function calculates Completion Time of processes.
	 * Using (CT)i-1 + (BT)i when burst time of (i-1)th process is smaller then arrival time of (i)th process,
	 * And (AT)i + (BT)i when arrival time of (i)th process is gretter.
	 */
	public void calCompletionTime(){
		for(int i = 0; i < totalProcesses; i++){
			if(i==0){
				completionTime.add(burstTime.get(i));
			}
			else{
				if(burstTime.get(i-1) >= arrivalTime.get(i)){
					completionTime.add(completionTime.get(i-1) + burstTime.get(i));
				}
				else{
					completionTime.add(arrivalTime.get(i) + burstTime.get(i));
				}
			}
		}
	}

	/**
	 * This function calculates Waiting Time of processes.
	 * Using value = { (BT)i-1 - (AT)i } when value >= 0,
	 * And assign (WT)i = 0 when new process arrives before completion of current process.
	 */
	public void calWaitingTime(){
		waitingTime.add(0);
		for(int i = 1; i < totalProcesses; i++){
			if(burstTime.get(i-1) - arrivalTime.get(i) >= 0){
				waitingTime.add(burstTime.get(i-1) - arrivalTime.get(i));
			}
			else{
				waitingTime.add(0);
			}
		}
	}

	/**
	 * This function calculates Turn Around Time of processes.
	 * Using value = { (BT)i-1 - (AT)i + (BT)i } when value >= 0,
	 * And assign (WT)i = (BT)i when value <0.
	 */
	public void calTurnAroundTime(){
		turnAroundTime.add(burstTime.get(0) - arrivalTime.get(0));
		for(int i = 1; i < totalProcesses; i++){
			if(burstTime.get(i-1) - arrivalTime.get(i) + burstTime.get(i) >= 0){
				turnAroundTime.add(burstTime.get(i-1) - arrivalTime.get(i) + burstTime.get(i));
			}
			else{
				turnAroundTime.add(burstTime.get(i));
			}
		}
	}

	/**
	 * This function calculates Average Waiting Time of Processes using the values stored in ArrayList waitingTime.
	 * @return the integer value of average waiting time. 
	 */
	public int calAvgWaitingTime(){
		int totalSum = 0;
		for(int i = 0; i < totalProcesses; i++){
			totalSum += waitingTime.get(i);
		}
		return (totalSum/totalProcesses);
	}

	/**
	 *This function finds Maximum Waiting Time of Processes using the values stored in ArrayList waitingTime.
	 * @return the integer value of Maximum waiting time.
	 */
	public int calMaxWaitingTime(){
		int findMax = waitingTime.get(0);
		for(int i = 1; i < totalProcesses; i++){
			if(findMax < waitingTime.get(i)){
				findMax = waitingTime.get(i);
			}
			else{
				continue;
			}
		}
		return findMax;
	}
}
