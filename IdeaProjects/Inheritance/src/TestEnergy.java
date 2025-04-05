public class TestEnergy {
    public static void main(String[] args) {
        KineticEnergy ke = new KineticEnergy();
        ke.def();
        ke.energy();

        PotentialEnergy pe = new PotentialEnergy();
        pe.energy();


        ElectricalEnergy ee = new ElectricalEnergy();
        ee.def();
    }
}
