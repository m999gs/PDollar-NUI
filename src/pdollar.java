
import java.io.*;
import java.util.ArrayList;

public class pdollar {

	public static void main(String args[]) throws Exception {

		// Initializing the File variables
		PDollarRecognizer pDollarR = new PDollarRecognizer();
		File file = new File("save.txt");
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter outputWriter = new BufferedWriter(fw);

		try {
			if (args.length == 0)// No Arguments
			{
				System.out.println("\n****************************     HELP     ****************************");
				System.out.println("\nPlease enter the correct input");
				System.out.println("java pdollar –t <gesture file location>: Adds the gesture file to the list of gesture templates");
				System.out.println("java pdollar –r: Clears the previous templates");
				System.out.println("java pdollar <eventstream file location>: Prints the name of gestures from the event stream.\n");
				System.out.println("**********************************************************************");
				System.exit(0);

			} else if (args[0].equalsIgnoreCase("-r")) {//Clear the previous templates
				new FileOutputStream("save.txt");
			} else if (args[0].equalsIgnoreCase("-t")) {// Adding the Template
				BufferedReader br = new BufferedReader(new FileReader(args[1]));
				
				try {
					String gestureName = br.readLine();
					outputWriter.append(gestureName + "\n");

					int Stroke_id = 0;
					String line = " ";
					while ((line = br.readLine()) != null) {
						if (line.equalsIgnoreCase("BEGIN"))
							Stroke_id++;
						else if (line.equalsIgnoreCase("END")) {
						} else {
							outputWriter.append(line + "," + Stroke_id + "\n");
						}
					}
					outputWriter.append("*****\n");

				} finally {outputWriter.close();
					br.close();
				}
			} else {// Reading the EventGesture File
				BufferedReader br = new BufferedReader(new FileReader(args[0]));

				ArrayList<Point> eventList = new ArrayList<Point>();

				try {
					int Stroke_id = 0;
					String line = " ";
					while ((line = br.readLine()) != null) {
						if (line.equalsIgnoreCase("MOUSEDOWN")) {
							Stroke_id++;

						} else if (line.equalsIgnoreCase("MOUSEUP")) {

						} else if (line.equalsIgnoreCase("RECOGNIZE")) {//Recognizing the Gesture
							pDollarR.Recognize(eventList);
							Stroke_id = 0;
							line = " ";
							eventList.clear();
						} else if (line.contains(",")) {
							String P[] = line.split(",");

							eventList.add(new Point(Double.parseDouble(P[0]), Double.parseDouble(P[1]), Stroke_id));
						}
					}

				} finally {
					br.close();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
			return;
		}
	}
}