package me.mehedee.accounts.ui.accounts;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.mehedee.accounts.R;
import me.mehedee.accounts.databinding.AccountsRowBinding;
import me.mehedee.accounts.model.Account;

public class AccountsListAdapter extends RecyclerView.Adapter<AccountsViewHolder> {

    List<Account> data;

    public AccountsListAdapter(List<Account> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public AccountsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        AccountsRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.accounts_row, parent, false);
        return new AccountsViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull AccountsViewHolder holder, int position) {
        holder.binding.tvAccountsName.setText(data.get(position).name);
        holder.binding.tvAccountsBalance.setText(String.valueOf(data.get(position).receivableAmount));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
