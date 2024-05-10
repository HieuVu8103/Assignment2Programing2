package a2_2101140058;


public class PC {
    private String model;
    private int year;
    private String manufacturer;
    private Set<String> comps;
    
    public PC(String model, int year, String manufacturer, Set<String> comps) {
    	if (validateModel(model) && validateYear(year) && validateManufacturer(manufacturer)) {
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.comps = comps;
    	} else {
    		throw new IllegalArgumentException();
    	}
    }

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public Set<String> getComps() {
		return comps;
	}
    
    public boolean setModel(String model) {
    	boolean result = false;
		if (validateModel(model)) {
			this.model = model;
			result = true;
		} 
		return result;
	}

	public boolean setComps(Set<String> comps) {
		boolean result = true;
		this.comps = comps;
		return result;
	}
	
	public boolean validateModel(String model) {
		boolean result = false;
		if (model.length() <= 20) {
			result = true;
		}
		return result;
	}
	
	public boolean validateYear(int year) {
		boolean result = false;
		if (year >= 1984) {
			result = true;
		}
		return result;
	}
	
	public boolean validateManufacturer(String manufacturer) {
		boolean result = false;
		if (manufacturer.length() <= 15) {
			result = true;
		}
		return result;
	}

	@Override
    public String toString() {
        return "PC<" + model + ", " + year + ", " + manufacturer + ", " + comps + ">";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PC)) return false;
        PC otherPC = (PC) obj;
        return model.equals(otherPC.model) && year == otherPC.year && manufacturer.equals(otherPC.manufacturer)
                && comps.equals(otherPC.comps);
    }
}
