/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import javax.naming.InsufficientResourcesException;

/**
 * 动态的锁顺序死锁(不要这样做，不推荐写法)
 * @author wxh
 * @version $Id: DynamicDeadLock.java, v 0.1 2017年11月6日 下午2:20:01 wxh Exp $
 */
public class DynamicDeadLock {

    /**
     * 银行转账
     * @param fromAccount
     * @param toAccount
     * @param amount
     * @throws InsufficientResourcesException
     */
    public void transferMoney(Account fromAccount, Account toAccount, DollarAccount amount)
                                                                                           throws InsufficientFundsException {
        synchronized (fromAccount) {
            synchronized (toAccount) {
                if (fromAccount.getBalance().compareTo(amount)) {
                    throw new InsufficientFundsException();
                } else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }
    }

    private static class Account {
        private double amout;

        /**
         *
         * @return
         */
        public DollarAccount getBalance() {
            return null;
        }

        /**
         *
         * @param amount
         */
        public void credit(DollarAccount amount) {
        }

        /**
         *
         * @param amount
         */
        public void debit(DollarAccount amount) {
        }

    }

    private static class DollarAccount {
        private double amoutDollar;

        /**
         *
         * @param amount
         * @return
         */
        public boolean compareTo(DollarAccount amount) {
            return false;
        }
    }
}
