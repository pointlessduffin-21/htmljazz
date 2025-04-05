import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountantTest {
    BusinessLead BL = new BusinessLead("Amy Wood");
    TechnicalLead TL = new TechnicalLead("Satya Nadella");
    SoftwareEngineer SE = new SoftwareEngineer("Kasey");
    Accountant AC = new Accountant("Bill");

    @Test
    void approveBonusFalse() {
        TL.addReport(SE);
        BL.addReport(AC, TL);
        assertFalse(AC.ApproveBonus(20000000));
    }

    @Test
    void approveBonusTrue() {
        TL.addReport(SE);
        BL.addReport(AC, TL);
        assertTrue(AC.ApproveBonus(1000));
    }

}