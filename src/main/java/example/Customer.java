package example;

import java.util.List;

@SuppressWarnings("StringConcatenationInLoop")
class Customer {

    public static String getStatement(String name, List<Rental> rentals) {
        String result = "Rental Record for " + name + "\n";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle()+ "\t" + rental.getCharge() + "\n";
        }
        //add footer lines
        result += "Amount owed is " + getTotalAmount(rentals) + "\n";
        result += "You earned " + getTotalFrequentRenterPoints(rentals) + " frequent renter points";
        return result;
    }

    private static double getTotalAmount(List<Rental> rentals) {
        return rentals.stream()
                .mapToDouble(Rental::getCharge)
                .sum();
    }

    private static int getTotalFrequentRenterPoints(List<Rental> rentals) {
        return rentals.stream()
                .mapToInt(Rental::getFrequentRenterPointsIncrement)
                .sum();
    }
}
