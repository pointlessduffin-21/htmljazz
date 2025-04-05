import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoftwareEngineerTest {
    TechnicalLead TL = new TechnicalLead("Satya Nadella");
    SoftwareEngineer SE = new SoftwareEngineer("Kasey");
    @Test
    void checkInCodeFalse() {
        TL.addReport(SE);
        SE.setCodeAccess(false);
        assertFalse(SE.checkInCode());
    }

    @Test
    void checkInCodeTrue() {
        TL.addReport(SE);
        SE.setCodeAccess(true);
        assertTrue(SE.checkInCode());
    }

}