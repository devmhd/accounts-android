package me.mehedee.accounts.persistence.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import me.mehedee.accounts.persistence.entity.AccountEntity;

@Dao
public interface AccountDao {

    @Query("SELECT * FROM accountentity ORDER BY balance DESC")
    Observable<List<AccountEntity>> getAllBalanceSorted();

    @Insert
    Completable insert(AccountEntity... accountEntities);

}
