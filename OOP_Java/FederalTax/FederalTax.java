import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FederalTax {
	// attributes, instance variables
	private String SSN;
	private double income;
    private Date date;

    //class variables 
    private static double highTax; 

	// constants
	private static final double DEFAULT_INCOME = 0.;
	private static final String DEFAULT_SSN = "001-01-0001";
	private static final double BRACKET_1_INCOME = 0., BRACKET_2_INCOME = 53500., BRACKET_3_INCOME = 250000.;
	private static final double BRACKET_1_BASE = 0., BRACKET_2_BASE = 12107., BRACKET_3_BASE = 79772.;
	private static final double BRACKET_1_PERCENT = .15, BRACKET_2_PERCENT = .31, BRACKET_3_PERCENT = .396;
	private static final String AREA_LOW = "001", AREA_HIGH = "649", GROUP_LOW = "01", GROUP_HIGH = "99",
			SERIAL_LOW = "0001", SERIAL_HIGH = "9999";
	private static final NumberFormat DOLLAR_FORMAT = NumberFormat.getCurrencyInstance();
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");


	// constructors
	public FederalTax() {
		setSSN(DEFAULT_SSN);
		setIncome(DEFAULT_INCOME);
        setDate();
	}

	public FederalTax(String newSSN, double newIncome) {
		setSSN(newSSN);
		setIncome(newIncome);
	}

	// accessors
	public String getSSN() {
		return SSN;
	}

	public double getIncome() {
		return income;
	}

    public Date getDate(){
        Date d1 = new Date();
        d1.setYear(date.getYear());
        d1.setMonth(date.getMonth());
        d1.setDate(date.getDate());

        return d1;
    }

	// mutators
	private void setSSN(String newSSN) {
		String[] split = newSSN.split("-");
		if (split.length != 3) { // {"454", "34", "1234"}
			SSN = DEFAULT_SSN;
			return;
		}

		if (split[0].length() != 3 || Integer.parseInt(split[0]) < Integer.parseInt(AREA_LOW)
				|| Integer.parseInt(split[0]) > Integer.parseInt(AREA_HIGH)) {
			SSN = DEFAULT_SSN;
			return;
		}

		if (split[1].length() != 2 || Integer.parseInt(split[1]) < Integer.parseInt(GROUP_LOW)
				|| Integer.parseInt(split[1]) > Integer.parseInt(GROUP_HIGH)) {
			SSN = DEFAULT_SSN;
			return;
		}

		if (split[2].length() != 4 || Integer.parseInt(split[2]) < Integer.parseInt(SERIAL_LOW)
				|| Integer.parseInt(split[2]) > Integer.parseInt(SERIAL_HIGH)) {
			SSN = DEFAULT_SSN;
			return;
		}

		SSN = newSSN;
	}

	private void setIncome(double newIncome) {
		if (newIncome >= BRACKET_1_INCOME) {
			income = newIncome;
		} else {
			income = DEFAULT_INCOME;
		}

	}

    private void setDate(){
        date = new Date();
    }

	public String toString() {
		return "SSN:" + getSSN() + " Taxable Income:" + DOLLAR_FORMAT.format(getIncome()) + " Date:" + DATE_FORMAT.format(date);
	}

	public int taxBracket() {
		if (income <= BRACKET_2_INCOME) {
			return 1;
		} else if (income <= BRACKET_3_INCOME) {
			return 2;
		} else {
			return 3;
		}
	}

	public double taxPaid() {
		double tax = 0;
		if (this.taxBracket() == 1) {
			tax = BRACKET_1_PERCENT * income;
		} else if (this.taxBracket() == 2) {
			tax = BRACKET_2_BASE + BRACKET_2_PERCENT * (income - BRACKET_2_INCOME);
		} else {
			tax = BRACKET_3_BASE + BRACKET_3_PERCENT * (income - BRACKET_3_INCOME);
		}

        if (tax > highTax){
            highTax = tax;
        }

		BigDecimal tax1 = new BigDecimal(tax).setScale(2, RoundingMode.HALF_UP);
		return tax1.doubleValue();
	}

    public boolean equals(FederalTax t1){
        return this.getIncome() == t1.getIncome();
    }

    public static double getHighestTaxPaid(){
        return highTax;
    }

	public static void main(String[] args) {

		FederalTax tax1 = new FederalTax("454-34-1234", 134345.36);
		System.out.println(tax1);
		System.out.println(tax1.taxBracket());
		System.out.println(tax1.taxPaid());

        Date tax1Date = tax1.getDate();
        System.out.println(DATE_FORMAT.format(tax1.getDate()));
	}

}