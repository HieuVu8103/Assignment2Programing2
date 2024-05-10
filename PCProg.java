package a2_2101140058;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;


import utils.NotPossibleException;
/**
 * A program that captures data about PC objects and displays
 * a report about them on the console.
 */
public class PCProg {
    private static final Object YES = "Y";
    private Set<PC> objs;

    /**
     * Initialise this to have an empty set of PCs
     */
    public PCProg() {
        objs = new Set<>();
    }

    /**
     * If <tt>objs</tt> is not empty, displays a text-based tabular
     * report on <tt>objs</tt> to the standard console.
     * Displays nothing if <tt>objs</tt> is empty.
     *
     * @return this report if <tt>objs</tt> is not empty or <tt>null</tt> otherwise.
     */
    public String displayReport() {
        if (!objs.isEmpty()) {
            Vector<PC> pcs = objs.getElements();
            PCReport reportObj = new PCReport();
            return reportObj.displayReport(pcs.toArray(new PC[0]));
        } else {
            return null;
        }
    }

    /**
     * Saves report to a file <tt>pcs.txt</tt> in the program's working directory.
     */
    public void saveReport(String report) {
        String fileName = "pcs.txt";
        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.println(report);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Create PC objects from data entered by the user and add them to the set.
     * Terminates when the user enters "N" to stop adding more PCs.
     * @throws NotPossibleException if any exception occurs during PC creation.
     */
    public void createObjects() {
        Scanner scanner = new Scanner(System.in);
        PCFactory pcFactory = PCFactory.getInstance();

        String continueInput = "Y";
        int pcCount = 1;

        while (continueInput.equalsIgnoreCase("Y")) {
            System.out.println("Enter PC information:");
            System.out.print("Model: ");
            String model = scanner.nextLine();
            System.out.print("Year: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Manufacturer: ");
            String manufacturer = scanner.nextLine();
            
            Set<String> comps = new Set<>();
            System.out.println("Enter components (Enter blank line to stop):");
            String component;
            while (!(component = scanner.nextLine()).isEmpty()) {
                comps.insert(component);
            }

            PC pc = pcFactory.createPC(model, year, manufacturer, comps);
            objs.insert(pc);

            System.out.print("Do you want to add another PC? (Y/N): ");
            continueInput = scanner.nextLine();
            pcCount++;
        }
    }

    
    /**
     * Retrieves the recorded PC objects.
     * @return a set of PC objects.
     */
    public Set<PC> getObjects() {
        return objs;
    }

    /**
     * Initializes an instance of <tt>PCProg</tt>.
     * Create objects from data entered by the user.
     * Display a report on the objects.
     * Prompt user to save report to file. If user answers "Y", save report.
     * Otherwise, end program.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PCProg prog = new PCProg();
        try {
            // create objects
            prog.createObjects();
            // display report
            String report = prog.displayReport();
            System.out.println(report);
            if (report != null) {
                // prompt user to save report
                System.out.println("Save report to file? [Y/N]");
                String toSave = sc.nextLine();
                if (toSave.equals("Y")) {
                    prog.saveReport(report);
                    System.out.println("report saved");
                }
            }
        } catch (NotPossibleException e) {
            System.err.printf("%s: %s%n", e, e.getMessage());
        }
        System.out.println("~END~");
    }
}
