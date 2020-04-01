package me.mehedee.accounts.ui.accounts;

import androidx.recyclerview.widget.RecyclerView;

import me.mehedee.accounts.databinding.AccountsRowBinding;

public class AccountsViewHolder extends RecyclerView.ViewHolder {

    public AccountsRowBinding binding;


    public AccountsViewHolder(AccountsRowBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
