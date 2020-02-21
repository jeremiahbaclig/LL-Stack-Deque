/**
 * This class sets and gets the variables name, code, capitol, etc. Methods include a 
 * constructor that we can call from Project2 and assign values from the file, and
 * a toString() method as well.
 * 
 * @author <Jeremiah Baclig>
 * @version <10/21/2019>
 */


public class Country {

	// initialize local variables
	private String name, code, capitol;
	private long population;
	private double GDP;
	private int happiness;
	private double GDPPerCapita = getGDP()/getPopulation();

	/**
	 * Constructor for the class. Populates variables read in from Project1.
	 * 
	 * @param name  Name of country.
	 * @param code  Country code.
	 * @param capitol	Capitol city.
	 * @param population	Total population.
	 * @param GDP	Country's GDP.
	 * @param happiness	 Happiness ranking.
	 */
	public Country(String name, String code, String capitol, long population, double GDP, int happiness) {
		this.name = name;
		this.code = code;
		this.capitol = capitol;
		this.population = population;
		this.GDP = GDP;
		this.happiness = happiness;
	}

	public Country() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getter for variable name.
	 * 
	 * @return value of name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for variable name.
	 * 
	 * @param name	Country's name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter for country's code.
	 * 
	 * @return value of code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setter for variable code.
	 * 
	 * @param code	Country's code.
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Getter for country's capitol city.
	 * 
	 * @return value of capitol.
	 */
	public String getCapitol() {
		return capitol;
	}

	/**
	 * Setter for variable capitol.
	 * 
	 * @param capitol  Country's capitol city.
	 */
	public void setCapitol(String capitol) {
		this.capitol = capitol;
	}

	/**
	 * Getter for country's GDP. 
	 * 
	 * @return value of GDP.
	 */
	public double getGDP() {
		return GDP;
	}

	/**
	 * Setter for GDP variable.
	 * 
	 * @param GDP  Country's GDP in terms of a double.
	 */
	public void setGDP(double GDP) {
		this.GDP = GDP;
	}

	/**
	 * Getter for country's population.
	 * 
	 * @return value of population.
	 */
	public long getPopulation() {
		return population;
	}

	/**
	 * Setter for population variable.
	 * 
	 * @param population  Country's population given in terms of long.
	 */
	public void setPopulation(long population) {
		this.population = population;
	}
	
	/**
	 * Getter for happiness ranking.
	 * 
	 * @return value of happiness ranking.
	 */
	public int getHappiness() {
		return happiness;
	}

	/**
	 * Setter for happiness ranking.
	 * 
	 * @param happiness  Happiness ranking in terms of an int.
	 */
	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}
	
	/**
	 * Getter for GDP Per Capita.
	 * 
	 * @return GDPPerCapita  GDP Per Capita is GPD / population.
	 */
	public double getGDPPerCapita() {
		return GDPPerCapita;
	}
	
	/**
	 * Setter for GDP Per Capita.
	 * 
	 * @param GDPPerCapita  GDP / population.
	 */
	public void setGDPPerCapita(double GDPPerCapita) {
		this.GDPPerCapita = GDPPerCapita;
	}

	@Override
	/**
	 * toString method to format the list of country objects.
	 */
	public String toString() {
		return String.format("%-32.31s%-16s%-24s%-24d%-24.2e%-12d", getName(), getCode(), getCapitol(), getPopulation(), getGDP(), getHappiness());
	}

}