import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TechnicalLeadTest {
    BusinessLead BL = new BusinessLead("Amy Wood");
    TechnicalLead TL = new TechnicalLead("Satya Nadella");
    SoftwareEngineer SE = new SoftwareEngineer("Kasey");
    Accountant AC = new Accountant("Bill");

    @Test
    void requestBonusFalse() {
        TL.addReport(SE);
        BL.addReport(AC, TL);
        assertFalse(TL.requestBonus(SE, 20000000));
    }

    @Test
    void requestBonusTrue() {
        TL.addReport(SE);
        BL.addReport(AC, TL);
        assertTrue(TL.requestBonus(SE, 1000));
    }

}