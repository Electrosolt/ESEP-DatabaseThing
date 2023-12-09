public class DatabaseTests {

    public static void main(String[] args) throws IllegalAccessException {

        Database database = new Database();

        // should return null, because A doesn’t exist in the DB yet
        System.out.println(database.get("A"));

        // should throw an error because a transaction is not in progress
        try {
            database.put("A", 5);
        } catch (IllegalAccessException e) {
            System.out.println("Error accessing key");
        }

        // starts a new transaction
        database.begin_transaction();

        // set’s value of A to 5, but its not committed yet
        database.put("A", 5);

        // should return null, because updates to A are not committed yet
        System.out.println(database.get("A"));

        // update A’s value to 6 within the transaction
        database.put("A", 6);

        // commits the open transaction
        database.commit();

        // should return 6, that was the last value of A to be committed
        System.out.println(database.get("A"));

        // throws an error, because there is no open transaction
        try {
            database.commit();
        } catch (IllegalAccessException e) {
            System.out.println("Error creating commit");
        }


        // throws an error because there is no ongoing transaction

        try {
            database.rollback();
        } catch (IllegalAccessException e) {
            System.out.println("Error aborting commit");
        }

        // should return null because B does not exist in the database
        System.out.println(database.get("B"));

        // starts a new transaction
        database.begin_transaction();

        // Set key B’s value to 10 within the transaction
        database.put("B", 10);

        // Rollback the transaction - revert any changes made to B
        database.rollback();

        // Should return null because changes to B were rolled back
        System.out.println(database.get("B"));

    }
}