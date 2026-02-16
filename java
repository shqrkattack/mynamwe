import java.util.ArrayList;

public class CanAttend {

	//precondition: 
	//postcondition: 
	public static boolean canAttend(ArrayList<MeetingInterval> meetings) {
		//your implementation here
		selectionSort(meetings);
		for (int i = 0; i < meetings.size()-1;++){
			MeetingInterval current = meetings.get(i);
			MeetingInterval next = meetings.get(i+1);
		if (current.getEnd() > next.getStart()){
			return false;
		}
	}
	return true; //replace me with actual logic please!
	}
	public static void selectionSort(ArrayList < MeetingInterval>meetings){
		int n = meetings.size();
		for (int i = 0; i < n-1; i++){
			int minIndex = i;
			for (int j = i +1; j < n; j++){
				if (meetings.get(j).getStart() < meetings.get(minIndex).getStart()){
					minIndex = j;
				}
			}
			if (minIndex != i){
				MeetingInterval temp = meetings.get(i);
				meetings.set(i,meetings.get(minIndex));
				meetings.set(minIndex,temp);
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<MeetingInterval> meet = new ArrayList<MeetingInterval>();
		for(int i =0; i<10; i++) {
			int start = (int)(Math.random()*2399);
			int end = start + ((int)(Math.random()*(2399-start)));
			meet.add(new MeetingInterval(start, end));
		}
		System.out.println(canAttend(meet) ? "There is no conflict with attending "+meet+" meetings":"Can't attend "+meet+" meetings due to conflict");
		//please include additional testing here!
	}
}
