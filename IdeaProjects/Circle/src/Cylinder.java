class Cylinder extends Circle{
    double height;
    public Cylinder(double height, double radius) {
        super(radius);
        this.height = height;
    }
        public double volume() {
            return this.area()*(this.height);
        }
    }


