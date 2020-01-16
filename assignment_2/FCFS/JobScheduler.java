package FCFS;

import java.util.*;

public class JobScheduler {

	/**
	 * @exception are handled using "If-else" conditional statements for negative values provided by user,
	 * And for alphabets and special character exceptions are handled using "InputMismatchException" class.
	 */
	public static void main(String[] args){
		Fcfs job = new Fcfs();
		Scanner readInp = new Scanner(System.in);
		operationOnFCFS:
			while (true) {

				if(job.arrivalTime.isEmpty()){

					System.out.println("Enter total number of processes");

					while(job.totalProcesses == 0){
						try {
							job.totalProcesses = readInp.nextInt();
							if(job.totalProcesses < 0){
								System.out.println("\nError : Give positive integer values\n");
								job.totalProcesses = 0;
							}
						} catch (InputMismatchException e) {
							System.out.println("\nError : Provide valid input\n");
							readInp.nextLine();
						}
					}

					System.out.println("your total processes are : " + job.totalProcesses);

					int iterate = 0;

					while(iterate < job.totalProcesses){
						System.out.println("Enter arrival time then burst time for Process" + iterate);

						try {
							job.arrivalTime.add(readInp.nextInt());
							if(job.arrivalTime.get(iterate) < 0){
								job.arrivalTime.remove(iterate);
								System.out.println("\nError : Provide positive Integer value\n");
								continue;
							}
							if(!job.arrivalTime.isEmpty()){
								if(iterate >0){
									if(job.arrivalTime.get(iterate) < job.arrivalTime.get(iterate -1)){
										System.out.println("\nError : Provide arrival time in incremental order\n");
										job.arrivalTime.remove(iterate);
										continue;
									}
								}
								job.burstTime.add(readInp.nextInt());
								if(job.burstTime.get(iterate) < 0){
									job.burstTime.remove(iterate);
									System.out.println("\nError : Provide positive Integer value\n");
									continue;
								}else{
									iterate ++;
								}
							}
						} catch (InputMismatchException e) {
							System.out.println("\n Type Mismatch Error : Provide Integer Input\n");
							if(!job.arrivalTime.isEmpty()){
								job.arrivalTime.remove(iterate);
							}
							readInp.nextLine();
						}
					}
				}
				else {

					System.out
					.println("Choose the option from below :\n1.Completion Time\n2.Waiting Time\n3.Turn Around Time\n4.Average Waiting Time\n5.Maximum Waiting Time\n6.Exit\n");

					int option = 0;

					try {
						option = readInp.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("\nError : Provide valid input\n");
						readInp.nextLine();
					}

					switch (option) {
					case 1:
						job.calCompletionTime();
						System.out.println("\nThe Completion time for processes are :\n");
						for(int i = 0; i < job.totalProcesses; i++){
							System.out.println("Process "+ i + " : " + job.completionTime.get(i));
						}
						break;

					case 2:
						job.calWaitingTime();
						System.out.println("\nThe Waiting time for processes are :\n");
						for(int i = 0; i < job.totalProcesses; i++){
							System.out.println("Process "+ i + " : " + job.waitingTime.get(i));
						}
						break;

					case 3:
						job.calTurnAroundTime();
						System.out.println("\nThe Turn Around time for processes are :\n");
						for(int i = 0; i < job.totalProcesses; i++){
							System.out.println("Process "+ i + " : " + job.turnAroundTime.get(i));
						}
						break;

					case 4:
						if(job.waitingTime.isEmpty()){
							job.calWaitingTime();
						}
						int avgTime = job.calAvgWaitingTime();
						System.out
						.println("\nAvg. waiting time is : " + avgTime + "\n");
						break;

					case 5:
						if(job.waitingTime.isEmpty()){
							job.calWaitingTime();
						}
						int maxWaitingTime = job.calMaxWaitingTime();
						System.out.println("\nMax. waiting time is : " + maxWaitingTime
								+ "\n");
						break;

					case 6:
						break operationOnFCFS;

					default:
						System.out.println("\nError : Provide valid input\n");
						break;
					}	
				}
			}
		readInp.close();		
	}

}
