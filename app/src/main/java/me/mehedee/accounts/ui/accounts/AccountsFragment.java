package me.mehedee.accounts.ui.accounts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.mehedee.accounts.R;
import me.mehedee.accounts.databinding.FragmentAccountsBinding;
import me.mehedee.accounts.model.Account;

public class AccountsFragment extends Fragment {


    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private AccountsViewModel accountsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        accountsViewModel =
                new ViewModelProvider(this).get(AccountsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_accounts, container, false);

        FragmentAccountsBinding binding = DataBindingUtil.setContentView(this.getActivity(), R.layout.fragment_accounts);


        binding.rvAccounts.setHasFixedSize(true);
        binding.rvAccounts.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter = new AccountsListAdapter(accountsViewModel.getAllAccounts().getValue());
        binding.rvAccounts.setAdapter(mAdapter);

        binding.fabAddAcc.setOnClickListener(v -> {
            accountsViewModel.addAccount(new Account("Khrabiul vai", 345));
            //mAdapter.notifyDataSetChanged();
        });

        accountsViewModel.getAllAccounts().observe(this, new Observer<List<Account>>() {
            @Override
            public void onChanged(@Nullable List<Account> e) {
                mAdapter.notifyDataSetChanged();
                binding.rvAccounts.scrollToPosition(e.size() - 1);
            }
        });


        return root;
    }
}