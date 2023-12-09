import java.util.HashMap;

public class Database
{

    HashMap<String, Integer> mainDatabase = new HashMap<>();
    HashMap<String, Integer> lastCommit = new HashMap<>(); // Misunderstood what the rollback() function did
    HashMap<String, Integer> commit = new HashMap<>();

    private boolean transactionOngoing = false;

    public Integer get(String key) {
        return mainDatabase.get(key);
    }

    public void put(String key, int val) throws IllegalAccessException {
        if (transactionOngoing)
        {
            commit.put(key, val);
        } else
        {
            throw new IllegalAccessException("You must have a transaction ongoing.");
        }
    }

    public void begin_transaction() throws IllegalAccessException {
        if (transactionOngoing)
        {
            throw new IllegalAccessException("Only one transaction may happen at a time.");
        } else
        {
            transactionOngoing = true;
        }
    }

    public void commit() throws IllegalAccessException {

        if(!transactionOngoing)
        {
            throw new IllegalAccessException("You must have a transaction ongoing.");
        }

        lastCommit.clear();

        for(var key : commit.keySet())
        {
            lastCommit.put(key, mainDatabase.get(key));
            mainDatabase.put(key, commit.get(key));
        }

        commit.clear();
        transactionOngoing = false;

    }

    public void rollback() throws IllegalAccessException {

        if(!transactionOngoing)
        {
            throw new IllegalAccessException("You must have a transaction ongoing.");
        }

        commit.clear();
        transactionOngoing = false;
    }
}
