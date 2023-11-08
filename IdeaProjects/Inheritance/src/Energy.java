public class Energy {
    public void def() {
        System.out.println("Energy can neither be created or destroyed.");
        System.out.println("Energy can only be transferred from one form to another.");
    }
}

class KineticEnergy extends Energy {
    public void energy() {
        System.out.println("Energy generated from moving objects");
    }
}

class PotentialEnergy extends Energy {
    public void energy(){
        System.out.println("Energy generated from standstill objects");
    }
}

class ElectricalEnergy extends KineticEnergy {
    public void def() {
        System.out.println("Energy stored in the items that can be utilized in the future.");
    }
}

