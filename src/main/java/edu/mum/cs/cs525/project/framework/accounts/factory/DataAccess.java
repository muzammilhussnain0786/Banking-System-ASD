package edu.mum.cs.cs525.project.framework.accounts.factory;

import edu.mum.cs.cs525.project.framework.accounts.Account;
import edu.mum.cs.cs525.project.framework.accounts.Owner;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DataAccess {
    private static DataAccess dataAccess;

    private DataAccess(){
    }

    public static DataAccess getInstance(){
        if (dataAccess == null){
            return dataAccess = new DataAccess();
        }
        return dataAccess;
    }

    enum StorageType {
        ACCOUNT, OWNER;
    }

    public Map<String, Account> readAccountMap() {
        return (Map<String,Account>) readFromStorage(StorageType.ACCOUNT);
    }

    public Map<String, Owner> readOwner() {
        return (Map<String, Owner>) readFromStorage(StorageType.OWNER);
    }

    public List<Owner> getOwners() {
        return (List<Owner>) readFromStorage(StorageType.OWNER);
    }

    public void saveAccount(Account member) {
        Map<String, Account> mems = readAccountMap();
        if (mems == null){
            mems = new HashMap<>();
        }
        String memberId = member.getAccountNumber();
        mems.put(memberId, member);
        saveToStorage(StorageType.ACCOUNT, mems);
    }

    public static void saveAccounts(List<Account> accounts) {
        HashMap<String, Account> books = new HashMap<String, Account>();
        accounts.forEach(book -> books.put(book.getAccountNumber(), book));
        saveToStorage(StorageType.ACCOUNT, books);
    }
    public static void saveOwners(List<Owner> userList) {
        HashMap<String, Owner> users = new HashMap<String, Owner>();
        userList.forEach(user -> users.put(user.getId(), user));
        saveToStorage(StorageType.OWNER, users);
    }

    static void saveToStorage(StorageType type, Object ob) {
        ObjectOutputStream out = null;
        try {
            Path path = Path.of(Objects.requireNonNull(DataAccess.class.getResource("/db/ACCOUNT")).toURI());
            out = new ObjectOutputStream(Files.newOutputStream(path));
            out.writeObject(ob);
        } catch(IOException | URISyntaxException e) {
            e.printStackTrace();
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch(Exception e) {}
            }
        }
    }

    static Object readFromStorage(StorageType type) {
        ObjectInputStream in = null;
        Object retVal = null;
        try {
            Path path = Path.of(Objects.requireNonNull(DataAccess.class.getResource("/db/ACCOUNT")).toURI());
            in = new ObjectInputStream(Files.newInputStream(path));
            retVal = in.readObject();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch(Exception e) {}
            }
        }
        return retVal;
    }
}
