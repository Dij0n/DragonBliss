package dijon.dragonBliss.data.players;

import java.util.UUID;

public class PlayerData {

    UUID uuid;
    int value;
    int balance;
    boolean active;

    public PlayerData(UUID uuid) {
        this.uuid = uuid;
        value = 0;
        balance = 0;
        active = true;
    }

    public PlayerData(UUID uuid, int value, int balance, boolean active) {
        this.uuid = uuid;
        this.value = value;
        this.balance = balance;
        this.active = active;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
