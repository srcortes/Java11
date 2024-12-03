package CAP1.NESTED_CLASSES.ANONYMUSCLASSES;


interface PersonalInformation {
    String getLastName(String value);

}

class WorkInformation{
    private String job;

    public String getAlgo(){
        return "...";
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}

interface Number{
    String phone();
}

public class ExampleAnonymusClass {

    public class Persona {
        private String nombre;
        private String apellido;

        private String profession;

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        @Override
        public String toString(){
            return nombre +" "+apellido+" "+ profession;
        }
    }

    public static void main(String[] args) {
        PersonalInformation personalInformation = getLastName -> {
            if (getLastName.contains("Rodriguez")) {
                getLastName =  "Prada";
            }
            return getLastName;
        };

        WorkInformation workInformation = new WorkInformation(){
            private String job;

            public String getJob() {
                return job;
            }

            public void setJob(String job) {
                this.job = job;
            }

        };

        ExampleAnonymusClass.Persona p = new ExampleAnonymusClass().new Persona();
        p.setNombre("John");
        p.setApellido(personalInformation.getLastName("Rodriguez Cortes"));

        workInformation.setJob("Software Engineer");
        p.setProfession(workInformation.getJob());
        System.out.println(p);



    }
}
