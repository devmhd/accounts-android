package me.mehedee.accounts.ui.accounts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.mehedee.accounts.model.Account;

public class AccountsViewModel extends ViewModel {

    private MutableLiveData<List<Account>> allAccData;

    List<Account> allAcc = new ArrayList<>();

    public AccountsViewModel() {

        allAcc.add(new Account("Ifta vai", -200));
        allAcc.add(new Account("Pappu vai", -100));
        allAcc.add(new Account("Bishwa", 200));

        allAccData = new MutableLiveData<>();
        allAccData.setValue(allAcc);

    }

    public void addAccount(Account acc){
        allAcc.add(acc);
        allAccData.setValue(allAcc);
    }


    public LiveData<List<Account>> getAllAccounts() {
        return allAccData;
    }
}