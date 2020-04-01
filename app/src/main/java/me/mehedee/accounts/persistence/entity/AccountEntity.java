package me.mehedee.accounts.persistence.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.time.LocalDateTime;

@Entity
public class AccountEntity {

    @Ignore
    public AccountEntity(String name, int balance, LocalDateTime createdAt) {
        this.name = name;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    public AccountEntity() {
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "balance")
    public int balance;

    @TypeConverters(me.mehedee.accounts.persistence.TypeConverters.class)
    @ColumnInfo(name = "created_at")
    public LocalDateTime createdAt;

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                '}';
    }
}
