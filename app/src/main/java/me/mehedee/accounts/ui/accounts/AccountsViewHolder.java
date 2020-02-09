package me.mehedee.accounts.ui.accounts;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import me.mehedee.accounts.R;

public class AccountsViewHolder extends RecyclerView.ViewHolder {
    public TextView tv;
    public TextView tvBalance;
    public View rootv;

    public AccountsViewHolder(View rootv) {
        super(rootv);
        this.rootv = rootv;
        this.tv = rootv.findViewById(R.id.tv_accounts_name);
        this.tvBalance = rootv.findViewById(R.id.tv_accounts_balance);
    }
}
