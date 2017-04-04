package com.hzxm.easyloan.presenter;

import com.hzxm.easyloan.adapter.mine.BankCardAdapter;

/**
 * 作者：LMZ on 2016/12/28 0028 13:30
 */
public interface IBankCardManager {
    void lookBankCard();

    BankCardAdapter getAdapter();

    void deleteCard(String id);
}
