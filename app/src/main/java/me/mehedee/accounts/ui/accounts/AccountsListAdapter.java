package me.mehedee.accounts.ui.accounts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.mehedee.accounts.R;
import me.mehedee.accounts.model.Account;

public class AccountsListAdapter extends RecyclerView.Adapter<AccountsViewHolder> {

    List<Account> data;

    public AccountsListAdapter(List<Account> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public AccountsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.accounts_row, parent, false);

        return new AccountsViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull AccountsViewHolder holder, int position) {
        holder.tv.setText(data.get(position).name);
        holder.tvBalance.setText(String.valueOf(data.get(position).receivableAmount));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
