public class FlipStats {

	private int[] data;
	private int[] runTrack;

	public FlipStats(int[] d) {
		data = new int[d.length];
		for (int i = 0; i < d.length; i++) { // deep copy of array
			data[i] = d[i];
		}
		runTrack = createRunTrack(data);
	}

	private int[] createRunTrack(int[] d) {
		int l = 0;
		int current = -1;
		for (int i = 0; i < d.length; i++) {
			if (current != d[i]) {
				l += 1;
				current = d[i];
			}
		}

		int[] track = new int[l];
		current = d[0];
		int temp = 0, location = 0;
		for (int i = 0; i < d.length; i++) {
			if (current == d[i]) {
				temp += 1;
			} else {
				track[location] = d[i - 1] == 0 ? -temp : temp;
				current = d[i];
				temp = 1;
				location += 1;
			}
		}
		track[location] = d[d.length - 1] == 0 ? -temp : temp;

		return track;
	}

	public int[] getRunTrack() {
		return runTrack;
	}

	// public int firstRun(int side, int length) {
	// 	int currentRun = 0, i = 0;
	// 	boolean found = false;
	// 	while (!found && i < data.length) {
	// 		if (data[i] == side) {
	// 			currentRun++;
	// 		} else {
	// 			currentRun = 0;
	// 		}
	// 		if (((i + 1) == data.length || data[i + 1] != side) && currentRun == length) {
	// 			found = true;
	// 		}
	// 		i++;
	// 	}
	// 	if (found) {
	// 		return i - length;
	// 	} else {
	// 		return -1;
	// 	}
	// }

        public int firstRun(int side, int length){
            int location = 0;

            for(int i = 0; i < runTrack.length; i++){
                if((side == 0? -runTrack[i] : runTrack[i]) == length){
                    return location;
                }
                location += runTrack[i] < 0? -runTrack[i] : runTrack[i];
            }

            return -1;
        }

        public int longestRun(int side) {

            int min = 0, max = 0;

            for (int i = 0; i<runTrack.length; i++){
                if(runTrack[i]>max){
                    max = runTrack[i];
                }
                if(runTrack[i]<min){
                    min = runTrack[i];
                }
            }
            if(side == 0) {
                return -min;
            } else{
                return max;
            }
        }

        public int longestRun() {
            int headRun = longestRun(0);
            int tailRun = longestRun(1);

            return headRun > tailRun? headRun: tailRun;
        }

	public static void main(String[] args) {

		int[] flipData = { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0 };
		FlipStats data = new FlipStats(flipData);
		System.out.println(data.firstRun(0, 2)); // prints 5
		System.out.println(data.firstRun(1, 3)); // prints 7
		System.out.println(data.firstRun(0, 3)); // prints -1
		System.out.println(data.firstRun(1, 1)); // prints 11

		System.out.println("*********************************************");

		int[] track = data.getRunTrack();
		for (int i = 0; i < track.length; i++) {
			System.out.print(track[i] + (i == track.length - 1 ? "" : ", "));
		} // prints -1, 4, -2, 3, -1, 1, -1, 1, -2

		System.out.println();

		int[] flipData1 = { 1, 1, 1, 1, 1, 1, 1 };
		FlipStats data1 = new FlipStats(flipData1);

		int[] track1 = data1.getRunTrack();
		for (int i = 0; i < track1.length; i++) {
			System.out.print(track1[i] + (i == track1.length - 1 ? "" : ", "));
		} // prints 7

		System.out.println();
		System.out.println("*********************************************");
		
        System.out.println(data.longestRun(0));
        System.out.println(data.longestRun(1));
        System.out.println(data1.longestRun(0));
        System.out.println(data1.longestRun(1));
		System.out.println("*********************************************");

	}

}