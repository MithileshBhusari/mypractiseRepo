package mtb.facadeex;

import com.mtb.facadeex.subsystems.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @author MithileshB
 * @created 19/07/2020 - 8:36 PM
 * @project DesignPattern
 */
@Stateless
public class BankSystem {

    @EJB
    private CreditRatingService creditRatingService;

    @EJB
    private InternalBankPolicyService internalBankPolicyService;

    @EJB
    private RepaymentPayabilityService repaymentPayabilityService;

    @EJB
    private RepaymentService repaymentService;

    @EJB
    private TransferService transferService;


    public boolean processLoanApplication(Customer customer,Double principle,Double income,Integer months){
                        boolean passes=creditRatingService.checkCustomerRating(customer);

                        if(!passes) return false;

                        boolean affordable=repaymentPayabilityService.calculatePayability(principle,income,months);

                        if(!affordable) return  false;

                        boolean compliant=internalBankPolicyService.checkCompliance(customer);

                        if(!compliant) return  false;

                        transferService.makeTransfer(principle,customer);
                        repaymentService.setupPaymentSchedule(customer,principle,months);
                        return true;
    }

}
