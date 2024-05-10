package a2_2101140058;

public class PCReport {

    private String formatComponents(String components) {
        if (components.length() > 50) { 
            components = components.substring(0, 47) + "...]";
        }
        return components;
    }

    public String displayReport(PC[] objs) {
        StringBuilder report = new StringBuilder();
        report.append("---------------------------------------------------------------------------------------------------\n")
              .append("                                           PCPROG REPORT                                            \n")
              .append("---------------------------------------------------------------------------------------------------\n");

        int counter = 1;
        for (PC pc : objs) {
            String model = pc.getModel();
            int year = pc.getYear();
            String manufacturer = pc.getManufacturer();
            String components = formatComponents(pc.getComps().getElements().toString());
            report.append(String.format("%3d   %-18s   %-4d         %-7s %s\n", counter, model, year, manufacturer, components));
            counter++;
        }
        report.append("---------------------------------------------------------------------------------------------------");
        return report.toString();
    }
}


