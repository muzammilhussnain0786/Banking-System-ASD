package edu.mum.cs.cs525.project.framework.accounts.factory;

import edu.mum.cs.cs525.project.framework.accounts.Account;

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

    public void saveAccount(Account member) {
        Map<String, Account> mems = readAccountMap();
        if (mems == null){
            mems = new HashMap<>();
        }
        String memberId = member.getAccountNumber();
        mems.put(memberId, member);
        saveToStorage(StorageType.ACCOUNT, mems);
    }

    public void saveAccounts(List<Account> accounts) {
        Map<String, Account> account = new HashMap<>();
        accounts.forEach(book -> account.put(book.getAccountNumber(), book));
        saveToStorage(StorageType.ACCOUNT, account);
    }

    static void saveToStorage(StorageType type, Object ob) {
        ObjectOutputStream out = null;
        try {
            Path path = Path.of(Objects.requireNonNull(DataAccess.class.getResource("/db/" + type)).toURI());
            out = new ObjectOutputStream(Files.newOutputStream(path));
            out.writeObject(ob);
        } catch(IOException | URISyntaxException e) {
            e.printStackTrace();
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    static Object readFromStorage(StorageType type) {
        ObjectInputStream in = null;
        Object retVal = null;
        try {
            Path path = Path.of(Objects.requireNonNull(DataAccess.class.getResource("/db/" + type)).toURI());
            in = new ObjectInputStream(Files.newInputStream(path));
            retVal = in.readObject();
        } catch(Exception e) {
            System.out.println(e.getMessage());
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
