package com.mtb.ex.ocp;

/**
 * @author MithileshB
 * @created 01/12/2021 - 7:49 AM
 * @project interviewex
 */
public interface NotificationService {
    public void sendOTP(String medium);

    public void sendTransactionReport(String medium);
}
